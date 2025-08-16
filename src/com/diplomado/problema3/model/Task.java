package com.diplomado.problema3.model;

/**
 * Representa una tarea en el sistema de gestión de tareas.
 * Esta clase actúa como el objeto sobre el cual se ejecutan los comandos.
 */
public class Task {
    private int id;
    private String title;
    private String description;
    private boolean completed;

    /**
     * Constructor para crear una nueva tarea.
     * 
     * @param id Identificador único de la tarea
     * @param title Título de la tarea
     * @param description Descripción detallada de la tarea
     */
    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Crea una copia de la tarea actual.
     * Útil para operaciones de undo que necesitan restaurar el estado anterior.
     * 
     * @return Una nueva instancia de Task con los mismos valores
     */
    public Task copy() {
        Task copy = new Task(this.id, this.title, this.description);
        copy.setCompleted(this.completed);
        return copy;
    }

    @Override
    public String toString() {
        return String.format("Task{id=%d, title='%s', description='%s', completed=%s}", 
                           id, title, description, completed);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
