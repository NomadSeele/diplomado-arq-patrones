package com.diplomado.problema2.service;

import com.diplomado.problema2.model.Report;

/**
 * Servicio responsable de generar reportes personalizados.
 * Utiliza el patrón Builder para crear reportes con diferentes configuraciones.
 */
public class ReportGeneratorService {
    
    /**
     * Genera un reporte con la configuración especificada.
     * @param report El reporte a generar
     * @return Un mensaje de confirmación con los detalles del reporte generado
     */
    public String generateReport(Report report) {
        // En una implementación real, aquí se generaría el PDF o documento final
        // Por ahora, solo devolvemos un resumen del reporte
        
        StringBuilder sb = new StringBuilder();
        sb.append("Generando reporte: ").append(report.getTitle()).append("\n");
        
        if (report.isIncludeCover()) {
            sb.append("- Incluyendo portada personalizada\n");
        }
        
        if (report.isIncludeCharts()) {
            sb.append("- Incluyendo gráficos estadísticos\n");
        }
        
        if (report.isIncludeTransactionsTable()) {
            sb.append("- Incluyendo tabla de movimientos recientes\n");
        }
        
        if (report.isIncludeTrendAnalysis()) {
            sb.append("- Incluyendo análisis de tendencias\n");
        }
        
        if (report.isIncludeFooter()) {
            sb.append(String.format("- Incluyendo pie de página (Asesor: %s, Contacto: %s)\n", 
                report.getAdvisorName(), report.getAdvisorContact()));
        }
        
        // En una implementación real, aquí se generaría el archivo PDF/Excel/etc.
        sb.append("\n[ARCHIVO GENERADO CON ÉXITO]");
        
        return sb.toString();
    }
}
