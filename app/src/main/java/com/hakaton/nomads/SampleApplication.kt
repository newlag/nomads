package com.hakaton.nomads

import android.app.Application
import android.util.Log
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import com.yandex.metrica.push.YandexMetricaPush

//API KEY Yandex Metrica
private const val YANDEX_METRICA_KEY: String = "b505b4ed-94e8-4dcc-9276-d67cd684be8c"

class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        VK.addTokenExpiredHandler(tokenTracker)
        initYandexMetrica()
    }

    private fun initYandexMetrica() {
        val config: YandexMetricaConfig = YandexMetricaConfig.newConfigBuilder(YANDEX_METRICA_KEY).build()
        YandexMetrica.activate(applicationContext, config)
        YandexMetrica.enableActivityAutoTracking(this)
        YandexMetricaPush.init(applicationContext)
    }

    private val tokenTracker = object : VKTokenExpiredHandler {
        override fun onTokenExpired() {
            Log.i("dwdawd", "onTokenExpired")
        }
    }
}