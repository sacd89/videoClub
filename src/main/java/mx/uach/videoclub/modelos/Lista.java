package mx.uach.videoclub.modelos;

import java.util.Date;
import mx.uach.videoclub.modelos.genericos.Model;

/**
 * Modelo para mappear las listas de las peliculas del VideoClub
 *
 * @author Daniela Santillanes Castro
 * @version 1.0
 * @since 06/10/2016
 */
public class Lista extends Model {

    public static final String TABLA = "listas";

    public static final String[] FIELDS = {"id", "fecha", "hora", "estatus", "socios_id", "peliculas_id"};

    public static final String Q = String.format("SELECT %s FROM %s",
            fieldsToQuery(FIELDS, Boolean.FALSE), TABLA);

    public static final String INSERT_LISTA
            = String.format("%s %s (%s) VALUES (%s);",
                    Model.INSERT, TABLA, fieldsToQuery(FIELDS, Boolean.TRUE),
                    paramsToStatement(FIELDS, Boolean.TRUE));

    public static final String UPDATE_LISTA
            = String.format("%s %s SET %s WHERE %s = ?",
                    Model.UPDATE, TABLA, paramsToStatementToCreate(FIELDS, Boolean.TRUE),
                    ID);

    public static final String DELETE_LISTA
            = String.format("%s %s %s ?", Model.DELETE, TABLA, Model.Q_WHERE_ID);

    private Date fecha;
    private Date hora;
    private Boolean estatus;
    private Socio socio;
    private Pelicula pelicula;

    /**
     * Constructor vacio.
     */
    public Lista() {
    }

    /**
     * Constructor que trae de paramentros la fecha, hora, estatus, socio y
     * pelicula de la lista.
     *
     * @param fecha que es la fecha de la lista.
     * @param hora que es la hora de la lista.
     * @param estatus que es el estatus de la lista.
     * @param socio que es el socio de la lista.
     * @param pelicula que es la pelicula de la lista.
     */
    public Lista(Date fecha, Date hora, Boolean estatus, Socio socio, Pelicula pelicula) {
        this.fecha = fecha;
        this.hora = hora;
        this.estatus = estatus;
        this.socio = socio;
        this.pelicula = pelicula;
    }

    /**
     * Constructor que trae de paramentros el id, la fecha, hora, estatus, socio
     * y pelicula de la lista.
     *
     * @param id que es el identificador unico de la lista.
     * @param fecha que es la fecha de la lista.
     * @param hora que es la hora de la lista.
     * @param estatus que es el estatus de la lista.
     * @param socio que es el socio de la lista.
     * @param pelicula que es la pelicula de la lista.
     */
    public Lista(Integer id, Date fecha, Date hora, Boolean estatus, Socio socio, Pelicula pelicula) {
        this.setId(id);
        this.fecha = fecha;
        this.hora = hora;
        this.estatus = estatus;
        this.socio = socio;
        this.pelicula = pelicula;
    }

    /**
     * Método que obtiene la fecha de la lista.
     *
     * @return fecha que es la fecha de la lista.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Método que asigna una fecha a un lista.
     *
     * @param fecha que es la fecha de la lista.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Método que obtiene la hora de la lista.
     *
     * @return hora que es la hora de la lista.
     */
    public Date getHora() {
        return hora;
    }

    /**
     * Método que asigna una hora a una lista.
     *
     * @param hora que es la hora de la lista.
     */
    public void setHora(Date hora) {
        this.hora = hora;
    }

    /**
     * Método que obtiene el estatus de la lista.
     *
     * @return estatus que es el estatus de la lista.
     */
    public Boolean getEstatus() {
        return estatus;
    }

    /**
     * Método que asigna un estatus a una lista.
     *
     * @param estatus que es el estatus de la lista.
     */
    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    /**
     * Método que obtiene el socio de la lista.
     *
     * @return socio que es el socio de la lista.
     */
    public Socio getSocio() {
        return socio;
    }

    /**
     * Método que asigna un socio a una lista.
     *
     * @param socio que es el socio de la lista.
     */
    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    /**
     * Método que obtiene la pelicula de la lista.
     *
     * @return pelicula que es la pelicula de la lista.
     */
    public Pelicula getPelicula() {
        return pelicula;
    }

    /**
     * Método que asigna una pelicula a la lista.
     *
     * @param pelicula que es la pelicula de la lista.
     */
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
