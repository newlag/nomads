package com.hakaton.nomads.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;
import com.hakaton.nomads.R;
import com.hakaton.nomads.ui.MainActivity;
import com.yandex.metrica.push.firebase.MetricaMessagingService;

import java.util.Map;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    public static final String Tag = "FCM";
    public static final String key_click_action = "click_action";
    public static final String key_something = "key_something";
    private final int notificationId = 545115;
    private String CHANNEL_ID = "";
    private String channel_description = "standard notification channel";
    private MetricaMessagingService yandexService;

    @Override
    public void onCreate() {
        super.onCreate();
        yandexService = new MetricaMessagingService();
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        createNotificationChannel();
        if (remoteMessage.getData().containsKey("yamp")) {
            yandexService.processPush(this, remoteMessage);
            yandexService.onMessageReceived(remoteMessage);
        } else {
            sendNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody(), remoteMessage.getData());
        }
    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        yandexService.onNewToken(s);
    }

    private void createNotificationChannel() {
        CHANNEL_ID = getResources().getString(R.string.app_name);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, importance);
            channel.setDescription(channel_description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void sendNotification(String messageTitle, String messageBody, Map<String, String> messageData) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("title", messageTitle);
        intent.putExtra("body", messageBody);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if (messageData.size() > 0) {
            if (messageData.get(key_click_action) != null) {
                intent.putExtra(key_click_action, messageData.get(key_click_action));
            }

        }

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        Bitmap largeIcon = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher_round);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setLargeIcon(largeIcon)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(messageBody))
                .setContentTitle(messageTitle)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setLights(Color.MAGENTA, 500, 1000)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(notificationId, notificationBuilder.build());
    }
}
