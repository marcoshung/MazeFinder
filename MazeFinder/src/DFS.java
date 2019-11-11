
public class DFS {
	public boolean DFS(Graph g) {
		//initializes all nodes in the graph
		for(Node n: g.getVertex().neighbors) {
			n.color = "white";
			n.parent = null;
		}
		g.time = 0;
		Node source = g.vertex;
		visit(g, source);
		for(Node n: g.vertex.neighbors) {
			if(n.color.equals("white")) {
				visit(g,n);
			}
		}
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
