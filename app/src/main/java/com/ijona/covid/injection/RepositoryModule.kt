package com.ijona.covid.injection

import com.ijona.covid.data.repository.Repo
import org.koin.dsl.module

val repositoryModule = module {
    single {
        Repo(coronaEntityDao = get(), apiService = get())
    }
}

