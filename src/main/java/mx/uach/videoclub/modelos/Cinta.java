package mx.uach.videoclub.modelos;

import mx.uach.videoclub.modelos.genericos.Model;

/**
 * Modelo para mappear las cintas de las peliculas del VideoClub
 *
 * @author Daniela Santillanes Castro
 * @version 1.0
 * @since 06/10/2016
 */
public class Cinta extends Model {

    public static final String TABLA = "Cinta";

    public static final String[] FIELDS = {"id", "numeroCopias", "pelicula"};

    public static final String Q = String.format("SELECT %s FROM %s",
            fieldsToQuery(FIELDS, Boolean.FALSE), TABLA);

    public static final String INSERT_CINTA
            = String.format("%s %s (%s) VALUES (%s);",
                    Model.INSERT, TABLA, fieldsToQuery(FIELDS, Boolean.TRUE),
                    paramsToStatement(FIELDS, Boolean.TRUE));

    public static final String UPDATE_CINTA
            = String.format("%s %s SET %s WHERE %s = ?",
                    Model.UPDATE, TABLA, paramsToStatementToCreate(FIELDS, Boolean.TRUE),
                    ID);

    public static final String DELETE_CINTA
            = String.format("%s %s %s ?", Model.DELETE, TABLA, Model.Q_WHERE_ID);

    private Integer numCopia;
    private Pelicula pelicula;

    /**
     * Constructor vacio.
     */
    public Cinta() {
    }

    /**
     * Constructor que trae de parametros el número de copias y la pelicula de
     * la cinta.
     *
     * @param numCopia que es el número de copias de la cinta.
     * @param pelicula que es la pelicula de la cinta.
     */
    public Cinta(Integer numCopia, Pelicula pelicula) {
        this.numCopia = numCopia;
        this.pelicula = pelicula;
    }

    /**
     * Constructor que trae de parametros el id, el número de copias y la
     * pelicula de la cinta.
     *
     * @param id qie es el identificador unico de la cinta.
     * @param numCopia que es el número de copias de la cinta.
     * @param pelicula que es la pelicula de la cinta.
     */
    public Cinta(Integer id, Integer numCopia, Pelicula pelicula) {
        this.numCopia = numCopia;
        this.pelicula = pelicula;
        this.setId(id);
    }

    /**
     * Método que te obtiene el número de copias de la cinta.
     *
     * @return numCopia que es el número de copias de la cinta.
     */
    public Integer getNumCopia() {
        return numCopia;
    }

    /**
     * Método que asigna un número de copas a la cinta.
     *
     * @param numCopia que es el número de copias de la cinta.
     */
    public void setNumCopia(Integer numCopia) {
        this.numCopia = numCopia;
    }

    /**
     * Método que obtiene la pelicula de la cinta.
     *
     * @return pelicula que es la pelicula de la cinta.
     */
    public Pelicula getPelicula() {
        return pelicula;
    }

    /**
     * Método que asigna una pelicula a la cinta.
     *
     * @param pelicula que es la pelicula de la cinta.
     */
    public void setPelicula(Pelicula pelicula) {

        this.pelicula = pelicula;
    }

}
