package com.karzek.funnycats.di

import android.app.Application
import com.karzek.funnycats.di.app.AppComponent

interface DaggerComponentBuilder {

    fun build(application: Application) : AppComponent
}