import java.util.Scanner;

public class Player {
    private String name = "Giorno";
    private String symbol = "L";
    private boolean isBot = false;

    void move(Player player, Scanner scanner) {
        if (!player.isBot) {
            System.out.println("Enter the square number for your move.");
            System.out.println("If you've forgotten the square numbers, press 0");

            try {
                int move = scanner.nextInt();
                if (move == 0) {
                    Intro.printBoard();
                    System.out.println("Now enter your move (1-9):");
                    try {
                        move = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                        System.out.println("Invalid input! Goodbye!");
                        System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                        System.exit(0);
                    }
                }

                if (move >= 1 && move <= 9) {
                    if (Board.checkBoard(move) == 0) {
                        Board.placeMove(move, player);
                    } else {
                        System.out.println("The square is already occupied silly.");
                        Board.printBoardInGame();
                        System.out.println("See! Try another square!");
                        move(player, scanner);
                    }
                } else {
                    System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                    System.out.println("Why are u trolling? Thats not a valid square to move in!");
                    System.out.println("ugh,Goodbye!");
                    System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                System.out.println("Invalid input! ugh,Goodbye!");
                System.out.println("\n__  _  _  _  _  _  _  _  _\n");
                System.exit(0);
            }
        } else {
            boolean isPlayer1Turn = (player == Game.player1);
            String player1Symbol = Game.player1.getSymbol();
            String player2Symbol = Game.player2.getSymbol();

            int bestMove = MinimaxAI.getBestMove(player1Symbol, player2Symbol, isPlayer1Turn);
            Board.placeMove(bestMove, player);
        }
    }

    static int wonBoard() {
        String player1Symbol = Game.player1.getSymbol();
        String player2Symbol = Game.player2.getSymbol();

        for (int i = 1; i < 6; i += 2) {
            if (Board.board[i][1].equals(player1Symbol) && Board.board[i][3].equals(player1Symbol)
                    && Board.board[i][5].equals(player1Symbol)) {
                return 1;
            } else if (Board.board[i][1].equals(player2Symbol) && Board.board[i][3].equals(player2Symbol)
                    && Board.board[i][5].equals(player2Symbol)) {
                return 2;
            }
        }

        for (int i = 1; i < 6; i += 2) {
            if (Board.board[1][i].equals(player1Symbol) && Board.board[3][i].equals(player1Symbol)
                    && Board.board[5][i].equals(player1Symbol)) {
                return 1;
            } else if (Board.board[1][i].equals(player2Symbol) && Board.board[3][i].equals(player2Symbol)
                    && Board.board[5][i].equals(player2Symbol)) {
                return 2;
            }
        }

        if (Board.board[1][1].equals(player1Symbol) && Board.board[3][3].equals(player1Symbol)
                && Board.board[5][5].equals(player1Symbol)) {
            return 1;
        } else if (Board.board[1][1].equals(player2Symbol) && Board.board[3][3].equals(player2Symbol)
                && Board.board[5][5].equals(player2Symbol)) {
            return 2;
        }

        if (Board.board[1][5].equals(player1Symbol) && Board.board[3][3].equals(player1Symbol)
                && Board.board[5][1].equals(player1Symbol)) {
            return 1;
        } else if (Board.board[1][5].equals(player2Symbol) && Board.board[3][3].equals(player2Symbol)
                && Board.board[5][1].equals(player2Symbol)) {
            return 2;
        }

        boolean isDraw = true;
        for (int i = 1; i < 6; i += 2) {
            for (int j = 1; j < 6; j += 2) {
                if (Board.board[i][j].equals(" ")) {
                    isDraw = false;
                    break;
                }
            }
        }

        if (isDraw) {
            return 0;
        }

        return -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        if (symbol == null || symbol.trim().isEmpty() || symbol.equals(" ")) {
            System.out.println("\n__  _  _  _  _  _  _  _  _\n");
            System.out.println("Invalid symbol! Cannot use empty space or null as symbol!");
            System.out.println("Goodbye!");
            System.out.println("\n__  _  _  _  _  _  _  _  _\n");
            System.exit(0);
        }
        this.symbol = symbol;
    }

    public boolean isIsBot() {
        return isBot;
    }

    public void setIsBot(boolean isBot) {
        this.isBot = isBot;
    }
}
