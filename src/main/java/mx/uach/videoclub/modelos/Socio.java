package mx.uach.videoclub.modelos;

import java.util.List;
import mx.uach.videoclub.modelos.genericos.Model;

/**
 * Modelo para mappear los socios del VideoClub.
 *
 * @author Daniela Santillanes Castro
 * @version 1.0
 * @since 06/10/2016
 */
public class Socio extends Model {

    public static final String TABLA = "Socio";

    public static final String[] FIELDS = {"id", "nombre", "direccion",
        "telefono", "directores", "actores"};

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
    private List<Director> directores;
    private List<Actor> actores;

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
     * @param directores que son los directores favoritos del socio.
     * @param actores que son los actores favoritos del socio.
     */
    public Socio(String nombre, String direccion, String telefono, List<Director> directores, List<Actor> actores) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.directores = directores;
        this.actores = actores;
    }

    /**
     * Constructor que trae de parametros el id, nombre, direccion, telefono,
     * directores y actores favoritos del socio.
     *
     * @param id que es el identificador unico del socio.
     * @param nombre que es el nombre del socio.
     * @param direccion que es la direccion del socio.
     * @param telefono que es el telefono del socio.
     * @param directores que son los directores favoritos del socio.
     * @param actores que son los actores favoritos del socio.
     */
    public Socio(Integer id, String nombre, String direccion, String telefono, List<Director> directores, List<Actor> actores) {
        this.setId(id);
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.directores = directores;
        this.actores = actores;
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

    /**
     * Método que obtiene una lista de directores del socio.
     *
     * @return directores que son los directores favoritos del socio.
     */
    public List<Director> getDirectores() {
        return directores;
    }

    /**
     * Método que asigna directores favoritos a un socio.
     *
     * @param directores que es una lista de directores favoritos del socio.
     */
    public void setDirectores(List<Director> directores) {
        this.directores = directores;
    }

    /**
     * Método que obtiene una lista de actores del socio.
     *
     * @return actores que son los actores favoritos del socio.
     */
    public List<Actor> getActores() {
        return actores;
    }

    /**
     * Método que asigna actores favoritos a un socio.
     *
     * @param actores que es una lista de actores favoritos del socio.
     */
    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }
}
