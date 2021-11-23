package mx.edu.j2se.moreno.tasks;

import org.junit.Assert;
import org.junit.Test;
/**
 * A class to do test over Task
 *
 * @author Isaac Moreno
 * @version 1.1
 */
public class TaskTest {

    @Test
    public void testTask(){
        //Creacion de dos objetos de la clase Task, uno repetitivo y uno no repetitivo.
        Task repetitiveTask = new Task("Probe a repetitive Task",10, 56, 5);
        Task normalTask = new Task("Probe a non-repetitive Task ",6);

        //Se comprueba que se crean inactivos y su respectiva bandera isRepeated().
        Assert.assertFalse(repetitiveTask.isActive());
        Assert.assertFalse(normalTask.isActive());
        Assert.assertTrue(repetitiveTask.isRepeated());
        Assert.assertFalse(normalTask.isRepeated());

        //Se activan y se comprueba su valor esperado.
        repetitiveTask.setActive(true);
        normalTask.setActive(true);
        Assert.assertTrue(repetitiveTask.isActive());
        Assert.assertTrue(normalTask.isActive());

        //Se comprueba que getTime devuelve el startTime de un Task repetitivo.
        Assert.assertEquals(repetitiveTask.getTime(),10);

        //Pruebas con la funcion nextTimeAfter sabiendo los valores actuales.
        Assert.assertEquals(repetitiveTask.nextTimeAfter(8),10);
        Assert.assertEquals(repetitiveTask.nextTimeAfter(36),40);
        Assert.assertEquals(repetitiveTask.nextTimeAfter(45),50);
        Assert.assertEquals(repetitiveTask.nextTimeAfter(58),-1);
        Assert.assertEquals(normalTask.nextTimeAfter(5),6);
        Assert.assertEquals(normalTask.nextTimeAfter(6),-1);
        Assert.assertEquals(normalTask.nextTimeAfter(7),-1);

        //Usando setTime(int) convierte al Task en no repetitivo.
        repetitiveTask.setTime(15);
        //Usando setTime(int,int,int) convierte al Task en repetitivo.
        normalTask.setTime(6,12, 3);

        //Comprobando la situacion de los Task.
        Assert.assertTrue(normalTask.isRepeated());
        Assert.assertFalse(repetitiveTask.isRepeated());

        //Verificar sus nuevos posibles nextTimeAfter().
        Assert.assertEquals(normalTask.nextTimeAfter(11),12);
        Assert.assertEquals(repetitiveTask.nextTimeAfter(10),15);
    }

    @Test
    public void testTaskConstructors(){
        //Creacion de dos objetos de la clase Task, uno repetitivo y uno no repetitivo.
        Task repetitiveTask = new Task("Probe a repetitive Task",10, 56, 5);
        Task normalTask = new Task("Probe a non-repetitive Task ",6);

        //Se comprueba que se crean inactivos y su respectiva bandera isRepeated().
        Assert.assertFalse(repetitiveTask.isActive());
        Assert.assertFalse(normalTask.isActive());
        Assert.assertTrue(repetitiveTask.isRepeated());
        Assert.assertFalse(normalTask.isRepeated());
    }

    @Test
    public void testTaskSetActive(){
        //Creacion de dos objetos de la clase Task, uno repetitivo y uno no repetitivo.
        Task repetitiveTask = new Task("Probe a repetitive Task",10, 56, 5);
        Task normalTask = new Task("Probe a non-repetitive Task ",6);

        Assert.assertFalse(repetitiveTask.isActive());
        Assert.assertFalse(normalTask.isActive());

        repetitiveTask.setActive(true);
        normalTask.setActive(true);

        Assert.assertTrue(repetitiveTask.isActive());
        Assert.assertTrue(normalTask.isActive());

        repetitiveTask.setActive(false);
        normalTask.setActive(false);

        Assert.assertFalse(repetitiveTask.isActive());
        Assert.assertFalse(normalTask.isActive());
    }

    @Test
    public void testTaskSetters(){
        //Creacion de dos objetos de la clase Task, uno repetitivo y uno no repetitivo.
        Task repetitiveTask = new Task("Probe a repetitive Task",10, 56, 5);
        Task normalTask = new Task("Probe a non-repetitive Task ",6);
    }
}