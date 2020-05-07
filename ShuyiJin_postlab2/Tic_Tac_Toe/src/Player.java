
import java.util.Scanner;
/**
 * The class Player creates the players of the game
 * 
 * @author Shuyi Jin
 * @version 1.0
 * @since February 1, 2018
 */
public class Player implements Constants{
	/**
	 * The name of the player
	 */
	private String name;
	
	/**
	 * The board of the game
	 */
	private Board board;
	
	/**
	 * The opponent player
	 */
	private Player opponent;
	
	/**
	 * The mark this player uses
	 */
	private char mark;
	
	
	/**
	 * Default constructor
	 */
	public Player() {
		this.name = " ";
		this.mark = SPACE_CHAR;
	}
	
	/**
	 * Constructor. Define and initialize the name and the mark of the player
	 * @param name the name of the player
	 * @param mark the mark the player uses
	 */
	public Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}
	
	/**
	 * The player's turn to play the game. End the game if anyone wins or there is a tie.
	 */
	public void play() {
		if(board.xWins()) {
			System.out.println("THE GAME IS OVER!" + opponent.name + " is the winner!");
			System.exit(0);
		}
		else if(board.oWins()) {
			System.out.println("THE GAME IS OVER!" + opponent.name + " is the winner!");
			System.exit(0);
		}
		else if(board.isFull()) {
			System.out.println("It's a tie! Game ends.");
			System.exit(0);
		} 
		else {
			this.makeMove();
			board.display();
			opponent.play();
		}
	}
	
	/**
	 * The player is asked for a position to put the mark
	 */
	public void makeMove() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter row");
		int row = Integer.parseInt(scan.nextLine());
		System.out.println("Please enter column");
		int col = Integer.parseInt(scan.nextLine());
		while(board.getMark(row, col) != SPACE_CHAR) {
			System.out.println("Space is already filled! Please try again.");
			System.out.println("Please enter row");
			row = Integer.parseInt(scan.nextLine());
			System.out.println("Please enter column");
			col = Integer.parseInt(scan.nextLine());
		}
		board.addMark(row, col, mark);
	}
	
	/**
	 * Set the opponent of the player
	 * @param a the value of opponent to be set
	 */
	public void setOpponent(Player a) {
		this.opponent = a;
	}
	
	
	/**
	 * Set the board of the game
	 * @param theBoard the value of board to be set
	 */
	public void setBoard(Board theBoard) {
		this.board = theBoard;
	}
}
