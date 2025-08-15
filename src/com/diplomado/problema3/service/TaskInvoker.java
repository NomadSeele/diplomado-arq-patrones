package com.diplomado.problema3.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Invocador de comandos que actúa como el Invoker en el patrón Command.
 * Esta clase es responsable de ejecutar comandos y mantener un historial
 * para operaciones de deshacer.
 */
public class TaskInvoker {
    private List<Command> commandHistory;
    private int currentPosition;

    /**
     * Constructor que inicializa el invocador de comandos.
     */
    public TaskInvoker() {
        this.commandHistory = new ArrayList<>();
        this.currentPosition = -1;
    }

    /**
     * Ejecuta un comando y lo agrega al historial.
     * 
     * @param command El comando a ejecutar
     */
    public void executeCommand(Command command) {
        // Eliminar comandos posteriores a la posición actual si existieran
        // (esto ocurre cuando se ejecuta un nuevo comando después de hacer undo)
        if (currentPosition < commandHistory.size() - 1) {
            commandHistory = commandHistory.subList(0, currentPosition + 1);
        }

        // Ejecutar el comando
        command.execute();
        
        // Agregar al historial
        commandHistory.add(command);
        currentPosition++;
        
        System.out.println("Comando ejecutado: " + command.getDescription());
    }

    /**
     * Deshace el último comando ejecutado.
     * 
     * @return true si se pudo deshacer un comando, false si no hay comandos para deshacer
     */
    public boolean undoLastCommand() {
        if (canUndo()) {
            Command lastCommand = commandHistory.get(currentPosition);
            lastCommand.undo();
            currentPosition--;
            System.out.println("Comando deshecho: " + lastCommand.getDescription());
            return true;
        } else {
            System.out.println("No hay comandos para deshacer.");
            return false;
        }
    }

    /**
     * Rehace el siguiente comando en el historial.
     * 
     * @return true si se pudo rehacer un comando, false si no hay comandos para rehacer
     */
    public boolean redoCommand() {
        if (canRedo()) {
            currentPosition++;
            Command commandToRedo = commandHistory.get(currentPosition);
            commandToRedo.execute();
            System.out.println("Comando rehecho: " + commandToRedo.getDescription());
            return true;
        } else {
            System.out.println("No hay comandos para rehacer.");
            return false;
        }
    }

    /**
     * Verifica si es posible deshacer un comando.
     * 
     * @return true si hay comandos para deshacer
     */
    public boolean canUndo() {
        return currentPosition >= 0;
    }

    /**
     * Verifica si es posible rehacer un comando.
     * 
     * @return true si hay comandos para rehacer
     */
    public boolean canRedo() {
        return currentPosition < commandHistory.size() - 1;
    }

    /**
     * Obtiene el historial de comandos ejecutados.
     * 
     * @return Lista con la descripción de todos los comandos ejecutados
     */
    public List<String> getCommandHistory() {
        List<String> history = new ArrayList<>();
        for (int i = 0; i <= currentPosition; i++) {
            history.add(commandHistory.get(i).getDescription());
        }
        return history;
    }

    /**
     * Muestra el historial de comandos en formato legible.
     */
    public void displayCommandHistory() {
        if (commandHistory.isEmpty()) {
            System.out.println("No hay comandos en el historial.");
            return;
        }

        System.out.println("\nHistorial de Comandos:");
        System.out.println("========================");
        for (int i = 0; i < commandHistory.size(); i++) {
            String marker = (i <= currentPosition) ? "[X]" : "[ ]";
            System.out.printf("%s %d. %s\n", marker, i + 1, commandHistory.get(i).getDescription());
        }
        System.out.println();
    }

    /**
     * Limpia el historial de comandos.
     */
    public void clearHistory() {
        commandHistory.clear();
        currentPosition = -1;
        System.out.println("Historial de comandos limpiado.");
    }

    /**
     * Obtiene el número total de comandos en el historial.
     * 
     * @return Número de comandos en el historial
     */
    public int getHistorySize() {
        return commandHistory.size();
    }
}
