package noughts;

public class Computer{
    private Game game;

    //This is so that when you create an object you feed it a game class
    public Computer(Game game) {
        this.game = game;
    }

    //function that generates the streategy for teh computer move and selectst the square
    public void move() {

        if (conquerCenter()){
            return;
        }

        makeStrategicMove();
    }

    //this function makes a random move, I found teh one line random number implementation on stack overflow and modified to make its range 1 to 9, I explain how it works down there so you can see that I understand it
    private void makeStrategicMove(){
        int square;
        do {
            square = (int) (Math.random() * 9) + 1;//random number from 0,0 inclusive to 0.9 exclusive 
            //then cast it into an int so remove teh decimal part and it is from 1 to 9 and add 1 to get the
            //range 1 inclusive to 10 exclusive
        } while (!game.isEmpty(square));//loops until finding an empty square

        game.setComputer(square);
    }

    //I read online that a good strat for tic tac toe is to conquer the center so Im making the computer do this if possible
    private boolean conquerCenter(){
        int square = 5;

        //im making it return true or false so that the the move function knows which of the strategies to run
        if (game.isEmpty(square)){
            game.setComputer(square);
            return true;
        } else {
            return false;
        }

    }




}