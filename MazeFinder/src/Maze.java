

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
	
	Cell[][] maze;
	int time;
	int r;
	int numCells;
	Stack<Cell> cellLocations;
	int visited;
	Cell current;
	List<Cell> allCells;
	
	public Maze(int r) {
		this.r=r;
		time=0;
		this.visited=1;
		allCells=new ArrayList<>();
		
		maze=new Cell[r][r];
		for(int i=0;i<r;i++) {
			for(int j=0;j<r;j++) {
				maze[i][j]=new Cell(i,j);
				allCells.add(maze[i][j]);
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
		rand.setSeed(20);
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
	
	
	/*public static void main(String[] args) {
		Maze tester=new Maze(4);
		tester.generateMaze();
		tester.printMaze();
		tester.DFS();
		tester.BFS();
		
	}
	*/
	
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
	
	//can also do mod
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
	// DFS Solution
	
	
	
	public  void DFS(BufferedWriter writer) throws IOException {
	///reset
		time=0;
			for(int i=0;i<maze.length;i++) {
				for(int j=0;j<maze[0].length;j++) {
					maze[i][j].color="white";
					maze[i][j].disc=0;
					maze[i][j].parent=null;
					maze[i][j].shortest=false;

				}
			}		
		Cell c=maze[0][0];
		Stack<Cell> dfsStack=new Stack<>();
		dfsStack.push(c);
		current=c;
		
		while(dfsStack.size()>0 && !(current.equals(allCells.get(allCells.size()-1)))) {
			current=dfsStack.pop();
			current.color="black";
			time++;
			current.disc=time;
			
			for(Cell next: findAdjacent(current)) {
				if(next.color=="white") {
					next.color="grey";
					next.parent=current;
					dfsStack.add(next);
				}		
			}
		}
		//backtrack 
		Cell last=current;
		while(last!=allCells.get(0)) {
			last.shortest=true;
			last=last.parent;
		}
		last.shortest=true;
		
		System.out.println("\n\n DFS:");
		writer.write("\n\n DFS:\n");
		printMazePath(writer);
		System.out.println("\n");
		writer.write("\n");
		writer.write("\n Shortest Path:\n");
		printMazeShortest(writer);
		
	}

	////////////////////////////////////////////////////////////////////
	//BFS Solution
	
	public  void BFS(BufferedWriter writer) throws IOException {
		
		///reset
		time=0;
		for(int i=0;i<maze.length;i++) {
			for(int j=0;j<maze[0].length;j++) {
				maze[i][j].color="white";
				maze[i][j].disc=0;
				maze[i][j].parent=null;
				maze[i][j].shortest=false;
			}
		}
		Cell c=maze[0][0];
		Queue<Cell> bfsQueue=new LinkedList<>();
		bfsQueue.add(c);
		current=c;
		
		while(bfsQueue.size()>0 && !(current.equals(allCells.get(allCells.size()-1)))) {
			current=bfsQueue.remove();
			current.color="black";
			time++;
			current.disc=time;

			for(Cell next: findAdjacent(current)) {
				if(next.color=="white") {
					next.color="grey";
					next.parent=current;
					bfsQueue.add(next);
				}	
			}
		}
		//backtrack 
		Cell last=maze[r-1][r-1];
		while(!last.equals(allCells.get(0))) {
			last.shortest=true;
			last=last.parent;
		}
		last.shortest=true;
		
		System.out.println("\n\n BFS:");
		writer.write("\n\n BFS:\n");
		printMazePath(writer);
		System.out.println("\n");
		writer.write("\n");
		writer.write("\n Shortest Path:\n");
		printMazeShortest(writer);
		
	}
	
	
	////////////////////////////////////////////////////////////////
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
	
	
	
		
		
		
}



