package com.karzek.funnycats.di.android

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides

@Module
class AndroidModule {

    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(FUNNY_CATS_SHARED_PREFERENCES, Context.MODE_PRIVATE)
    }

    companion object {
        private const val FUNNY_CATS_SHARED_PREFERENCES = "FUNNY_CATS_SHARED_PREFERENCES"
    }

}