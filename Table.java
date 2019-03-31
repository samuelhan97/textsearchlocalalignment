/*
 * Class Table
 * 
 * Represents the actual table where dynamic programming is plotted and can be used to keep track of scoring as well.
 * Data structure element.
 */
public class Table {
	
	private int rows;
	private int cols;
	
	private TableData[][] table;
	
	//Constructor
	public Table(int row, int col) {
		this.rows = row + 1;
		this.cols = col + 1;
		
		table = new TableData[rows][cols];
		
		//initiate all elements in table
		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < cols - 1; j++) {
				table[i][j] = new TableData(i,j);
			}//for j
		}//for i
		
		//sets all - rows/cols to 0 in Dynamic table
		for (int i = 0; i < rows - 1; i++) {
			table[i][0].setScore(0);
		}//for
		for (int i = 0; i < cols - 1; i++) {
			table[0][i].setScore(0);
		}//for
	}//Constructor


	
	//Get an Element at coords
	public TableData getAt(int row, int col) {
		return table[row][col];
	}
	
	public int getScoreAt(int row, int col) {
		return table[row][col].getScore();
	}
	
	//Set an element at coords
	public void setAt(int row,int col, TableData object) {
		table[row][col] = object;
	}
	
	/*
	 * 	printTable
	 * 	
	 * 	prints all scores of data members in a visual table fashion
	 */
	public void printTable() {
		for (int i = 0; i < rows-1; i++) {
			for (int j = 0; j < cols-1; j++) {
				table[i][j].printout();
				System.out.print(" ");
			}//for j
			System.out.println("");
		}//for i
	}//printTable
	
	/*
	 * 	printDynamicTable
	 * 
	 * 	prints all scores of data members in a visual table fashion.
	 * 	Also includes directional arrows that indicate the dynamic path
	 */
	public void printDynamicTable() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				table[i][j].printout();
				System.out.println(" ");
			}//for j
			System.out.println("\n");
		}//for i
	}//printDyanmicTable
}//Table
