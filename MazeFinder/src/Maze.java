//HEADER

//represents a maze object
//generates random perfect maze
//preforms dfs and bfs to find path
//find shortest exit path 
//reads from input file to create maze object

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;


public class Maze {
	
	//maze represented in 2d array
	Cell[][] maze;
	//to find order, stores which cell visited first
	int time;
	//stores dimensions of maze
	int r;
	//total num of cells
	int numCells;
	//stores cells in stack
	Stack<Cell> cellLocations;
	//number of cells visited from 0 to total num of cells
	int visited;
	//stores cell being used currently
	Cell current;
	//one array of all cells left ro right top to bottom
	List<Cell> allCells;
	
	////////////////////////////////////////////////////////////////////////

	//CONSTRUCTOR
	public Maze(int r) {
		this.r=r;
		time=0;
		this.visited=1;
		allCells=new ArrayList<>();
		
		//create maze with all walls up
		maze=new Cell[r][r];
		for(int i=0;i<r;i++) {
			for(int j=0;j<r;j++) {
				maze[i][j]=new Cell(i,j);
				allCells.add(maze[i][j]);
			}
		}
		numCells=r*r;
		
		//open first cells top to enter maze
		maze[0][0].top=false;
		
		//current is first cell
		current=maze[0][0];
		cellLocations=new Stack<>();
	}
	
	////////////////////////////////////////////////////////////////////////

	//creates perfect random maze
	//seed for random set to 20
	public void generateMaze() {
		Random rand=new Random();
		rand.setSeed(20);
		
		//while all cells have not been visited, finds neighbors of current cell
		//which have all 4 walls up, picks random neighbor, knocks down wall between
		//them, updates current to next cell, increases visited and pushes in current.
		while(visited<numCells) {
			List<Cell> neighbors=findNeighbors(current);
			if(neighbors.size()>=1) {
				Cell next=neighbors.get(rand.nextInt(neighbors.size()));
				knockDownWall(current, next);
				cellLocations.push(maze[current.x][current.y]);
				current=next;
				visited++;
			}
			//if no eligible neighbors 
			else {
				Cell temp=cellLocations.pop();
				current=temp;
				
			}
		}
		
		//open last cells bottom wall to make exit
		maze[r-1][r-1].bottom=false;
	}
	
	////////////////////////////////////////////////////////////////////////

	//takes two cells and knocks down the wall between them
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
	
	////////////////////////////////////////////////////////////////////////

	//returns all niehgbors of a cell that have all 4 walls up
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
	
	////////////////////////////////////////////////////////////////////////

	//checks to see if cell's walls are all up and returns true if they are
	
	public static boolean checkNeighborWalls(Cell c) {
		return c.top && c.bottom && c.left && c.right; 
	}
	
	////////////////////////////////////////////////////////////////////////

	//prints unsolved maze into console and writes into an output file
	//output file is made in tester
	//if wall is present, prints/writes necessary ASCII symbol
	//if not, prints blank between cells
	
	public void printMaze(BufferedWriter writer) throws IOException {
		for(int i = 0; i < maze.length;i++) {
			for(int j = 0; j < maze.length; j++) {
				System.out.print("+");
				writer.write("+");
				if(maze[i][j].top == true) {
					System.out.print("-");
					writer.write("-");
				}else {
					System.out.print(" ");
					writer.write(" ");
				}
			}

			System.out.print("+");
			writer.write("+");
			System.out.println();
			writer.write("\n");
			for(int j = 0; j < maze.length; j++) {
				if(maze[i][j].left == false) {
					System.out.print(" ");
					writer.write(" ");
				}
				else if(maze[i][j].left == true) {
					System.out.print("|");
					writer.write("|");
				}
				System.out.print(" ");
				writer.write(" ");
			}
			
			
			if(maze[i][maze[i].length - 1].right == true) {
				System.out.print("|");
				writer.write("|");
			}
			System.out.println();
			writer.write("\n");
		}
		for(int i = 0; i < maze[maze.length - 1].length; i++) {
			System.out.print("+");
			writer.write("+");
			if(maze[maze.length -1][i].bottom == true) {
				System.out.print("-");
				writer.write("-");
			}else {
				System.out.print(" ");
				writer.write(" ");
			}
		}
		System.out.print("+");
		writer.write("+");
	}
	
	////////////////////////////////////////////////////////////////////////

