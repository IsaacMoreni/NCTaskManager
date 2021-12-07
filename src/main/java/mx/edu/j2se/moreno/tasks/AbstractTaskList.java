package mx.edu.j2se.moreno.tasks;

public abstract class AbstractTaskList {

    protected int length;
    private

    /**
     * @return the number of tasks in the list.
     */
    int size(){
        return this.length;
    }

    /**
     * Add a task at the end of the list.
     *
     * @exception NullPointerException thrown by a null pointer in the param
     */
    public abstract void add(Task task);

    /**
     * Remove the first coincidence of the task given from the list
     *
     * @return return true if the task is deleted, return false if the
     * task wasn't in the list.
     * @exception NullPointerException thrown by a null pointer in the param
     */
    public abstract boolean remove(Task task);

    /**
     * @return a reference of the task in the list
     * @exception ArrayIndexOutOfBoundsException If the index doesn't exist, is less than 0 or is greater than size.
     */
    public abstract Task getTask(int index);

    /**
     * This checks the activities in the ist that are going to happen in the
     * interval given.
     *
     * @return A list with the events that will happen.
     * @exception IllegalArgumentException When from is greater than to, or when anyone is less than 0.
     */
    public AbstractTaskList incoming(int from, int to){
        if(from < 0 || to < 0 || from > to)
            throw new IllegalArgumentException();
        AbstractTaskList events = new ArrayTaskList();
        int event;
        for (int i = 0; i < length; i++){
            event = getTask(i).nextTimeAfter(from);
            if(event <= to && event != -1){
                events.add(getTask(i));
            }
        }
        return events;
    }
}
