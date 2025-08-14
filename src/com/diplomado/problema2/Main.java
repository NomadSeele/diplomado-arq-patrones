package com.diplomado.problema2;

import com.diplomado.problema2.model.Report;
import com.diplomado.problema2.service.ReportGeneratorService;

public class Main {
    public static void main(String[] args) {
        // Inicializar el servicio de generación de reportes
        ReportGeneratorService generator = new ReportGeneratorService();
        
        System.out.println("=== DEMOSTRACIÓN DEL PATRÓN BUILDER PARA REPORTES ===\n");
        
        // Ejemplo 1: Reporte básico solo con título
        Report basicReport = new Report.Builder("Reporte de Actividades Básico")
                .build();
        
        System.out.println("1. Reporte Básico:");
        System.out.println(generator.generateReport(basicReport));
        
        // Ejemplo 2: Reporte completo con todas las secciones
        Report fullReport = new Report.Builder("Reporte Financiero Anual")
                .withCover()
                .withCharts()
                .withTransactionsTable()
                .withTrendAnalysis()
                .withFooter("Ana López", "ana.lopez@unisabana.edu.co | Tel: 310-123-5554")
                .build();
        
        System.out.println("\n2. Reporte Completo:");
        System.out.println(generator.generateReport(fullReport));
        
        // Ejemplo 3: Reporte personalizado con algunas secciones
        Report customReport = new Report.Builder("Resumen de Inversiones")
                .withCover()
                .withCharts()
                .withFooter("Juan Perez", "juan.perez@unisabana.edu.co | Cel: 310-123-6789")
                .build();
        
        System.out.println("\n3. Reporte Personalizado:");
        System.out.println(generator.generateReport(customReport));
        
        // Ejemplo 4: Validación de parámetros obligatorios
        try {
            System.out.println("\n4. Validación de parámetros:");
            Report invalidReport = new Report.Builder("")  // Título vacío
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }
}
