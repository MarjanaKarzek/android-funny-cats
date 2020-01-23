package com.karzek.funnycats.ui.randomcat

import com.karzek.funnycats.common.extension.doOnIoObserveOnMain
import com.karzek.funnycats.domain.cat.GetRandomCatUseCase
import com.karzek.funnycats.domain.cat.GetRandomCatUseCase.Input
import com.karzek.funnycats.domain.common.error.Errors
import com.karzek.funnycats.domain.model.CatImage
import com.karzek.funnycats.domain.token.IsApiTokenAvailableUseCase
import com.karzek.funnycats.domain.token.UpdateApiTokenUseCase
import com.karzek.funnycats.ui.FunnyCatsApplication
import com.karzek.funnycats.ui.common.base.BaseViewModel
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class CatViewModel : BaseViewModel() {

    @Inject
    lateinit var getRandomCatUseCase: GetRandomCatUseCase
    @Inject
    lateinit var isApiTokenAvailableUseCase: IsApiTokenAvailableUseCase
    @Inject
    lateinit var updateApiTokenUseCase: UpdateApiTokenUseCase

    val errorState = PublishSubject.create<Errors>()
    val tokenAvailable = PublishSubject.create<Boolean>()
    val loading = PublishSubject.create<Boolean>()
    val catImage = PublishSubject.create<CatImage>()

    init {
        FunnyCatsApplication.get().components.getRandomCatComponent().inject(this)
        isApiTokenAvailable()
    }

    fun getRandomCatImage() {
        getRandomCatUseCase.execute(Input())
            .doOnIoObserveOnMain()
            .doOnSubscribe { loading.onNext(true) }
            .subscribeBy {
                loading.onNext(false)
                if (it is GetRandomCatUseCase.Success) {
                    catImage.onNext(it.catImage)
                } else {
                    errorState.onNext(it as Errors)
                }
            }
            .addTo(compositeDisposable)
    }

    private fun isApiTokenAvailable() {
        isApiTokenAvailableUseCase.execute(IsApiTokenAvailableUseCase.Input())
            .doOnIoObserveOnMain()
            .subscribeBy {
                if (it is IsApiTokenAvailableUseCase.Output.Success) {
                    tokenAvailable.onNext(it.available)
                    if(it.available) {
                        getRandomCatImage()
                    }
                } else {
                    errorState.onNext(it as Errors)
                }
            }
            .addTo(compositeDisposable)

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    fun setToken(token: String) {
        updateApiTokenUseCase.execute(UpdateApiTokenUseCase.Input(token))
            .doOnIoObserveOnMain()
            .doOnSubscribe { loading.onNext(true) }
            .subscribeBy {
                loading.onNext(false)
            }
            .addTo(compositeDisposable)
    }

}