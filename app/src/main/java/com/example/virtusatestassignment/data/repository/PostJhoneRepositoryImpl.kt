package com.example.virtusatestassignment.data.repository

import com.example.virtusatestassignment.data.remote.PostJhoneApi
import com.example.virtusatestassignment.data.remote.dto.JhonBook
import com.example.virtusatestassignment.domain.repository.PostJhoneRepository
import javax.inject.Inject

class PostJhoneRepositoryImpl @Inject constructor(
    private val api: PostJhoneApi
) : PostJhoneRepository {


    override suspend fun getPost(endPoint:String): JhonBook {
        return api.getPost(endPoint)
    }
}
