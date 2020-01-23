package com.karzek.funnycats.data.token

import android.annotation.SuppressLint
import android.content.SharedPreferences
import io.reactivex.Completable
import io.reactivex.Single


class LocalTokenDataSourceImpl(private val sharedPreferences: SharedPreferences) :
    LocalTokenDataSource {

    override fun isTokenAvailable(): Single<Boolean> {
        return Single.just(sharedPreferences.contains(KEY_API_TOKEN))
    }

    override fun getToken(): Single<String> {
        return Single.just(sharedPreferences.getString(KEY_API_TOKEN, ""))
    }

    @SuppressLint("ApplySharedPref")
    override fun setToken(token: String): Completable {
        return Completable.fromAction {
            sharedPreferences.edit().putString(KEY_API_TOKEN, token).commit()
        }
    }

    companion object {
        private const val KEY_API_TOKEN = "KEY_API_TOKEN"
    }
}