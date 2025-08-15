package com.diplomado.problema2.model.sections;

// Tabla de movimientos recientes
public class TransactionsTable {
    private final int quantity;

    public TransactionsTable(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad de transacciones debe ser mayor a 0");
        }
        this.quantity = quantity;
    }

    public TransactionsTable() {
        this(10);
    }

    @Override
    public String toString() {
        return "Tabla con " + quantity + " movimientos recientes";
    }
}