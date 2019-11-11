import java.util.LinkedList;

public class Graph {
	LinkedList[] graph = new LinkedList[10];
	int time = 0;
	Node vertex;
	
	
	public Graph(Node vertex) {
		this.vertex = vertex;
	}
	
	public Node getVertex() {
		return this.vertex;
	}
	

	
}
