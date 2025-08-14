# 🏛️ Constructor de Reportes Personalizados

## 📋 Descripción

Se está desarrollando un sistema que genera reportes PDF personalizados para los clientes de una entidad financiera.

## 📌 Características del Reporte

Cada cliente puede pedir un reporte con diferentes secciones opcionales, como:
- Portada con logotipo y nombre del cliente
- Gráficos estadísticos (de inversión, ahorro, etc.)
- Tabla de movimientos recientes
- Análisis de tendencias
- Pie de página con información de contacto del asesor

## 🎯 Requisitos de la Solución

La solución propuesta debe permitir:
- Crear reportes personalizados con secciones opcionales
- Asegurar que los reportes se construyan sólo cuando estén correctamente configurados
- Mantener el código limpio y fácil de extender si se agregan nuevas secciones

### Criterios de Calidad

- El código debe ser legible y fluido
- Debe ser seguro frente a mal uso (por ejemplo, no permitir construir un objeto incompleto)
- Debe permitir agregar o quitar secciones fácilmente
- El objeto final debe ser inmutable una vez construido

## 🧩 Patrón Implementado

Se implementó el patrón **Builder** (patrón creacional) para resolver el problema de construcción de reportes personalizados.

### Estructura del Código

```
problema2/
├── model/              # Modelos de datos
├── service/            # Lógica de negocio
└── README.md           # Documentación
```

## 🚀 Uso

```java
// Ejemplo de uso del patrón Builder
Report report = new Report.Builder("Reporte Financiero Anual")
    .withCover()
    .withCharts()
    .withTransactionsTable()
    .build();
```