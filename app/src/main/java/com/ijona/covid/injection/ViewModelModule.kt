package com.ijona.covid.injection

import com.ijona.covid.ui.MainActivityViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { MainActivityViewModel(get()) }
}