package com.limehd.limeapiclient.requests.errorResponse

import com.example.radiostation.data.request.errorResponse.ErrorResponseData

interface ErrorResponseCallBack {
    fun errorResponse(errorResponseData: ErrorResponseData)
}