	//prints maze with numbers in cells representing order found in console and
	//also writes into output file determined by tester
	//numbers are between 0-9 (uses mod func so after 9, the 10th cell found will
	//have '0' in it.

	public void printMazePath(BufferedWriter writer) throws IOException {
		for(int i = 0; i < maze.length;i++) {
			for(int j = 0; j < maze.length; j++) {
				System.out.print("+");
				writer.write("+");
				if(maze[i][j].top == true) {
					System.out.print("-");
					writer.write("-");
				}else {
					System.out.print(" ");
					writer.write(" ");
				}
			}

			System.out.print("+");
			writer.write("+");
			System.out.println();
			writer.write("\n");
			for(int j = 0; j < maze.length; j++) {
				if(maze[i][j].left == false) {
					System.out.print(" ");
					writer.write(" ");
				}
				else if(maze[i][j].left == true) {
					System.out.print("|");
					writer.write("|");
				}
				if(maze[i][j].disc!=0) {
					//places mod 10 value in cell
					System.out.print(maze[i][j].disc%10);
					writer.write(Integer.toString(maze[i][j].disc%10));
				}	
				else {
					System.out.print(" ");
					writer.write(" ");
				}
				
			}
			
			
			if(maze[i][maze[i].length - 1].right == true) {
				System.out.print("|");
				writer.write("|");
			}
			System.out.println();
			writer.write("\n");
		}
		for(int i = 0; i < maze[maze.length - 1].length; i++) {
			System.out.print("+");
			writer.write("+");
			if(maze[maze.length -1][i].bottom == true) {
				System.out.print("-");
				writer.write("-");
			}else {
				System.out.print(" ");
				writer.write(" ");
			}
		}
		System.out.print("+");
		writer.write("+");
	}
	
	////////////////////////////////////////////////////////////////////////

	//prints into console and writes into desired output file maze with 
	//shortest path represented using #
	
	public void printMazeShortest(BufferedWriter writer) throws IOException {
		for(int i = 0; i < maze.length;i++) {
			for(int j = 0; j < maze.length; j++) {
				System.out.print("+");
				writer.write("+");
				if(maze[i][j].top == true) {
					System.out.print("-");
					writer.write("-");
				}else {
					System.out.print(" ");
					writer.write(" ");
				}
			}

			System.out.print("+");
			writer.write("+");
			System.out.println();
			writer.write("\n");
			for(int j = 0; j < maze.length; j++) {
				if(maze[i][j].left == false) {
					System.out.print(" ");
					writer.write(" ");
				}
				else if(maze[i][j].left == true) {
					System.out.print("|");
					writer.write("|");
				}
				if(maze[i][j].shortest) {
					System.out.print("#");
					writer.write("#");
				} else {
					System.out.print(" ");
					writer.write(" ");
				}
			}
			
			
			if(maze[i][maze[i].length - 1].right == true) {
				System.out.print("|");
				writer.write("|");
			}
			System.out.println();
			writer.write("\n");
		}
		for(int i = 0; i < maze[maze.length - 1].length; i++) {
			System.out.print("+");
			writer.write("+");
			if(maze[maze.length -1][i].bottom == true) {
				System.out.print("-");
				writer.write("-");
			}else {
				System.out.print(" ");
				writer.write(" ");
			}
		}
		System.out.print("+");
		writer.write("+");
	}
	
	////////////////////////////////////////////////////////////////////////

	//finds all cells adjacent to a cell where the wall between them is down
	//used to traverse thru maze where there is no wall
	public List<Cell> findAdjacent(Cell c){
		List<Cell> neighbors=new ArrayList<>();
		if((c.x)>0 && maze[c.x-1 ][c.y].bottom==false) 
			neighbors.add(maze[c.x-1][c.y]);
		if((c.y)<r-1 && maze[c.x][c.y+1].left==false) 
			neighbors.add(maze[c.x][c.y+1]);
		if((c.x)<r-1 && maze[c.x+1][c.y].top==false) 
			neighbors.add(maze[current.x+1][c.y]);
		if((c.y)>0 && maze[c.x][c.y - 1].right==false )
			neighbors.add(maze[c.x][c.y-1]);
		return neighbors;
	}
		
	
	//////////////////////////////////////////////////////////////////////
	// DFS Traversal
	//takes in a BufferedReader so it can write solution into desired output 
	//file defined in tester
	
