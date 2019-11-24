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
		/*BufferedReader testCase1=new BufferedReader(new FileReader("max4.txt"));
		
		String testLine = testCase1.readLine();
		String[] dimensions=testLine.split("\\s+");
		int r=Integer.parseInt(dimensions[0]);
		Maze tester5=new Maze(r);
		*/
		
		
		
		
		

	}

}
