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
	
	public void makeMove() {
		System.out.println("Smart Player playing:");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if((board.getMark(i, j) == SPACE_CHAR) && this.testForWinning(i, j)) {
					board.addMark(i, j, mark);
					return;
				}
			}
		}
		 super.makeMove();
	}
	
	public boolean testForWinning(int row, int col) {
		if(testRow(row)) return true;
		else if(testColumn(col)) return true;
		else if(row == col || (row + col) == 2) {
			return testDiagonal(row, col);
		}
		else
			return false;
	}
	
	public boolean testColumn(int col) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if(board.getMark(i, col) == mark) {
				count++;
				if(count == 2) return true;
			}
		}
		return false;
	}
	
	public boolean testRow(int row) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if(board.getMark(row, i) == mark) {
				count++;
				if(count == 2) return true;
			}
		}
		return false;
	}
	
	public boolean testDiagonal(int row, int col) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if(row == col) {
				if(board.getMark(i, i) == mark) {
					count++;
					if(count == 2) return true;
				}
			}
			else {
				if(board.getMark(i, 2-i) == mark) {
					count++;
					if(count == 2) return true;
				}
			}
		}
		return false;
	}
}
