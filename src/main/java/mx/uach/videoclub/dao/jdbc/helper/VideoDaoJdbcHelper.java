package mx.uach.videoclub.dao.jdbc.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import mx.uach.videoclub.dao.VideoDao;
import mx.uach.videoclub.dao.enums.Genero;
import mx.uach.videoclub.dao.enums.Prestamos;
import mx.uach.videoclub.dao.jdbc.VideoDaoJDBC;
import mx.uach.videoclub.modelos.Actor;
import mx.uach.videoclub.modelos.Cinta;
import mx.uach.videoclub.modelos.Director;
import mx.uach.videoclub.modelos.Ficha;
import mx.uach.videoclub.modelos.Lista;
import mx.uach.videoclub.modelos.Pelicula;
import mx.uach.videoclub.modelos.Prestamo;
import mx.uach.videoclub.modelos.Socio;

/**
 * Helper que genera objetos del Dao
 * 
 * @author Daniela Santillanes Castro
 * @version 1.0
 * @since 12/10/2016
 */
public class VideoDaoJdbcHelper {
    
    /**
     * Método que mappea un ResultSet a una instancia de la clase Director.
     * 
     * @param rs ResultSet con el iterador en la línea donde se planea mappear a objeto.
     * @return objeto mappeado a director.
     * @throws java.sql.SQLException
     */
    public final static Director makeDirector(ResultSet rs) throws SQLException {
        Director obj = new Director(rs.getInt(Director.FIELDS[0]),
                rs.getString(Director.FIELDS[1]));
        return obj;
    }
    
     /**
     * Método que mappea un ResultSet a una instancia de la clase Actor.
     * 
     * @param rs ResultSet con el iterador en la línea donde se planea mappear a objeto.
     * @return objeto mappeado a actor.
     * @throws java.sql.SQLException
     */
    public final static Actor makeActor(ResultSet rs) throws SQLException {
        Actor obj = new Actor(rs.getInt(Actor.FIELDS[0]),
                rs.getString(Actor.FIELDS[1]), rs.getString(Actor.FIELDS[2]));
        return obj;
    }
    
     /**
     * Método que mappea un ResultSet a una instancia de la clase Cinta.
     * 
     * @param rs ResultSet con el iterador en la línea donde se planea mappear a objeto.
     * @return objeto mappeado a cinta.
     * @throws java.sql.SQLException
     */
    public final static Cinta makeCinta(ResultSet rs) throws SQLException {
        VideoDao dao = new VideoDaoJDBC();
        Pelicula pelicula = dao.getPeliculaById(rs.getInt(Cinta.FIELDS[2]));
        Cinta obj = new Cinta(rs.getInt(Cinta.FIELDS[0]),
                rs.getInt(Cinta.FIELDS[1]), pelicula);
        return obj;
    }
    
     /**
     * Método que mappea un ResultSet a una instancia de la clase Ficha.
     * 
     * @param rs ResultSet con el iterador en la línea donde se planea mappear a objeto.
     * @return objeto mappeado a ficha.
     * @throws java.sql.SQLException
     */
    public final static Ficha makeFicha(ResultSet rs) throws SQLException {
        VideoDao dao = new VideoDaoJDBC();
        Socio socio = dao.getSocioById(rs.getInt(Ficha.FIELDS[2]));
        Ficha obj = new Ficha(rs.getInt(Ficha.FIELDS[0]),
                rs.getDate(Ficha.FIELDS[1]), socio);
        return obj;
    }
    
     /**
     * Método que mappea un ResultSet a una instancia de la clase Lista.
     * 
     * @param rs ResultSet con el iterador en la línea donde se planea mappear a objeto.
     * @return objeto mappeado a lista.
     * @throws java.sql.SQLException
     */
    public final static Lista makeLista(ResultSet rs) throws SQLException {
        VideoDao dao = new VideoDaoJDBC();
        Socio socio = dao.getSocioById(rs.getInt(Lista.FIELDS[4]));
        Pelicula pelicula = dao.getPeliculaById(rs.getInt(Lista.FIELDS[5]));
        Lista obj = new Lista(rs.getInt(Lista.FIELDS[0]),
                rs.getDate(Lista.FIELDS[1]),rs.getDate(Lista.FIELDS[2]), 
                rs.getBoolean(Lista.FIELDS[3]), 
                socio, pelicula);
        return obj;
    }
    
     /**
     * Método que mappea un ResultSet a una instancia de la clase Pelicula.
     * 
     * @param rs ResultSet con el iterador en la línea donde se planea mappear a objeto.
     * @return objeto mappeado a pelicula.
     * @throws java.sql.SQLException
     */
    public final static Pelicula makePelicula(ResultSet rs) throws SQLException {
        VideoDao dao = new VideoDaoJDBC();
        Director director = dao.getDirectorById(rs.getInt(Pelicula.FIELDS[4]));
        Pelicula obj = new Pelicula(rs.getInt(Pelicula.FIELDS[0]),
                rs.getString(Pelicula.FIELDS[1]), Genero.valueOf(rs.getString(Pelicula.FIELDS[2])),
                rs.getInt(Pelicula.FIELDS[3]), director);
        return obj;
    }
    
     /**
     * Método que mappea un ResultSet a una instancia de la clase Prestamo.
     * 
     * @param rs ResultSet con el iterador en la línea donde se planea mappear a objeto.
     * @return objeto mappeado a prestamo.
     */
    public final static Prestamo makePrestamo(ResultSet rs) throws SQLException {
        VideoDao dao = new VideoDaoJDBC();
        Cinta cinta = dao.getCintaById(rs.getInt(Prestamo.FIELDS[3]));
        Ficha ficha = dao.getFichaById(rs.getInt(Prestamo.FIELDS[4]));
        Prestamo obj = new Prestamo(rs.getInt(Prestamo.FIELDS[0]),
                rs.getDate(Prestamo.FIELDS[1]), Prestamos.valueOf(rs.getString(Prestamo.FIELDS[2])),
                ficha,
                cinta);
        return obj;
    }
    
     /**
     * Método que mappea un ResultSet a una instancia de la clase Socio.
     * 
     * @param rs ResultSet con el iterador en la línea donde se planea mappear a objeto.
     * @return objeto mappeado a socio.
     */
    public final static Socio makeSocio(ResultSet rs) throws SQLException {
        Socio obj = new Socio(rs.getInt(Socio.FIELDS[0]),
                rs.getString(Socio.FIELDS[1]), rs.getString(Socio.FIELDS[2]),
                rs.getString(Socio.FIELDS[3]));
        return obj;
    }
    
}
