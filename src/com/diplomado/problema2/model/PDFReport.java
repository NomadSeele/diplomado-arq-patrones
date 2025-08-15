package com.diplomado.problema2.model;

import com.diplomado.problema2.model.sections.Charts;
import com.diplomado.problema2.model.sections.Cover;
import com.diplomado.problema2.model.sections.Footer;
import com.diplomado.problema2.model.sections.TransactionsTable;
import com.diplomado.problema2.model.sections.TrendAnalysis;

import java.util.Objects;
import java.util.stream.Stream;

// Reporte PDF que usa patrón Builder para evitar constructores complejos
public class PDFReport {
    private final String title;
    private final Cover cover;
    private final Charts charts;
    private final TransactionsTable transactionsTable;
    private final TrendAnalysis trendAnalysis;
    private final Footer footer;

    // Constructor privado - solo el Builder puede crear instancias
    private PDFReport(Builder builder) {
        this.title = builder.title;
        this.cover = builder.cover;
        this.charts = builder.charts;
        this.transactionsTable = builder.transactionsTable;
        this.trendAnalysis = builder.trendAnalysis;
        this.footer = builder.footer;
    }



    // Genera el contenido del reporte usando Stream
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== REPORTE PDF ===\n");
        report.append("Título: ").append(title).append("\n\n");
        
        // Procesa todas las secciones con Stream
        Stream.of(cover, charts, transactionsTable, trendAnalysis, footer)
              .filter(Objects::nonNull)
              .forEach(section -> report.append("✓ ").append(section).append("\n"));
        
        report.append("\n[Aquí se generaría el archivo PDF]");
        return report.toString();
    }

    // Builder para construir reportes PDF paso a paso
    public static class Builder {
        private final String title; // Obligatorio
        // Secciones opcionales
        private Cover cover = null;
        private Charts charts = null;
        private TransactionsTable transactionsTable = null;
        private TrendAnalysis trendAnalysis = null;
        private Footer footer = null;

        public Builder(String title) {
            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("El título es obligatorio");
            }
            this.title = title.trim();
        }

        public Builder withCover(String clientName) {
            this.cover = new Cover(clientName);
            return this;
        }

        public Builder withCharts(String chartType) {
            this.charts = new Charts(chartType);
            return this;
        }

        public Builder withCharts() {
            this.charts = new Charts();
            return this;
        }

        public Builder withTransactionsTable(int quantity) {
            this.transactionsTable = new TransactionsTable(quantity);
            return this;
        }

        public Builder withTransactionsTable() {
            this.transactionsTable = new TransactionsTable();
            return this;
        }

        public Builder withTrendAnalysis() {
            this.trendAnalysis = new TrendAnalysis();
            return this;
        }

        public Builder withFooter(String advisorName) {
            this.footer = new Footer(advisorName);
            return this;
        }

        public PDFReport build() {
            // Validación: análisis requiere gráficos
            if (trendAnalysis != null && charts == null) {
                throw new IllegalStateException("Análisis de tendencias requiere gráficos");
            }
            return new PDFReport(this);
        }
    }
}