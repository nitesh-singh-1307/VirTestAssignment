package com.example.virtusatestassignment.domain.repository

import com.example.virtusatestassignment.data.remote.dto.JhonBook

interface PostJhoneRepository {

    suspend fun getPost(endPoint: String): JhonBook
}