package com.karzek.funnycats.ui.common.base

import androidx.lifecycle.ViewModel
import com.karzek.funnycats.domain.common.error.Errors
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject

abstract class BaseViewModel : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()

    val errorState = BehaviorSubject.create<Errors>()
    val loading = BehaviorSubject.create<Boolean>()

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}