package com.diplomado.problema2.model.sections;

// Portada del reporte
public class Cover {
    private final String clientName;

    public Cover(String clientName) {
        if (clientName == null || clientName.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente es obligatorio");
        }
        this.clientName = clientName.trim();
    }

    @Override
    public String toString() {
        return "Portada para cliente: " + clientName;
    }
}