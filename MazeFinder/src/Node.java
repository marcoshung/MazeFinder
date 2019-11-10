
public class Node {
	Node parent;
	LinkedList<Node> children = new LinkedList<Node>();
	int discovery;
	int id;
	int fin;
	String color;
	
	public Node(int id, String color) {
		this.id = id;
		this.color = color;
	}
	
	public void setColor(String c) {
		this.color = c;
	}
	
	public void setParent(Node n) {
		this.parent = n;
	}
	
	public void setChild(Node n) {
		children.insertAtEnd(n);
	}
	
	
	public int[] getChildren() {
		int[] elements = new int[children.getSize()];
		for(int i = 0; i < children.getSize(); i++) {
			elements[i] = children.getHead();
		}
	}
	
	public int getID() {
		return this.id;
	}
	
}
