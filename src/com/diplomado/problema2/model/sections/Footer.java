package com.diplomado.problema2.model.sections;

// Pie de página con contacto del asesor
public class Footer {
    private final String advisorName;

    public Footer(String advisorName) {
        if (advisorName == null || advisorName.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del asesor es obligatorio");
        }
        this.advisorName = advisorName.trim();
    }

    @Override
    public String toString() {
        return "Pie de página - Asesor: " + advisorName;
    }
}