
public class BFS {
	
	public void BFS(Graph g) {
		for(Node n: g.getVertex().getNeighbors()) {
			n.setColor("white");
			n.setParent(null);
			n.setDistance(Integer.MAX_VALUE);
		}
		
		Node source=g.getVertex();
		source.setColor("gray");
		source.setDistance(0);
		source.setParent(null);
		
		Queue q=new Queue(source);
		//blah
		while(q.getSize()!=0) {
			Node u=q.dequeue();
			for(Node v:u.getNeighbors()) {
				if(v.getColor().equals("white")) {
					v.setColor("gray");
					v.setDistance(u.getDistance()+1);
					v.setParent(u);
					q.enqueue(v);
				}
			}
			u.setColor("black");
		}
	}

}
