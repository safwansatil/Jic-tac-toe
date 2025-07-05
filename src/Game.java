import java.util.Scanner;

public class Game {

    static Player player1 = new Player();
    static Player player2 = new Player();
    Scanner scanner;
    int numberOfMoves = 9;
    int result = Player.wonBoard();

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    void startGame() {
        int startNum = Intro.displayIntro();
        if (startNum == 1) {
            System.out.println("Do you want to go first? (Y/N)");
            try {
                String choice = scanner.nextLine().trim().toUpperCase();
                if (choice.equals("Y") || choice.equals("YES") || choice.equals("1")) {
                    System.out.println("Alright, You'll go first, and what symbol you wanna go with? (X/O)");
                    player2.setIsBot(true);
                    player2.setName("MiniMax");

                    try {
                        String symbolChoice = scanner.nextLine().trim().toUpperCase();
                        if (!symbolChoice.equals("X") && !symbolChoice.equals("O")) {
                            System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                            System.out.println("Invalid symbol! I said X or O! Goodbye!");
                            System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                            System.exit(0);
                        }

                        System.out.println("Alright, Fine!! You can have the " + symbolChoice);
                        player1.setSymbol(symbolChoice);
                        player2.setSymbol(symbolChoice.equals("X") ? "O" : "X");
                        System.out.println("Just before we begin, what's your name again?");
                        String name = scanner.nextLine().trim();
                        if (name.isEmpty()) {
                            name = "Player";
                        }
                        player1.setName(name);
                    } catch (Exception e) {
                        System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                        System.out.println("Invalid input! Goodbye");
                        System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                        System.exit(0);
                    }
                } else if (choice.equals("N") || choice.equals("NO") || choice.equals("0")) {
                    System.out.println("Alright, You'll go second, and what symbol you wanna go with? (X/O)");
                    player1.setIsBot(true);
                    player1.setName("MiniMax");

                    try {
                        String symbolChoice = scanner.nextLine().trim().toUpperCase();
                        if (!symbolChoice.equals("X") && !symbolChoice.equals("O")) {
                            System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                            System.out.println("Invalid symbol! I said X or O! Goodbye!");
                            System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                            System.exit(0);
                        }

                        System.out.println("Alright, Fine!! You can have the " + symbolChoice);
                        player2.setSymbol(symbolChoice);
                        player1.setSymbol(symbolChoice.equals("X") ? "O" : "X");
                        System.out.println("Just before we begin, what's your name again?");
                        String name = scanner.nextLine().trim();
                        if (name.isEmpty()) {
                            name = "Player";
                        }
                        player2.setName(name);
                    } catch (Exception e) {
                        System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                        System.out.println("Invalid input! Goodbye!ugh");
                        System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                        System.exit(0);
                    }
                } else {
                    System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                    System.out.println("Invalid choice! I said Y or N! Goodbye!ugh");
                    System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                System.out.println("Invalid input! Goodbye!ugh");
                System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                System.exit(0);
            }
        } else if (startNum == -1) {
            System.out.println("\n__  _  _  _  _  _  _  _  _\n");
            System.out.println("Thanks for stopping by! Maybe next time you'll be brave enough to play!");
            System.out.println("Goodbye");
            System.out.println("\n__  _  _  _  _  _  _  _  _\n");
            System.exit(0);
        }
    }

    void jictactoe() {
        while (numberOfMoves > 0) {
            result = Player.wonBoard();
            if (result == 1 || result == 2 || result == 0) {
                break;
            }

            player1.move(player1, scanner);
            result = Player.wonBoard();
            if (result == 1 || result == 2 || result == 0) {
                break;
            }

            player2.move(player2, scanner);
            numberOfMoves--;
        }

        if (result == 1) {
            System.out.println("Congratulations!! On playing the game.");
            System.out.println(player1.getName() + " has graciously won the game.");
            System.out.println("See you next time!");
        } else if (result == 2) {
            System.out.println("Congratulations!! On playing the game.");
            System.out.println(player2.getName() + " has graciously won the game.");
            System.out.println("See you next time!");
        } else if (result == 0) {
            System.out.println("See, it's a draw. You can't win!");
            System.out.println("See you later loser!");
        }
    }
}
