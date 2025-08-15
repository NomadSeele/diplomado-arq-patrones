package com.diplomado.problema2.model.sections;

// Gráficos estadísticos del reporte
public class Charts {
    private final String type;

    public Charts(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de gráfico es obligatorio");
        }
        this.type = type.trim();
    }

    public Charts() {
        this("inversión");
    }

    @Override
    public String toString() {
        return "Gráficos de " + type;
    }
}