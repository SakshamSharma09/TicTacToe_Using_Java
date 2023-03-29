package Projects;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        Scanner input = new Scanner(System.in);

        createBoard(board);

        char player = 'X';
        boolean gameOver = false;

        while(!gameOver){

            printBoard(board);
            System.out.println("Player "+ player +" please tell the row and col:-");
            int row = input.nextInt();
            int col = input.nextInt();

            if(board[row][col] == ' '){
                board[row][col] = player;
                gameOver = haveWon(board, player);

                if(gameOver==true){
                    printBoard(board);
                    System.out.println("Player "+ player +" won.");
                }
                // changing the player
                player = (player=='X') ? 'O' : 'X';

            }
            else{
                System.out.println("Invalid Move. Try Again!");
            }
        }
    }

    public static boolean haveWon(char[][] board, char player){
        //check for rows
        for(int row=0;row<board.length;row++){
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
                return true;
            }
        }

        //check for cols
        for(int col=0;col<board.length;col++){
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
                return true;
            }
        }

        //check for diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }

        return false;
    }

    public static void createBoard(char[][] board){
        for(int row=0;row< board.length;row++){
            for(int col=0;col< board.length;col++){
                board[row][col] = ' ';
            }
        }
    }

    
    public static void printBoard(char[][] board){
        for(int row=0;row< board.length;row++){
            for(int col=0;col< board.length;col++){
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
