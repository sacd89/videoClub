package mx.uach.videoclub.modelos;

import mx.uach.videoclub.modelos.genericos.Model;

/**
 * Modelo para mappear los actores de las peliculas del VideoClub
 *
 * @author Daniela Santillanes Castro
 * @version 1.0
 * @since 06/10/2016
 */
public class Actor extends Model {

    public static final String TABLA = "Actor";

    public static final String[] FIELDS = {"id", "nombre", "apellido"};

    public static final String Q = String.format("SELECT %s FROM %s",
            fieldsToQuery(FIELDS, Boolean.FALSE), TABLA);

    public static final String INSERT_ACTOR
            = String.format("%s %s (%s) VALUES (%s);",
                    Model.INSERT, TABLA, fieldsToQuery(FIELDS, Boolean.TRUE),
                    paramsToStatement(FIELDS, Boolean.TRUE));

    public static final String UPDATE_ACTOR
            = String.format("%s %s SET %s WHERE %s = ?",
                    Model.UPDATE, TABLA, paramsToStatementToCreate(FIELDS, Boolean.TRUE),
                    ID);

    public static final String DELETE_ACTOR
            = String.format("%s %s %s ?", Model.DELETE, TABLA, Model.Q_WHERE_ID);

    private String nombre;
    private String apellido;

    /**
     * Constructor vacio.
     */
    public Actor() {
    }

    /**
     * Constructor que trae de parametros el nombre y apellido del actor.
     *
     * @param nombre que es el nombre del actor.
     * @param apellido que es el apellido del actor.
     */
    public Actor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     * Constructor que trae de parametro el id,el nombre y apellido del actor.
     *
     * @param id que es el identificador del actor.
     * @param nombre que es el nombre del actor.
     * @param apellido que es el apellido del actor.
     */
    public Actor(Integer id, String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.setId(id);
    }

    /**
     * Método que te obtiene el nombre del actor.
     *
     * @return nombre que es el nombre del actor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que te asigna un nombre al actor.
     *
     * @param nombre que es el nombre del actor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que te obtiene el apellido del actor.
     *
     * @return apellido que es el apellido del actor.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Método que asigna un apellido al actor.
     *
     * @param apellido que es el apellido del actor.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
