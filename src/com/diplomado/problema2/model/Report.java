package com.diplomado.problema2.model;

/**
 * Clase que representa un reporte personalizado.
 * Es el producto final que se construye usando el patrón Builder.
 */
public class Report {
    private final String title;
    private final boolean includeCover;
    private final boolean includeCharts;
    private final boolean includeTransactionsTable;
    private final boolean includeTrendAnalysis;
    private final boolean includeFooter;
    private final String advisorName;
    private final String advisorContact;

    // Constructor privado para forzar el uso del Builder
    private Report(Builder builder) {
        this.title = builder.title;
        this.includeCover = builder.includeCover;
        this.includeCharts = builder.includeCharts;
        this.includeTransactionsTable = builder.includeTransactionsTable;
        this.includeTrendAnalysis = builder.includeTrendAnalysis;
        this.includeFooter = builder.includeFooter;
        this.advisorName = builder.advisorName;
        this.advisorContact = builder.advisorContact;
    }

    // Getters (no hay setters para hacer la clase inmutable)
    public String getTitle() {
        return title;
    }

    public boolean isIncludeCover() {
        return includeCover;
    }

    public boolean isIncludeCharts() {
        return includeCharts;
    }

    public boolean isIncludeTransactionsTable() {
        return includeTransactionsTable;
    }

    public boolean isIncludeTrendAnalysis() {
        return includeTrendAnalysis;
    }

    public boolean isIncludeFooter() {
        return includeFooter;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public String getAdvisorContact() {
        return advisorContact;
    }

    @Override
    public String toString() {
        return "Report{" +
                "title='" + title + '\'' +
                ", includeCover=" + includeCover +
                ", includeCharts=" + includeCharts +
                ", includeTransactionsTable=" + includeTransactionsTable +
                ", includeTrendAnalysis=" + includeTrendAnalysis +
                ", includeFooter=" + includeFooter +
                ", advisorName='" + advisorName + '\'' +
                ", advisorContact='" + advisorContact + '\'' +
                '}';
    }

    /**
     * Clase Builder para crear instancias de Report.
     * Sigue el patrón Builder para permitir la construcción flexible de objetos Report.
     */
    public static class Builder {
        // Parámetros obligatorios
        private final String title;
        
        // Parámetros opcionales - inicializados con valores por defecto
        private boolean includeCover = false;
        private boolean includeCharts = false;
        private boolean includeTransactionsTable = false;
        private boolean includeTrendAnalysis = false;
        private boolean includeFooter = false;
        private String advisorName = "";
        private String advisorContact = "";

        /**
         * Constructor con parámetro obligatorio.
         * @param title Título del reporte (obligatorio)
         */
        public Builder(String title) {
            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("El título del reporte no puede estar vacío");
            }
            this.title = title;
        }

        public Builder withCover() {
            this.includeCover = true;
            return this;
        }

        public Builder withCharts() {
            this.includeCharts = true;
            return this;
        }

        public Builder withTransactionsTable() {
            this.includeTransactionsTable = true;
            return this;
        }

        public Builder withTrendAnalysis() {
            this.includeTrendAnalysis = true;
            return this;
        }

        public Builder withFooter(String advisorName, String advisorContact) {
            if (advisorName == null || advisorName.trim().isEmpty() || 
                advisorContact == null || advisorContact.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre y contacto del asesor son obligatorios");
            }
            this.includeFooter = true;
            this.advisorName = advisorName;
            this.advisorContact = advisorContact;
            return this;
        }

        /**
         * Construye y devuelve una instancia de Report.
         * @return Una nueva instancia de Report configurada según los parámetros proporcionados.
         */
        public Report build() {
            // Validaciones adicionales podrían ir aquí
            if (includeFooter && (advisorName.isEmpty() || advisorContact.isEmpty())) {
                throw new IllegalStateException("Se requiere nombre y contacto del asesor cuando se incluye pie de página");
            }
            
            return new Report(this);
        }
    }
}
