package mx.uach.videoclub.modelos;

import java.util.Date;
import mx.uach.videoclub.modelos.genericos.Model;

/**
 * Modelo para mappear las Fichas de las peliculas del VideoClub
 *
 * @author Daniela Santillanes Castro
 * @version 1.0
 * @since 06/10/2016
 */
public class Ficha extends Model {

    public static final String TABLA = "fichas";

    public static final String[] FIELDS = {"id", "fecha_prestamo", "socio_id"};

    public static final String Q = String.format("SELECT %s FROM %s",
            fieldsToQuery(FIELDS, Boolean.FALSE), TABLA);

    public static final String INSERT_FICHA
            = String.format("%s %s (%s) VALUES (%s);",
                    Model.INSERT, TABLA, fieldsToQuery(FIELDS, Boolean.TRUE),
                    paramsToStatement(FIELDS, Boolean.TRUE));

    public static final String UPDATE_FICHA
            = String.format("%s %s SET %s WHERE %s = ?",
                    Model.UPDATE, TABLA, paramsToStatementToCreate(FIELDS, Boolean.TRUE),
                    ID);

    public static final String DELETE_FICHA
            = String.format("%s %s %s ?", Model.DELETE, TABLA, Model.Q_WHERE_ID);

    private Date fechaPrestamo;
    private Socio socio;

    /**
     * Constructor vacio.
     */
    public Ficha() {
    }

    /**
     * Constructor que trae de parametros la fecha de prestamo y el socio de la
     * ficha.
     *
     * @param fechaPrestamo que es la fecha de prestamo de la cinta.
     * @param socio que es el socio al que se le hizo el prestamo.
     */
    public Ficha(Date fechaPrestamo, Socio socio) {
        this.fechaPrestamo = fechaPrestamo;
        this.socio = socio;
    }

    /**
     * Constructor que trae de parametros el id,la fecha de prestamo y el socio
     * de la ficha.
     *
     * @param id que es el identificador unico de la ficha.
     * @param fechaPrestamo que es la fecha de prestamo de la cinta.
     * @param socio que es el socio al que se le hizo el prestamo.
     */
    public Ficha(Integer id, Date fechaPrestamo, Socio socio) {
        this.fechaPrestamo = fechaPrestamo;
        this.socio = socio;
        this.setId(id);
    }

    /**
     * Método que obtiene la fecha del prestamo de la ficha.
     *
     * @return fechaPrestamo que es la fecha de prestamo de la ficha.
     */
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Método que asigna una fecha de prestamo a la ficha.
     *
     * @param fechaPrestamo que es la fecha de prestamo de la ficha.
     */
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * Método que obtiene el socio de la ficha.
     *
     * @return socio que es el socio de la ficha.
     */
    public Socio getSocio() {
        return socio;
    }

    /**
     * Método que asigna un socio a la ficha.
     *
     * @param socio que es el socio de la ficha.
     */
    public void setSocio(Socio socio) {
        this.socio = socio;
    }

}
