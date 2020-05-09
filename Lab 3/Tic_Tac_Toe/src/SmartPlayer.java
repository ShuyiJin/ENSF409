/*
 * A sub-class of Blocking player.
 * First to look at board, if it can find a move to win immediately, it makes that move.
 * Otherwise, it looks for a way to block its opponent from winning on the next move.
 * Otherwise, it picks a vacant square at random.
 */
public class SmartPlayer extends BlockingPlayer{

	public SmartPlayer(String name, char mark) {
		super(name, mark);
	}
	
	public SmartPlayer() {
		super();
	}
	
	public void statement() {
		System.out.println( "Smart player " + this.name + " playing:");
	}
	
	public void makeMove() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if((board.getMark(i, j) == SPACE_CHAR) && this.testForWinning(i, j)) {
					this.statement();
					board.addMark(i, j, mark);
					return;
				}
			}
		}
		 super.makeMove();
	}
	
	public boolean testForWinning(int row, int col) {
		if(testRow(row, this.mark)) return true;
		else if(testColumn(col, this.mark)) return true;
		else if(row == col || (row + col) == 2) {
			return testDiagonal(row, col, this.mark);
		}
		else
			return false;
	}
}
