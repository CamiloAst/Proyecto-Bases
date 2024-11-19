package co.edu.uniquindio.proyectobases.controller;

import co.edu.uniquindio.proyectobases.aplication.model.Afiliado;
import co.edu.uniquindio.proyectobases.connection.DatabaseConnection;

public enum AppController {

    INSTANCE;

    private final DatabaseConnection databaseConnection;
    private Afiliado afiliado;

    AppController() {
        afiliado = new Afiliado();
        databaseConnection = new DatabaseConnection();
    }

    public DatabaseConnection getDatabaseConnection() {
        return databaseConnection;
    }


    public void setUsuario(Afiliado afiliado) {
        this.afiliado = afiliado;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }
}
