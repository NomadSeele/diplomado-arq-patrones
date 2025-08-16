package com.diplomado.problema1.strategy;

import com.diplomado.problema1.model.Notification;

/**
 * Strategy interface that defines the contract for all notification channels
 */
public interface NotificationChannel {
    void send(Notification notification);
    String getChannelName();
}