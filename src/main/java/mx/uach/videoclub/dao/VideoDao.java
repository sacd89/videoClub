package mx.uach.videoclub.dao;

import java.util.List;
import mx.uach.videoclub.dao.enums.CRUD;
import mx.uach.videoclub.modelos.Actor;
import mx.uach.videoclub.modelos.Cinta;
import mx.uach.videoclub.modelos.Director;
import mx.uach.videoclub.modelos.Ficha;
import mx.uach.videoclub.modelos.Lista;
import mx.uach.videoclub.modelos.Pelicula;
import mx.uach.videoclub.modelos.Prestamo;
import mx.uach.videoclub.modelos.Socio;

/**
 * Declaración de los métodos de escritura y lectura de un modelo a otro.
 *
 * @author Daniela Santillanes Castro
 * @version 1.0
 */
public interface VideoDao {

    //-------------------------DIRECTORES---------------------------------------
    /**
     * Regresa un director basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code mx.uach.videoclub.modelos.Director} si el id es valido.
     */
    public Director getDirectorById(Integer id);

    /**
     * Regresa una lista de directores basada en un criterio de busqueda de los
     * registros de la base de datos.
     *
     * @param criterio string que sera el criterio de busqueda.
     * @return objects que es la lista de directores.
     */
    public List<Director> getDirectoresByCriteria(String criterio);

    /**
     * Método donde realizamos operaciones CRUD para el modelo Director.
     *
     * @param director que es el modelo a utilizar.
     * @param crud es el ENUM que contiene las operaciones CRUD.
     */
    public void directorProcess(Director director, CRUD crud);

    //----------------------------ACTORES---------------------------------------
    /**
     * Regresa un actor basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Actor} si el id es valido.
     */
    public Actor getActorById(Integer id);

    /**
     * Regresa una lista de actores basada en un criterio de busqueda de los
     * registros de la base de datos.
     *
     * @param criterio string que sera el criterio de busqueda.
     * @return objects que es la lista de actores.
     */
    public List<Actor> getActoresByCriteria(String criterio);

    /**
     * Método donde realizamos operaciones CRUD para el modelo Actor.
     *
     * @param actor que es el modelo a utilizar.
     * @param crud es el ENUM que contiene las operaciones CRUD.
     */
    public void actorProcess(Actor actor, CRUD crud);

    // ---------------------------CINTAS----------------------------------------
    /**
     * Regresa una cinta basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó una
     * {@code Cinta} si el id es valido.
     */
    public Cinta getCintaById(Integer id);

    /**
     * Regresa una lista de cintas basada en un criterio de busqueda de los
     * registros de la base de datos.
     *
     * @param criterio string que sera el criterio de busqueda.
     * @return objects que es la lista de cintas.
     */
    public List<Cinta> getCintasByCriteria(String criterio);

    /**
     * Método donde realizamos operaciones CRUD para el modelo Cinta.
     *
     * @param cinta que es el modelo a utilizar.
     * @param crud es el ENUM que contiene las operaciones CRUD.
     */
    public void cintaProcess(Cinta cinta, CRUD crud);

    // ---------------------------FICHAS----------------------------------------
    /**
     * Regresa una ficha basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Ficha} si el id es valido.
     */
    public Ficha getFichaById(Integer id);

    /**
     * Regresa una lista de fichas basada en un criterio de busqueda de los
     * registros de la base de datos.
     *
     * @param criterio string que sera el criterio de busqueda.
     * @return objects que es la lista de fichas.
     */
    public List<Ficha> getFichasByCriteria(String criterio);

    /**
     * Método donde realizamos operaciones CRUD para el modelo Ficha.
     *
     * @param ficha que es el modelo a utilizar.
     * @param crud es el ENUM que contiene las operaciones CRUD.
     */
    public void fichaProcess(Ficha ficha, CRUD crud);

    // ---------------------------LISTAS----------------------------------------
    /**
     * Regresa una lista basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó una
     * {@code Lista} si el id es valido.
     */
    public Lista getListaById(Integer id);

    /**
     * Regresa una lista de listas basada en un criterio de busqueda de los
     * registros de la base de datos.
     *
     * @param criterio string que sera el criterio de busqueda.
     * @return objects que es la lista de listas.
     */
    public List<Lista> getListasByCriteria(String criterio);

    /**
     * Método donde realizamos operaciones CRUD para el modelo Lista.
     *
     * @param lista que es el modelo a utilizar.
     * @param crud es el ENUM que contiene las operaciones CRUD.
     */
    public void listaProcess(Lista lista, CRUD crud);

    //----------------------------PELICULAS-------------------------------------
    /**
     * Regresa una pelicula basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó una
     * {@code Pelicula} si el id es valido.
     */
    public Pelicula getPeliculaById(Integer id);

    /**
     * Regresa una lista de peliculas basada en un criterio de busqueda de los
     * registros de la base de datos.
     *
     * @param criterio string que sera el criterio de busqueda.
     * @return objects que es la lista de peliculas.
     */
    public List<Pelicula> getPeliculasByCriteria(String criterio);

    /**
     * Método donde realizamos operaciones CRUD para el modelo Pelicula.
     *
     * @param pelicula que es el modelo a utilizar.
     * @param crud es el ENUM que contiene las operaciones CRUD.
     */
    public void peliculaProcess(Pelicula pelicula, CRUD crud);

    //---------------------------PRESTAMOS--------------------------------------
    /**
     * Regresa un prestamo basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Prestamo} si el id es valido.
     */
    public Prestamo getPrestamoById(Integer id);

    /**
     * Regresa una lista de prestamos basada en un criterio de busqueda de los
     * registros de la base de datos.
     *
     * @param criterio string que sera el criterio de busqueda.
     * @return objects que es la lista de prestamos.
     */
    public List<Prestamo> getPrestamosByCriteria(String criterio);

    /**
     * Método donde realizamos operaciones CRUD para el modelo Prestamo.
     *
     * @param prestamo que es el modelo a utilizar.
     * @param crud es el ENUM que contiene las operaciones CRUD.
     */
    public void prestamoProcess(Prestamo prestamo, CRUD crud);

    //---------------------------SOCIOS-----------------------------------------
    /**
     * Regresa un socio basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Socio} si el id es valido.
     */
    public Socio getSocioById(Integer id);

    /**
     * Regresa una lista de socios basada en un criterio de busqueda de los
     * registros de la base de datos.
     *
     * @param criterio string que sera el criterio de busqueda.
     * @return objects que es la lista de socios.
     */
    public List<Socio> getSociosByCriteria(String criterio);

    /**
     * Método donde realizamos operaciones CRUD para el modelo Socio.
     *
     * @param socio que es el modelo a utilizar.
     * @param crud es el ENUM que contiene las operaciones CRUD.
     */
    public void socioProcess(Socio socio, CRUD crud);
}
