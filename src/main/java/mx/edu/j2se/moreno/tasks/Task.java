package mx.edu.j2se.moreno.tasks;

/**
 * @author Isaac Moreno
 * @version 1.1
 */

public class Task {

    /* Attributes */

    private String title;
    private boolean active;
    private int startTime;
    private int endTime;
    private int repeatInterval;

    /* Constructors */

    /**
     * Constructor for a non-repetitive event, the event is inactive by default.
     *
     * @param  title  a little describe of event.
     * @param  time   the time that the event happens.
     * @exception IllegalArgumentException throws exception when time is less than 0.
     */
    public Task (String title, int time){
        this.title = title;
        if(time > 0)
            this.startTime = time;
        else
            throw new IllegalArgumentException();
        this.endTime = -1;
        this.repeatInterval = 0;
        this. active = false;
    }

    /**
     * Constructor for a repetitive event, the event is inactive by default.
     * If the end is greater than start, the Task created are going to be non-repetitive.
     *
     * @param  title     a little describe of event
     * @param  start     the start of the first event.
     * @param  end       the end date of the repetitive task.
     * @param  interval  the time between the task events.
     * @exception IllegalArgumentException throws exception when start is less than 0.
     */
    public Task (String title, int start, int end, int interval){
        this.title = title;
        if (start > 0)
            this.startTime = start;
        else
            throw new IllegalArgumentException();
        this.active = false;
        this.endTime = start < end ? end : -1;
        this.repeatInterval = start < end ? interval : 0;
    }

    /* Methods */

    String getTitle(){
        return this.title;
    }

    void setTitle(String title){
        this.title = title;
    }

    boolean isActive(){
        return this.active;
    }

    void setActive(boolean active){
        this.active = active;
    }

    /**
     * @return If the task is a repetitive one, the method must return the start time of the
     *         repetition, otherwise the time of te task.
     */
    int getTime(){
        return this.startTime;
    }

    /**
     * If the task was a repetitive one,it should become non-repetitive.
     *
     * @param time new time of the event.
     * @exception IllegalArgumentException throws exception when time is less than 0.
     */
    void setTime(int time){
        if (time > 0)
            this.startTime = time;
        else
            throw new IllegalArgumentException();
        this.endTime = -1;
        this.repeatInterval = 0;
    }

    int getStartTime(){
        return this.startTime;
    }

    int getEndTime(){
        return this.endTime;
    }

    int getRepeatInterval(){
        return this.repeatInterval;
    }

    /**
     * If the end is greater than start, only start is going to be modified
     * and end an interval are going to be for a non-repetitive Task.
     *
     * @param start    new startTime of the Task
     * @param end      new endTime of the Task
     * @param interval new repeatInterval of the Task
     * @exception IllegalArgumentException throws exception when start is less than 0.
     */
    void setTime(int start, int end, int interval){
        if (start > 0)
            this.startTime = start;
        else
            throw new IllegalArgumentException();
        this.endTime = start < end ? end : -1;
        this.repeatInterval = start < end ? interval : 0;
    }

    boolean isRepeated(){
        return this.endTime != -1;
    }

    /**
     * If after the specified time the task is not executed
     * anymore, the method return -1.
     * If the current time is the time of the executed time
     * the method return -1.
     *
     * @param current  set the current time
     * @return         the next start time of the task execution after the current time.
     * @exception IllegalArgumentException Current time can't be less than 0.
     */
    int nextTimeAfter(int current){
        if (current < 0)
            throw new IllegalArgumentException();
        if(this.isActive()) {
            int nextTask = startTime;
            do {
                if (current < nextTask)
                    return nextTask;
                else
                    nextTask += this.repeatInterval;
            } while (this.endTime >= nextTask);
        }
        return -1;
    }

    /**
     * Compare the Task object with another task object
     * @param task Not null task
     * @exception NullPointerException thrown by a null pointer in the param
     */
    boolean isEqual(Task task){
        if(task == null)
            throw new NullPointerException();
        if(task.getTitle() == this.title && task.getStartTime() == this.startTime
        && task.getEndTime() == this.endTime && task.getRepeatInterval() == this.repeatInterval){
            return true;
        }
        return false;
    }
}
