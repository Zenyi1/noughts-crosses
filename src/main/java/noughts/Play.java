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
            
            boolean playAgain = true;
            Scanner playAgainInput = new Scanner(System.in);

            //loop to allow the player to play again
            do {
                // constructor
                System.out.println("Welcome to noughts and crosses"); 
                game = new Game();  // create game board
                input = new Scanner(System.in);  // Scanner for user input
                bot = new Computer(game); // Intialize the computer object
                player = new Player(input, game); //Initialize player with the scanner object so it can validate it
                
                boolean gameOver = false; //helps track if the game is over

                while (!gameOver) {
                    game.printBoard(); // print board
                    playerTurn();
                    game.printBoard();

                    if (game.checkWin()) {
                        System.out.println("Congrats you defeated the evil bots.");
                        gameOver = true;
                    } else if (game.checkTie()) {
                        System.out.println("You tied , maybe the machines can't be defeated.");
                        gameOver = true;
                    } else {
                        computerTurn();
                        //printing the board again so you see how you were defeated
                        game.printBoard();
                        if (game.checkWin()) {
                            System.out.println("The machines have defeated you.");
                            gameOver = true;
                        } else if (game.checkTie()) {
                            System.out.println("You tied , maybe the machines can't be defeated.");
                            gameOver = true;
                        }
                    }
                }

                // Ask if the player wants to play again and handle different inputs
                boolean validResponse = false;
                do {
                    System.out.print("Do you want to try again? (yes/no): ");
                    String playAgainResponse = playAgainInput.next().toLowerCase();
                    if (playAgainResponse.equals("yes")) {
                        playAgain = true;
                        validResponse = true;
                    } else if (playAgainResponse.equals("no")) {
                        playAgain = false;
                        validResponse = true;
                    } else {
                        System.out.println("Please enter 'yes' or 'no'.");
                    }
                } while (!validResponse);
            } while (playAgain);

            System.out.println("Thanks for playing!");
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