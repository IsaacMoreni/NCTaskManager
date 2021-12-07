package mx.edu.j2se.moreno.tasks;

public class TaskListFactory {

    public static AbstractTaskList createTaskList(ListTypes.types type){
        if(type == null)
            throw new NullPointerException();
        if(type == ListTypes.types.ARRAY)
            return new ArrayTaskList();
        if(type == ListTypes.types.LINKED)
            return new LinkedTaskList();
        return null;
    }
}
