package noughts;

public class Computer{
    private Game game;

    //This is so that when you create an object you feed it a game class
    public Computer(Game game) {
        this.game = game;
    }

    //function that generates the streategy for teh computer move and selectst the square
    public void move() {

        if (winRows()){
            return;
        }

        if (winColumns()){
            return;
        }

        if (winDiagonal()){
            return;
        }
        //first we try to win before blocking the payer from winning
        

        if (conquerCenter()){
            return;
        }

        secretStrategy();
    }

    //this function makes a random move, I found teh one line random number implementation on stack overflow and modified to make its range 1 to 9, I explain how it works down there so you can see that I understand it
    private void secretStrategy(){
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

    //checks if there is a win in any of the rows, uses a system simmilar to the one I used to create winning detection
    //loops through rows for each win case (left, center, end) to see if any row has a winning move
    private boolean winRows(){
        for(int i =0; i < 7; i += 3){
            if(game.board[i] == BoxStatus.Empty && game.board[i+1] == BoxStatus.Computer && game.board[i+2] == BoxStatus.Computer){
                //I got a lot of bugs because of this but basically since the for loop is index 0 and the board is index 1 I was selecting the wrong square for winning move
                int square = i+1;
                game.setComputer(square);
                return true;
            } 
        }
        for(int i = 1; i < 8; i += 3){
            if(game.board[i] == BoxStatus.Empty && game.board[i-1] == BoxStatus.Computer && game.board[i+1] == BoxStatus.Computer){
                //I got a lot of bugs because of this but basically since the for loop index1 is the board index 2 I was selecting the wrong square for winning move
                int square2 = i+1;
                game.setComputer(square2);
                return true;
            }
        }
        for(int i = 2; i < 9; i += 3){
            if(game.board[i] == BoxStatus.Empty && game.board[i-1] == BoxStatus.Computer && game.board[i-2] == BoxStatus.Computer){
                //I got a lot of bugs because of this but basically since the for loop index 2 means the board index 3 I was selecting the wrong square for winning move
                int square3 = i+1;
                game.setComputer(square3);
                return true;
            }
        }
        return false;
    }

    
    //This function checks the 2 possible diagonals to see if there is a possible win there, again this was inspired by the function I created to check for diagonal wins
    //I am making all these private because they are only accessed within the class and applied to the move function
    private boolean winDiagonal() {
        if(game.board[0] == BoxStatus.Empty && game.board[4] == BoxStatus.Computer && game.board[8] == BoxStatus.Computer){
            int square = 1;
            game.setComputer(square);
            return true;
        }
        if(game.board[4] == BoxStatus.Empty && game.board[1] == BoxStatus.Computer && game.board[8] == BoxStatus.Computer){
            int square = 5;
            game.setComputer(square);
            return true;
        }
        if(game.board[8] == BoxStatus.Empty && game.board[1] == BoxStatus.Computer && game.board[4] == BoxStatus.Computer){
            int square = 9;
            game.setComputer(square);
            return true;
        }
        if(game.board[2] == BoxStatus.Empty && game.board[4] == BoxStatus.Computer && game.board[6] == BoxStatus.Computer){
            int square = 3;
            game.setComputer(square);
            return true;
        }
        if(game.board[4] == BoxStatus.Empty && game.board[2] == BoxStatus.Computer && game.board[6] == BoxStatus.Computer){
            int square = 5;
            game.setComputer(square);
            return true;
        }
        if(game.board[6] == BoxStatus.Empty && game.board[4] == BoxStatus.Computer && game.board[2] == BoxStatus.Computer){
            int square = 7;
            game.setComputer(square);
            return true;
        }
        return false;

    }
    
    //Make sure that the computer wins on columns
    private boolean winColumns(){
        for(int i =0; i < 3; i += 1){
            if(game.board[i] == BoxStatus.Empty && game.board[i+3] == BoxStatus.Computer && game.board[i+6] == BoxStatus.Computer){
                //I got a lot of bugs because of this but basically since the for loop is index 0 and the board is index 1 I was selecting the wrong square for winning move
                int square = i+1;
                game.setComputer(square);
                return true;
            } 
        }
        for(int i = 3; i < 6; i += 1){
            if(game.board[i] == BoxStatus.Empty && game.board[i-3] == BoxStatus.Computer && game.board[i+3] == BoxStatus.Computer){
                //I got a lot of bugs because of this but basically since the for loop index1 is the board index 2 I was selecting the wrong square for winning move
                int square2 = i+1;
                game.setComputer(square2);
                return true;
            }
        }
        for(int i = 6; i < 9; i += 1){
            if(game.board[i] == BoxStatus.Empty && game.board[i-3] == BoxStatus.Computer && game.board[i-6] == BoxStatus.Computer){
                //I got a lot of bugs because of this but basically since the for loop index 2 means the board index 3 I was selecting the wrong square for winning move
                int square3 = i+1;
                game.setComputer(square3);
                return true;
            }
        }
        return false;

    }




}