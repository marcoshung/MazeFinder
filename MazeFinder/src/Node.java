import java.util.LinkedList;

public class Node {
	private Node parent;
	private LinkedList<Node> neighbors = new LinkedList<Node>();
	private int discovery;
	private int id;
	private int fin;
	private int dist;
	private String color;
	
	public Node(int id, String color) {
		this.id = id;
		this.color = color;
	}
	
	public void setColor(String c) {
		this.color = c;
	}
	
	public void setDistance(int d) {
		this.dist = d;
	}
	public int getDistance() {
		return dist;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setParent(Node n) {
		this.parent = n;
	}
	
	public void setChild(Node n) {
		neighbors.addLast(n);
	}
	
	public LinkedList<Node> getNeighbors() {
		return neighbors;
	}
	
	/*public int[] getChildren() {
		int[] elements = new int[neighbors.size()];
		for(int i = 0; i < neighbors.size(); i++) {
			elements[i] = neighbors.getHead();
		}
	}
	
	*/
	
	public int getID() {
		return this.id;
	}
	
}
