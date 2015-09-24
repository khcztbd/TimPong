package Tpong;

/*
 * Pong Tutorial - Tim Brailsford, 2015
 * 
 * Main program class - instantiates the game window 
 * 
 */

public class Main {

	public static void main(String[] args) {
	       MainWindow gameWindow = new MainWindow();
	       gameWindow.setVisible(true);
	       gameWindow.start();
	}

}
