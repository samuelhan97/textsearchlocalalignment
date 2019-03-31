/*
 * Class TableData
 * 
 * Represents the data values for each element of the dynamic programming table. Score is the value of the element and source is a pointer to
 * 		the previous element the score was derived from. Null sources are valid.
 */
public class TableData {
	
	private int score;
	private TableData source;
	private int xcoord;
	private int ycoord;
	
	public TableData () {
		setScore(-1);
		setSource(null);
		xcoord = 0;
		ycoord = 0;
	}
	
	public TableData(int x, int y) {
		setScore(-1);
		setSource(null);
		xcoord = x;
		ycoord = y;
	}
	
	public TableData (int score, int x, int y) {
		setScore(score);
		setSource(null);
		xcoord = x;
		ycoord = y;
	}
	
	public TableData (int score, TableData source) {
		setScore(score);
		setSource(source);
		xcoord = 0;
		ycoord = 0;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setSource(TableData source) {
		this.source = source;
	}
	
	public TableData getSource() {
		return source;
	}
	
	public void follow(TableData source) {
		if (this.source == null) {
			return;
		}
		else {
			System.out.println("row:" + xcoord + " | col:" + ycoord + " | " + score);
			follow(this.source);
		}
	}
	
	public void printout() {
		if (score >= 0)
			System.out.print(score);
		else 
			System.out.print("X");
	}
}
