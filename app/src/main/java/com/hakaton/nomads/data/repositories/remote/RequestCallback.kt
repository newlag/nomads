package com.hakaton.nomads.data.repositories.remote

import com.example.radiostation.data.request.errorResponse.ErrorResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class RequestCallback<T> : Callback<T> {
    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (call.isCanceled) {
            return
        }
        if (response.body() != null && response.isSuccessful) {
            callCallback(response.body()!!, response.code())
        } else {
            failRequest(
                ErrorResponseData(
                    "response is not successful ${response.body()}",
                    response.code(),
                    Exception("response is not successful")
                )
            )
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        if (call.isCanceled) {
            return
        }

        failRequest(
            ErrorResponseData(
                "Failure request unknown: " + t.localizedMessage,
                t.hashCode(),
                t as Exception
            )
        )
    }

    abstract fun callCallback(body: T, code: Int)

    abstract fun failRequest(errorData: ErrorResponseData)
}