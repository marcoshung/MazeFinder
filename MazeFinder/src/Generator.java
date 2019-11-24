

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Generator {
	public static void main(String[] args) {
		Cell[][] maze=makeMaze(4);
		for(int i=0;i<maze.length;i++) {
			for(int j=0;j<maze.length;j++) {
				System.out.println(maze[i][j].x+", "+maze[i][j].y);
				System.out.println(maze[i][j].top+", "+maze[i][j].bottom+", "+maze[i][j].left+", "+maze[i][j].right);
			}
		}
		//print maze
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
	
	//returns a perfect maze 
	//input: number of rows
	public static Cell[][] makeMaze(int r) {
		Stack<Cell> cellLocation=new Stack<>();
		Cell[][] maze=new Cell[r][r];
		int totalCells=r*r;
		//Creating 2d array that has cells with x and y coordinates
		for(int i=0;i<r;i++) {
			for(int j=0;j<r;j++) {
				maze[i][j]=new Cell(i,j);
			}
		}
		//start generating maze from starting position at (0,0)
		Cell current=maze[0][0];
		//keep track of visited cells 1---> r*r
		int visited=1;
		
		//create start and finish
		maze[0][0].top=false;
		maze[r-1][r-1].bottom=false;
		
		//start knocking down walls
		while(visited<totalCells) {
			//list to store all neighbors of current regardless of how many walls
			List<Cell> neighbors=new ArrayList<>();
			if((current.x)>0) 
				neighbors.add(maze[current.x-1][current.y]);
			if((current.y)<r-1) 
				neighbors.add(maze[current.x][current.y+1]);
			if((current.x)<r-1) 
				neighbors.add(maze[current.x+1][current.y]);
			if((current.y)>0) 
				neighbors.add(maze[current.x][current.y-1]);
			
			//delete cells without all walls intact
			for(int k=0;k<neighbors.size();k++) {
				Cell temp=neighbors.get(k);
				if(!(temp.bottom=true && temp.top==true && temp.left==true && temp.right==true)) {
					neighbors.remove(k);
					k--;
				}
			}
			Random rand=new Random();
			
			if(neighbors.size()>0) {
				Cell next=neighbors.get(rand.nextInt(neighbors.size()));
				System.out.println(next.x+" "+next.y);
				//Update Maze with new walls broken down
				
				//find the location on 2d array
				int xCoor2=next.x;
				int yCoor2=next.y;
				
				//location of current 
				int xCoor1=current.x;
				int yCoor1=current.y;
				
				//knock down the wall between current and next cell in 2d array
				
				if(xCoor1==(xCoor2-1)) {
					maze[xCoor1][yCoor1].bottom=false;
					maze[xCoor2][yCoor2].top=false;
				}
				else if(xCoor1==(xCoor2+1)) {
					maze[xCoor1][yCoor1].top=false;
					maze[xCoor2][yCoor2].bottom=false;
				}
				else if(yCoor1==(yCoor2-1)) {
					maze[xCoor1][yCoor1].right=false;
					maze[xCoor2][yCoor2].left=false;
				}
				else if(yCoor1==(yCoor2+1)) {
					maze[xCoor1][yCoor1].left=false;
					maze[xCoor2][yCoor2].right=false;
				}
				
				//push current cell into cellStack
				cellLocation.push(maze[xCoor1][yCoor1]);
				current=maze[xCoor2][yCoor2];
				visited+=1;
			
			}
			else {
				current=cellLocation.pop();
			}
				
			
		}
		//close bottom
		for(int i=0;i<r;i++) {
			if(i==r-1)
				maze[r-1][r-1].bottom=false;
			else
				maze[r-1][i].bottom=true;
				
		}
		
	
		 return maze;
	}
}

