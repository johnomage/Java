package ListsStacksQueuesPriority_Queues;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class MainToDoClass {
	static ToDo todo = new ToDo();
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException, InterruptedException
	{
		boolean repeat = true;
		while(repeat){
	
			System.out.println("\nWhat do you want to do? : ");
		
			System.out.println("1. Create a task.\n2. Assign a task.\n3. Delete a task.\n4. Update a task."+
			"\n5. View Task.\n6. View all tasks.\n7. Exit");
			
			switch(input.nextInt()){
				
				case 1: System.out.print("Enter task name: ");
						String taskName = input.nextLine();
						System.out.print("Enter task owner: ");
						String taskOwner = input.nextLine();
						System.out.print("Enter task deadline (dd/MM/YYYY): ");
						Date taskDeadline = new SimpleDateFormat("dd/MM/YYYY").parse(input.nextLine());
						todo.createTask(taskName, taskOwner, taskDeadline);
						todo.addToTask(new Task(taskName, taskOwner, taskDeadline));
						System.out.println("Task created\n" + todo.toString());
						break;
			
				case 2: System.out.print("Enter task owner: ");
						todo.setTaskOwner(input.nextLine()); break;
					
				case 3: System.out.print("Enter task to delete: ");
						todo.deleteTask(new Task(input.nextLine())); break;
					
				case 4: System.out.print("Enter task to update: ");
						String oldTaskName = input.nextLine();
						String newTaskName = oldTaskName;
						System.out.print("Enter new deadline (dd/MM/YYYY): ");
						Date newDeadline = new SimpleDateFormat("dd/MM/YYYY").parse(input.nextLine());
						//todo.deleteTask(new Task(input.nextLine()));
						todo.updateTask(newTaskName, newDeadline); break;
						
				case 5: System.out.print("Enter task name to view: ");
						//String viewTaskName = input.nextLine();
						System.out.println(todo.viewTask(new Task(input.next()))); break;
						
				case 6: todo.viewAllTasks(); break;
				
				case 7: System.exit(0); break;
					
				default: System.out.println("You're not serious o. mtcheeww\n"); break;
			}
			
			System.out.print("\n\nDone? (Y/N): ");
			
			char response = input.next().charAt(0);
			
			if(response == 'y' || response == 'Y'){
				repeat = false;
				System.out.println("Bye bye...");
				Thread.sleep(2000);
			    //System.exit(0);
			   }
			   
			else main(args);
		 
		}
	}
}

