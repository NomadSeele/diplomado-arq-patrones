package com.diplomado.problema1.context;

import com.diplomado.problema1.strategy.NotificationChannel;
import com.diplomado.problema1.model.Notification;
import java.util.*;

/**
 * Context that manages multiple notification strategies
 */
public class MultichannelNotifier {
    private List<NotificationChannel> channels;
    private Map<String, Integer> statistics;

    public MultichannelNotifier() {
        this.channels = new ArrayList<>();
        this.statistics = new HashMap<>();
    }

    // Add channel at runtime
    public void addChannel(NotificationChannel channel) {
        if (!channels.contains(channel)) {
            channels.add(channel);
            System.out.println("Channel added: " + channel.getChannelName());
        }
    }

    // Remove channel at runtime
    public void removeChannel(NotificationChannel channel) {
        if (channels.remove(channel)) {
            System.out.println("Channel removed: " + channel.getChannelName());
        }
    }

    // Clear all channels
    public void clearChannels() {
        channels.clear();
        System.out.println("All channels have been removed");
    }

    // Send notification through all configured channels
    public void sendNotification(Notification notification) {
        if (channels.isEmpty()) {
            System.out.println("No channels configured to send the notification");
            return;
        }

        System.out.println("\nSTARTING NOTIFICATION DELIVERY");
        System.out.println("Active channels: " + channels.size());
        System.out.println("----------------------------------------");

        for (NotificationChannel channel : channels) {
            try {
                channel.send(notification);
                // Update statistics
                statistics.merge(channel.getChannelName(), 1, Integer::sum);
            } catch (Exception e) {
                System.err.println("Error sending via " + channel.getChannelName() + ": " + e.getMessage());
            }
        }

        System.out.println("----------------------------------------");
        System.out.println("NOTIFICATION PROCESSED");
        System.out.println();
    }

    // Get active channels
    public List<String> getActiveChannels() {
        return channels.stream()
                .map(NotificationChannel::getChannelName)
                .toList();
    }

    // Display statistics
    public void displayStatistics() {
        System.out.println("\nDELIVERY STATISTICS");
        System.out.println("========================");
        if (statistics.isEmpty()) {
            System.out.println("No statistics available");
        } else {
            statistics.forEach((channel, count) ->
                    System.out.println(channel + ": " + count + " deliveries")
            );
        }
        System.out.println();
    }
}
