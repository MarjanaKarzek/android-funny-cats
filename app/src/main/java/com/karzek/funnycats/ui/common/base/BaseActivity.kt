package com.karzek.funnycats.ui.common.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.karzek.funnycats.domain.common.error.Errors
import com.karzek.funnycats.domain.common.error.ErrorNetwork
import com.karzek.funnycats.domain.common.error.ErrorUnknown
import com.karzek.funnycats.ui.FunnyCatsApplication
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity(@LayoutRes layout: Int) : AppCompatActivity(layout) {

    protected val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FunnyCatsApplication.get().components.appComponent.inject(this)
    }

    fun showError(error: Errors) {
        when (error) {
            is ErrorUnknown -> Toast.makeText(this, "Unknown Error", Toast.LENGTH_LONG).show()
            is ErrorNetwork -> Toast.makeText(this, "Network Error", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}
