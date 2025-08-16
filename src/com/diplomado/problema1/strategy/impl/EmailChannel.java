package com.diplomado.problema1.strategy.impl;

import com.diplomado.problema1.strategy.NotificationChannel;
import com.diplomado.problema1.model.Notification;

public class EmailChannel implements NotificationChannel {
    private String smtpServer = "smtp.company.com";

    @Override
    public void send(Notification notification) {
        System.out.println("--- SENDING VIA EMAIL ---");
        System.out.println("SMTP Server: " + smtpServer);
        System.out.println("To: " + notification.getRecipient());
        System.out.println("Subject: " + notification.getSubject());
        System.out.println("Message: " + notification.getMessage());
        System.out.println("Status: Email sent successfully");
        System.out.println();
    }

    @Override
    public String getChannelName() {
        return "Email";
    }
}