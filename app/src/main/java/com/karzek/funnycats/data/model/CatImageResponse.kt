package com.karzek.funnycats.data.model

import com.google.gson.annotations.SerializedName

data class CatImageResponse(
    @SerializedName("id") val id: String,
    @SerializedName("url") val url: String
)