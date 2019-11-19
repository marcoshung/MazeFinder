import java.util.LinkedList;

public class Graph {
	//testing method with test cases
	public static void main(String[] args) {
		Node nodes1 = new Node(1);
		Node nodes2 = new Node(2);
		Node nodes3 = new Node(3);
		Graph test = new Graph(nodes1);
		nodes1.addNeighbor(nodes2);
		nodes1.addNeighbor(nodes3);
		
		nodes2.addNeighbor(nodes3);
		nodes2.addNeighbor(nodes1);
		
		nodes3.addNeighbor(nodes1);
		nodes3.addNeighbor(nodes2);
		
		Node[] testers = {nodes1, nodes2, nodes3};
		
		test.graph = testers;
		
		DFS.DFS(test);
		BFS.BFS(test);
		
	}
	
	Node[] graph = new Node[3];
	int time = 0;
	Node vertex;
	
	
	public Graph(Node vertex) {
		this.vertex = vertex;
	}
	
	public Node getVertex() {
		return this.vertex;
	}
	
	

	
}
