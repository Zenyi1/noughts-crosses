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

    
}
