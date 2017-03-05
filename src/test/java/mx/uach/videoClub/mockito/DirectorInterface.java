/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoClub.mockito;

/**
 *
 * @author dsantillanes
 */
public interface DirectorInterface {
    
        //-------------------------DIRECTORES---------------------------------------
    /**
     * Regresa un integer que es el id del Director.
     *
     * @param id entero que identifica la entidad.
     * @return null si el id no se encuentra en la base de datos ó un
     * {@code mx.uach.videoclub.modelos.Director} si el id es valido.
     */
    public Integer getIdDirector(Integer id);

    /**
     * Regresa un nombre de director.
     *
     * @param nombre string que sera el nombre del director.
     * @return objects que es la lista de directores.
     */
    public String getNombreDirector(String nombre);
    
}
