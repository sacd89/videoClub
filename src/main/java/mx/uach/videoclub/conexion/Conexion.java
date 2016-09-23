package mx.uach.videoclub.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Conexión a base de datos MySQL
 * 
 * @author Daniela Santillanes Castro
 * @version 1.0
 */
public class Conexion {
    
    private static Conexion INSTANCE;
    private Connection con;
    private final static String USUARIO = "root";
    private final static String PASSWORD = "";
    private final static String CONEXION = "jdbc:mysql://localhost:3306/db_video";

    private Conexion() {
        initConnection();
    }
    
    private void initConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(CONEXION, USUARIO, PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Conexion getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Conexion();
        }
        return INSTANCE;
    }
    
    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }
}
