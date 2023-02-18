package com.hakaton.nomads.data.repositories.remote.errorResponse

class ErrorResponseData(
    val errorMessage: String = "",
    val statusCode: Int,
    val exception: Exception,
    var className: String = "",
)