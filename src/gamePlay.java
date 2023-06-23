import javax.script.ScriptContext;
import java.util.Scanner;

public class gamePlay {
    private Player player1;
    private Player player2;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("hello and welcome to chess in java");
        Player player1 = new HumanPlayer(true);
        Player player2 = new HumanPlayer(false);




    }
}
