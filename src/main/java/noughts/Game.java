/*
 * Game.java
 *
 * Represents a game of noughts and crosses
 */

package noughts;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ereiter
 */
public class Game {
    
    BoxStatus[] board = new BoxStatus[9];  // board contains 9 boxes
    
    /** Creates a new instance of game */
    public Game() {
        for(int i = 0; i<9; i++)
            board[i] = BoxStatus.Empty;  // initially each box is empty (not taken)
        
    }
    
    public boolean isEmpty(int n) {
        // is a box empty?
        return (board[n-1] == BoxStatus.Empty);
    }
    
    public boolean isComputer(int n) {
        // is a box taken by the Computer?
        return (board[n-1] == BoxStatus.Computer);
    }
    
    public boolean isHuman(int n) {
        // is a box taken by the Human?
        return (board[n-1] == BoxStatus.Human);
    }
    
    public void setHuman(int n) {
        // human claims square N
        board[n-1] = BoxStatus.Human;
    }
    
    public void setComputer(int n) {
        // computer claims square N
        board[n-1] = BoxStatus.Computer;
    }
    
    public BoxStatus getBox(int n) {
        // return square N
        return board[n-1];
    }

    public char boxChar(int n) {
        // return a character which shows whether a square is empty, taken by the computer, or taken by the human
        switch (board[n-1]) {
            case Human: return 'H';
            case Computer: return 'C';
            case Empty: return '.';
        }
        return ' ';
    }

    public void printBoard() {
        // print the noard on System.out
        System.out.println("Board");
        System.out.printf("| %c %c %c |\n", boxChar(1), boxChar(2), boxChar(3));
        System.out.printf("| %c %c %c |\n", boxChar(4), boxChar(5), boxChar(6));
        System.out.printf("| %c %c %c |\n", boxChar(7), boxChar(8), boxChar(9));
    }
    
    //Chheck all the options for a win
    public boolean checkWin() {
        return checkRows() || checkColumns() || checkDiagonal();
    }

    //checks each row using a for loop and checks the next 2 squares for a win
    public boolean checkRows() {
        for (int i = 0; i < 9; i+=3) {
            if (board[i] != BoxStatus.Empty && board[i] == board[i+1] && board[i] == board[i+2]) {
                return true;
                
            }
        }
        return false;
    }

    //Checks for diagonals wins, not loop since there are only 2 specific cases
    public boolean checkDiagonal() {
        if (board[0] != BoxStatus.Empty && board[0] == board[4] && board[0] == board[8]) {
            return true;
            
        }
        if (board[2] != BoxStatus.Empty && board[2] == board[4] && board[2] == board[6]) {
            return true;
            
        }
        return false;
    }

    //check each column using a loop and the squres below 
    public boolean checkColumns() {
        for (int i = 0; i<3; i++){
            if (board[i] != BoxStatus.Empty && board[i] == board [i+3] && board[i] == board[i+6]) {
                return true;
                
            }
        }
        return false;

    }

    //Very simple, loops through all the squares and if there are no empty ones calls tie
    public boolean checkTie() {
        for (int i = 0; i<9; i++) {
            if (board[i] == BoxStatus.Empty) {
                return false;
            }
        }
        return true;
    }
}
