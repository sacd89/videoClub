package mx.uach.videoclub.modelos;

import mx.uach.videoclub.modelos.genericos.Model;

/**
 * Modelo para mappear los socios del VideoClub.
 *
 * @author Daniela Santillanes Castro
 * @version 1.0
 * @since 06/10/2016
 */
public class Socio extends Model {

    public static final String TABLA = "socios";

    public static final String[] FIELDS = {"id", "nombre", "direccion",
        "telefono"};

    public static final String Q = String.format("SELECT %s FROM %s",
            fieldsToQuery(FIELDS, Boolean.FALSE), TABLA);

    public static final String INSERT_SOCIO
            = String.format("%s %s (%s) VALUES (%s);",
                    Model.INSERT, TABLA, fieldsToQuery(FIELDS, Boolean.TRUE),
                    paramsToStatement(FIELDS, Boolean.TRUE));

    public static final String UPDATE_SOCIO
            = String.format("%s %s SET %s WHERE %s = ?",
                    Model.UPDATE, TABLA, paramsToStatementToCreate(FIELDS, Boolean.TRUE),
                    ID);

    public static final String DELETE_SOCIO
            = String.format("%s %s %s ?", Model.DELETE, TABLA, Model.Q_WHERE_ID);

    private String nombre;
    private String direccion;
    private String telefono;

    /**
     * Constructor vacio.
     */
    public Socio() {
    }

    /**
     * Constructor que trae de parametros el nombre, direccion, telefono,
     * directores y actores favoritos del socio.
     *
     * @param nombre que es el nombre del socio.
     * @param direccion que es la direccion del socio.
     * @param telefono que es el telefono del socio.
     */
    public Socio(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * Constructor que trae de parametros el id, nombre, direccion, telefono,
     * directores y actores favoritos del socio.
     *
     * @param id que es el identificador unico del socio.
     * @param nombre que es el nombre del socio.
     * @param direccion que es la direccion del socio.
     * @param telefono que es el telefono del socio.
     */
    public Socio(Integer id, String nombre, String direccion, String telefono) {
        this.setId(id);
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * Método que obtiene el nombre del socio.
     *
     * @return nombre que es el nombre del socio.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que asigna un nombre a un socio.
     *
     * @param nombre que es el nombre del socio.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que obtiene la dirección del socio.
     *
     * @return direccion que es la dirección del socio.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método que asigna una dirección a un socio.
     *
     * @param direccion que es la dirección del socio.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método que obtiene el telefono del socio.
     *
     * @return telefono que es el telefono del socio.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método que asigna un telefono a un socio.
     *
     * @param telefono que es el telefono del socio.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
