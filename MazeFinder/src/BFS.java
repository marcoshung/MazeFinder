
public class BFS {
	
	public static void BFS(Graph g) {
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
		//tester
		for(int i = 0; i < g.graph.length; i++) {
			System.out.println(g.graph[i].id + " " + g.graph[i].discovery + " " +g.graph[i].fin);
		}
	}
	
	
	

}
