package co.edu.uniquindio.proyectobases.connection;

import co.edu.uniquindio.proyectobases.aplication.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public boolean guardarProducto(Producto producto) {
        String sql = "INSERT INTO PRODUCTO (ID_PRODUCTO, NOMBRE, PRECIO, CATEGORIA_ID_CATEGORIA, ID_DESCPRODUCTO) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = cx.prepareStatement(sql)) {
            pstmt.setInt(1, producto.getIdProducto());
            pstmt.setString(2, producto.getNombre());
            pstmt.setFloat(3, producto.getPrecio());
            pstmt.setInt(4, producto.getIdCategoria());
            pstmt.setInt(5, producto.getIdDescripcionPTO());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al guardar el producto");
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarProducto(Producto producto) {
        String sql = "UPDATE PRODUCTO SET NOMBRE = ?, PRECIO = ?, CATEGORIA_ID_CATEGORIA = ?, ID_DESCPRODUCTO = ? WHERE ID_PRODUCTO = ?";
        try (PreparedStatement pstmt = cx.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setFloat(2, producto.getPrecio());
            pstmt.setInt(3, producto.getIdCategoria());
            pstmt.setInt(4, producto.getIdDescripcionPTO());
            pstmt.setInt(5, producto.getIdProducto());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto");
            e.printStackTrace();
            return false;
        }
    }

    public List<Producto> cargarProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTO";

        try (Statement stmt = cx.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getInt("ID_PRODUCTO"),
                        rs.getString("NOMBRE"),
                        rs.getFloat("PRECIO"),
                        rs.getInt("ID_CATEGORIA"),
                        rs.getInt("ID_DESCRIPCION_PTO")
                );
                listaProductos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar los productos");
            e.printStackTrace();
        }
        return listaProductos;
    }
}
