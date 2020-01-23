package com.karzek.funnycats.di.app

import android.app.Application
import androidx.lifecycle.ViewModel
import com.karzek.funnycats.di.android.AndroidModule
import com.karzek.funnycats.di.api.ApiModule
import com.karzek.funnycats.di.api.TokenModule
import com.karzek.funnycats.di.randomcat.RandomCatComponent
import com.karzek.funnycats.di.randomcat.RandomCatModule
import com.karzek.funnycats.ui.FunnyCatsApplication
import com.karzek.funnycats.ui.common.base.BaseActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidModule::class, ApiModule::class, TokenModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun plus(randomCatModule: RandomCatModule): RandomCatComponent

    fun inject(application: FunnyCatsApplication)

    fun inject(activity: BaseActivity)
}