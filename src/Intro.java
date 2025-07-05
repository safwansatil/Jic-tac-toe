import java.util.Scanner;

public class Intro {

    private static final Scanner scanner = new Scanner(System.in);

    public static int displayIntro() {
        System.out.println("__  _  _  _  _  _  _  _  _");
        System.out.println("\nWelcome to Jic-tac-toe!");
        System.out.println("__  _  _  _  _  _  _  _  _\n");
        continueGame();

        System.out.println("""
                The rules are simple:
                1. The game is played on a 3x3 grid.
                2. Players take turns placing their mark (X or O) in an empty cell.
                3. The first player to get 3 of their marks in a row (horizontally, vertically, or diagonally) wins.
                4. If all cells are filled and no player has 3 in a row, the game is a draw.
                5. Players can choose to play as X or O.""");
        System.out.println(
                "6. Once the game starts, player specifies their move by entering a number from 1 to 9, corresponding: ");
        printBoard();
        continueGame();

        System.out.println("\n__  _  _  _  _  _  _  _  _\n");
        System.out.println("Wanna play?");
        System.out.println("1. Yeah\n2. Nah, I'll skip\n Psst, dont enter yes/no, enter a number (1/2)");
        System.out.println("\n__  _  _  _  _  _  _  _  _\n");

        try {
            int startChoice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline
            if (startChoice == 1) {
                System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                System.out.println("Let's go!!");
                System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                return 1;

            } else if (startChoice == 2) {
                System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                System.out.println("Hah! Afraid to lose? ");
                System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                return -1;
            } else {
                System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                System.out.println("Bruh, this ain't a circus!");
                System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                return -1;
            }
        } catch (Exception e) {
            System.out.println("\n__  _  _  _  _  _  _  _  _\n");
            System.out.println("Why you trolling me? I said 1 or 2!");
            System.out.println("Goodbye! ");
            System.out.println("\n__  _  _  _  _  _  _  _  _\n");
            return -1;
        }

    }

    private static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void printBoard() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (j % 2 == 0 && i % 2 == 0) {
                    System.out.print(" ");
                } else if (i % 2 == 0 && j % 2 != 0) {
                    System.out.print("_");
                } else if (i % 2 != 0 && j % 2 == 0) {
                    System.out.print("|");
                } else {
                    System.out.print((i / 2) * 3 + (j / 2) + 1);
                }
            }
            System.out.println();
        }
    }

    private static void continueGame() {
        System.out.println(
                "\n[Press enter to continue. Btw, you can exit the game anytime by pressing some invalid input]");
        try {
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("\n__  _  _  _  _  _  _  _  _\n");
            System.out.println("Thanks for playing! Goodbye!");
            System.out.println("\n__  _  _  _  _  _  _  _  _\n");
            System.exit(0);
        }
        clearScreen();
    }
}
