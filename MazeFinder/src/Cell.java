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
	
	LinkedList<Cell> neighbors;

	
	public Cell(int x, int y) {
		this.x=x;
		this.y=y;
		this.top=true;
		this.bottom=true;
		this.left=true;
		this.right=true;
	}
	
	

}
