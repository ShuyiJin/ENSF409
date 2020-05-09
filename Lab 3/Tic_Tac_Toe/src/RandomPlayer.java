/*
 * A sub-class of Player. 
 * This is a computer player that uses a random generator and 
 * picks a vacant spot on the board randomly.
 */
public class RandomPlayer extends Player {

	public RandomPlayer(String name, char mark) {
		super(name, mark);
	}
	
	public RandomPlayer() {
		super();
	}
	
	public void statement() {
		System.out.println("Random player " + this.name + " playing:");
	}

	public void makeMove() {
		RandomGenerator ran = new RandomGenerator(); 
		int row, col;
		do{
			row = ran.discrete(0, 2);
			col = ran.discrete(0, 2);
		}while(board.getMark(row, col) != SPACE_CHAR); 
		this.statement();
		board.addMark(row, col, mark);
	}
}
