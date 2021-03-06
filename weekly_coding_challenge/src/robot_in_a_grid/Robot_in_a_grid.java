package robot_in_a_grid;

import java.util.Random;
import java.util.Scanner;

public class Robot_in_a_grid {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("What is the number of rows in the grid.\n>");
		int rows = scan.nextInt();
		//rows = 100;
		
		System.out.print("What is the number of columns in the grid.\n>");
		int colmns = scan.nextInt();
		//colmns = 100;
		
		int[][] grid = new int[rows][colmns];  // create Grid
		
		for(int i = 0; i < rows; i++) { //  Add obstablce to Grid
			Random rand = new Random();
			int random = rand.nextInt(colmns-1) +1;
			grid[i][random] = 1;
		}
		
//		for(int i = 0; i < rows; i++) {       // Print out Grid so we can see it
//			for(int j = 0; j < colmns; j++) {
//				System.out.print(grid[i][j]);
//			}
//			System.out.print("\n");
//		}
		/*
		 *  Note: the lower number of grids and columns you go the greater
		 *  chance that the Robot will fail.
		 */
		robot_path(0, 0, grid);

	}
	
	public static void robot_path(int robotRow, int robotColmn, int[][] grid) {
		int timer = 0;
		int time = grid.length* 2;
		while(robotRow < grid.length-1 || robotColmn < grid[0].length-1) {
			if(timer == time) {break;}
			if(robotColmn < grid[0].length-1 && grid[robotRow][robotColmn + 1] == 0) {
				robotColmn++;
			}
			if(robotRow < grid.length-1 && grid[robotRow +1][robotColmn] == 0) {
				robotRow++;
			}
			timer++;
		}
		//   The Robots ending location, uncomment to see
		//System.out.print("Robot Location "+ robotRow + " "+ robotColmn+"\n");
		if(robotRow == grid.length-1 && robotColmn == grid[0].length-1) {
			System.out.print("Robot has reached Distination");
		}else {
			System.out.print("The Robot has Failed!");
		}
	}
	
}
