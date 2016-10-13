package mx.uach.videoClub.dao.jdbc;

import java.sql.Date;
import java.util.List;
import mx.uach.videoclub.dao.VideoDao;
import mx.uach.videoclub.dao.enums.CRUD;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Pruebas del Dao JDBC
 *
 * @author Daniela Santillanes Castro
 */
public class DaoJdbcJUnitTest {

    //--------------------------DIRECTORES--------------------------------------
    /**
     * Prueba Unitaria para obtener ciertos directores y evaluamos si se
     * encontro dicho director haciendo una busqueda por ID y verificamos que el
     * nombre coincidan.
     */
    @Test
    public void directorByIdTest() {
        VideoDao dao = new VideoDaoJDBC();

        // Id = 1 James Cameron
        Director d = dao.getDirectorById(1);

        assertNotNull(d);
        assertEquals(d.getNombre(), "James Cameron");

        assertNotSame(d.getNombre(), "Alfonso Cuaron");

        //Id = 2 Alfonso Cuaron
        Director d2 = dao.getDirectorById(2);

        assertNotNull(d2);
        assertEquals(d2.getNombre(), "Alfonso Cuaron");

        assertNotSame(d2.getNombre(), "James Cameron");

        List<Director> directores = dao.getDirectoresByCriteria("");
        //assertEquals(3, directores.size());

    }

    /**
     * Prueba unitaria donde creamos un director y evaluamos si se creo dicho
     * director haciendo una busqueda por su ID y verificamos que el nombre
     * coincida.
     */
    @Test
    public void makeDirector() {
        VideoDao dao = new VideoDaoJDBC();
        dao.directorProcess(new Director("Tim Burton"), CRUD.CREATE);

        Director d = dao.getDirectorById(4);
        assertNotNull(d);
        assertEquals(d.getNombre(), "Tim Burton");
    }

    /**
     * Prueba unitaria donde modificamos un director y evaluamos si dicho
     * director se modifico, haciendo una busqueda por su ID, modificando y
     * verificando que el nombre haya sido modificado por el nuevo.
     */
    @Test
    public void updateDirector() {
        VideoDao dao = new VideoDaoJDBC();

        Director d = dao.getDirectorById(3);
        assertNotNull(d);

        d.setNombre("David Yates");
        dao.directorProcess(d, CRUD.UPDATE);

        d = dao.getDirectorById(3);
        assertNotNull(d);
        assertEquals(d.getNombre(), "David Yates");

    }

    /**
     * Prueba unitaria donde eliminamos un director, haciendo una busqueda por
     * su ID y verificamos que se haya eliminado si nos retorna NULL.
     */
    @Test
    public void deleteDirector() {
        VideoDao dao = new VideoDaoJDBC();

        Director d = dao.getDirectorById(6);
        assertNotNull(d);

        dao.directorProcess(d, CRUD.DELETE);

        d = dao.getDirectorById(6);
        assertNull(d);

    }

    //--------------------------ACTORES-----------------------------------------
    /**
     * Prueba Unitaria para obtener ciertos actores y evaluamos si se encontro
     * dicho actor haciendo una busqueda por ID y verificamos que el nombre
     * coincidan.
     */
    @Test
    public void actorByIdTest() {
        VideoDao dao = new VideoDaoJDBC();

        Actor d = dao.getActorById(1);

        assertNotNull(d);
        assertEquals(d.getNombre(), "Ashton");

        assertNotSame(d.getNombre(), "Natalie");

        Actor d2 = dao.getActorById(2);

        assertNotNull(d2);
        assertEquals(d2.getNombre(), "Natalie");

        assertNotSame(d2.getNombre(), "Ashton");

        List<Actor> actores = dao.getActoresByCriteria("");

    }

    /**
     * Prueba unitaria donde creamos un actor y evaluamos si se creo dicho actor
     * haciendo una busqueda por su ID y verificamos que el nombre coincida.
     */
    @Test
    public void makeActor() {
        VideoDao dao = new VideoDaoJDBC();
        dao.actorProcess(new Actor("Mila", "Kunis"), CRUD.CREATE);

        Director d = dao.getDirectorById(3);
        assertNotNull(d);
        assertEquals(d.getNombre(), "Mila");
    }

