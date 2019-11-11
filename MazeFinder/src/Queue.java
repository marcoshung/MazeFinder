import java.util.LinkedList;

public class Queue {
	private LinkedList<Node> queue;
	
	public Queue(Node vertex) {
		queue.addFirst(vertex);
	}
	
	public void enqueue(Node v) {
		queue.addLast(v);
	}
	
	public Node dequeue() {
		return queue.removeFirst();
	}
	
	public int getSize() {
		return queue.size();
	}
}
