package noughts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class PlayTest 
{

    @Test
    public void testCheckWin() {
        Game game = new Game();
        // Test checking for a win condition
        game.setHuman(1);
        game.setHuman(2);
        game.setHuman(3);
        assertTrue(game.checkWin()); // Should be a win for the human player

        // Test checking for a win condition in a different scenario
        game = new Game(); // Reset the game
        game.setHuman(1);
        game.setHuman(4);
        game.setHuman(7);
        assertTrue(game.checkWin()); // Should be a win for the human player

        game = new Game(); // Reset the game
        game.setComputer(3);
        game.setComputer(5);
        game.setComputer(7);
        assertTrue(game.checkWin()); // Should be a win for the computer player

        // Test checking for a win condition when there's no win yet
        game = new Game(); // Reset the game
        game.setHuman(1);
        game.setComputer(5);
        game.setHuman(9);
        assertFalse(game.checkWin()); // No win yet
    }

    @Test
    public void testCheckTie() {
        Game game = new Game();
        // Test checking for a tie when the board is full but no one has won
        game.setHuman(1);
        game.setComputer(2);
        game.setHuman(3);
        game.setHuman(4);
        game.setComputer(5);
        game.setHuman(6);
        game.setComputer(7);
        game.setHuman(8);
        game.setComputer(9);
        assertTrue(game.checkTie()); // Should be a tie game

        // Test checking for a tie when the board is not full
        game = new Game(); // Reset the game
        game.setHuman(1);
        game.setComputer(2);
        assertFalse(game.checkTie()); // Not a tie yet
    }

    //checking if my row startegy works
    @Test
    public void testCheckComputerWinRows(){
        Game game = new Game();
        Computer computer = new Computer(game);
        //checking for a wining move on the first square of a row
        game.setComputer(5);
        game.setComputer(6);

        //let the computer move
        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(4)); // check if the correct square was picked

        //Checking for winning move in middle square of a row
        game = new Game(); // resetting the game
        computer = new Computer(game);
        game.setComputer(1);
        game.setComputer(3);

        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(2));

        //Checking for winning move in the last square of a row
        game = new Game();
        computer = new Computer(game);
        game.setComputer(7);
        game.setComputer(8);

        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(9));
    }

    //checking if myy diagonal strategy works
    @Test
    public void testCheckComputerWinDiagonal(){
        Game game = new Game();
        Computer computer = new Computer(game);

        //Checking diagonal 1,5,9
        game.setComputer(5);
        game.setComputer(9);

        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(1));

        //checking diagonal 3,5,7
        game = new Game();
        computer = new Computer(game);

        game.setComputer(3);
        game.setComputer(5);

        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(7));
    }

    //checking the center strategy
    @Test
    public void testCenterStrategy(){
        Game game = new Game();
        Computer computer = new Computer(game);

        
        game.setComputer(4);
        game.setComputer(9);
        game.setHuman(1);
        game.setHuman(8);

        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(5));

        //check that it won't prioritize center over winning
        game = new Game();
        computer = new Computer(game);

        game.setComputer(3);
        game.setComputer(1);

        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(2));

    }

    //checking if my column strategy works
    @Test
    public void testCheckComputerWinColumn() {
        Game game = new Game();
        Computer computer = new Computer(game);
        //checking for a wining move on the first square of a column
        game.setComputer(4);
        game.setComputer(7);

        //let the computer move
        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(1)); // check if the correct square was picked

        //Checking for winning move in middle square of a column
        game = new Game(); // resetting the game
        computer = new Computer(game);
        game.setComputer(2);
        game.setComputer(8);

        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(5));

        //Checking for winning move in the last square of a column
        game = new Game();
        computer = new Computer(game);
        game.setComputer(3);
        game.setComputer(6);

        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(9));
    }

     //checking if my column blocking startegy works
    @Test
    public void testCheckComputerBlockHumanRows(){
        Game game = new Game();
        Computer computer = new Computer(game);
        //stopping a winning move in the first quare of a row
        game.setHuman(5);
        game.setHuman(6);

        //let the computer move
        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(4)); // check if the correct square was picked

        //Stopping a winning move in middle square of a row
        game = new Game(); // resetting the game
        computer = new Computer(game);
        game.setHuman(1);
        game.setHuman(3);

        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(2));

        //Stopping a winning move in the last square of a row
        game = new Game();
        computer = new Computer(game);
        game.setHuman(7);
        game.setHuman(8);

        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(9));
    }

    //Test to check that the computer blocks human winning columns
    @Test
    public void testCheckComputerBlockHumanColumn() {
        Game game = new Game();
        Computer computer = new Computer(game);
        //Stoping a wining move on the first square of a column
        game.setHuman(4);
        game.setHuman(7);

        //let the computer move
        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(1)); // check if the correct square was picked

        //Stopping a winning move in middle square of a column
        game = new Game(); // resetting the game
        computer = new Computer(game);
        game.setHuman(2);
        game.setHuman(8);

        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(5));

        //Stopping a winning move in the last square of a column
        game = new Game();
        computer = new Computer(game);
        game.setHuman(3);
        game.setHuman(6);

        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(9));
    }

    //Test to check that my strategy blocks human winning diagonals
    @Test
    public void testCheckComputerBlockHumanDiagonal(){
        Game game = new Game();
        Computer computer = new Computer(game);

        //Checking diagonal 1,5,9
        game.setHuman(5);
        game.setHuman(9);

        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(1));

        //checking diagonal 3,5,7
        game = new Game();
        computer = new Computer(game);

        game.setHuman(3);
        game.setHuman(5);

        computer.move();

        assertEquals(BoxStatus.Computer, game.getBox(7));
    }

    
}
