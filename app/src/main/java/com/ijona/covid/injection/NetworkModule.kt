package com.ijona.covid.injection

import com.ijona.covid.data.network.NetworkConstant
import com.ijona.covid.data.network.category.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single(named("I1")) {
        Retrofit.Builder()
            .client(get())
            .baseUrl(NetworkConstant.BaseUrl)
//            .addConverterFactory(CsvConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { provideDefaultOkHttpClient() }
    single { provideCoronaS1Service(get(named("I1"))) }
}

private val logger: HttpLoggingInterceptor
    get() {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.apply { loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS }
            .level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

fun provideDefaultOkHttpClient(): OkHttpClient {
    val builder = OkHttpClient().newBuilder()
    builder.addInterceptor(logger)

    return builder.build()
}

fun provideCoronaS1Service(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)