    /**
     * Prueba unitaria donde modificamos un actor y evaluamos si dicho director
     * se modifico, haciendo una busqueda por su ID, cambiando y verificando que
     * el nombre haya sido modificado por el nuevo.
     */
    @Test
    public void updateActor() {
        VideoDao dao = new VideoDaoJDBC();

        Actor d = dao.getActorById(3);
        assertNotNull(d);

        d.setNombre("Mia");
        dao.actorProcess(d, CRUD.UPDATE);

        d = dao.getActorById(3);
        assertNotNull(d);
        assertEquals(d.getNombre(), "Mia");

    }

    /**
     * Prueba unitaria donde eliminamos un actor, haciendo una busqueda por su
     * ID y verificamos que se haya eliminado si nos retorna NULL.
     */
    @Test
    public void deleteActor() {
        VideoDao dao = new VideoDaoJDBC();

        Actor d = dao.getActorById(3);
        assertNotNull(d);

        dao.actorProcess(d, CRUD.DELETE);

        d = dao.getActorById(3);
        assertNull(d);

    }

    //-----------------------------CINTAS---------------------------------------
    /**
     * Prueba Unitaria para obtener ciertas cintas y evaluamos si se encontro
     * dicha cinta haciendo una busqueda por ID y verificamos que el numero de
     * copias coincidan.
     */
    @Test
    public void cintaByIdTest() {
        VideoDao dao = new VideoDaoJDBC();

        Cinta d = dao.getCintaById(1);

        assertNotNull(d);
        assertEquals(d.getNumCopia(), "4");
        assertNotSame(d.getNumCopia(), "2");

        Cinta d2 = dao.getCintaById(2);

        assertNotNull(d2);
        assertEquals(d2.getNumCopia(), "2");
        assertNotSame(d2.getNumCopia(), "4");

        List<Cinta> cintas = dao.getCintasByCriteria("");

    }

    /**
     * Prueba unitaria donde creamos una cinta y evaluamos si se creo dicha
     * cinta haciendo una busqueda por su ID y verificamos que el número de
     * cinta coincidan.
     */
    @Test
    public void makeCinta() {
        VideoDao dao = new VideoDaoJDBC();
        dao.cintaProcess(new Cinta(Integer.SIZE, null), CRUD.CREATE);

        Cinta d = dao.getCintaById(3);
        assertNotNull(d);
        assertEquals(d.getNumCopia(), "5");
    }

    /**
     * Prueba unitaria donde modificamos una cinta y evaluamos si dicha cinta se
     * modifico, haciendo una busqueda por su ID, cambiando y verificando que el
     * numero de copias haya sido modificado por el nuevo.
     */
    @Test
    public void updateCinta() {
        VideoDao dao = new VideoDaoJDBC();

        Cinta d = dao.getCintaById(3);
        assertNotNull(d);

        d.setNumCopia(10);
        dao.cintaProcess(d, CRUD.UPDATE);

        d = dao.getCintaById(3);
        assertNotNull(d);
        assertEquals(d.getNumCopia(), "10");

    }

    /**
     * Prueba unitaria donde eliminamos una cinta, haciendo una busqueda por su
     * ID y verificamos que se haya eliminado si nos retorna NULL.
     */
    @Test
    public void deleteCinta() {
        VideoDao dao = new VideoDaoJDBC();

        Cinta d = dao.getCintaById(3);
        assertNotNull(d);

        dao.cintaProcess(d, CRUD.DELETE);

        d = dao.getCintaById(3);
        assertNull(d);

    }

    //-----------------------------FICHAS---------------------------------------
    /**
     * Prueba Unitaria para obtener ciertas fichas y evaluamos si se encontro
     * dicha ficha haciendo una busqueda por ID y verificamos que la fecha de
     * prestamo coincidan.
     */
    @Test
    public void fichaByIdTest() {
        VideoDao dao = new VideoDaoJDBC();

        Ficha d = dao.getFichaById(1);

        assertNotNull(d);
        assertEquals(d.getFechaPrestamo(), Date.valueOf("01/01/2016"));

        assertNotSame(d.getFechaPrestamo(), Date.valueOf("02/02/2016"));

        Ficha d2 = dao.getFichaById(2);

        assertNotNull(d2);
        assertEquals(d2.getFechaPrestamo(), Date.valueOf("02/02/2016"));

        assertNotSame(d2.getFechaPrestamo(), Date.valueOf("01/01/2016"));

        List<Ficha> fichas = dao.getFichasByCriteria("");

    }

