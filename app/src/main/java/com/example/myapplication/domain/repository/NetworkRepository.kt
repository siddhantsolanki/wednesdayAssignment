package com.example.myapplication.domain.repository

import com.example.myapplication.common.DomainResult
import com.example.myapplication.domain.model.ResponseDomainModel
import kotlinx.coroutines.flow.Flow

interface NetworkRepository {

    suspend fun getData() : Flow<DomainResult<List<ResponseDomainModel>>>

}