
import java.io.*;
/**
 * The class Game creates the game and contains the main
 * 
 * @author Shuyi Jin
 * @version 1.0
 * @since February 1, 2018
 */
public class Game implements Constants {
	/**
	 * The board of the game
	 */
	private Board theBoard;
	
	/**
	 * The referee of the game
	 */
	private Referee theRef;
	
	/**
	 * The constructor which defines the board of the game.
	 */
    public Game( ) {
        theBoard  = new Board();
	}
    
    /**
	 * Initialize the referee
	 * @param r defines the Referee object
	 * @throws java.io.IOException Exception from I/O
	 */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }
	
    /**
	 * The main method
	 * @param args command line arguments
	 * @throws java.io.IOException exception from I/O
	 */
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);
		
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef);
	}
	

}
