/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.uach.videoclub.dao.jdbc.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import mx.uach.videoclub.modelos.Director;

/**
 * Helper que genera objetos del Dao
 * 
 * @author Daniela Santillanes Castro
 */
public class VideoDaoJdbcHelper {
    
    public final static Director makeDirector(ResultSet rs) throws SQLException{
        Director obj = new Director(rs.getInt(Director.FIELDS[0]), 
                        rs.getString(Director.FIELDS[1]));
        
        return obj;
    }
    
}
