package com.karzek.funnycats.di

import android.app.Application
import com.karzek.funnycats.di.app.AppComponent
import com.karzek.funnycats.di.app.DaggerAppComponent


class AppComponentBuilder : DaggerComponentBuilder {

    override fun build(application: Application): AppComponent {
        return DaggerAppComponent.builder()
            .application(application)
            .build()
    }

}