    /**
     * Prueba unitaria donde creamos una ficha y evaluamos si se creo dicha
     * ficha haciendo una busqueda por su ID y verificamos que la fecha de
     * prestamo coincidan.
     */
    @Test
    public void makeFicha() {
        VideoDao dao = new VideoDaoJDBC();
        dao.fichaProcess(new Ficha(null, null), CRUD.CREATE);

        Ficha d = dao.getFichaById(3);
        assertNotNull(d);
        assertEquals(d.getFechaPrestamo(), Date.valueOf("03/03/2016"));
    }

    /**
     * Prueba unitaria donde modificamos una ficha y evaluamos si dicha ficha se
     * modifico, haciendo una busqueda por su ID, cambiando y verificando que la
     * fecha de prestamo haya sido modificada por el nuevo.
     */
    @Test
    public void updateFicha() {
        VideoDao dao = new VideoDaoJDBC();

        Ficha d = dao.getFichaById(3);
        assertNotNull(d);

        d.setFechaPrestamo(Date.valueOf("13/03/2016"));
        dao.fichaProcess(d, CRUD.UPDATE);

        d = dao.getFichaById(3);
        assertNotNull(d);
        assertEquals(d.getFechaPrestamo(), Date.valueOf("13/03/2016"));

    }

    /**
     * Prueba unitaria donde eliminamos una ficha, haciendo una busqueda por su
     * ID y verificamos que se haya eliminado si nos retorna NULL.
     */
    @Test
    public void deleteFicha() {
        VideoDao dao = new VideoDaoJDBC();

        Ficha d = dao.getFichaById(6);
        assertNotNull(d);

        dao.fichaProcess(d, CRUD.DELETE);

        d = dao.getFichaById(6);
        assertNull(d);

    }

    //------------------------------LISTAS--------------------------------------
    /**
     * Prueba Unitaria para obtener ciertas listas y evaluamos si se encontro
     * dicha lista haciendo una busqueda por ID y verificamos que el estatus
     * coincidan.
     */
    @Test
    public void listaByIdTest() {
        VideoDao dao = new VideoDaoJDBC();

        Lista d = dao.getListaById(1);

        assertNotNull(d);
        assertEquals(d.getEstatus(), true);

        assertNotSame(d.getEstatus(), false);

        Lista d2 = dao.getListaById(2);

        assertNotNull(d2);
        assertEquals(d2.getEstatus(), false);

        assertNotSame(d2.getEstatus(), true);

        List<Lista> listas = dao.getListasByCriteria("");

    }

    /**
     * Prueba unitaria donde creamos una lista y evaluamos si se creo dicha
     * lista haciendo una busqueda por su ID y verificamos que el estatus
     * coincidan.
     */
    @Test
    public void makeLista() {
        VideoDao dao = new VideoDaoJDBC();
        dao.listaProcess(new Lista(null, null, Boolean.TRUE, null, null), CRUD.CREATE);

        Lista d = dao.getListaById(3);
        assertNotNull(d);
        assertEquals(d.getEstatus(), true);
    }

    /**
     * Prueba unitaria donde modificamos una lista y evaluamos si dicha lista se
     * modifico, haciendo una busqueda por su ID, cambiando y verificando que el
     * estatus haya sido modificado por el nuevo.
     */
    @Test
    public void updateLista() {
        VideoDao dao = new VideoDaoJDBC();

        Lista d = dao.getListaById(3);
        assertNotNull(d);

        d.setEstatus(false);
        dao.listaProcess(d, CRUD.UPDATE);

        d = dao.getListaById(3);
        assertNotNull(d);
        assertEquals(d.getEstatus(), false);

    }

