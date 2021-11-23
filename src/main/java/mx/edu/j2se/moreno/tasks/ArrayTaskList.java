package mx.edu.j2se.moreno.tasks;

/**
 * @author Isaac Moreno
 * @version 1.0
 */
public class ArrayTaskList {

    private Task[] taskArray;
    private int length;

    public ArrayTaskList(){
        length = 0;
    }

    /**
     * Add a task at the end of the list.
     *
     */
    void add(Task task){
        Task[] tmpArray = new Task[length + 1];
        if (length >= 0) System.arraycopy(taskArray, 0, tmpArray, 0, length);
        tmpArray[length] = task;
        length++;
        taskArray = tmpArray;
    }

    /**
     * Remove the first coincidence of the task given from the list
     *
     * @return return true if the task is deleted, return false if the
     * task wasn't in the list.
     */
    boolean remove(Task task){
        int i;
        boolean found = false;
        for (i=0; i < length; i++) {
            if (taskArray[i].isEqual(task)){
                found = true;
                break;
            }
        }
        if (found){
            Task[] tmpArray = new Task[length-1];
            for(int j=0, k=0; j < length; j++){
                if(j != i){
                    tmpArray[k]=taskArray[j];
                    k++;
                }
            }
            length--;
            taskArray = tmpArray;
        }
        return found;
    }

    /**
     * @return the number of tasks in the list.
     */
    int size(){
        return this.length;
    }

    /**
     * @return a reference of the task in the list
     */
    Task getTask(int index){
        if(index >= length || index < 0)
            return null;
        return taskArray[index];
    }

    /**
     * This checks the activities in the ist that are going to happen in the
     * interval given.
     *
     * @return A list with the events that will happen.
     */
    ArrayTaskList incoming(int from, int to){
        ArrayTaskList taskIncluded = new ArrayTaskList();
        int nextTime;
        for(int i = 0; i < length; i++){
            nextTime = taskArray[i].nextTimeAfter(from);
            if(nextTime >= from && nextTime <= to)
                taskIncluded.add(taskArray[i]);
        }
        if (taskIncluded.size() != 0)
            return taskIncluded;
        return null;
    }
}
