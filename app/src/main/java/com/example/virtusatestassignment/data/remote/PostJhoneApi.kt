package com.example.virtusatestassignment.data.remote

import com.example.virtusatestassignment.data.remote.dto.JhonBook
import retrofit2.http.GET
import retrofit2.http.Url

interface PostJhoneApi {


    @GET
    suspend fun getPost(@Url endpoint: String): JhonBook
}