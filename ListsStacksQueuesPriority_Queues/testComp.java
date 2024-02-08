package ListsStacksQueuesPriority_Queues;

import java.util.Comparator;

public class testComp implements Comparator<Integer> {

	public static void main(String[] args) {
		testComp test = new testComp();
		
		int result = 	compare(2,3);
		System.out.print(result);

	}

	@Override
	public int compare(Integer a, Integer b) {
		if(a>b)
			return 1;
		else if(a<b)
			return -1;
		else 
			return 0;
	}
	
}
