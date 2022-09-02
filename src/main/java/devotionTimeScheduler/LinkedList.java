package devotionTimeScheduler;

public class LinkedList {
	Node head;
	
	public LinkedList(Preacher preacher) {
		this.head = new Node(preacher);
	}
	
	public void appendPreacher(Preacher preacher) {
		if(this.head != null) {
			Node temp = head;
			while(true) {
				if (temp.next == null) { 
					Node newPreacher = new Node(preacher);
					temp.next = newPreacher;
					newPreacher.next = null;
					break;
					}
				temp = temp.next;
			}
		}
		else { this.head = new Node(preacher);}
	}
	
	public void printPreachers() {
		System.out.println("Name \t\t preachersClass \t\t uncomfortable");
		if (this.head != null) {
			Node temp = this.head;
			while (true) {
				if(temp.next == null) { break;}
				System.out.printf("%s \t\t %s \t\t %s",temp.preacher.name,temp.preacher.preacherClass,temp.preacher.exceptions.toString());
			}
		}
	}
	
	public int getLength() {
		int len;
		if (head != null) {
			Node temp = head;
			len = 0;
			while(true) {
				len++;
				if (temp.next == null) {return len;}
				temp = temp.next;
			}
		}
		
		return 0;
	}

}
