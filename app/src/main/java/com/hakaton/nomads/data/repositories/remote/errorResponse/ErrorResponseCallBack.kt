package com.limehd.limeapiclient.requests.errorResponse

import com.hakaton.nomads.data.repositories.remote.errorResponse.ErrorResponseData


interface ErrorResponseCallBack {
    fun errorResponse(errorResponseData: ErrorResponseData)
}