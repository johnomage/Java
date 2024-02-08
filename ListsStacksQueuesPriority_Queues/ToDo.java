package ListsStacksQueuesPriority_Queues;


import java.util.*;

public class ToDo extends Task
{
	private Scanner input = new Scanner(System.in);
	List<Task> taskList = new ArrayList<>();
	
	//Constructor
	public ToDo(){}
	
	//Add task to list
	public void addToTask(Task task){
		if(inTaskList(task) == true)
			System.out.println(task.getTaskName() + " given details already exists.");
		
		else taskList.add(task);
	}
	
	//Delete a given task
	public void deleteTask(Task task){
		if(inTaskList(task) == true)
			taskList.remove(task);
		
		else System.out.println(task.getTaskName() + " is not in task list.");
	}
	
	//Print task details
	public void printTask(Task task){
		if(inTaskList(task) == true){
			taskList.toString();
			}
		
		else taskNotFound(task);
	}
	
	//check if a task is in the task list
	private boolean inTaskList(Task task) {
		return taskList.contains(task) ? true : false;
	}

	public void viewAllTasks()
	{
		for(Task task: taskList){
			printTask(task);
		}
	}

	public String viewTask(Task task){
		if(inTaskList(task) == false) {
			System.out.println(task.getTaskName() + " is not in task list.");
			System.out.print("Create " + task.getTaskName() + "? (y/n)");
			char res = input.next().charAt(0);
			if(res=='y' || res=='Y') {
				createTask(requestTaskName(), requestTaskOwner(), requestTaskDate());
			}
			
			return task.getTaskName() + " created";
		}
			
		else return task.toString();
	}
	
	public String requestTaskName() {
		System.out.print("Enter task Name: ");
		return input.nextLine();
	}
	
	public String requestTaskOwner() {
		System.out.print("Enter task Owner: ");
		return input.nextLine();
	}
	
	public Date requestTaskDate() {
		System.out.print("Enter task Name: ");
		return getDeadline();
	}
	
}
