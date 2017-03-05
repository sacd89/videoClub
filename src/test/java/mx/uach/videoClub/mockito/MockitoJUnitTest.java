/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.videoClub.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;


/**
 *
 * @author dsantillanes
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoJUnitTest {
//    
 //@InjectMocks annotation is used to create and inject the mock object
   @InjectMocks
   DirectorMockito directorMockito = new DirectorMockito();

   //@Mock annotation is used to create the mock object to be injected
   @Mock
   DirectorInterface directorInterface;

   @Test
   public void directorId(){
      //add the behavior of calc service to add two numbers
      when(directorInterface.getIdDirector(1)).thenReturn(3);
		
      //test the add functionality
      Assert.assertEquals(directorMockito.getIdDirectorMockito(1),1,0);
   }
   
      @Test
   public void directorNombre(){
      //add the behavior of calc service to add two numbers
      when(directorInterface.getNombreDirector("Daniela")).thenReturn("Daniela");
		
      //test the add functionality
      Assert.assertEquals(directorMockito.getNombreDirectorMockito("Daniela"),"Daniela",0);
   }
}
