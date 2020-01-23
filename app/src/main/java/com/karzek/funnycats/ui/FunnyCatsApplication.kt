package com.karzek.funnycats.ui

import android.app.Application
import com.karzek.funnycats.di.AppComponentBuilder
import com.karzek.funnycats.di.ComponentProvider

class FunnyCatsApplication : Application(){

    lateinit var components: ComponentProvider

    companion object {

        private lateinit var application: FunnyCatsApplication

        fun get(): FunnyCatsApplication {
            return application
        }
    }

    override fun onCreate() {
        super.onCreate()

        application = this

        components = createComponents()
        components.appComponent.inject(this)
    }

    private fun createComponents() = ComponentProvider(AppComponentBuilder().build(this))
}