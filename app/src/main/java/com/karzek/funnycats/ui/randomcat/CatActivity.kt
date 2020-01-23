package com.karzek.funnycats.ui.randomcat

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProviders
import com.karzek.funnycats.R
import com.karzek.funnycats.common.extension.doOnIoObserveOnMain
import com.karzek.funnycats.ui.FunnyCatsApplication
import com.karzek.funnycats.ui.common.base.BaseActivity
import io.reactivex.Single
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_cat.*
import java.net.URL


class CatActivity : BaseActivity(R.layout.activity_cat) {

    private lateinit var viewModel: CatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FunnyCatsApplication.get().components.getRandomCatComponent().inject(this)

        viewModel = ViewModelProviders.of(this).get(CatViewModel::class.java)

        setupCatImageListener()
        setupTokenAvailabilityListener()
        setupErrorListener()
        setupLoadingListener()
        setupButtonListener()
    }

    private fun setupLoadingListener() {
        viewModel.loading
            .doOnIoObserveOnMain()
            .subscribeBy(onNext = {
                if (it) {
                    progress_overlay.visibility = View.VISIBLE
                } else {
                    progress_overlay.visibility = View.GONE
                }
            }, onError = {
                it.printStackTrace()
            })
            .addTo(compositeDisposable)
    }

    private fun setupButtonListener() {
        get_new_image.setOnClickListener {
            viewModel.getRandomCatImage()
        }
    }

    private fun setupCatImageListener() {
        viewModel.catImage
            .doOnIoObserveOnMain()
            .subscribeBy(onNext = {
                loadImageFromUrl(it.url)
            }, onError = {
                it.printStackTrace()
            })
            .addTo(compositeDisposable)
    }

    private fun setupTokenAvailabilityListener() {
        viewModel.tokenAvailable
            .doOnIoObserveOnMain()
            .subscribeBy(onNext = {
                if (!it) {
                    showEnterTokenDialog()
                }
            }, onError = {
                it.printStackTrace()
            })
            .addTo(compositeDisposable)
    }

    private fun showEnterTokenDialog() {
        val view = layoutInflater.inflate(R.layout.dialog_with_input, null)
        val editText = view.findViewById<EditText>(R.id.input_field)
        AlertDialog.Builder(this)
            .setTitle("Token missing")
            .setMessage("Please enter a valid API token to continue:")
            .setView(view)
            .setPositiveButton("OK") { _, _ ->
                viewModel.setToken(editText.text.toString())
            }
            .setCancelable(false)
            .show()
    }

    private fun setupErrorListener() {
        viewModel.errorState
            .doOnIoObserveOnMain()
            .subscribeBy {
                showError(it)
            }
            .addTo(compositeDisposable)
    }

    private fun loadImageFromUrl(url: URL) {
        Single.fromCallable { BitmapFactory.decodeStream(url.openConnection().getInputStream()) }
            .doOnIoObserveOnMain()
            .subscribeBy { cat_image.setImageBitmap(it) }
            .addTo(compositeDisposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        get_new_image.setOnClickListener(null)
    }

}
