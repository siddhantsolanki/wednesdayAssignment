package com.example.myapplication.data.mapper

import com.example.myapplication.data.model.ResponseData
import com.example.myapplication.domain.model.ResponseDomainModel

fun ResponseData.mapToDomain(): ResponseDomainModel {
    return ResponseDomainModel(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}