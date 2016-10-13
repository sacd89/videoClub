/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.uach.videoclub.dao.jdbc.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
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
     * Método que nos genera un objeto Director.
     * 
     * @param rs resultset 
     * @return obj que es el 
     * @throws SQLException 
     */
    public final static Director makeDirector(ResultSet rs) throws SQLException {
        Director obj = new Director(rs.getInt(Director.FIELDS[0]),
                rs.getString(Director.FIELDS[1]));
        return obj;
    }
    
    public final static Actor makeActor(ResultSet rs) throws SQLException {
        Actor obj = new Actor(rs.getInt(Actor.FIELDS[0]),
                rs.getString(Actor.FIELDS[1]), rs.getString(Actor.FIELDS[2]));
        return obj;
    }
    
    public final static Cinta makeCinta(ResultSet rs) throws SQLException {
        Cinta obj = new Cinta(rs.getInt(Cinta.FIELDS[0]),
                rs.getInt(Cinta.FIELDS[1]), rs.getString(Cinta.FIELDS[2]));
        return obj;
    }
    
    public final static Ficha makeFicha(ResultSet rs) throws SQLException {
        Ficha obj = new Ficha(rs.getInt(Ficha.FIELDS[0]),
                rs.getDate(Ficha.FIELDS[1]), rs.getString(Ficha.FIELDS[2]));
        return obj;
    }
    
    public final static Lista makeLista(ResultSet rs) throws SQLException {
        Lista obj = new Lista(rs.getInt(Lista.FIELDS[0]),
                rs.getDate(Lista.FIELDS[1]),rs.getDate(Lista.FIELDS[2]), 
                rs.getBoolean(Lista.FIELDS[3]), rs.getString(Lista.FIELDS[4]), 
                rs.getString(Lista.FIELDS[5]));
        return obj;
    }
    
    public final static Pelicula makePelicula(ResultSet rs) throws SQLException {
        Pelicula obj = new Pelicula(rs.getInt(Pelicula.FIELDS[0]),
                rs.getString(Pelicula.FIELDS[1]), rs.getString(Pelicula.FIELDS[2]),
                rs.getInt(Pelicula.FIELDS[3]), rs.getString(Pelicula.FIELDS[4]),
        rs.getArray(Pelicula.FIELDS[5]));
        return obj;
    }
    
    public final static Prestamo makePrestamo(ResultSet rs) throws SQLException {
        Prestamo obj = new Prestamo(rs.getInt(Prestamo.FIELDS[0]),
                rs.getDate(Prestamo.FIELDS[1]), rs.getString(Prestamo.FIELDS[2]),
                rs.getString(Prestamo.FIELDS[3]),rs.getString(Prestamo.FIELDS[4]));
        return obj;
    }
    
    public final static Socio makeSocio(ResultSet rs) throws SQLException {
        Socio obj = new Socio(rs.getInt(Socio.FIELDS[0]),
                rs.getString(Socio.FIELDS[1]), rs.getString(Socio.FIELDS[2]),
                rs.getString(Socio.FIELDS[3]), rs.getArray(Socio.FIELDS[4]),
                rs.getArray(Socio.FIELDS[5]));
        return obj;
    }
    
}
