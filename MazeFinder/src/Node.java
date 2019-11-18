import java.util.LinkedList;

public class Node {
	public Node parent;
	public LinkedList<Node> neighbors = new LinkedList<Node>();
	public int discovery;
	public int id;
	public int fin;
	public int dist;
	public String color;
	
	public Node(int id) {
		this.id = id;
	}
	
	public void addNeighbor(Node n) {
		neighbors.add(n);
	}
	
	public void printList() {
		System.out.print(id + " ");
		int i = 0;
		while(!neighbors.isEmpty()) {
			System.out.print("-> " + neighbors.get(i));
			i++;
		}
	}
}
