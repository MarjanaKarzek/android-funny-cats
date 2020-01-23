package com.karzek.funnycats.di

import com.karzek.funnycats.di.app.AppComponent
import com.karzek.funnycats.di.randomcat.RandomCatComponent
import com.karzek.funnycats.di.randomcat.RandomCatModule

class ComponentProvider(val appComponent: AppComponent) {

    fun getRandomCatComponent() : RandomCatComponent {
        return appComponent.plus(RandomCatModule())
    }

}
