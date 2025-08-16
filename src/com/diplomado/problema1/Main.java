package com.diplomado.problema1;

import com.diplomado.problema1.model.Customer;
import com.diplomado.problema1.service.NotificationManager;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║       MULTICHANNEL NOTIFICATION SYSTEM       ║");
        System.out.println("║        Strategy Pattern Implementation       ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        // Create notification manager
        NotificationManager manager = new NotificationManager();

        // Create customers
        Customer customer1 = new Customer("001", "Carlos Arevalo", "carlos@email.com", "+57-310-1234567");
        customer1.setSlackUser("@carlos.arevalo");

        Customer customer2 = new Customer("002", "Mario Lozano", "mario@email.com", "+57-310-1234567");

        Customer customer3 = new Customer("003", "Juan Gomez", "juan@email.com", "+57-310-1234567");
        customer3.setSlackUser("@juan.gomez");

        // SCENARIO 1: Customer with Email + WhatsApp
        System.out.println("SCENARIO 1: Customer with Email + WhatsApp");
        System.out.println("-------------------------------------------");
        manager.configureCustomerChannels(customer1, Arrays.asList("EMAIL", "WHATSAPP"));
        manager.notifyOrderCompleted(customer1, "2025-001");

        // SCENARIO 2: Customer with SMS + Slack
        System.out.println("\nSCENARIO 2: Customer with SMS + Slack");
        System.out.println("-------------------------------------");
        manager.configureCustomerChannels(customer2, Arrays.asList("SMS", "SLACK"));
        manager.notifyOrderCompleted(customer2, "2025-002");

        // SCENARIO 3: Customer with ALL channels
        System.out.println("\nSCENARIO 3: Customer with ALL channels");
        System.out.println("---------------------------------------");
        manager.configureCustomerChannels(customer3,
                Arrays.asList("EMAIL", "SMS", "WHATSAPP", "SLACK", "PUSH"));
        manager.notifyOrderCompleted(customer3, "2025-003");

        // Display statistics
        System.out.println("\nNOTIFICATION SUMMARY");
        System.out.println("-----------------------");
        System.out.println("Customer 1 (Carlos Arevalo):");
        manager.displayStatistics("001");
        System.out.println("Customer 2 (Mario Lozano):");
        manager.displayStatistics("002");
        System.out.println("Customer 3 (Juan Gomez):");
        manager.displayStatistics("003");

        // DEMO: Dynamic channel modification
        System.out.println("\nDEMO: Runtime channel modification");
        System.out.println("-------------------------------------");
        System.out.println("Adding PUSH channel to customer 1 at runtime...");
        manager.configureCustomerChannels(customer1,
                Arrays.asList("EMAIL", "WHATSAPP", "PUSH"));
        manager.notifyOrderCompleted(customer1, "2025-004");
    }
}