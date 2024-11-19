package co.edu.uniquindio.proyectobases.connection;

import co.edu.uniquindio.proyectobases.aplication.model.Afiliado;
import co.edu.uniquindio.proyectobases.aplication.model.Producto;
import co.edu.uniquindio.proyectobases.aplication.model.Venta;

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



    public Afiliado buscarAfiliado(String email, String password) {
        String sql = "SELECT ID_AFILIADO, CEDULA, NOMBRE, APELLIDO, TELEFONO, EMAIL, FECHA_AFILIACION, RANGO_ID_RANGO, ADMINISTRADOR_ID_ADMINISTRADOR " +
                "FROM AFILIADO " +
                "WHERE EMAIL = ? AND CEDULA = ?";
        try (PreparedStatement pstmt = cx.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                Afiliado afiliado = new Afiliado(
                        resultSet.getInt("ID_AFILIADO"),
                        resultSet.getString("NOMBRE"),
                        resultSet.getString("RANGO_ID_RANGO"),
                        resultSet.getString("ADMINISTRADOR_ID_ADMINISTRADOR")
                );
                return afiliado;
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el afiliado");
            e.printStackTrace();
        }
        return null;
    }
    public List<Producto> cargarProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        String sql = "SELECT p.ID_PRODUCTO, p.NOMBRE, p.PRECIO, c.NOMBRE NOMBRE_CATEGORIA, d.DESCRIPCION " +
                "FROM PRODUCTO p " +
                "JOIN CATEGORIA c ON p.CATEGORIA_ID_CATEGORIA = c.ID_CATEGORIA " +
                "JOIN DESCRIPCION_PTO d ON p.ID_DESCPRODUCTO = d.ID_DESCPRODUCTO";

        try (Statement stmt = cx.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getInt("ID_PRODUCTO"),
                        rs.getString("NOMBRE"),
                        rs.getFloat("PRECIO"),
                        rs.getString("NOMBRE_CATEGORIA"),
                        rs.getString("DESCRIPCION")
                );
                listaProductos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar los productos");
            e.printStackTrace();
        }
        return listaProductos;
    }
    public boolean verificarAdmin(String idUser) {
        String sql = "SELECT ADMINISTRADOR_ID_ADMINISTRADOR FROM AFILIADO WHERE ID_AFILIADO = ?";
        try (PreparedStatement pstmt = cx.prepareStatement(sql)) {
            pstmt.setString(1, idUser);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                Integer adminId = resultSet.getObject("ADMINISTRADOR_ID_ADMINISTRADOR", Integer.class);
                if (adminId != null) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar el administrador");
            e.printStackTrace();}
        return false;
    }

    public boolean verificarDatosUsuario(String email, int idUser) {
        String sql = "SELECT EMAIL,CEDULA FROM AFILIADO WHERE EMAIL = ? AND CEDULA = ?";
        try (PreparedStatement pstmt = cx.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setInt(2, idUser);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar los datos del usuario");
            e.printStackTrace();
        }
        return false;
    }

    public List<Venta> cargarVentas() {
        List<Venta> listaVentas = new ArrayList<>();
        String sql = "SELECT v.ID_VENTA, v.FECHA_VENTA, v.TOTAL_VENTA, a.NOMBRE NOMBRE_AFILIADO, a.NOMBRE " +
                "FROM VENTA v " +
                "JOIN AFILIADO a ON v.AFILIADO_ID_AFILIADO = a.ID_AFILIADO";

        try (Statement stmt = cx.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Venta venta = new Venta(
                        rs.getInt("ID_VENTA"), // ID de la venta
                        rs.getDate("FECHA_VENTA"), // Fecha de la venta
                        rs.getFloat("TOTAL_VENTA"), // Total de la venta
                        rs.getString("NOMBRE_AFILIADO"), // Nombre del afiliado
                        rs.getString("NOMBRE") // ID del afiliado
                );
                listaVentas.add(venta);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar las ventas");
            e.printStackTrace();
        }
        return listaVentas;
    }

    public List<Afiliado> cargarAfiliadosJerarquicos(int idAfiliadoPadre) {
        List<Afiliado> listaAfiliados = new ArrayList<>();
        String sql =  "SELECT ID_AFILIADO, NOMBRE, RANGO_ID_RANGO, ADMINISTRADOR_ID_ADMINISTRADOR " +
                "FROM ( " +
                "    SELECT a.ID_AFILIADO, a.NOMBRE, a.RANGO_ID_RANGO, a.ADMINISTRADOR_ID_ADMINISTRADOR, LEVEL " +
                "    FROM AFILIADO a " +
                "    START WITH a.ID_AFILIADO = ? " +
                "    CONNECT BY PRIOR a.ID_AFILIADO = a.ADMINISTRADOR_ID_ADMINISTRADOR " +
                ") " +
                "ORDER BY LEVEL";

        try (PreparedStatement pstmt = cx.prepareStatement(sql)) {
            pstmt.setInt(1, idAfiliadoPadre);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Afiliado afiliado = new Afiliado(
                            rs.getInt("ID_AFILIADO"), // ID del afiliado
                            rs.getString("NOMBRE"),  // Nombre del afiliado
                            rs.getString("LEVEL"),   // Rango del afiliado
                            rs.getString("ADMINISTRADOR_ID_ADMINISTRADOR")    // ID del afiliado padre
                    );
                    listaAfiliados.add(afiliado);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar los afiliados jerárquicos");
            e.printStackTrace();
        }
        return listaAfiliados;
    }
}
