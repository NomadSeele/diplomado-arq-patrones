package com.diplomado.problema1.model;

import java.util.*;

public class Customer {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String slackUser;
    private List<String> preferredChannels;

    public Customer(String id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.preferredChannels = new ArrayList<>();
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getSlackUser() { return slackUser; }
    public void setSlackUser(String slackUser) { this.slackUser = slackUser; }
    public List<String> getPreferredChannels() { return preferredChannels; }

    public void addPreferredChannel(String channel) {
        if (!preferredChannels.contains(channel)) {
            preferredChannels.add(channel);
        }
    }
}