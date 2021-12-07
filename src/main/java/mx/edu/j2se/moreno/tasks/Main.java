package mx.edu.j2se.moreno.tasks;

public class Main {
	
	public static void main(String[] args) {

		AbstractTaskList listA = TaskListFactory.createTaskList(ListTypes.types.ARRAY);
		AbstractTaskList listL = TaskListFactory.createTaskList(ListTypes.types.LINKED);

		System.out.println("Type listA:" + listA.getClass());
		System.out.println("Type listL:" + listL.getClass());



	}
}
