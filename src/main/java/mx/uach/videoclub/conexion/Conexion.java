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
    
    private final static String USUARIO = "root";
    private final static String PASSWORD = "soojung";
    private final static String CONEXION =
            "jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static Conexion INSTANCE;
    private Connection con;

    /**
     * Constructor de la conexión a la base de datos.
     */
    private Conexion() {
        this.initConection();
    }

    /**
     * Método que crea la conexión a la base de datos.
     */
    private void initConection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(CONEXION, USUARIO, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que obtiene la instancia de la conexión de la base de datos.
     * 
     * @return INSTANCE que es la instancia que creamos.
     */
    public static Conexion getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Conexion();
        }
        return INSTANCE;
    }

    /**
     * Método que obtiene la conexión.
     * 
     * @return con que es la conexión de la base de datos.
     */
    public Connection getCon() {
        return con;
    }
}
