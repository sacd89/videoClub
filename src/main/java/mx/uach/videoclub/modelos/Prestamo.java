package mx.uach.videoclub.modelos;

import java.util.Date;
import mx.uach.videoclub.dao.enums.Prestamos;
import mx.uach.videoclub.modelos.genericos.Model;

/**
 * Modelo para mappear los prestamos de las peliculas del VideoClub.
 *
 * @author Daniela Santillanes Castro
 * @version 1.0
 * @since 06/10/2016
 */
public class Prestamo extends Model {

    public static final String TABLA = "prestamo";

    public static final String[] FIELDS = {"id", "fecha_entrega", "estatus",
        "fichas_id", "cintas_id"};

    public static final String Q = String.format("SELECT %s FROM %s",
            fieldsToQuery(FIELDS, Boolean.FALSE), TABLA);

    public static final String INSERT_PRESTAMO
            = String.format("%s %s (%s) VALUES (%s);",
                    Model.INSERT, TABLA, fieldsToQuery(FIELDS, Boolean.TRUE),
                    paramsToStatement(FIELDS, Boolean.TRUE));

    public static final String UPDATE_PRESTAMO
            = String.format("%s %s SET %s WHERE %s = ?",
                    Model.UPDATE, TABLA, paramsToStatementToCreate(FIELDS, Boolean.TRUE),
                    ID);

    public static final String DELETE_PRESTAMO
            = String.format("%s %s %s ?", Model.DELETE, TABLA, Model.Q_WHERE_ID);

    private Date fechaEntrega;
    private Prestamos estatus;
    private Ficha ficha;
    private Cinta cinta;

    /**
     * Constructor vacio.
     */
    public Prestamo() {
    }

    /**
     * Constructor que trae de parametros la fecha de entrega, estatus, ficha y
     * cinta del prestamo.
     *
     * @param fechaEntrega que es la fecha de entrega de la cinta.
     * @param estatus que es el estado del prestamo.
     * @param ficha que es la ficha del prestamo.
     * @param cinta que es la cinta del prestamo.
     */
    public Prestamo(Date fechaEntrega, Prestamos estatus, Ficha ficha, Cinta cinta) {
        this.fechaEntrega = fechaEntrega;
        this.estatus = estatus;
        this.ficha = ficha;
        this.cinta = cinta;
    }

    /**
     * Constructor que trae de parametros el id, la fecha de entrega, estatus,
     * ficha y cinta del prestamo.
     *
     * @param id que es el identificador unico del prestamo.
     * @param fechaEntrega que es la fecha de entrega de la cinta.
     * @param estatus que es el estado del prestamo.
     * @param ficha que es la ficha del prestamo.
     * @param cinta que es la cinta del prestamo.
     */
    public Prestamo(Integer id, Date fechaEntrega, Prestamos estatus, Ficha ficha, Cinta cinta) {
        this.setId(id);
        this.fechaEntrega = fechaEntrega;
        this.estatus = estatus;
        this.ficha = ficha;
        this.cinta = cinta;
    }

    /**
     * Método que obtiene la fecha de entrega de la cinta del prestamo.
     *
     * @return fechaEntrega que es la fecha de entrega de la cinta.
     */
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Método que asigna una fecha de entrega a una cinta dentro de un prestamo.
     *
     * @param fechaEntrega que es la fecha de entrega de la cinta.
     */
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * Método que obtiene el estatus del prestamo.
     *
     * @return estatus que es el estatus del prestamo.
     */
    public Prestamos getEstatus() {
        return estatus;
    }

    /**
     * Método que asigna un estatus a un prestamo.
     *
     * @param estatus que es el estatus del prestamo.
     */
    public void setEstatus(Prestamos estatus) {
        this.estatus = estatus;
    }

    /**
     * Método que obtiene la ficha del prestamo.
     *
     * @return ficha que es la ficha del prestamo.
     */
    public Ficha getFicha() {
        return ficha;
    }

    /**
     * Método que asigna una ficha a un prestamo.
     *
     * @param ficha que es la ficha de un prestamo.
     */
    public void setFicha(Ficha ficha) {
        this.ficha= ficha;
    }

    /**
     * Método que obtiene la cinta del prestamo.
     *
     * @return cinta que es la cinta de un prestamo.
     */
    public Cinta getCinta() {
        return cinta;
    }

    /**
     * Método que asigna una cinta a un prestamo.
     *
     * @param cinta que es la cinta de un prestamo.
     */
    public void setCinta(Cinta cinta) {
        this.cinta = cinta;
    }
}
