//HEADER
//tests simples cases of maze and dfs and bfs 
//tests given input files

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;




class MazeTester {

	@Test
	void test() throws IOException {
		
		//1. Simple Cases
		
		//Testing if perfect maze generated with r=2,4,5,8
		//Input: r(dimension)
		//Output: into output file, a. perfect random maze, b. dfs's ordered maze and shortest path
		//c. bfs's ordered maze and shortest path
		
		//a. generate random maze when r=2
		
		//create new maze object
		Maze tester1a=new Maze(2);
		
		//generate maze
		tester1a.generateMaze();
		
		//initialize write, write into output file
		BufferedWriter writer2 = new BufferedWriter(new FileWriter("simpleCase2Output.txt"));
		System.out.println("\nRandom Perfect Maze size=2:");
		writer2.write("\nRandom Perfect Maze size=2:\n");
		tester1a.printMaze(writer2);
		
		tester1a.BFS(writer2);
		tester1a.DFS(writer2);
		
		System.out.println("\n MAZE COMPLETED!");
		writer2.write("\n MAZE COMPLETED!\n");
		writer2.close();
		
		
		//b. generate random maze when r=4
		Maze tester1b=new Maze(4);
		tester1b.generateMaze();
		BufferedWriter writer4 = new BufferedWriter(new FileWriter("simpleCase4Output.txt"));
		System.out.println("\nRandom Perfect Maze size=4:");
		writer4.write("\nRandom Perfect Maze size=4:\n");
		tester1b.printMaze(writer4);
		
		tester1b.BFS(writer4);
		tester1b.DFS(writer4);
		
		System.out.println("\n MAZE COMPLETED!");
		writer4.write("\n MAZE COMPLETED!\n");
		writer4.close();
		
		//c. generate random maze when r=5
		Maze tester1c=new Maze(5);
		tester1c.generateMaze();
		BufferedWriter writer5 = new BufferedWriter(new FileWriter("simpleCase5Output.txt"));
		System.out.println("\nRandom Perfect Maze size=5:");
		writer5.write("\nRandom Perfect Maze size=5:\n");
		tester1c.printMaze(writer5);
		
		tester1c.BFS(writer5);
		tester1c.DFS(writer5);
		
		System.out.println("\n MAZE COMPLETED!");
		writer5.write("\n MAZE COMPLETED!\n");
		writer5.close();
		
		//d. generate random maze when r=8
		Maze tester1d=new Maze(8);
		tester1d.generateMaze();
		System.out.println("\nRandom Perfect Maze size=8:");
		BufferedWriter writer8 = new BufferedWriter(new FileWriter("simpleCase8Output.txt"));
		writer8.write("\nRandom Perfect Maze size=8:\n");
		tester1d.printMaze(writer8);
		
		tester1d.BFS(writer8);
		tester1d.DFS(writer8);
		
		System.out.println("\n MAZE COMPLETED!");
		writer8.write("\n MAZE COMPLETED!\n");
		writer8.close();
		
		 /////////////////////////////////////////////////////////////////////////////
		
		//2. Reading from sample files and solving
		
		//2a. Input: maze4.txt
		//	  Output: maze4Output.txt
		
		//readers from input file
		BufferedReader testCase1=new BufferedReader(new FileReader("maze4.txt"));
		String testLine = testCase1.readLine();
		String[] dimensions=testLine.split("\\s+");
		
		//first line of input file has dimension
		int r=Integer.parseInt(dimensions[0]);
		
		//creates maze
		Maze readTest1=new Maze(r);
		
		//intializes writer for output file
		BufferedWriter writerMaze4 = new BufferedWriter(new FileWriter("maze4Output.txt"));
		writerMaze4.write("\n Input: maze4.txt \n");
		readTest1.readMazeFile("maze4.txt");
		writerMaze4.write("Maze: \n");
		readTest1.printMaze(writerMaze4);
		
		//run and print dfs and bfs
		readTest1.DFS(writerMaze4);
		readTest1.BFS(writerMaze4);
		
		System.out.println("\n MAZE COMPLETED!");
		writerMaze4.write("\n MAZE COMPLETED!\n");
		writerMaze4.close();
		
		//2b. Input: maze6.txt
		//	  Output: maze6Output.txt
		
		BufferedReader testCase2=new BufferedReader(new FileReader("maze6.txt"));
		String testLine2 = testCase2.readLine();
		String[] dimensions2=testLine2.split("\\s+");
		int r2=Integer.parseInt(dimensions2[0]);
		Maze readTest2=new Maze(r2);
		BufferedWriter writerMaze6 = new BufferedWriter(new FileWriter("maze6Output.txt"));
		writerMaze6.write("\n Input: maze6.txt \n");
		readTest2.readMazeFile("maze6.txt");
		writerMaze6.write("Maze: \n");
		readTest2.printMaze(writerMaze6);
		
		//run and print dfs and bfs
		readTest2.DFS(writerMaze6);
		readTest2.BFS(writerMaze6);
		
		System.out.println("\n MAZE COMPLETED!");
		writerMaze6.write("\n MAZE COMPLETED!\n");
		writerMaze6.close();
		
		
		//2c. Input: maze8.txt
		//	  Output: maze8Output.txt
		
		BufferedReader testCase3=new BufferedReader(new FileReader("maze8.txt"));
		String testLine3 = testCase3.readLine();
		String[] dimensions3=testLine3.split("\\s+");
		int r3=Integer.parseInt(dimensions3[0]);
		Maze readTest3=new Maze(r3);
		BufferedWriter writerMaze8 = new BufferedWriter(new FileWriter("maze8Output.txt"));
		writerMaze8.write("\n Input: maze8.txt \n");
		readTest3.readMazeFile("maze8.txt");
		writerMaze8.write("Maze: \n");
		readTest3.printMaze(writerMaze8);
		
		//run and print dfs and bfs
		readTest3.DFS(writerMaze8);
		readTest3.BFS(writerMaze8);
		
		System.out.println("\n MAZE COMPLETED!");
		writerMaze8.write("\n MAZE COMPLETED!\n");
		writerMaze8.close();
		
		
		//2a. Input: maze10.txt
		//	  Output: maze10Output.txt
		
		BufferedReader testCase4=new BufferedReader(new FileReader("maze10.txt"));
		String testLine4 = testCase4.readLine();
		String[] dimensions4=testLine4.split("\\s+");
		int r4=Integer.parseInt(dimensions4[0]);
		Maze readTest4=new Maze(r4);
		BufferedWriter writerMaze10 = new BufferedWriter(new FileWriter("maze10Output.txt"));
		writerMaze10.write("\n Input: maze10.txt \n");
		readTest4.readMazeFile("maze10.txt");
		writerMaze10.write("Maze: \n");
		readTest4.printMaze(writerMaze10);
		
		//run and print dfs and bfs
		readTest4.DFS(writerMaze10);
		readTest4.BFS(writerMaze10);
		
		System.out.println("\n MAZE COMPLETED!");
		writerMaze10.write("\n MAZE COMPLETED!\n");
		writerMaze10.close();
		
		//2a. Input: maze20.txt
		//	  Output: maze20Output.txt
		BufferedReader testCase5=new BufferedReader(new FileReader("maze20.txt"));
		String testLine5 = testCase5.readLine();
		String[] dimensions5=testLine5.split("\\s+");
		int r5=Integer.parseInt(dimensions5[0]);
		Maze readTest5=new Maze(r5);
		BufferedWriter writerMaze20 = new BufferedWriter(new FileWriter("maze20Output.txt"));
		writerMaze20.write("\n Input: maze20.txt \n");
		readTest5.readMazeFile("maze20.txt");
		writerMaze20.write("Maze: \n");
		readTest5.printMaze(writerMaze20);
		
		//run and print dfs and bfs
		readTest5.DFS(writerMaze20);
		readTest5.BFS(writerMaze20);
		
		System.out.println("\n MAZE COMPLETED!");
		writerMaze20.write("\n MAZE COMPLETED!\n");
		writerMaze20.close();

	
	}

}