    /**
     * Prueba unitaria donde eliminamos una lista, haciendo una busqueda por su
     * ID y verificamos que se haya eliminado si nos retorna NULL.
     */
    @Test
    public void deleteLista() {
        VideoDao dao = new VideoDaoJDBC();

        Lista d = dao.getListaById(6);
        assertNotNull(d);

        dao.listaProcess(d, CRUD.DELETE);

        d = dao.getListaById(6);
        assertNull(d);

    }

    //-----------------------------PELICULAS------------------------------------
    /**
     * Prueba Unitaria para obtener ciertas peliculas y evaluamos si se encontro
     * dicha pelicula haciendo una busqueda por ID y verificamos que el titulo
     * coincidan.
     */
    @Test
    public void peliculaByIdTest() {
        VideoDao dao = new VideoDaoJDBC();

        // Id = 1 James Cameron
        Pelicula d = dao.getPeliculaById(1);

        assertNotNull(d);
        assertEquals(d.getTitulo(), "Lluvia de Hamburguesas");

        assertNotSame(d.getTitulo(), "Toy Story");

        //Id = 2 Alfonso Cuaron
        Pelicula d2 = dao.getPeliculaById(2);

        assertNotNull(d2);
        assertEquals(d2.getTitulo(), "Toy Story");

        assertNotSame(d2.getTitulo(), "Lluvia de Hamburguesas");

        List<Pelicula> peliculas = dao.getPeliculesByCriteria("");

    }

    /**
     * Prueba unitaria donde creamos una pelicula y evaluamos si se creo dicha
     * pelicula haciendo una busqueda por su ID y verificamos que el titulo
     * coincidan.
     */
    @Test
    public void makePelicula() {
        VideoDao dao = new VideoDaoJDBC();
        dao.peliculaProcess(new Pelicula(null, null, Integer.SIZE, null, null), CRUD.CREATE);

        Pelicula d = dao.getPeliculaById(3);
        assertNotNull(d);
        assertEquals(d.getTitulo(), "Ralph El Demoledor");
    }

    /**
     * Prueba unitaria donde modificamos una pelicula y evaluamos si dicha
     * pelicula se modifico, haciendo una busqueda por su ID, cambiando y
     * verificando que el titulo haya sido modificado por el nuevo.
     */
    @Test
    public void updatePelicula() {
        VideoDao dao = new VideoDaoJDBC();

        Pelicula d = dao.getPeliculaById(3);
        assertNotNull(d);

        d.setTitulo("Ralph: El Demoledor");
        dao.peliculaProcess(d, CRUD.UPDATE);

        d = dao.getPeliculaById(3);
        assertNotNull(d);
        assertEquals(d.getTitulo(), "Ralph: El Demoledor");

    }

    /**
     * Prueba unitaria donde eliminamos una pelicula, haciendo una busqueda por
     * su ID y verificamos que se haya eliminado si nos retorna NULL.
     */
    @Test
    public void deletePelicula() {
        VideoDao dao = new VideoDaoJDBC();

        Pelicula d = dao.getPeliculaById(3);
        assertNotNull(d);

        dao.peliculaProcess(d, CRUD.DELETE);

        d = dao.getPeliculaById(3);
        assertNull(d);

    }

    //----------------------------PRESTAMOS-------------------------------------
    /**
     * Prueba Unitaria para obtener ciertos prestamos y evaluamos si se encontro
     * dicho prestamo haciendo una busqueda por ID y verificamos que el estatus
     * coincidan.
     */
    @Test
    public void prestamoByIdTest() {
        VideoDao dao = new VideoDaoJDBC();

        Prestamo d = dao.getPrestamoById(1);

        assertNotNull(d);
        assertEquals(d.getEstatus(), "ENTREGADO");

        assertNotSame(d.getEstatus(), "PRESTADO");

        Prestamo d2 = dao.getPrestamoById(2);

        assertNotNull(d2);
        assertEquals(d2.getEstatus(), "PRESTADO");

        assertNotSame(d2.getEstatus(), "ENTREGADO");

        List<Prestamo> prestamos = dao.getPrestamosByCriteria("");
        //assertEquals(3, directores.size());

    }

