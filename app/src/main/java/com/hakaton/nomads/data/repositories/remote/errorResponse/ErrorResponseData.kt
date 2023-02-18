package com.example.radiostation.data.request.errorResponse

class ErrorResponseData(
    val errorMessage: String = "",
    val statusCode: Int,
    val exception: Exception,
    var className: String = "",
)