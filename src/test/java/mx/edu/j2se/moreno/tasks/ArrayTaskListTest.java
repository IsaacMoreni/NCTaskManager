package mx.edu.j2se.moreno.tasks;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import org.junit.Assert;
import org.junit.Test;

/**
 * A class to do test over ArrayTaskList
 *
 * @author Isaac Moreno
 * @version 1.0
 */
public class ArrayTaskListTest {
    @Test
    public void arrayTest(){
        //Pruebas hechas con arreglos de enteros.
        int[] array1 = new int[5];
        int[] array2 = new int[6];

        array1[0]=10;
        array1[1]=20;
        array1[2]=30;
        array1[3]=40;
        array1[4]=50;

        System.arraycopy(array1, 0, array2, 0, 5);
        array2[5]=60;
        array1 = array2;

        for (int i=0; i < 6; i++){
            System.out.println(array1[i]);
        }
    }

    @Test
    public void testingAddAndRemove(){
        Task t1,t2,t3,t4,t5,t6,t7,t8;
        t1 = new Task("Task 1",12);
        t2 = new Task("Task 2", 10, 20, 5);
        t3 = new Task("Task 3", 6);
        t4 = new Task("Task 4", 8, 12,2);
        t5 = new Task("Task 5", 20);
        t6 = new Task("Task 6",26, 40,8);
        t7 = new Task("Task 7", 27);
        t8 = new Task("Task 8",32, 58,2);

        ArrayTaskList listTask = new ArrayTaskList();
        listTask.add(t6);
        listTask.add(t4);
        listTask.add(t7);
        listTask.add(t2);
        Assert.assertEquals(4,listTask.size());

        System.out.println("List moment 1: Adding 4 tasks. Size: " + listTask.size());
        printArray(listTask);

        listTask.add(t1);
        listTask.add(t3);
        listTask.add(t2);

        System.out.println("\nList moment 2: Adding 3 more tasks. Size: " + listTask.size());
        printArray(listTask);

        Assert.assertFalse(listTask.remove(t8));
        Assert.assertTrue(listTask.remove(t2));
        Assert.assertEquals(6,listTask.size());

        System.out.println("\nList moment 3: Remove 2 tasks(only task 2 is removed). Size: " + listTask.size());
        printArray(listTask);

        listTask.remove(t6);
        listTask.remove(t4);
        listTask.remove(t7);
        listTask.remove(t2);
        listTask.remove(t1);

        System.out.println("\nList moment 4: Remove until have one task. Size: " + listTask.size());
        printArray(listTask);
    }

    @Test
    public void testingGetTask(){
        Task t1,t2,t3,t4,t5,t6,t7,t8;
        t1 = new Task("Task 1",12);
        t2 = new Task("Task 2", 10, 20, 5);
        t3 = new Task("Task 1", 12);
        t4 = new Task("Task 4", 8, 12,2);
        t5 = new Task("Task 5", 20);
        t6 = new Task("Task 6",26, 40,8);
        t7 = new Task("Task 7", 27);
        t8 = new Task("Task 8",32, 58,2);

        ArrayTaskList listTask = new ArrayTaskList();

        listTask.add(t6);
        listTask.add(t4);
        listTask.add(t7);
        listTask.add(t2);
        listTask.add(t1);
        listTask.add(t3);
        listTask.add(t2);
        listTask.add(t5);
        listTask.add(t8);
        listTask.add(t1);

        System.out.println("List moment 1:");
        for(int i=-2;i<12;i++)
            gettingTask(listTask, i);

        listTask.remove(t1);
        listTask.remove(t5);

        System.out.println("\n\nList moment 2:");
        for(int i=-2;i<12;i++)
            gettingTask(listTask, i);

    }

    @Test
    public void testingIncoming(){
        ArrayTaskList events, listTask = new ArrayTaskList();

        listTask.add(new Task("Task 01",12));
        listTask.add(new Task("Task 02", 10, 20, 5));
        listTask.add(new Task("Task 03", 6));
        listTask.add(new Task("Task 04", 8, 12,2));
        listTask.add(new Task("Task 05", 20));
        listTask.add(new Task("Task 06",26, 40,8));
        listTask.add(new Task("Task 07", 27));
        listTask.add(new Task("Task 08",32, 58,2));
        listTask.add(new Task("Task 09",49));
        listTask.add(new Task("Task 10",52));
        listTask.add(new Task("Task 11",67));
        listTask.add(new Task("Task 12",18));
        listTask.add(new Task("Task 13",46));
        listTask.add(new Task("Task 14",15));
        listTask.add(new Task("Task 15",56));
        listTask.add(new Task("Task 16",78));
        listTask.add(new Task("Task 17",15));
        listTask.add(new Task("Task 18",65));
        listTask.add(new Task("Task 19",49));
        listTask.add(new Task("Task 20",55));

        for (int i = 0; i < listTask.size(); i++){
            listTask.getTask(i).setActive(true);
        }

        System.out.println("Probe from: 12 - to: 30");
        events = listTask.incoming(12, 30);
        printArrayTime(events,12);

        System.out.println("\nProbe from: 56 - to: 80");
        events = listTask.incoming(56, 80);
        printArrayTime(events,56);

    }

    private void printArray(ArrayTaskList list){
        for (int i=0; i < list.size(); i++){
            System.out.print(i + ": ");
            System.out.println("Event: "+list.getTask(i).getTitle());
        }
    }

    private void gettingTask(ArrayTaskList list, int index){
        System.out.print(index + ": ");
        if (list.getTask(index) == null)
            System.out.println("The index doesn't exist");
        else {
            Task tmp = list.getTask(index);
            System.out.println("Event: " + tmp.getTitle());
        }
    }

    private void printArrayTime(ArrayTaskList list, int from){
        for (int i=0; i < list.size(); i++){
            System.out.print(i + ": ");
            System.out.print("Event: "+list.getTask(i).getTitle());
            System.out.println(" NextTime: "+list.getTask(i).nextTimeAfter(from));
        }
    }
}