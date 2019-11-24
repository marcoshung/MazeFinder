

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Maze {
	
	Cell[][] maze;
	int r;
	int numCells;
	Stack<Cell> cellLocations;
	int visited;
	Cell current;
	
	public Maze(int r) {
		this.r=r;
		this.visited=1;
		
		maze=new Cell[r][r];
		for(int i=0;i<r;i++) {
			for(int j=0;j<r;j++) {
				maze[i][j]=new Cell(i,j);
			}
		}
		
		//check
		numCells=r*r;
		maze[0][0].top=false;
		current=maze[0][0];
		cellLocations=new Stack<>();
	}
	
	public void generateMaze() {
		Random rand=new Random();
		while(visited<numCells) {
			List<Cell> neighbors=findNeighbors(current);
			if(neighbors.size()>=1) {
				Cell next=neighbors.get(rand.nextInt(neighbors.size()));
				knockDownWall(current, next);
				cellLocations.push(maze[current.x][current.y]);
				current=next;
				visited++;
			}
			else {
				Cell temp=cellLocations.pop();
				current=temp;
				
			}
		}
		
		maze[r-1][r-1].bottom=false;
		
	}
	
	/*public void knockDownWall1(Cell c, Cell n) {
		int x1=c.x;
		int x2=n.x;
		int y1=c.y;
		int y2=n.y;
		
		if(x1<r-1 && x1==x2-1) {
			maze[x1][y1].bottom=false;
			maze[x2][y2].top=false;
		}
		else if(y1<r-1 && y1==y2-1) {
			maze[x1][y1].right=false;
			maze[x2][y2].left=false;
		}
		else if(x1>0 && x1==x2+1) {
			maze[x1][y1].top=false;
			maze[x2][y2].bottom=true;
		}
		else if(y1>0 && y1==y2+1) {
			maze[x1][y1].left=false;
			maze[x2][y2].right=false;
		}
	}
	*/
	
	
	
	public void knockDownWall(Cell c, Cell n) {
		if (c.x == n.x) { // same row
			if (c.y < n.y) {
				c.right = false;
				n.left = false;
			} else {
				c.left = false;
				n.right = false;
			}
		}
		if (c.y == n.y) { // same column
			if (c.x < n.x) {
				c.bottom = false;
				n.top = false;
			} else {
				c.top = false;
				n.bottom = false;
			}
		}
	}
	
	public List<Cell> findNeighbors(Cell c){
		List<Cell> neighbors=new ArrayList<>();
		if((c.x)>0 && checkNeighborWalls(maze[c.x-1 ][c.y])) 
			neighbors.add(maze[c.x-1][c.y]);
		if((c.y)<r-1 && checkNeighborWalls(maze[c.x][c.y+1])) 
			neighbors.add(maze[c.x][c.y+1]);
		if((c.x)<r-1 && checkNeighborWalls(maze[c.x+1][c.y])) 
			neighbors.add(maze[current.x+1][c.y]);
		if((c.y)>0 && checkNeighborWalls(maze[c.x][c.y - 1]) )
			neighbors.add(maze[c.x][c.y-1]);
		return neighbors;
	}
	
	public static boolean checkNeighborWalls(Cell c) {
		return c.top && c.bottom && c.left && c.right; 
	}
	
	
	public static void main(String[] args) {
		Maze tester=new Maze(4);
		tester.generateMaze();
		tester.printMaze();
	}
	
	public void printMaze() {
		for(int i = 0; i < maze.length;i++) {
			for(int j = 0; j < maze.length; j++) {
				System.out.print("+");
				if(maze[i][j].top == true) {
					System.out.print("-");
				}else {
					System.out.print(" ");
				}
			}

			System.out.print("+");
			System.out.println();
			for(int j = 0; j < maze.length; j++) {
				if(maze[i][j].left == false) {
					System.out.print(" ");
				}
				else if(maze[i][j].left == true) {
					System.out.print("|");
				}
				System.out.print(" ");
			}
			
			
			if(maze[i][maze[i].length - 1].right == true) {
				System.out.print("|");
			}
			System.out.println();
		}
		for(int i = 0; i < maze[maze.length - 1].length; i++) {
			System.out.print("+");
			if(maze[maze.length -1][i].bottom == true) {
				System.out.print("-");
			}else {
				System.out.print(" ");
			}
		}
		System.out.print("+");
		
		
	}


}
