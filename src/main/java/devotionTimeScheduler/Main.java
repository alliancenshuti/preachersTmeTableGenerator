package devotionTimeScheduler;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	
	
	public static void main(String[] args) {
		// main function for the application
		Scanner scanner = new Scanner(System.in);
		LinkedList llist = new LinkedList(null);
		String[] classes = {"y8","y9","y10","y11","y12","y13"};
		String[] days = {"tuesday","wednesday","thursday"};
		
		underline(50);
		System.out.println("WELCOME TO PREACERS SCHEDULER");
		underline(50);
		
		System.out.println("1. register Preacher \t 2. get time table  \t 3. get preachers");
		
		System.out.print("enter choice: ");
		if(scanner.hasNextInt()) {
		int choice = scanner.nextInt();
		
		switch(choice) {
		
		case 1:
						// register preacher
						underline(20);
						System.out.println("register preacher");
						underline(20);
						System.out.print("how many preachers: ");
						int preacherNum = scanner.nextInt();
						int k = 0;
					
						while(k < preacherNum) {
							System.out.printf("enter name(s) of preacher %d: ", k + 1);
							String name = scanner.next();
							System.out.println("enter preacher class: ");
							String preacherClass = scanner.next();
							System.out.println("enter number of uncomfortable classes:");
							int excptNum = scanner.nextInt();
							ArrayList<String> exceptionalClasses = new ArrayList<String>() ;
							if (excptNum > 0) {
								for(int i = 0; i < excptNum; i++) {
									System.out.printf("enter uncomfortable class %d :", i+1);
									String exptClass = scanner.next();
									exceptionalClasses.add(exptClass);
								}
							}
							Preacher preacher = new Preacher(name , preacherClass , exceptionalClasses);
							llist.appendPreacher(preacher);
							k++;
						}
						
		case 2:
			TimeTable table = new TimeTable(llist,classes,days);
			table.outputTable();
						
		case 3:
						llist.printPreachers();
		default:
			System.out.println("wrong choice | try again ");
		}
		}
		scanner.close();

	}
	

	public static void underline(int length) {
		for (int i = 0; i < length ; i++ ) {
			System.out.print("=");
		}
		System.out.println();
	}


}
