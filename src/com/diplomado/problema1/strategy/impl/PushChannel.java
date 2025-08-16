package com.diplomado.problema1.strategy.impl;

import com.diplomado.problema1.strategy.NotificationChannel;
import com.diplomado.problema1.model.Notification;

/**
 * Example of future extension
 */
public class PushChannel implements NotificationChannel {
    private String firebaseToken = "FCM_TOKEN_123456";

    @Override
    public void send(Notification notification) {
        System.out.println("--- SENDING PUSH NOTIFICATION ---");
        System.out.println("Firebase Token: " + firebaseToken);
        System.out.println("Device: " + notification.getRecipient());
        System.out.println("Title: " + notification.getSubject());
        System.out.println("Body: " + notification.getMessage());
        System.out.println("Status: Push notification sent successfully");
        System.out.println();
    }

    @Override
    public String getChannelName() {
        return "Push Notification";
    }
}