    /**
     * Prueba unitaria donde creamos un prestamo y evaluamos si se creo dicho
     * prestamo haciendo una busqueda por su ID y verificamos que el estatus
     * coincidan.
     */
    @Test
    public void makePrestamo() {
        VideoDao dao = new VideoDaoJDBC();
        dao.prestamoProcess(new Prestamo(null, Prestamos.VENCIDO, null, null), CRUD.CREATE);

        Prestamo d = dao.getPrestamoById(3);
        assertNotNull(d);
        assertEquals(d.getEstatus(), "VENCIDO");
    }

    /**
     * Prueba unitaria donde modificamos un prestamo y evaluamos si dicho
     * prestamo se modifico, haciendo una busqueda por su ID, cambiando y
     * verificando que la fecha de entrega haya sido modificada por el nuevo.
     */
    @Test
    public void updatePrestamo() {
        VideoDao dao = new VideoDaoJDBC();

        Prestamo d = dao.getPrestamoById(3);
        assertNotNull(d);

        d.setFechaEntrega(Date.valueOf("01/02/2016"));
        dao.prestamoProcess(d, CRUD.UPDATE);

        d = dao.getPrestamoById(3);
        assertNotNull(d);
        assertEquals(d.getFechaEntrega(), Date.valueOf("01/02/2016"));

    }

    /**
     * Prueba unitaria donde eliminamos un prestamo, haciendo una busqueda por
     * su ID y verificamos que se haya eliminado si nos retorna NULL.
     */
    @Test
    public void deletePrestamo() {
        VideoDao dao = new VideoDaoJDBC();

        Prestamo d = dao.getPrestamoById(3);
        assertNotNull(d);

        dao.prestamoProcess(d, CRUD.DELETE);

        d = dao.getPrestamoById(3);
        assertNull(d);

    }

    //-------------------------------SOCIOS-------------------------------------
    /**
     * Prueba Unitaria para obtener ciertos socios y evaluamos si se encontro
     * dicho socio haciendo una busqueda por ID y verificamos que el nombre
     * coincidan.
     */
    @Test
    public void socioByIdTest() {
        VideoDao dao = new VideoDaoJDBC();

        Socio d = dao.getSocioById(1);

        assertNotNull(d);
        assertEquals(d.getNombre(), "Daniela Santillanes");

        assertNotSame(d.getNombre(), "Leticia Castro");

        Socio d2 = dao.getSocioById(2);

        assertNotNull(d2);
        assertEquals(d2.getNombre(), "Leticia Castro");

        assertNotSame(d2.getNombre(), "Daniela Santillanes");

        List<Socio> socios = dao.getSociosByCriteria("");

    }

    /**
     * Prueba unitaria donde creamos un socio y evaluamos si se creo dicho socio
     * haciendo una busqueda por su ID y verificamos que el nombre coincidan.
     */
    @Test
    public void makeSocio() {
        VideoDao dao = new VideoDaoJDBC();
        dao.socioProcess(new Socio("Ararat Mendez", null, null, null, null), CRUD.CREATE);

        Socio d = dao.getSocioById(3);
        assertNotNull(d);
        assertEquals(d.getNombre(), "Ararat Mendez");
    }

    /**
     * Prueba unitaria donde modificamos un socio y evaluamos si dicho socio se
     * modifico, haciendo una busqueda por su ID, cambiando y verificando que el
     * nombre haya sido modificado por el nuevo.
     */
    @Test
    public void updateSocio() {
        VideoDao dao = new VideoDaoJDBC();

        Socio d = dao.getSocioById(3);
        assertNotNull(d);

        d.setNombre("Consuelo Ararat Mendez");
        dao.socioProcess(d, CRUD.UPDATE);

        d = dao.getSocioById(3);
        assertNotNull(d);
        assertEquals(d.getNombre(), "Consuelo Ararat Mendez");

    }

    /**
     * Prueba unitaria donde eliminamos un socio, haciendo una busqueda por su
     * ID y verificamos que se haya eliminado si nos retorna NULL.
     */
    @Test
    public void deleteSocio() {
        VideoDao dao = new VideoDaoJDBC();

        Socio d = dao.getSocioById(2);
        assertNotNull(d);

        dao.socioProcess(d, CRUD.DELETE);

        d = dao.getSocioById(2);
        assertNull(d);

    }
}
