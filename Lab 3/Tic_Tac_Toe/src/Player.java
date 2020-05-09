
/**
 * The class Player creates the players of the game
 * 
 * @author Shuyi Jin
 * @version 1.0
 * @since February 1, 2018
 */
abstract class Player implements Constants{
	/**
	 * The name of the player
	 */
	protected String name;
	
	/**
	 * The board of the game
	 */
	protected Board board;
	
	/**
	 * The opponent player
	 */
	protected Player opponent;
	
	/**
	 * The mark this player uses
	 */
	protected char mark;
	
	/**
	 * The player is asked for a position to put the mark
	 */
	abstract protected void makeMove();
	
	/**
	 * Default constructor
	 */
	protected Player() {
		this.name = " ";
		this.mark = SPACE_CHAR;
	}
	
	/**
	 * Constructor. Define and initialize the name and the mark of the player
	 * @param name the name of the player
	 * @param mark the mark the player uses
	 */
	protected Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}
	
	/**
	 * The player's turn to play the game. End the game if anyone wins or there is a tie.
	 */
	public void play() {
		if(board.xWins() || board.oWins()) {
			System.out.println("THE GAME IS OVER! " + opponent.name + " is the winner!");
			System.exit(0);
		}
		if(board.isFull()) {
			System.out.println("It's a tie! Game ends.");
			System.exit(0);
		} 
		this.makeMove();
		board.display();
		opponent.play();
	}
	
	public char getMark() {
		return this.mark;
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
