package mx.uach.videoclub.modelos;

import mx.uach.videoclub.modelos.genericos.Model;

/**
 * Modelo para mappear los directores de las peliculas del VideoClub
 *
 * @author Daniela Santillanes Castro
 * @version 1.0
 */
public class Director extends Model {

    public static final String TABLA = "Director";

    public static final String[] FIELDS = {"id", "nombre"};

    public static final String Q = String.format("SELECT %s FROM %s",
            fieldsToQuery(FIELDS, Boolean.FALSE), TABLA);

    public static final String INSERT_DIRECTOR
            = String.format("%s %s (%s) VALUES (%s);",
                    Model.INSERT, TABLA, fieldsToQuery(FIELDS, Boolean.TRUE),
                    paramsToStatement(FIELDS, Boolean.TRUE));

    public static final String UPDATE_DIRECTOR
            = String.format("%s %s SET %s WHERE %s = ?",
                    Model.UPDATE, TABLA, paramsToStatementToCreate(FIELDS, Boolean.TRUE),
                    ID);

    public static final String DELETE_DIRECTOR
            = String.format("%s %s %s ?", Model.DELETE, TABLA, Model.Q_WHERE_ID);

    private String nombre;

    /**
     * Constructor vacio
     */
    public Director() {
    }

    /**
     * Constructor que trae de parametro el nombre del director.
     *
     * @param nombre que es el nombre del director.
     */
    public Director(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor que trae de parametro el id y el nombre del director.
     *
     * @param id identificador del director.
     * @param nombre que es el nombre del director.
     */
    public Director(Integer id, String nombre) {
        this(nombre);
        this.setId(id);
    }

    /**
     * Método que te obtiene el nombre del director.
     *
     * @return nombre del director.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para asignar un nombre al director.
     *
     * @param nombre que es el nombre del director.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
