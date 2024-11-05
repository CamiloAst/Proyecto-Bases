package co.edu.uniquindio.proyectobases.connection;

import java.sql.*;

public class DatabaseConnection {

    private final String stringConexion = "jdbc:oracle:thin:@localhost:1521:xe";
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private Connection cx;
    private String usr = "PROYECTO";
    private String passwd = "1234";
    private Statement statement;
    private ResultSet resultSet;

    public DatabaseConnection(){

    }

    public Connection conectar(){
        try{
            Class.forName(driver);
            cx = DriverManager.getConnection(stringConexion, usr, passwd);
            System.out.println("Se ha levantado la conexión a la base de datos");
        } catch (ClassNotFoundException e) {
            System.out.println("El driver JDBC no se encontró");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
        }
        return cx;
    }
}
