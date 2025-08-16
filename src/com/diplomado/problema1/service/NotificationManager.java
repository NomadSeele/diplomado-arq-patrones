package com.diplomado.problema1.service;

import com.diplomado.problema1.context.MultichannelNotifier;
import com.diplomado.problema1.strategy.NotificationChannel;
import com.diplomado.problema1.strategy.impl.*;
import com.diplomado.problema1.model.*;
import java.util.*;

/**
 * Main service that manages notifications per customer
 */
public class NotificationManager {
    private Map<String, MultichannelNotifier> notifiersByCustomer;
    private Map<String, NotificationChannel> availableChannels;

    public NotificationManager() {
        this.notifiersByCustomer = new HashMap<>();
        this.availableChannels = new HashMap<>();
        initializeChannels();
    }

    private void initializeChannels() {
        // Register all available channels
        registerChannel("EMAIL", new EmailChannel());
        registerChannel("SMS", new SMSChannel());
        registerChannel("WHATSAPP", new WhatsAppChannel());
        registerChannel("SLACK", new SlackChannel());
        registerChannel("PUSH", new PushChannel());
    }

    private void registerChannel(String key, NotificationChannel channel) {
        availableChannels.put(key, channel);
    }

    public void configureCustomerChannels(Customer customer, List<String> channelTypes) {
        MultichannelNotifier notifier = new MultichannelNotifier();

        for (String type : channelTypes) {
            NotificationChannel channel = availableChannels.get(type.toUpperCase());
            if (channel != null) {
                notifier.addChannel(channel);
                customer.addPreferredChannel(type);
            }
        }

        notifiersByCustomer.put(customer.getId(), notifier);
    }

    public void notifyOrderCompleted(Customer customer, String orderNumber) {
        MultichannelNotifier notifier = notifiersByCustomer.get(customer.getId());

        if (notifier == null) {
            System.out.println("Customer has no configured channels");
            return;
        }

        // Create notification based on channel type
        String recipient = determineRecipient(customer);
        Notification notification = new Notification(
                recipient,
                "Order #" + orderNumber + " Completed",
                "Hello " + customer.getName() + ", your order #" + orderNumber +
                        " has been successfully completed and is ready for shipping."
        );

        notifier.sendNotification(notification);
    }

    private String determineRecipient(Customer customer) {
        // Simplified logic to determine recipient
        if (customer.getEmail() != null) return customer.getEmail();
        if (customer.getPhoneNumber() != null) return customer.getPhoneNumber();
        if (customer.getSlackUser() != null) return customer.getSlackUser();
        return "user@example.com";
    }

    public void displayStatistics(String customerId) {
        MultichannelNotifier notifier = notifiersByCustomer.get(customerId);
        if (notifier != null) {
            notifier.displayStatistics();
        }
    }
}