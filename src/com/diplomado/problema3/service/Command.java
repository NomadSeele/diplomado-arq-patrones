package com.diplomado.problema3.service;

/**
 * Interfaz Command que define la estructura básica para todos los comandos.
 * Esta interfaz es el núcleo del patrón Command, permitiendo encapsular
 * las operaciones como objetos.
 */
public interface Command {
    
    /**
     * Ejecuta el comando.
     * Este método encapsula la acción que debe realizarse.
     */
    void execute();
    
    /**
     * Deshace la operación realizada por el comando.
     * Permite implementar funcionalidad de undo.
     */
    void undo();
    
    /**
     * Obtiene una descripción del comando para propósitos de logging.
     * 
     * @return Descripción textual del comando
     */
    String getDescription();
}
