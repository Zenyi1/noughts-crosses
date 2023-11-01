package noughts;

public class Computer{
    private Game game;

    //This is so that when you create an object you feed it a game class
    public Computer(Game game) {
        this.game = game;
    }

    //function that generates the streategy for teh computer move and selectst the square
    public void move() {


        makeStrategicMove();
    }

    public void makeStrategicMove(){
        int square;
        do {
            square = (int) (Math.random() * 9) + 1;//random number from 0,0 inclusive to 0.9 exclusive 
            //then we cast it into an int so remove teh decimal part and it is from 1 to 9 and add 1 to get the
            //range 1 inclusive to 10 exclusive
        } while (!game.isEmpty(square));//loops until finding an empty square

        game.setComputer(square);
    }


}