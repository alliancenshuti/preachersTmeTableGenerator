package devotionTimeScheduler;
public class Node {
	Preacher preacher;
	Node next;
	
	public Node(Preacher preacher , Node next) {
		this.preacher = preacher;
		this.next = next;
	}
	
	public Node(Preacher preacher) {
		this.preacher = preacher;
		this.next = null;
	}
	
}
