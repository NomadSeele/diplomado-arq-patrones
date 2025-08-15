package com.diplomado.problema3.service;

import com.diplomado.problema3.model.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Gestor de tareas que actúa como el Receiver en el patrón Command.
 * Esta clase contiene la lógica de negocio para manipular las tareas.
 */
public class TaskManager {
    private List<Task> tasks;
    private int nextId;

    /**
     * Constructor que inicializa el gestor de tareas.
     */
    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.nextId = 1;
    }

    /**
     * Crea una nueva tarea y la agrega a la lista.
     * 
     * @param title Título de la tarea
     * @param description Descripción de la tarea
     * @return La tarea creada
     */
    public Task createTask(String title, String description) {
        Task task = new Task(nextId++, title, description);
        tasks.add(task);
        System.out.println("Tarea creada: " + task);
        return task;
    }

    /**
     * Edita una tarea existente.
     * 
     * @param taskId ID de la tarea a editar
     * @param newTitle Nuevo título
     * @param newDescription Nueva descripción
     * @return true si la tarea fue editada, false si no se encontró
     */
    public boolean editTask(int taskId, String newTitle, String newDescription) {
        Optional<Task> taskOpt = findTaskById(taskId);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            task.setTitle(newTitle);
            task.setDescription(newDescription);
            System.out.println("Tarea editada: " + task);
            return true;
        }
        System.out.println("No se encontro la tarea con ID: " + taskId);
        return false;
    }

    /**
     * Elimina una tarea del sistema.
     * 
     * @param taskId ID de la tarea a eliminar
     * @return La tarea eliminada, o null si no se encontró
     */
    public Task deleteTask(int taskId) {
        Optional<Task> taskOpt = findTaskById(taskId);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            tasks.remove(task);
            System.out.println("Tarea eliminada: " + task);
            return task;
        }
        System.out.println("No se encontro la tarea con ID: " + taskId);
        return null;
    }

    /**
     * Marca una tarea como completada.
     * 
     * @param taskId ID de la tarea a completar
     * @return true si la tarea fue completada, false si no se encontró
     */
    public boolean completeTask(int taskId) {
        Optional<Task> taskOpt = findTaskById(taskId);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            task.setCompleted(true);
            System.out.println("Tarea completada: " + task);
            return true;
        }
        System.out.println("No se encontro la tarea con ID: " + taskId);
        return false;
    }

    /**
     * Marca una tarea como no completada.
     * 
     * @param taskId ID de la tarea
     * @return true si la tarea fue marcada como no completada, false si no se encontró
     */
    public boolean uncompleteTask(int taskId) {
        Optional<Task> taskOpt = findTaskById(taskId);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            task.setCompleted(false);
            System.out.println("Tarea marcada como no completada: " + task);
            return true;
        }
        System.out.println("No se encontro la tarea con ID: " + taskId);
        return false;
    }

    /**
     * Restaura una tarea eliminada.
     * 
     * @param task La tarea a restaurar
     */
    public void restoreTask(Task task) {
        if (task != null && !tasks.contains(task)) {
            tasks.add(task);
            System.out.println("Tarea restaurada: " + task);
        }
    }

    /**
     * Obtiene una tarea por su ID.
     * 
     * @param taskId ID de la tarea
     * @return La tarea si se encuentra, null en caso contrario
     */
    public Task getTask(int taskId) {
        return findTaskById(taskId).orElse(null);
    }

    /**
     * Obtiene todas las tareas del sistema.
     * 
     * @return Lista de todas las tareas
     */
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    /**
     * Muestra todas las tareas en formato legible.
     */
    public void displayAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas en el sistema.");
            return;
        }

        System.out.println("\nLista de Tareas:");
        System.out.println("==================");
        for (Task task : tasks) {
            String status = task.isCompleted() ? "COMPLETADA" : "PENDIENTE";
            System.out.printf("ID: %d | %s | %s\n", task.getId(), status, task.getTitle());
            System.out.printf("   Descripción: %s\n", task.getDescription());
            System.out.println();
        }
    }

    /**
     * Busca una tarea por su ID.
     * 
     * @param taskId ID de la tarea
     * @return Optional con la tarea si se encuentra
     */
    private Optional<Task> findTaskById(int taskId) {
        return tasks.stream()
                   .filter(task -> task.getId() == taskId)
                   .findFirst();
    }
}
