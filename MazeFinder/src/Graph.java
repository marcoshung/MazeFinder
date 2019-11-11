import java.util.LinkedList;

public class Graph {
	LinkedList[] graph = new LinkedList[10];
	int time = 0;
	Node vertex;
	
	
	//public Graph(Node vertex) {
	public Graph(Node vertex) {
		this.vertex = vertex;
	}
	
	public Node getVertex() {
		return this.vertex;
	}
	
	public boolean DFSearch(Node vertex, int target) {
		boolean targetFound = false;
		for(Node n : vertex.getNeighbors()) {
			if(n.getColor().equals("white")) {
				n.setColor("grey");
				if(n.getID() == target) {
					return true;
				}
				targetFound = (DFSearch(n, target));
				n.setColor("black");
			}
		}
		return false;
	}

	
}
