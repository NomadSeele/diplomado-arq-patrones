package com.diplomado.problema1.strategy.impl;

import com.diplomado.problema1.strategy.NotificationChannel;
import com.diplomado.problema1.model.Notification;

public class SMSChannel implements NotificationChannel {
    private String smsProvider = "Aldeamo";
    private int characterLimit = 160;

    @Override
    public void send(Notification notification) {
        System.out.println("--- SENDING VIA SMS ---");
        System.out.println("Provider: " + smsProvider);
        System.out.println("Phone Number: " + notification.getRecipient());

        String shortMessage = notification.getMessage();
        if (shortMessage.length() > characterLimit) {
            shortMessage = shortMessage.substring(0, characterLimit - 3) + "...";
        }

        System.out.println("Message (" + shortMessage.length() + " chars): " + shortMessage);
        System.out.println("Status: SMS sent successfully");
        System.out.println();
    }

    @Override
    public String getChannelName() {
        return "SMS";
    }
}