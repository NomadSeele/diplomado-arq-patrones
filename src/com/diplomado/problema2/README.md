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

```mermaid
classDiagram
    class Report {
        -String title
        -boolean includeCover
        -boolean includeCharts
        -boolean includeTransactionsTable
        -boolean includeTrendAnalysis
        -boolean includeFooter
        -String advisorName
        -String advisorContact
        +String getTitle()
        +boolean isIncludeCover()
        +boolean isIncludeCharts()
        +boolean isIncludeTransactionsTable()
        +boolean isIncludeTrendAnalysis()
        +boolean isIncludeFooter()
        +String getAdvisorName()
        +String getAdvisorContact()
        +String toString()
    }
    
    class ReportBuilder {
        -String title
        -boolean includeCover
        -boolean includeCharts
        -boolean includeTransactionsTable
        -boolean includeTrendAnalysis
        -boolean includeFooter
        -String advisorName
        -String advisorContact
        +ReportBuilder(String title)
        +withCover() Builder
        +withCharts() Builder
        +withTransactionsTable() Builder
        +withTrendAnalysis() Builder
        +withFooter(String, String) Builder
        +build() Report
    }
    
    class ReportGeneratorService {
        +generateReport(Report) String
    }
    
    class Main {
        +main(String[]) void
    }
    
    ReportBuilder ..> Report : builds
    ReportGeneratorService ..> Report : uses
    Main ..> Report : uses
    Main ..> ReportGeneratorService : uses
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