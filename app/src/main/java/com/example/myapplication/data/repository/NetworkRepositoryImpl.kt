package com.example.myapplication.data.repository

import com.example.myapplication.common.DomainResult
import com.example.myapplication.data.ApiService
import com.example.myapplication.data.mapper.mapToDomain
import com.example.myapplication.domain.model.ResponseDomainModel
import com.example.myapplication.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor( private val apiService: ApiService ) : NetworkRepository {
    override suspend fun getData(): Flow<DomainResult<List<ResponseDomainModel>>> = flow {
        val result = apiService.getData()
        if (result.isSuccessful){
            if(result.body() != null){
                emit(DomainResult.Success(result.body()!!.map { it.mapToDomain() }))
            }else{
                emit(DomainResult.Error(result.message().toString()))
            }
        }else{
            emit(DomainResult.Error(result.message().toString()))
        }
    }


}