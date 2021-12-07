package mx.edu.j2se.moreno.tasks;

/**
 * @author Isaac Moreno
 * @version 1.0
 */
public class LinkedTaskList extends AbstractTaskList{

    private TaskElement first;
    private TaskElement last;

    public LinkedTaskList(){
        length=0;
    }

    @Override
    public void add(Task task){
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

    @Override
    public boolean remove(Task task){
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

    @Override
    public Task getTask(int index){
        if(index >= length || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        TaskElement tmp = first;
        for(int i = 0; i < index; i++){
            tmp = tmp.getNext();
        }
        return tmp.getTask();
    }

//    @Override
//    LinkedTaskList incoming(int from, int to){
//        if(from < 0 || to < 0 || from > to)
//            throw new IllegalArgumentException();
//        LinkedTaskList taskIncluded = new LinkedTaskList();
//        int nextTime;
//        TaskElement index = first;
//        while(index.getNext()!=null){
//            nextTime = index.getTask().nextTimeAfter(from);
//            if(nextTime >= from && nextTime <= to)
//                taskIncluded.add(index.getTask());
//            index = index.getNext();
//        }
//        if (taskIncluded.size() != 0)
//            return taskIncluded;
//        return null;
//    }

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

}


