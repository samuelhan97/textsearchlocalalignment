import java.io.File;
import java.util.Scanner;

public class Driver {

	private static Table DynamicTable;
	private static Table ScoreTable;
	private static String query;
	private static String sourceText = "";
	private static int topHits;
	

	
	public static void main(String[] args) {
		
		int textSize;
		int querySize;
		
		//Open text file
		try {
			Scanner inputfile = new Scanner(new File("src/inputText.txt"));
			while (inputfile.hasNext()) {
				sourceText = sourceText + inputfile.nextLine();
			}
			}
			catch (Exception e) {
				System.out.println("Error opening File");
				System.exit(1);
			}
			textSize = sourceText.length();
		
			Scanner keyboard = new Scanner(System.in);
			//Prompt user for inputs (query and k)
			System.out.print("Enter a query text for the text: ");
			query = keyboard.nextLine();
			System.out.print("Enter a number for the top highest alignments: ");
			topHits = keyboard.nextInt();
			querySize = query.length();
			
			DynamicTable = new Table(textSize,querySize);
			DynamicTable.printTable();
			
			
			
		
	}//main

	/*
	 * 	calcScore
	 * 
	 * 	Method used for calculating the score given 2 characters.
	 */
	public int calcScore(char x, char y) {
		int score = 0;
		if (x == y) {
			score = 20;
		}
		else if ((x == '-' && y != '-') || (x != '-' && y == '-')) {
			score = -30;
		}
		else if (x != y) {
			score = -50;
		}
		else
			System.out.println("Error with score");
		return score;
	}//calcScore

	/*
	 * 	printOutput
	 * 
	 * 	method to print out results of program exactly as stated
	 * 
	 */
	public void printOutput(int[] scores, int[] index,String matched) {
		for (int i = 0; i < topHits; i++) {
			System.out.print("hit " + i +": score = " + scores[i] + "\n");
			System.out.print("\t[" + index[1] + "]");
			System.out.print(matched);
			System.out.print("[" + index[2]+ "]\n");
			//insert vericle line part
			System.out.print("\t" + query);
		}//for i
	}//printOutput
}//Driver
