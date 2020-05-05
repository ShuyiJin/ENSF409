

/**
 * The class Referee creates the referee of the game
 * 
 * @author Shuyi Jin
 * @version 1.0
 * @since February 1, 2018
 */
public class Referee {
	/**
	 * The player marks x on the board
	 */
	private Player xPlayer;
	
	/**
	 * The player marks o on the board
	 */
	private Player oPlayer;
	
	/**
	 * The board of the game
	 */	
	private Board board;
	
	/**
	 * The constructor to define board, xPlayer and oPlayer
	 */
	public Referee() {
		board = new Board();
		xPlayer = new Player();
		oPlayer = new Player();		
	}
	
	/**
	 * The referee starts the game by setting opponents and ask one player to play
	 */
	public void runTheGame() {
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		board.display();
		xPlayer.play();
	}
	
	/**
	 * Set the board
	 * @param board the value of board to be set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * Set he oPlayer
	 * @param oPlayer the value of oPlayer to be set
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}
	
	/**
	 * Set the xPlayer
	 * @param xPlayer the value of xPlayer to be set
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}
}
