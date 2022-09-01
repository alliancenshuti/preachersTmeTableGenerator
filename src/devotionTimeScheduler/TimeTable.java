package devotionTimeScheduler;
import java.util.ArrayList;
import java.util.Random;
public class TimeTable {
	LinkedList preachers;
	String[] classes;
	String[] days;
	Random rand = new Random();
	ArrayList<IndividualClass> loadedData = new ArrayList<IndividualClass>();
	//constructor of timetable
	public TimeTable(LinkedList preachers, String[]classes , String[] days) {
		this.preachers = preachers;
		this.classes = classes;
		this.days = days;
		assignPreachersToDays();
	}
	
	/*
	 * the logic is to make an array list of classes with their preachers and non preachers
	 * and then make a function to  all the preachers in other classes they can preach in.
	 * */
	private class IndividualClass{
		String name;
		ArrayList<String> preachersNames;
		ArrayList<String> nonPreachersNames;
		ArrayList<String> preacherOfDay;
		public IndividualClass(String name) {
			this.name = name;
		}
		
		public void appendToPreachers (String name) {
			preachersNames.add(name);
		}
		
		public void appendeToNonPreachers(String name) {
			nonPreachersNames.add(name);
		}
	}
	
	private void loadClasses() {
		for(int k =0; k < classes.length;k++) {
			IndividualClass currentClass = new IndividualClass(classes[k]);
			if(preachers.head != null) {
				Node temp = preachers.head;
				while(true) {
					if(temp.next == null) {break;}
					if(!temp.preacher.exceptions.contains(classes[k]) || temp.preacher.exceptions == null ) {
						currentClass.appendToPreachers(temp.preacher.name);
					}
					else {
						currentClass.appendeToNonPreachers(temp.preacher.name);
					}
					temp = temp.next;
				}
				
			}
			loadedData.add(currentClass);
		}
		
	}
	
	private void assignPreachersToDays() {
		loadClasses();
		boolean allClassesAssigned = false;
		if(preachers.head != null) {
			Node temp = preachers.head;
			while(true) {
				if(temp.next == null) {break;}
				while(true) {
					// check if all classes are assigned
					for (IndividualClass classe : loadedData) {
						if (!classe.preacherOfDay.isEmpty()) {
							allClassesAssigned = true;
						}
						else {allClassesAssigned = false;}
					}
					
					if(allClassesAssigned) { break;}
					
					//assign a preacher to random class
					int randomClass = rand.nextInt(loadedData.size());
					if (temp.preacher.exceptions.contains(loadedData.get(randomClass).name)) {
						continue;
					}
					if(loadedData.get(randomClass).preacherOfDay.size() < days.length) {
						int randomDay = rand.nextInt(days.length);
						if(loadedData.get(randomClass).preacherOfDay.get(randomDay) == null) {
							loadedData.get(randomClass).preacherOfDay.set(randomDay, temp.preacher.name);
						}
						else {
							while(loadedData.get(randomClass).preacherOfDay.get(randomDay) != null) {
								randomDay = rand.nextInt(days.length);
							}
							loadedData.get(randomClass).preacherOfDay.set(randomDay, temp.preacher.name);
						}
					}
					
				}
				temp = temp.next;
			}
		}
	}
	
	
	
	
	public void outputTable() {
		for(int i = 0; i < loadedData.size(); i++) {
			System.out.print(loadedData.get(i).name+"\t\t");
			for (int k =0; k < days.length ; k++) {
				System.out.print(loadedData.get(i).preacherOfDay.get(k)+"\t\t");
			}
			System.out.println();
		}
	}

}
