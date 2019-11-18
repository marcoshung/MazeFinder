
public class DFS {
	public static void DFS(Graph g) {
		//initializes all nodes in the graph
		for(int i = 0; i < g.graph.length; i++) {
			Node n = g.graph[i];
			n.color = "white";
			n.parent = null;
			System.out.println(n.id + " " + n.color);
		}
		
		g.time = 0;
		Node source = (Node) g.graph[0];
		
		for(int i = 0; i < g.graph.length;i++) {
			Node currentNode = g.graph[i];
			if(currentNode.color.equals("white")) {
				visit(g, currentNode);
			}
		}
		
		for(int i = 0; i < g.graph.length; i++) {
			System.out.println(g.graph[i].id + " " + g.graph[i].discovery + " " +g.graph[i].fin);
		}
	}
	
	public static void visit(Graph g, Node n) {
		n.color = "grey";
		g.time++;
		n.discovery = g.time;
		for(Node adj: n.neighbors) {
			if(adj.color.equals("white")) {
				adj.parent = n;
				visit(g, adj);
			}
		}
		
		n.color = ("black");
		g.time++;
		n.fin = g.time;
	}
}
