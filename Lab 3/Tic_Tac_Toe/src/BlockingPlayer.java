/*
 * A sub-class of random player.
 * It first looks at the board for a move that would block its opponent by winning on the next move.
 * If it can't find any such move, it picks a vacant spot randomly.
 */
public class BlockingPlayer extends RandomPlayer{

	public BlockingPlayer() {
		super();
	}
	
	public BlockingPlayer(String name, char mark) {
		super(name, mark);
	}
	
	public void statement() {
		System.out.println("Blocking Player " + this.name + " playing:");
	}
	
	public void makeMove() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if((board.getMark(i, j) == SPACE_CHAR) && this.testForBlocking(i, j)) {
					this.statement();
					board.addMark(i, j, mark);
					return;
				}
			}
		}
		 super.makeMove();
	}
	
	public boolean testForBlocking(int row, int col) {
		if(testRow(row, this.opponent.getMark())) return true;
		else if(testColumn(col, this.opponent.getMark())) return true;
		else if(row == col || (row + col) == 2) {
			return testDiagonal(row, col, this.opponent.getMark());
		}
		else
			return false;
	}
	
	public boolean testColumn(int col, char mark) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if(board.getMark(i, col) == mark) {
				count++;
				if(count == 2) return true;
			}
		}
		return false;
	}
	
	public boolean testRow(int row, char mark) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if(board.getMark(row, i) == mark) {
				count++;
				if(count == 2) return true;
			}
		}
		return false;
	}
	
	public boolean testDiagonal(int row, int col, char mark) {
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
