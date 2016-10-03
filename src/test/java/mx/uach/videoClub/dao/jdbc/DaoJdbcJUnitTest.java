package mx.uach.videoClub.dao.jdbc;

import java.util.List;
import mx.uach.videoclub.dao.VideoDao;
import mx.uach.videoclub.dao.enums.CRUD;
import mx.uach.videoclub.dao.jdbc.VideoDaoJDBC;
import mx.uach.videoclub.modelos.Director;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Pruebas del Dao JDBC
 * 
 * @author Daniela Santillanes Castro
 */
public class DaoJdbcJUnitTest {
    
    public DaoJdbcJUnitTest() {
    }
    
    /*@Test
    public void directorById(){
        VideoDao dao = new VideoDaoJDBC();
        
        //id = 1 James Cameron
        Director d = dao.getDirectorById(1);
        Assert.assertNotNull(d);
        Assert.assertEquals(d.getNombre(), "James Cameron");
        Assert.assertNotSame(d.getNombre(), "Alfonso Cuaron");
        
        //id = 2 Alfonso Cuaron
        Director d2 = dao.getDirectorById(2);
        assertNotNull(d2);
        assertEquals(d2.getNombre(), "Alfonso Cuaron");
        assertNotSame(d.getNombre(), "James Cameron");/*
        
//        List<Director> directores = dao.getDirectoresByCriteria("");
        //assertEquals(3, directores.size());
    }
    
    /*@Test
    public void makeDirector(){
        VideoDao dao = new VideoDaoJDBC();
        dao.directorProcess(new Director("Tim Burton"), CRUD.CREATE);
        Director d = dao.getDirectorById(3);
        assertNotNull(d);
        assertEquals(d.getNombre(), "Tim Burton");
    }*/
    
    @Test
    public void updateDirector(){
        VideoDao dao = new VideoDaoJDBC();
        Director d = dao.getDirectorById(2);
        assertNotNull(d);
        
        d.setNombre("David Yates");
        dao.directorProcess(d, CRUD.UPDATE);
        
        d = dao.getDirectorById(2);
        assertNotNull(d);
        assertEquals(d.getNombre(), "David Yates");
    }
    
    @Test
    public void deleteDirector(){
        VideoDao dao = new VideoDaoJDBC();
        Director d = dao.getDirectorById(3);
        assertNotNull(d);
        
        dao.directorProcess(d, CRUD.DELETE);
        
        d = dao.getDirectorById(3);
        assertNull(d);
    }
    
}
