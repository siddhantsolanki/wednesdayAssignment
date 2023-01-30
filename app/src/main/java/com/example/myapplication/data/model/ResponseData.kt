package com.example.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("userId")
    var userId: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("body")
    var body: String

)
