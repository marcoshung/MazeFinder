
public class BFS {
	
	public void BFS(Graph g) {
		//initializes all 
		for(int i = 0; i < g.graph.length; i++) {
			Node n = g.graph[i];
			n.color = "white";
			n.parent = null;
			n.dist = Integer.MAX_VALUE;
		}
		
		Node source = g.getVertex();
		source.color = "gray";
		source.dist = 0;
		source.parent = null;
		
		Queue q=new Queue(source);
		//blah
		while(q.getSize()!=0) {
			Node u=q.dequeue();
			for(Node v:u.neighbors) {
				if(v.color.equals("white")) {
					v.color = "gray";
					v.dist = u.dist+1;
					v.parent = u;
					q.enqueue(v);
				}
			}
			u.color = ("black");
		}
	}

}