	public  void DFS(BufferedWriter writer) throws IOException {
	///reset time
		time=0;
		
		//reset properties of cell
			for(int i=0;i<maze.length;i++) {
				for(int j=0;j<maze[0].length;j++) {
					maze[i][j].color="white";
					maze[i][j].disc=0;
					maze[i][j].parent=null;
					maze[i][j].shortest=false;

				}
			}	
		//start from first cell 
		Cell c=maze[0][0];
		
		//stores cells to be visited
		Stack<Cell> dfsStack=new Stack<>();
		dfsStack.push(c);
		current=c;
		
		//while still more cells to visit in stack and current is not the last node
		while(dfsStack.size()>0 && !(current.equals(allCells.get(allCells.size()-1)))) {
			//pop from stack, give cell a discovery time number
			current=dfsStack.pop();
			current.color="black";
			time++;
			current.disc=time;
			
			//for every cell next to current that has no wall between
			//change color, add to stack and add parent
			for(Cell next: findAdjacent(current)) {
				if(next.color=="white") {
					next.color="grey";
					next.parent=current;
					dfsStack.add(next);
				}		
			}
		}
		
		//to find shortest path, start from last node and use parent to continue to
		//starting cell
		//back pointers
		
		Cell last=current;
		while(last!=allCells.get(0)) {
			last.shortest=true;
			last=last.parent;
		}
		last.shortest=true;
		
		//print to console and write to output file dfs's ordered maze and 
		//shortest path maze
		System.out.println("\n\n DFS:");
		writer.write("\n\n DFS:\n");
		printMazePath(writer);
		System.out.println("\n");
		writer.write("\n");
		writer.write("\n Shortest Path:\n");
		printMazeShortest(writer);
		
	}

	////////////////////////////////////////////////////////////////////
	//BFS traversal
	
	public  void BFS(BufferedWriter writer) throws IOException {
		
		///reset time
		time=0;
		
		//reset cell properties
		for(int i=0;i<maze.length;i++) {
			for(int j=0;j<maze[0].length;j++) {
				maze[i][j].color="white";
				maze[i][j].disc=0;
				maze[i][j].parent=null;
				maze[i][j].shortest=false;
			}
		}
		//starting cell
		Cell c=maze[0][0];
		
		//holds cells to be visited
		Queue<Cell> bfsQueue=new LinkedList<>();
		bfsQueue.add(c);
		current=c;
		
		//while still more cells to visit in queue and current is not the last node
		while(bfsQueue.size()>0 && !(current.equals(allCells.get(allCells.size()-1)))) {
			current=bfsQueue.remove();
			current.color="black";
			time++;
			current.disc=time;
			
			//for every cell next to current that has no wall between
			//change color, add to stack and add parent
			for(Cell next: findAdjacent(current)) {
				if(next.color=="white") {
					next.color="grey";
					next.parent=current;
					bfsQueue.add(next);
				}	
			}
		}
		//back pointers from last cell to first using parents to find shortest path
		Cell last=maze[r-1][r-1];
		while(!last.equals(allCells.get(0))) {
			last.shortest=true;
			last=last.parent;
		}
		last.shortest=true;
		
		//prints to console and writes into outfile bfs's ordered maze and
		//shortest path maze
		System.out.println("\n\n BFS:");
		writer.write("\n\n BFS:\n");
		printMazePath(writer);
		System.out.println("\n");
		writer.write("\n");
		writer.write("\n Shortest Path:\n");
		printMazeShortest(writer);
		
	}
	
	
	//////////////////////////////////////////////////////////////////
	//reads input file with maze
	//creates maze object that looks like it
	public void readMazeFile(String fileName) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(fileName));
		String testLine = br.readLine();
		testLine=br.readLine();
		String[] line;
		for(int i=0;i<maze.length;i++) {
			testLine=br.readLine();
			line=testLine.split("");
			for(int j=1;j<maze[0].length;j++) {
				if(line[j*2].equals(" ")){
					maze[i][j-1].right=false;
					maze[i][j].left=false;
				}
			}
			testLine=br.readLine();
			line=testLine.split("");
			for(int j=1;j<=maze[0].length;j++) {
				if(line[j*2-1].equals(" ")){
					maze[i][j-1].bottom=false;
					if(!(i==maze.length-1))
						maze[i+1][j-1].top=false;
					}
			}
			maze[r-1][r-1].bottom=false;
		}
	}
	
	
	/////////////////////////////////////////////////////////////////////////
	//END OF PROGRAM
		
		
		
}



