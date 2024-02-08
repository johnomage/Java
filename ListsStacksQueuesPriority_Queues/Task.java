package ListsStacksQueuesPriority_Queues;


import java.util.Date;

public class Task
{
	
	String taskName;
	Date deadline;
	String taskOwner;
	
	public Task(){};
	
	public Task(String taskName){
		this.taskName = taskName;
	}
	
	public Task(Task task) {
		this.taskName = task.getTaskName();
		this.taskOwner = task.getTaskOwner();
		this.deadline = task.getDeadline();
	}
	
	Task(String taskName, String taskOwner, Date deadline){
		this.taskName = taskName;
		this.taskOwner = taskOwner;
		this.deadline = deadline;
	}

	public void setTaskName(String taskName)
	{
		this.taskName = taskName;
	}

	public String getTaskName()
	{
		return taskName;
	}

	public void setDeadline(Date deadline)
	{
		this.deadline = deadline;
	}

	public Date getDeadline()
	{
		return deadline;
	}

	public void setTaskOwner(String taskOwner)
	{
		this.taskOwner = taskOwner;
	}

	public String getTaskOwner()
	{
		return taskOwner;
	}
	
	public void createTask(String taskName, String taskOwner, Date deadline){
		setTaskName(taskName);
		setTaskOwner(taskOwner);
		setDeadline(deadline);
	}
	
	//Update a given task
	public void updateTask(String newTaskName, Date newDeadline){
		setTaskName(this.taskName = newTaskName);
		setDeadline(this.deadline = newDeadline);
	}
	
	public String taskNotFound(Task taskName){
		return taskName + " not found in list of tasks.";
	}
	
	//VIEW A PARTICULAR TASK
	
	@Override
	public String toString(){
		return "Task name: " + taskName + "\nAssigned to: " + taskOwner + "\nDeadline: " + deadline;
	}
}

