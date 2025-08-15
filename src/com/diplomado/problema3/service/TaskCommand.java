package com.diplomado.problema3.service;

import com.diplomado.problema3.model.Task;

/**
 * Comando unificado que maneja todas las operaciones básicas de tareas:
 * crear, editar, eliminar y completar.
 * Simplifica la implementación del patrón Command.
 */
public class TaskCommand implements Command {
    
    // Enum para definir los tipos de operación
    public enum OperationType {
        CREATE, EDIT, DELETE, COMPLETE
    }
    
    private TaskManager receiver;
    private OperationType operation;
    private int taskId;
    private String title;
    private String description;
    
    // Variables para almacenar estado anterior (para undo)
    private Task backupTask;
    private boolean wasExecuted;

    /**
     * Constructor para operación CREATE
     */
    public TaskCommand(TaskManager receiver, OperationType operation, String title, String description) {
        this.receiver = receiver;
        this.operation = operation;
        this.title = title;
        this.description = description;
        this.wasExecuted = false;
    }

    /**
     * Constructor para operaciones EDIT, DELETE, COMPLETE
     */
    public TaskCommand(TaskManager receiver, OperationType operation, int taskId, String title, String description) {
        this.receiver = receiver;
        this.operation = operation;
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.wasExecuted = false;
    }

    /**
     * Constructor simplificado para operaciones DELETE y COMPLETE
     */
    public TaskCommand(TaskManager receiver, OperationType operation, int taskId) {
        this.receiver = receiver;
        this.operation = operation;
        this.taskId = taskId;
        this.wasExecuted = false;
    }

    @Override
    public void execute() {
        switch (operation) {
            case CREATE:
                executeCreate();
                break;
            case EDIT:
                executeEdit();
                break;
            case DELETE:
                executeDelete();
                break;
            case COMPLETE:
                executeComplete();
                break;
        }
    }

    @Override
    public void undo() {
        if (!wasExecuted) {
            System.out.println("No se puede deshacer: el comando no fue ejecutado exitosamente");
            return;
        }

        switch (operation) {
            case CREATE:
                undoCreate();
                break;
            case EDIT:
                undoEdit();
                break;
            case DELETE:
                undoDelete();
                break;
            case COMPLETE:
                undoComplete();
                break;
        }
    }

    @Override
    public String getDescription() {
        switch (operation) {
            case CREATE:
                return "Crear tarea: " + title;
            case EDIT:
                return "Editar tarea ID " + taskId + ": " + title;
            case DELETE:
                return "Eliminar tarea ID: " + taskId;
            case COMPLETE:
                return "Completar tarea ID: " + taskId;
            default:
                return "Operación desconocida";
        }
    }

    // Métodos privados para ejecutar cada operación
    private void executeCreate() {
        backupTask = receiver.createTask(title, description);
        wasExecuted = (backupTask != null);
    }

    private void executeEdit() {
        Task originalTask = receiver.getTask(taskId);
        if (originalTask != null) {
            backupTask = originalTask.copy(); // Guardar estado original
            wasExecuted = receiver.editTask(taskId, title, description);
        }
    }

    private void executeDelete() {
        backupTask = receiver.deleteTask(taskId);
        wasExecuted = (backupTask != null);
    }

    private void executeComplete() {
        Task task = receiver.getTask(taskId);
        if (task != null) {
            backupTask = task.copy(); // Guardar estado original
            wasExecuted = receiver.completeTask(taskId);
        }
    }

    // Métodos privados para deshacer cada operación
    private void undoCreate() {
        if (backupTask != null) {
            receiver.deleteTask(backupTask.getId());
            System.out.println("Deshecha creacion de tarea: " + backupTask.getTitle());
        }
    }

    private void undoEdit() {
        if (backupTask != null) {
            receiver.editTask(taskId, backupTask.getTitle(), backupTask.getDescription());
            System.out.println("Deshecha edicion de tarea ID: " + taskId);
        }
    }

    private void undoDelete() {
        if (backupTask != null) {
            receiver.restoreTask(backupTask);
            System.out.println("Deshecha eliminacion de tarea: " + backupTask.getTitle());
        }
    }

    private void undoComplete() {
        if (backupTask != null) {
            receiver.uncompleteTask(taskId);
            System.out.println("Deshecha completar tarea ID: " + taskId);
        }
    }

    /**
     * Obtiene la tarea afectada por este comando (útil para operaciones posteriores)
     */
    public Task getAffectedTask() {
        return backupTask;
    }

    /**
     * Verifica si el comando fue ejecutado exitosamente
     */
    public boolean wasExecutedSuccessfully() {
        return wasExecuted;
    }
}
