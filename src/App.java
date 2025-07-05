import java.util.Scanner;

public class App {
    public boolean gameStart = false;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Board.initializeBoard();
        Game game = new Game(scanner);
        game.startGame();

        game.jictactoe();
        scanner.close();

        
        System.out.println("\n_ _  _  _  _  _  _  _  _  _\n");
        System.out.println("Thanks for playing Jic-tac-toe!");
        System.out.println("\n_ _  _  _  _  _  _  _  _  _\n");
    }

}

