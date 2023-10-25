package com.example.virtusatestassignment.domain.use_case.get_post
import com.example.virtusatestassignment.common.Resource
import com.example.virtusatestassignment.data.remote.dto.JhonBook
import com.example.virtusatestassignment.domain.repository.PostJhoneRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
class GetPostUseCase @Inject constructor(
    private val repository: PostJhoneRepository
) {
    operator fun invoke(endPoint: String): Flow<Resource<JhonBook>> = flow {
        try {
            emit(Resource.Loading<JhonBook>())
            val coins = repository.getPost(endPoint)
            emit(Resource.Success<JhonBook>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<JhonBook>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<JhonBook>("Couldn't reach server. Check your internet connection."))
        }
    }
}