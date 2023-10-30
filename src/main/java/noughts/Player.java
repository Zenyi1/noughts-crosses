package noughts;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Player {
    private Game game;
    private Scanner input;

    public Player(Scanner scanner, Game game) {
        this.input = scanner;
        this.game = game; //initialize game object to us ethe isEmpty function below
    }

    public int validateChoice() {
        while (true) {
            System.out.println("Choose a square (1-9): ");
            try {
                int choice = input.nextInt();
                if(choice >= 1 && choice <=9){
                    if(game.isEmpty(choice)){
                        return choice;
                    } else {
                        System.out.println("The square you chose is not empty, please choose an empty square.");
                    }
                    
                } else {
                    System.out.println("You entered an invalid input. Please choose a number from 1 to 9.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 9.");
                input.next(); //Added this to fix infinite loop if user entered an invalid character
            }
        }
    }
}