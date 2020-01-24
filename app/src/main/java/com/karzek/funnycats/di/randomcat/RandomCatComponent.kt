package com.karzek.funnycats.di.randomcat

import com.karzek.funnycats.ui.randomcat.CatViewModel
import dagger.Subcomponent

@Subcomponent(modules = [RandomCatModule::class])
interface RandomCatComponent {

    fun inject(viewModel: CatViewModel)
}