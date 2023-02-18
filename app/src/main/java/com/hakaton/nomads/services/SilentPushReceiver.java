package com.hakaton.nomads.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.yandex.metrica.push.YandexMetricaPush;

public class SilentPushReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(FirebaseMessagingService.Tag, "onReceive");
        String payload = intent.getStringExtra(YandexMetricaPush.EXTRA_PAYLOAD);
        if(payload != null)
            Log.e(FirebaseMessagingService.Tag, payload);
        else
            Log.e(FirebaseMessagingService.Tag, "payload == null");
    }
}