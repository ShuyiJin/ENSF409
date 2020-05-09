import java.util.Scanner;

/* A sub-class of Player.
 * The move is controlled by the user.
 *
 */

public class HumanPlayer extends Player{

	public HumanPlayer() {
		super();
	}
	
	public HumanPlayer(String name, char mark) {
		super(name, mark);
	}
	
	public void makeMove() {
		int row, col;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.printf("%s, what row should your next %c be placed in?", name, mark);
			row = Integer.parseInt(scan.nextLine());
			System.out.printf("%s, what column should your next %c be placed in?", name, mark);
			col = Integer.parseInt(scan.nextLine());
		}
		while(board.getMark(row, col) != SPACE_CHAR);
		board.addMark(row, col, mark);
	}
}
