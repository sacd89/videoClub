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
public class DirectorMockito {
    
    private DirectorInterface directorInterface;

   public void setDirectorInterface(DirectorInterface directorInterface){
      this.directorInterface = directorInterface;
   }
   
   public Integer getIdDirectorMockito(Integer id){
      return directorInterface.getIdDirector(id);
   }
   
    public String getNombreDirectorMockito(String nombre){
      return directorInterface.getNombreDirector(nombre);
   }
   
    
}
