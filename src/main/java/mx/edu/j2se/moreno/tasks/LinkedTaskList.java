package mx.edu.j2se.moreno.tasks;

/**
 * @author Isaac Moreno
 * @version 1.0
 */
public class LinkedTaskList {

    private TaskElement first;
    private TaskElement last;
    private int length;

    public LinkedTaskList(){
        this.length = 0;
    }

    /**
     * Add a task at the end of the list.
     *
     * @exception NullPointerException thrown by a null pointer in the param
     */
    void add(Task task){
        if(task == null)
            throw new NullPointerException();
        if(length == 0){
            first = new TaskElement(task);
            last = first;
        } else {
            TaskElement tmp = new TaskElement(task);
            last.setNextTask(tmp);
            last = tmp;
        }
        length ++;
    }

    /**
     * Remove the first coincidence of the task given from the list
     *
     * @return return true if the task is deleted, return false if the
     * task wasn't in the list.
     * @exception NullPointerException thrown by a null pointer in the param
     */
    boolean remove(Task task){
        if(task == null)
            throw new NullPointerException();
        switch (length){
            case 0:
                return false;
            case 1:
                if (first.getTask().isEqual(task)){
                    first = null;
                    last = null;
                    length --;
                    return true;
                }
                return false;
            default:
                if(first.getTask().isEqual(task)){
                    first = first.getNext();
                    length --;
                    return true;
                }
                TaskElement index = first;
                while(index.getNext()!=null){
                    if(index.getNext().getTask().isEqual(task)){
                        if(index.getNext() == last){
                            index.setNextTask(null);
                            last = index;
                        } else
                            index.setNextTask(index.getNext().getNext());
                        length --;
                        return true;
                    }
                    index = index.getNext();
                }
                return false;
        }
    }

    /**
     * @return the number of tasks in the list.
     */
    int size(){
        return length;
    }

    /**
     * @return a reference of the task in the list
     * @exception ArrayIndexOutOfBoundsException If the index doesn't exist, is less than 0 or is greater than size.
     */
    Task getTask(int index){
        if(index >= length || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        TaskElement tmp = first;
        for(int i = 0; i < index; i++){
            tmp = tmp.getNext();
        }
        return tmp.getTask();
    }

    /**
     * This checks the activities in the ist that are going to happen in the
     * interval given.
     *
     * @return A list with the events that will happen.
     * @exception IllegalArgumentException When from is greater than to, or when anyone is less than 0.
     */
    LinkedTaskList incoming(int from, int to){
        if(from < 0 || to < 0 || from > to)
            throw new IllegalArgumentException();
        LinkedTaskList taskIncluded = new LinkedTaskList();
        int nextTime;
        TaskElement index = first;
        while(index.getNext()!=null){
            nextTime = index.getTask().nextTimeAfter(from);
            if(nextTime >= from && nextTime <= to)
                taskIncluded.add(index.getTask());
            index = index.getNext();
        }
        if (taskIncluded.size() != 0)
            return taskIncluded;
        return null;
    }
}

class TaskElement {

    private final Task task;
    private TaskElement nextTask;

    protected TaskElement(Task task){
        this.task = task;
        nextTask = null;
    }

    protected Task getTask(){
        return task;
    }

    protected TaskElement getNext(){
        return nextTask;
    }

    protected void setNextTask(TaskElement next){
        nextTask = next;
    }
}
