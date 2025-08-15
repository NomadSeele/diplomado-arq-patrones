package com.diplomado.problema2.service;

import com.diplomado.problema2.model.PDFReport;
import java.util.function.Consumer;

// Servicio para generar reportes PDF usando el patrón Builder
public class ReportService {

    // Crea un reporte personalizado usando una función lambda para configurar secciones
    // Consumer es una función que recibe el Builder y lo configura según necesidades
    // Ejemplo: createReport("Título", builder -> builder.withCover("Cliente").withCharts())
    public PDFReport createReport(String title, Consumer<PDFReport.Builder> configurator) {
        PDFReport.Builder builder = new PDFReport.Builder(title);
        configurator.accept(builder);
        return builder.build();
    }

    // Genera el contenido del reporte en formato texto
    public String generateReportContent(PDFReport report) {
        return report.generateReport();
    }
}