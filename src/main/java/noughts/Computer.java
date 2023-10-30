package noughts;

public class Computer{
    private Game game;

    //This is so that when you create an object you feed it a game class
    public Computer(Game game) {
        this.game = game;
    }

    //function that generates the streategy for teh computer move and selectst the square
    public void move() {
        //The move that the computer uses
        int square;
        do {
            square = (int) (Math.random() * 9 ) + 1; //creaate a random number
        } while (!game.isEmpty(square)); //loops until it finds out an empty square

        game.setComputer(square);
    }
}