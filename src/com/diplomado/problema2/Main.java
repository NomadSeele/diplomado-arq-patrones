package com.diplomado.problema2;

import com.diplomado.problema2.model.PDFReport;
import com.diplomado.problema2.service.ReportService;

// Demostración del patrón Builder con flexibilidad para agregar/quitar secciones
public class Main {
    public static void main(String[] args) {
        ReportService reportService = new ReportService();
        
        System.out.println("=== PATRÓN BUILDER - REPORTES PDF FLEXIBLES ===\n");

        // Ejemplo 1: Reporte básico - solo algunas secciones
        PDFReport reporteBasico = reportService.createReport("Reporte Mensual", builder ->
            builder.withCover("Juan Pérez")
                   .withTransactionsTable()
        );
        
        System.out.println("1. REPORTE BÁSICO:");
        System.out.println(reportService.generateReportContent(reporteBasico));
        System.out.println("\n" + "=".repeat(50) + "\n");

        // Ejemplo 2: Reporte completo - todas las secciones
        PDFReport reporteCompleto = reportService.createReport("Análisis Anual", builder ->
            builder.withCover("María García")
                   .withCharts("ahorro")
                   .withTransactionsTable(25)
                   .withTrendAnalysis()
                   .withFooter("Ana López")
        );
        
        System.out.println("2. REPORTE COMPLETO:");
        System.out.println(reportService.generateReportContent(reporteCompleto));
        System.out.println("\n" + "=".repeat(50) + "\n");

        // Ejemplo 3: Reporte personalizado - solo gráficos y footer
        PDFReport reportePersonalizado = reportService.createReport("Resumen Trimestral", builder ->
            builder.withCharts("inversión")
                   .withFooter("Carlos Ruiz")
        );
        
        System.out.println("3. REPORTE PERSONALIZADO:");
        System.out.println(reportService.generateReportContent(reportePersonalizado));
        System.out.println("\n" + "=".repeat(50) + "\n");

        // Ejemplo 4: Reporte VIP - demostrar flexibilidad del Builder
        PDFReport reporteVIP = reportService.createReport("Reporte VIP", builder ->
            builder.withCover("Cliente VIP")
                   .withCharts("portafolio")
                   .withTransactionsTable(50)
                   .withTrendAnalysis()
                   .withFooter("Asesor VIP")
        );
        
        System.out.println("4. REPORTE VIP:");
        System.out.println(reportService.generateReportContent(reporteVIP));
        System.out.println("\n" + "=".repeat(50) + "\n");

        // Validaciones de seguridad contra mal uso
        System.out.println("5. VALIDACIONES DE SEGURIDAD:");
        
        // Análisis sin gráficos
        try {
            reportService.createReport("Reporte Inválido", builder ->
                builder.withTrendAnalysis() // Falla: requiere gráficos
            );
        } catch (IllegalStateException e) {
            System.out.println("✓ " + e.getMessage());
        }
        
        // Portada sin cliente
        try {
            reportService.createReport("Reporte Inválido", builder ->
                builder.withCover("") // Falla: nombre vacío
            );
        } catch (IllegalArgumentException e) {
            System.out.println("✓ " + e.getMessage());
        }
        
        // Footer sin asesor
        try {
            reportService.createReport("Reporte Inválido", builder ->
                builder.withFooter(null) // Falla: asesor null
            );
        } catch (IllegalArgumentException e) {
            System.out.println("✓ " + e.getMessage());
        }
    }
}