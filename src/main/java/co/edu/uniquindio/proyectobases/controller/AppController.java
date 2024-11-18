package co.edu.uniquindio.proyectobases.controller;

import co.edu.uniquindio.proyectobases.connection.DatabaseConnection;

public enum AppController {

    INSTANCE;

    private final DatabaseConnection databaseConnection;

    AppController() {
        databaseConnection = new DatabaseConnection();
    }

    public DatabaseConnection getDatabaseConnection() {
        return databaseConnection;
    }

    
}
