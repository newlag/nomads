package com.hakaton.nomads.data.repositories.remote.httpConnect

import com.hakaton.nomads.data.repositories.remote.HttpRequestTV
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


class RetrofitClientWrapper {

    private var okHttpClient: OkHttpClient

    init {
        val trustAllCerts = arrayOf<TrustManager>(
            object : X509TrustManager {
                override fun checkClientTrusted(
                    x509Certificates: Array<X509Certificate>,
                    s: String
                ) {
                }

                override fun checkServerTrusted(
                    x509Certificates: Array<X509Certificate>,
                    s: String
                ) {
                }

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return listOf<X509Certificate>().toTypedArray()
                }
            }
        )
        var tlsSocketFactory: TLSSocketFactory? = null
        try {
            tlsSocketFactory = TLSSocketFactory()
        } catch (ex: NoSuchAlgorithmException) {
            ex.printStackTrace()
        } catch (ex: KeyManagementException) {
            ex.printStackTrace()
        } catch (ex: NullPointerException) {
            ex.printStackTrace()
        }

        val okHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)

        if (tlsSocketFactory != null) {
            okHttpClientBuilder.sslSocketFactory(
                tlsSocketFactory,
                (trustAllCerts[0] as X509TrustManager)
            )
        }
        okHttpClient = okHttpClientBuilder.build()
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
                )
            )
            .baseUrl(HttpRequestTV.ROOT_URL)
            .client(okHttpClient)
            .build()
    }

    fun cancelRequest(tag: String) {
        for (call in okHttpClient.dispatcher.runningCalls()) {
            if (call.request().tag() != null && call.request().tag() == tag) {
                call.cancel()
            }
        }
    }

    fun isCallRunning(tag: String): Boolean {
        for (call in okHttpClient.dispatcher.runningCalls()) {
            if (call.request().tag() != null && call.request().tag() == tag) {
                return call.isExecuted()
            }
        }
        return false
    }

    companion object {
//        fun getHeaderMap(context: Context): Map<String, String> {
//            val tokenModule = dataProvider.tokenModule
//            val token = tokenModule?.token ?: ""
//
//            val headerMap = mutableMapOf<String, String>()
//            headerMap["User-Agent"] = dataProvider.userAgent
//            headerMap["X-Token"] = token
//            headerMap["Cache-Control"] = CacheControl.FORCE_NETWORK.toString()
//            return headerMap
//        }
    }
}