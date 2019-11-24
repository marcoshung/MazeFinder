
public class DFS {
	public static void DFS(Graph g) {
		//initializes all nodes in the graph
		for(int i = 0; i < g.graph.length; i++) {
			Node n = g.graph[i];
			n.color = "white";
			n.parent = null;
		}
		//initializes the time for the graph
		g.time = 0;
		
		//assume first element in graph is the source node
		Node source = (Node) g.graph[0];
		
		//DFS for nodes
		for(int i = 0; i < g.graph.length;i++) {
			Node currentNode = g.graph[i];
			if(currentNode.color.equals("white")) {
				visit(g, currentNode);
			}
		}
		
		//prints out discovery and finishing times of all nodes
		for(int i = 0; i < g.graph.length; i++) {
			System.out.println(g.graph[i].id + " " + g.graph[i].discovery + " " +g.graph[i].fin);
		}
	}
	
	public static void visit(Graph g, Node n) {
		n.color = "grey";
		g.time++;
		n.discovery = g.time;
		
		//checks all neighbors to see whether they have been iterated through
		for(Node adj: n.neighbors) {
			if(adj.color.equals("white")) {
				adj.parent = n;
				visit(g, adj);
			}
		}
		
		n.color = "black";
		g.time++;
		n.fin = g.time;
	}
	
}
