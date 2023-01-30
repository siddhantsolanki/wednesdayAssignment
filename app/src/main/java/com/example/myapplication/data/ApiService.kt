package com.example.myapplication.data

import com.example.myapplication.data.NetworkConstants.Companion.POSTS
import com.example.myapplication.data.model.ResponseData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(POSTS)
    suspend fun getData(): Response<List<ResponseData>>

}