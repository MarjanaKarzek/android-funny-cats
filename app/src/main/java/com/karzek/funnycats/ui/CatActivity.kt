package com.karzek.funnycats.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.karzek.funnycats.R.layout
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.activity_cat.cat_image

class CatActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    private lateinit var viewModel: CatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_cat)

        initializeViewModel()
    }

    private fun initializeViewModel() {
        viewModel = ViewModelProviders.of(this).get(CatViewModel::class.java)
        viewModel.catImage
            .map { BitmapFactory.decodeStream(it.url.openConnection().getInputStream()) }
            .subscribe {
                cat_image.setImageBitmap(it)
            }
            .addTo(compositeDisposable)
    }

}
