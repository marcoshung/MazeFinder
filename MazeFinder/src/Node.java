import java.util.LinkedList;

public class Node {
	public Node parent;
	public LinkedList<Node> neighbors = new LinkedList<Node>();
	public int discovery;
	public int id;
	public int fin;
	public int dist;
	public String color;
	
	public Node(int id, String color) {
		this.id = id;
		this.color = color;
	}
	
	
}
