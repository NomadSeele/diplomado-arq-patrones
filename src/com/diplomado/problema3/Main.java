package com.diplomado.problema3;

import com.diplomado.problema3.model.Task;
import com.diplomado.problema3.service.*;

/**
 * Clase principal que demuestra el uso del patrón Command
 * en un sistema de gestión de tareas.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema de Gestion de Tareas - Patron Command");
        System.out.println("==============================================\n");

        // Crear el receptor (TaskManager) y el invocador (TaskInvoker)
        TaskManager taskManager = new TaskManager();
        TaskInvoker invoker = new TaskInvoker();

        // Demostración completa del sistema
        demonstrateTaskManagement(taskManager, invoker);
    }

    /**
     * Demuestra las funcionalidades del sistema de gestión de tareas
     * con múltiples ejemplos según los requisitos del problema 3.
     */
    private static void demonstrateTaskManagement(TaskManager taskManager, TaskInvoker invoker) {
        // Ejemplo 1: Operaciones básicas de creación
        System.out.println("1. Ejemplo Básico - Crear Tareas:");
        Command createTask1 = new TaskCommand(taskManager, TaskCommand.OperationType.CREATE,
            "Estudiar patrones", "Revisar patrón Command");
        Command createTask2 = new TaskCommand(taskManager, TaskCommand.OperationType.CREATE,
            "Implementar proyecto", "Desarrollar sistema de tareas");
        
        invoker.executeCommand(createTask1);
        invoker.executeCommand(createTask2);
        taskManager.displayAllTasks();

        // Ejemplo 2: Operaciones de edición y completar
        System.out.println("\n2. Ejemplo Intermedio - Editar y Completar:");
        Command editTask = new TaskCommand(taskManager, TaskCommand.OperationType.EDIT, 1,
            "Estudiar patrones avanzados", "Revisar múltiples patrones de diseño");
        Command completeTask = new TaskCommand(taskManager, TaskCommand.OperationType.COMPLETE, 2);
        
        invoker.executeCommand(editTask);
        invoker.executeCommand(completeTask);
        taskManager.displayAllTasks();

        // Ejemplo 3: Operación de eliminación
        System.out.println("\n3. Ejemplo de Eliminación:");
        Command deleteTask = new TaskCommand(taskManager, TaskCommand.OperationType.DELETE, 1);
        invoker.executeCommand(deleteTask);
        taskManager.displayAllTasks();

        // Ejemplo 4: Capacidad de reversión (undo)
        System.out.println("\n4. Ejemplo de Reversión (Undo):");
        System.out.println("Deshaciendo eliminación...");
        invoker.undoLastCommand();
        taskManager.displayAllTasks();
        
        System.out.println("Deshaciendo completar tarea...");
        invoker.undoLastCommand();
        taskManager.displayAllTasks();

        // Mostrar historial final
        System.out.println("\nHistorial final de comandos:");
        invoker.displayCommandHistory();
    }
}
