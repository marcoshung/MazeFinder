
public class DFS {
	public boolean DFS(Graph g) {
		//initializes all nodes in the graph
		for(Node n: g.vertex.children) {
			n.color = "white";
			n.parent = null;
			n.time = 0;
		}
		for(Node n: g.vertex.chlidren) {
			if(n.color.equals("white")) {
				visit(g,n);
			}
		}
	}
	
	public void visit(Graph g, Node n) {
		n.color = "grey";
		g.time++;
		n.discovery = g.time;
		
		for(Node adj: n.children) {
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
