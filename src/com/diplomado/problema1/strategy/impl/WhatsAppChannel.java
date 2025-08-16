package com.diplomado.problema1.strategy.impl;

import com.diplomado.problema1.strategy.NotificationChannel;
import com.diplomado.problema1.model.Notification;

public class WhatsAppChannel implements NotificationChannel {
    private String apiURL = "https://api.whatsapp.com/v1/messages";

    @Override
    public void send(Notification notification) {
        System.out.println("--- SENDING VIA WHATSAPP ---");
        System.out.println("API URL: " + apiURL);
        System.out.println("Phone: " + notification.getRecipient());
        System.out.println("Message: " + notification.getMessage());
        System.out.println("Media: No");
        System.out.println("Status: WhatsApp message sent successfully");
        System.out.println();
    }

    @Override
    public String getChannelName() {
        return "WhatsApp";
    }
}