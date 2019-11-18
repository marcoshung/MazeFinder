
public class DFS {
	public void DFS(Graph g) {
		//initializes all nodes in the graph
		for(int i = 0; i < g.graph.length; i++) {
			Node n = (Node) g.graph[i].getFirst();
			n.color = "white";
			n.parent = null;
			System.out.println(n.id);
		}
		
		g.time = 0;
		Node source = (Node) g.graph[0].getFirst();
		//visit(g, source);
		/*
		for(Node n: g.vertex.neighbors) {
			if(n.color.equals("white")) {
				visit(g,n);
			}
		}
		*/
	}
	
	public void visit(Graph g, Node n) {
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
