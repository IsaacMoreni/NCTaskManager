package mx.edu.j2se.moreno.tasks;

/**
 * @author Isaac Moreno
 * @version 1.0
 */
public class ArrayTaskList extends AbstractTaskList{

    private Task[] taskArray;

    public ArrayTaskList(){ length = 0; }

    @Override
    public void add(Task task){
        if(task == null)
            throw new NullPointerException();
        Task[] tmpArray = new Task[length + 1];
        if (length >= 0) System.arraycopy(taskArray, 0, tmpArray, 0, length);
        tmpArray[length] = task;
        length++;
        taskArray = tmpArray;
    }

    @Override
    public boolean remove(Task task){
        if(task == null)
            throw new NullPointerException();
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

    @Override
    public Task getTask(int index){
        if(index >= length || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        return taskArray[index];
    }

//    @Override
//    ArrayTaskList incoming(int from, int to){
//        if(from < 0 || to < 0 || from > to)
//            throw new IllegalArgumentException();
//        ArrayTaskList taskIncluded = new ArrayTaskList();
//        int nextTime;
//        for(int i = 0; i < length; i++){
//            nextTime = taskArray[i].nextTimeAfter(from);
//            if(nextTime >= from && nextTime <= to)
//                taskIncluded.add(taskArray[i]);
//        }
//        if (taskIncluded.size() != 0)
//            return taskIncluded;
//        return null;
//    }
}
