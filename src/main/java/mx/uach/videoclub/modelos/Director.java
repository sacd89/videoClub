
package mx.uach.videoclub.modelos;

import mx.uach.videoclub.genericos.Model;

/**
 * Modelo para mappear los directores de las peliculas del VideoClub
 *
 * @author Daniela Santillanes Castro
 * @version 1.0
 */
public class Director extends Model {
    
    public static final String TABLA = "directores";
    public static final String[] FIELDS = {"id", "nombre"};
    public static final String Q = String.format("SELECT %s FROM %s",
            fieldsToQuery(FIELDS, false), TABLA);
    public static final String INSERT_DIRECTOR = 
            String.format("%s %s (%s) VALUES (%s);", 
            Model.INSERT, TABLA, fieldsToQuery(FIELDS, Boolean.TRUE), 
            paramsToStatement(FIELDS, Boolean.TRUE));
    public static final String UPDATE_DIRECTOR = 
            String.format("%s %s SET %s WHERE %s = ?;", 
            Model.UPDATE, TABLA, paramsToStatementToCreate(FIELDS, Boolean.TRUE),
            ID);
    public static final String DELETE_DIRECTOR = 
            String.format("%s %s %s ?;", 
            Model.DELETE, TABLA, Model.Q_WHERE_ID);
            
    
    private String nombre;
    
    public Director() {
    }
    
    public Director(String nombre) {
        this.nombre = nombre;
    }
    
    public Director(Integer id, String nombre) {
        this(nombre);
        this.setId(id);
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
