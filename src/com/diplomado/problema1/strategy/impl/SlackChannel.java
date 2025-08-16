package com.diplomado.problema1.strategy.impl;

import com.diplomado.problema1.strategy.NotificationChannel;
import com.diplomado.problema1.model.Notification;

public class SlackChannel implements NotificationChannel {
    private String webhookURL = "https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX";

    @Override
    public void send(Notification notification) {
        System.out.println("--- SENDING VIA SLACK ---");
        System.out.println("Webhook: " + webhookURL);
        System.out.println("Channel/User: " + notification.getRecipient());
        System.out.println("Title: " + notification.getSubject());
        System.out.println("Message: " + notification.getMessage());
        System.out.println("Status: Slack message sent successfully");
        System.out.println();
    }

    @Override
    public String getChannelName() {
        return "Slack";
    }
}