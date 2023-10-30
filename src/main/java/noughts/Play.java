/*
 * Play.java
 *
 * Play a game of noughts and crosses
 * includes main method
 */
 
 package noughts;

import java.util.Scanner;

class Play{
    Game game;   // the noughts and crosses game
    Computer bot; //The computer player, this ensures the same computer object is used throughout the game
    Scanner input;
    Player player; //The human player
        public static void main(String[] args) {
            // main method - just create a Play object
            new Play();
        }

        public Play () {
            // constructor
            System.out.println("Welcome to noughts and crosses"); 
            game = new Game();  // create game board
            input = new Scanner(System.in);  // Scanner for user input
            bot = new Computer(game); // Intialize the computer object
            player = new Player(input, game); //Initialize player with the scanner object so it can validate it
            while (true) { // infinite loop
                game.printBoard(); // print board
                playerTurn(); // human turn
                game.printBoard();
                computerTurn(); // computer turn
        }
    }
    public void playerTurn()  {
        
        int square = player.validateChoice();
        game.setHuman(square);
    }

    public void computerTurn() {
        // computer turn - currently does nothing other than print out a message
        System.out.println("Computer is thinking");
        bot.move(); //runs the move function from teh computer class
    }
}