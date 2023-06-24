import javax.script.ScriptContext;
import java.util.Scanner;

public class gamePlay {
    private Player player1;
    private Player player2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // saying hello!
        System.out.println("hello and welcome to chess in java");
        // initializing the players
        Player player1 = new HumanPlayer(true);
        Player player2 = new HumanPlayer(false);
        // determining the color of each player
        System.out.println("Player 1 is " + player1.playerColor());
        System.out.println("Player 2 is " + player2.playerColor());
        // creating an object from board
        Board board = new Board();
        // resetting the board
        board.resetBoard();
        // showing the game board : black
        for (int i = 0;i < board.squares[7].length; i ++){
            System.out.print(board.squares[7][i].getPiece().getName());
        }
        System.out.println();
        for (int i = 0; i <board.squares[6].length; i ++){
            System.out.print(board.squares[6][i].getPiece().getName());
        }
        System.out.println();
        // printing the empty blocks
        for (int i = 0; i < 4;i ++){
            System.out.print("[]");
        }
        System.out.println();
        for (int i = 0; i < 4;i ++){
            System.out.print("[]");
        }
        System.out.println();
        for (int i = 0; i < 4;i ++){
            System.out.print("[]");
        }
        System.out.println();
        for (int i = 0; i < 4;i ++){
            System.out.print("[]");
        }
        System.out.println();
        // showing the game board : white
        for (int i = 0;i < board.squares[1].length; i ++){
            System.out.print(board.squares[1][i].getPiece().getName());
        }
        System.out.println();
        for (int i = 0; i <board.squares[0].length; i ++){
            System.out.print(board.squares[0][i].getPiece().getName());


        }

        System.out.println();
        System.out.println("enter the row and the column of the piece you would like to move ");
        System.out.println("row : ");
        int x = scanner.nextInt();
        x = x - 1;

        System.out.println("column");
        int y = scanner.nextInt();
        y = y - 1;

        // checking the validity of the input
        if (!board.isInBoard(x , y)){
            System.out.println("please enter a valid input");
            System.exit(1);
        }

        // showing what piece has the player chosen
        System.out.println("you have chosen ");
        System.out.println(board.squares[x][y].getPiece().getName());

        // checking if the chosen piece can move
        System.out.println("enter the row of the destination");
        int dest_row = scanner.nextInt();
        dest_row = dest_row - 1;

        System.out.println("enter the column of destination");
        int dest_column = scanner.nextInt();
        dest_column = dest_column - 1;

        if (board.squares[x][y].getPiece().canMove(board , board.squares[x][y] , board.squares[dest_row][dest_column])){
            System.out.println("hello");
        } else {
            System.out.println("you can not move to this block");
        }


    }
}
