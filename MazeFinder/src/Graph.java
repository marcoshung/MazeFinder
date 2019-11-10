
public class Graph {
	LinkedList[] graph = new LinkedList[10];
	int time = 0;
	Node vertex;
	
	public Graph(Node vertex) {
		this.vertex = vertex;
	}
	
	public boolean DFSearch(Node vertex, int target) {
		boolean targetFound = false;
		for(Node n : vertex.children) {
			if(n.color.equals("white")) {
				n.setColor("grey");
				if(n.getID() == target) {
					return true;
				}
				targetFound = (DFSearch(n, target));
				n.color = "black";
			}
		}
		return false;
	}
}
