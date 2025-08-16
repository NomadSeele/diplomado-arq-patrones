package com.diplomado.problema1.model;

import java.time.LocalDateTime;

public class Notification {
    private String recipient;
    private String subject;
    private String message;
    private LocalDateTime timestamp;

    public Notification(String recipient, String subject, String message) {
        this.recipient = recipient;
        this.subject = subject;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public String getRecipient() { return recipient; }
    public String getSubject() { return subject; }
    public String getMessage() { return message; }
    public LocalDateTime getTimestamp() { return timestamp; }
}