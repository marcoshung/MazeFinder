package konduruHung.cs146.project3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;


class MazeTester {

	@Test
	void test() throws IOException {
		//1. Simple Cases
		//Testing if perfect maze generated with r=2,4,5,8
		
		//a. generate random maze when r=2
		Maze tester1a=new Maze(2);
		tester1a.generateMaze();
		System.out.println("\nRandom Perfect Maze size=2:");
		tester1a.printMaze();
		
		tester1a.BFS();
		tester1a.DFS();
		
		System.out.println("\n MAZE COMPLETED!");
		
		//b. generate random maze when r=4
		Maze tester1b=new Maze(4);
		tester1b.generateMaze();
		System.out.println("\nRandom Perfect Maze size=4:");
		tester1b.printMaze();
		
		tester1b.BFS();
		tester1b.DFS();
		
		System.out.println("\n MAZE COMPLETED!");
		
		//c. generate random maze when r=5
		Maze tester1c=new Maze(5);
		tester1c.generateMaze();
		System.out.println("\nRandom Perfect Maze size=5:");
		tester1c.printMaze();
		
		tester1c.BFS();
		tester1c.DFS();
		
		System.out.println("\n MAZE COMPLETED!");
		
		//d. generate random maze when r=8
		Maze tester1d=new Maze(8);
		tester1d.generateMaze();
		System.out.println("\nRandom Perfect Maze size=8:");
		tester1d.printMaze();
		
		tester1d.BFS();
		tester1d.DFS();
		
		System.out.println("\n MAZE COMPLETED!");
		
		
		//2. Reading from sample files and solving
		
		//2a. maze4.txt
		System.out.println("Input File: maze4.txt");
		BufferedReader testCase1=new BufferedReader(new FileReader("maze4.txt"));
		String testLine = testCase1.readLine();
		String[] dimensions=testLine.split("\\s+");
		int r=Integer.parseInt(dimensions[0]);
		Maze readTest1=new Maze(r);
		readTest1.readMazeFile("maze4.txt");
		System.out.println("Maze: ");
		readTest1.printMaze();
		
		//run and print dfs and bfs
		readTest1.DFS();
		readTest1.BFS();
		
		//2b. maze6.txt
		System.out.println("\nInput File: maze6.txt");
		BufferedReader testCase2=new BufferedReader(new FileReader("maze6.txt"));
		String testLine2 = testCase2.readLine();
		String[] dimensions2=testLine2.split("\\s+");
		int r2=Integer.parseInt(dimensions2[0]);
		Maze readTest2=new Maze(r2);
		readTest2.readMazeFile("maze6.txt");
		System.out.println("Maze: ");
		readTest2.printMaze();
		
		//run and print dfs and bfs
		readTest2.DFS();
		readTest2.BFS();
		
		
		//2c. maze8.txt
		System.out.println("\nInput File: maze8.txt");
		BufferedReader testCase3=new BufferedReader(new FileReader("maze8.txt"));
		String testLine3 = testCase3.readLine();
		String[] dimensions3=testLine3.split("\\s+");
		int r3=Integer.parseInt(dimensions3[0]);
		Maze readTest3=new Maze(r3);
		readTest3.readMazeFile("maze8.txt");
		System.out.println("Maze: ");
		readTest3.printMaze();
		
		//run and print dfs and bfs
		readTest3.DFS();
		readTest3.BFS();
		
		
		//2d. maze10.txt
		System.out.println("Input File: maze10.txt");
		BufferedReader testCase4=new BufferedReader(new FileReader("maze10.txt"));
		String testLine4 = testCase4.readLine();
		String[] dimensions4=testLine4.split("\\s+");
		int r4=Integer.parseInt(dimensions4[0]);
		Maze readTest4=new Maze(r4);
		readTest4.readMazeFile("maze10.txt");
		System.out.println("Maze: ");
		readTest4.printMaze();
		
		//run and print dfs and bfs
		readTest4.DFS();
		readTest4.BFS();
		
		//2e. maze20.txt
		System.out.println("Input File: maze20.txt");
		BufferedReader testCase5=new BufferedReader(new FileReader("maze20.txt"));
		String testLine5 = testCase5.readLine();
		String[] dimensions5=testLine5.split("\\s+");
		int r5=Integer.parseInt(dimensions5[0]);
		Maze readTest5=new Maze(r5);
		readTest5.readMazeFile("maze20.txt");
		System.out.println("Maze: ");
		readTest5.printMaze();
		
		//run and print dfs and bfs
		readTest5.DFS();
		readTest5.BFS();
		
		
	
		
	}
}