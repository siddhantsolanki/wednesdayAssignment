package com.example.myapplication.domain.model

import com.google.gson.annotations.SerializedName

data class ResponseDomainModel(
    var userId: Int,
    var id: Int,
    var title: String,
    var body: String
)