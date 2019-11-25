//HEADER
//Cell object represents one box in maze

import java.util.LinkedList;

//represents on cell in the maze
public class Cell {
	
	//coordinates of cell
	int x;
	int y;
	//walls (true if up, false if knocked down)
	boolean top;
	boolean bottom;
	boolean right;
	boolean left;
	
	//for solving in DFS and BFS
	String color;
	//to find shortest path, points to parent
	Cell parent;
	
	//order discovered
	int disc;
	
	//true if part of shortest path
	boolean shortest;

	
	public Cell(int x, int y) {
		this.x=x;
		this.y=y;
		
		//all walls are up initially
		this.top=true;
		this.bottom=true;
		this.left=true;
		this.right=true;
		
		//none discovered so white
		color="white";
		parent=null;
		shortest=false;
		disc=0;
	}
	
	

}
