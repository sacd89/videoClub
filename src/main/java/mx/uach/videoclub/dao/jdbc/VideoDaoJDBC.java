package mx.uach.videoclub.dao.jdbc;

import java.sql.Array;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.uach.videoclub.conexion.Conexion;
import mx.uach.videoclub.dao.VideoDao;
import mx.uach.videoclub.dao.enums.CRUD;
import mx.uach.videoclub.dao.jdbc.helper.VideoDaoJdbcHelper;
import mx.uach.videoclub.modelos.Actor;
import mx.uach.videoclub.modelos.Cinta;
import mx.uach.videoclub.modelos.Director;
import mx.uach.videoclub.modelos.Ficha;
import mx.uach.videoclub.modelos.Lista;
import mx.uach.videoclub.modelos.Pelicula;
import mx.uach.videoclub.modelos.Prestamo;
import mx.uach.videoclub.modelos.Socio;

/**
 *
 * @author Daniela Santillanes Castro
 * @version 1.0
 */
public class VideoDaoJDBC implements VideoDao {

    public VideoDaoJDBC() {
    }

    //-------------------------DIRECTORES---------------------------------------
    /**
     * Regresa un director basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Director} si el id es valido.
     */
    @Override
    public Director getDirectorById(Integer id) {
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Director.Q,
                    Director.Q_WHERE_ID, id));
            Director obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeDirector(rs);
            }
            return obj;
        } catch (SQLException ex) {

        }
        return null;
    }

    /**
     * Regresa una lista de directores basada en un criterio de busqueda de los
     * registros de la base de datos.
     *
     * @param criterio string que sera el criterio de busqueda.
     * @return objects que es la lista de directores.
     */
    @Override
    public List<Director> getDirectoresByCriteria(String criterio) {
        List<Director> objects = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Director.Q,
                    criterio.isEmpty() ? "" : Director.Q_WHERE, criterio));
            Director obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeDirector(rs);
                objects.add(obj);
            }

        } catch (SQLException ex) {

        }
        return objects;
    }

    /**
     * Método donde realizamos operaciones CRUD para el modelo Director.
     *
     * @param director que es el modelo a utilizar.
     * @param crud es el ENUM que contiene las operaciones CRUD.
     */
    @Override
    public void directorProcess(Director director, CRUD crud) {
        try {
            PreparedStatement ps = null;
            switch (crud) {
                case CREATE:
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Director.INSERT_DIRECTOR);
                    ps.setString(1, director.getNombre());
                    break;
                case UPDATE:
                    //UPDATE TABLA SET()
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Director.UPDATE_DIRECTOR);
                    ps.setString(1, director.getNombre());
                    ps.setInt(2, director.getId());
                    break;
                case DELETE:
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Director.DELETE_DIRECTOR);
                    ps.setInt(1, director.getId());
                    break;
                default:
                    break;
            }

            Boolean result = ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    //----------------------------ACTORES---------------------------------------
    /**
     * Regresa un actor basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Actor} si el id es valido.
     */
    @Override
    public Actor getActorById(Integer id) {
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Actor.Q,
                    Actor.Q_WHERE_ID, id));
            Actor obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeActor(rs);
            }
            return obj;
        } catch (SQLException ex) {

        }
        return null;
    }

    /**
     * Regresa una lista de actores basada en un criterio de busqueda de los
     * registros de la base de datos.
     *
     * @param criterio string que sera el criterio de busqueda.
     * @return objects que es la lista de actores.
     */
    @Override
    public List<Actor> getActoresByCriteria(String criterio) {
        List<Actor> objects = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Actor.Q,
                    criterio.isEmpty() ? "" : Actor.Q_WHERE, criterio));
            Actor obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeActor(rs);
                objects.add(obj);
            }

        } catch (SQLException ex) {

        }
        return objects;
    }

    /**
     * Método donde realizamos operaciones CRUD para el modelo Actor.
     *
     * @param actor que es el modelo a utilizar.
     * @param crud es el ENUM que contiene las operaciones CRUD.
     */
    @Override
    public void actorProcess(Actor actor, CRUD crud) {
        try {
            PreparedStatement ps = null;
            switch (crud) {
                case CREATE:
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Actor.INSERT_ACTOR);
                    ps.setString(1, actor.getNombre());
                    ps.setString(2, actor.getApellido());
                    break;
                case UPDATE:
                    //UPDATE TABLA SET()
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Actor.UPDATE_ACTOR);
                    ps.setString(1, actor.getNombre());
                    ps.setString(2, actor.getApellido());
                    ps.setInt(2, actor.getId());
                    break;
                case DELETE:
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Actor.DELETE_ACTOR);
                    ps.setInt(1, actor.getId());
                    break;
                default:
                    break;
            }

            Boolean result = ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //-----------------------------CINTAS---------------------------------------
    /**
     * Regresa una cinta basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó una
     * {@code Cinta} si el id es valido.
     */
    @Override
    public Cinta getCintaById(Integer id) {
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Cinta.Q,
                    Cinta.Q_WHERE_ID, id));
            Cinta obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeCinta(rs);
            }
            return obj;
        } catch (SQLException ex) {

        }
        return null;
    }

    /**
     * Regresa una lista de cintas basada en un criterio de busqueda de los
     * registros de la base de datos.
     *
     * @param criterio string que sera el criterio de busqueda.
     * @return objects que es la lista de cintas.
     */
    @Override
    public List<Cinta> getCintasByCriteria(String criterio) {
        List<Cinta> objects = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Cinta.Q,
                    criterio.isEmpty() ? "" : Cinta.Q_WHERE, criterio));
            Cinta obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeCinta(rs);
                objects.add(obj);
            }

        } catch (SQLException ex) {

        }
        return objects;
    }

    /**
     * Método donde realizamos operaciones CRUD para el modelo Cinta.
     *
     * @param cinta que es el modelo a utilizar.
     * @param crud es el ENUM que contiene las operaciones CRUD.
     */
    @Override
    public void cintaProcess(Cinta cinta, CRUD crud) {
        try {
            PreparedStatement ps = null;
            switch (crud) {
                case CREATE:
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Cinta.INSERT_CINTA);
                    ps.setInt(1, cinta.getNumCopia());
                    ps.setObject(2, cinta.getPelicula());
                    break;
                case UPDATE:
                    //UPDATE TABLA SET()
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Cinta.UPDATE_CINTA);
                    ps.setInt(1, cinta.getNumCopia());
                    ps.setObject(2, cinta.getPelicula());
                    ps.setInt(3, cinta.getId());
                    break;
                case DELETE:
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Cinta.DELETE_CINTA);
                    ps.setInt(1, cinta.getId());
                    break;
                default:
                    break;
            }

            Boolean result = ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //----------------------------FICHAS----------------------------------------
    /**
     * Regresa una ficha basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Ficha} si el id es valido.
     */
    @Override
    public Ficha getFichaById(Integer id) {
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Ficha.Q,
                    Ficha.Q_WHERE_ID, id));
            Ficha obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeFicha(rs);
            }
            return obj;
        } catch (SQLException ex) {

        }
        return null;
    }

    /**
     * Regresa una lista de fichas basada en un criterio de busqueda de los
     * registros de la base de datos.
     *
     * @param criterio string que sera el criterio de busqueda.
     * @return objects que es la lista de fichas.
     */
    @Override
    public List<Ficha> getFichasByCriteria(String criterio) {
        List<Ficha> objects = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Ficha.Q,
                    criterio.isEmpty() ? "" : Ficha.Q_WHERE, criterio));
            Ficha obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeFicha(rs);
                objects.add(obj);
            }

        } catch (SQLException ex) {

        }
        return objects;
    }

    /**
     * Método donde realizamos operaciones CRUD para el modelo Ficha.
     *
     * @param ficha que es el modelo a utilizar.
     * @param crud es el ENUM que contiene las operaciones CRUD.
     */
    @Override
    public void fichaProcess(Ficha ficha, CRUD crud) {
        try {
            PreparedStatement ps = null;
            switch (crud) {
                case CREATE:
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Ficha.INSERT_FICHA);
                    ps.setDate(1, (Date) ficha.getFechaPrestamo());
                    ps.setObject(2, ficha.getSocio());
                    break;
                case UPDATE:
                    //UPDATE TABLA SET()
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Ficha.UPDATE_FICHA);
                    ps.setDate(1, (Date) ficha.getFechaPrestamo());
                    ps.setObject(2, ficha.getSocio());
                    ps.setInt(3, ficha.getId());
                    break;
                case DELETE:
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Ficha.DELETE_FICHA);
                    ps.setInt(1, ficha.getId());
                    break;
                default:
                    break;
            }

            Boolean result = ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //-----------------------------LISTAS---------------------------------------
    /**
     * Regresa una lista basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó una
     * {@code Lista} si el id es valido.
     */
    @Override
    public Lista getListaById(Integer id) {
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Lista.Q,
                    Lista.Q_WHERE_ID, id));
            Lista obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeLista(rs);
            }
            return obj;
        } catch (SQLException ex) {

        }
        return null;
    }

    /**
     * Regresa una lista de listas basada en un criterio de busqueda de los
     * registros de la base de datos.
     *
     * @param criterio string que sera el criterio de busqueda.
     * @return objects que es la lista de listas.
     */
    @Override
    public List<Lista> getListasByCriteria(String criterio) {
        List<Lista> objects = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Lista.Q,
                    criterio.isEmpty() ? "" : Lista.Q_WHERE, criterio));
            Lista obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeLista(rs);
                objects.add(obj);
            }

        } catch (SQLException ex) {

        }
        return objects;
    }

    /**
     * Método donde realizamos operaciones CRUD para el modelo Lista.
     *
     * @param lista que es el modelo a utilizar.
     * @param crud es el ENUM que contiene las operaciones CRUD.
     */
    @Override
    public void listaProcess(Lista lista, CRUD crud) {
        try {
            PreparedStatement ps = null;
            switch (crud) {
                case CREATE:
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Lista.INSERT_LISTA);
                    ps.setDate(1, (Date) lista.getFecha());
                    ps.setDate(2, (Date) lista.getHora());
                    ps.setBoolean(3, lista.getEstatus());
                    ps.setObject(4, lista.getSocio());
                    ps.setObject(5, lista.getPelicula());
                    break;
                case UPDATE:
                    //UPDATE TABLA SET()
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Lista.UPDATE_LISTA);
                    ps.setDate(1, (Date) lista.getFecha());
                    ps.setDate(2, (Date) lista.getHora());
                    ps.setBoolean(3, lista.getEstatus());
                    ps.setObject(4, lista.getSocio());
                    ps.setObject(5, lista.getPelicula());
                    ps.setInt(6, lista.getId());
                    break;
                case DELETE:
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Lista.DELETE_LISTA);
                    ps.setInt(1, lista.getId());
                    break;
                default:
                    break;
            }

            Boolean result = ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //--------------------------PELICULAS---------------------------------------
    /**
     * Regresa una pelicula basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó una
     * {@code Pelicula} si el id es valido.
     */
    @Override
    public Pelicula getPeliculaById(Integer id) {
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Pelicula.Q,
                    Pelicula.Q_WHERE_ID, id));
            Pelicula obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makePelicula(rs);
            }
            return obj;
        } catch (SQLException ex) {

        }
        return null;
    }

    /**
     * Regresa una lista de peliculas basada en un criterio de busqueda de los
     * registros de la base de datos.
     *
     * @param criterio string que sera el criterio de busqueda.
     * @return objects que es la lista de peliculas.
     */
    @Override
    public List<Pelicula> getPeliculesByCriteria(String criterio) {
        List<Pelicula> objects = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Pelicula.Q,
                    criterio.isEmpty() ? "" : Pelicula.Q_WHERE, criterio));
            Pelicula obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makePelicula(rs);
                objects.add(obj);
            }

        } catch (SQLException ex) {

        }
        return objects;
    }

    /**
     * Método donde realizamos operaciones CRUD para el modelo Pelicula.
     *
     * @param pelicula que es el modelo a utilizar.
     * @param crud es el ENUM que contiene las operaciones CRUD.
     */
    @Override
    public void peliculaProcess(Pelicula pelicula, CRUD crud) {
        try {
            PreparedStatement ps = null;
            switch (crud) {
                case CREATE:
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Pelicula.INSERT_PELICULA);
                    ps.setString(1, pelicula.getTitulo());
                    ps.setObject(2, pelicula.getGenero());
                    ps.setInt(3, pelicula.getDuracion());
                    ps.setObject(4, pelicula.getDirector());
                    ps.setArray(5, (Array) pelicula.getActores());
                    break;
                case UPDATE:
                    //UPDATE TABLA SET()
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Pelicula.UPDATE_PELICULA);
                    ps.setString(1, pelicula.getTitulo());
                    ps.setObject(2, pelicula.getGenero());
                    ps.setInt(3, pelicula.getDuracion());
                    ps.setObject(4, pelicula.getDirector());
                    ps.setArray(5, (Array) pelicula.getActores());
                    ps.setInt(6, pelicula.getId());
                    break;
                case DELETE:
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Pelicula.DELETE_PELICULA);
                    ps.setInt(1, pelicula.getId());
                    break;
                default:
                    break;
            }

            Boolean result = ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //--------------------------PRESTAMOS---------------------------------------
    /**
     * Regresa un prestamo basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Prestamo} si el id es valido.
     */
    @Override
    public Prestamo getPrestamoById(Integer id) {
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Prestamo.Q,
                    Prestamo.Q_WHERE_ID, id));
            Prestamo obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makePrestamo(rs);
            }
            return obj;
        } catch (SQLException ex) {

        }
        return null;
    }

    /**
     * Regresa una lista de prestamos basada en un criterio de busqueda de los
     * registros de la base de datos.
     *
     * @param criterio string que sera el criterio de busqueda.
     * @return objects que es la lista de prestamos.
     */
    @Override
    public List<Prestamo> getPrestamosByCriteria(String criterio) {
        List<Prestamo> objects = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Prestamo.Q,
                    criterio.isEmpty() ? "" : Prestamo.Q_WHERE, criterio));
            Prestamo obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makePrestamo(rs);
                objects.add(obj);
            }

        } catch (SQLException ex) {

        }
        return objects;
    }

    /**
     * Método donde realizamos operaciones CRUD para el modelo Prestamo.
     *
     * @param prestamo que es el modelo a utilizar.
     * @param crud es el ENUM que contiene las operaciones CRUD.
     */
    @Override
    public void prestamoProcess(Prestamo prestamo, CRUD crud) {
        try {
            PreparedStatement ps = null;
            switch (crud) {
                case CREATE:
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Prestamo.INSERT_PRESTAMO);
                    ps.setDate(1, (Date) prestamo.getFechaEntrega());
                    ps.setObject(2, prestamo.getEstatus());
                    ps.setObject(3, prestamo.getFicha());
                    ps.setObject(4, prestamo.getCinta());
                    break;
                case UPDATE:
                    //UPDATE TABLA SET()
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Prestamo.UPDATE_PRESTAMO);
                    ps.setDate(1, (Date) prestamo.getFechaEntrega());
                    ps.setObject(2, prestamo.getEstatus());
                    ps.setObject(3, prestamo.getFicha());
                    ps.setObject(4, prestamo.getCinta());
                    ps.setInt(5, prestamo.getId());
                    break;
                case DELETE:
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Prestamo.DELETE_PRESTAMO);
                    ps.setInt(1, prestamo.getId());
                    break;
                default:
                    break;
            }

            Boolean result = ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //----------------------------SOCIOS----------------------------------------
    /**
     * Regresa un socio basado en un id del registro de la base de datos.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code Socio} si el id es valido.
     */
    @Override
    public Socio getSocioById(Integer id) {
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Socio.Q,
                    Socio.Q_WHERE_ID, id));
            Socio obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeSocio(rs);
            }
            return obj;
        } catch (SQLException ex) {

        }
        return null;
    }

    /**
     * Regresa una lista de socios basada en un criterio de busqueda de los
     * registros de la base de datos.
     *
     * @param criterio string que sera el criterio de busqueda.
     * @return objects que es la lista de socios.
     */
    @Override
    public List<Socio> getSociosByCriteria(String criterio) {
        List<Socio> objects = new ArrayList<>();
        try {
            Statement st = Conexion.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(String.format("%s %s %s ", Socio.Q,
                    criterio.isEmpty() ? "" : Socio.Q_WHERE, criterio));
            Socio obj = null;
            while (rs.next()) {
                obj = VideoDaoJdbcHelper.makeSocio(rs);
                objects.add(obj);
            }

        } catch (SQLException ex) {

        }
        return objects;
    }

    /**
     * Método donde realizamos operaciones CRUD para el modelo Socio.
     *
     * @param socio que es el modelo a utilizar.
     * @param crud es el ENUM que contiene las operaciones CRUD.
     */
    @Override
    public void socioProcess(Socio socio, CRUD crud) {
        try {
            PreparedStatement ps = null;
            switch (crud) {
                case CREATE:
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Socio.INSERT_SOCIO);
                    ps.setString(1, socio.getNombre());
                    ps.setString(2, socio.getDireccion());
                    ps.setString(3, socio.getTelefono());
                    ps.setArray(4, (Array) socio.getDirectores());
                    ps.setArray(5, (Array) socio.getActores());
                    break;
                case UPDATE:
                    //UPDATE TABLA SET()
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Socio.UPDATE_SOCIO);
                    ps.setString(1, socio.getNombre());
                    ps.setString(2, socio.getDireccion());
                    ps.setString(3, socio.getTelefono());
                    ps.setArray(4, (Array) socio.getDirectores());
                    ps.setArray(5, (Array) socio.getActores());
                    ps.setInt(6, socio.getId());
                    break;
                case DELETE:
                    ps = Conexion.getInstance().
                            getCon().prepareStatement(Socio.DELETE_SOCIO);
                    ps.setInt(1, socio.getId());
                    break;
                default:
                    break;
            }

            Boolean result = ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
