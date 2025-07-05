public class Board {
    static String[][] board = new String[6][6];

    public static void initializeBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    board[i][j] = " "; 
                } else if (i % 2 == 0 && j % 2 != 0) {
                    board[i][j] = "_"; 
                } else if (i % 2 != 0 && j % 2 == 0) {
                    board[i][j] = "|"; 
                } else {
                    board[i][j] = " "; 
                }
            }
        }
    }

    public static void printBoardInGame() {
        System.out.println("\n__  _  _  _  _  _  _  _  _\n");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (j % 2 != 0) {
                    if (i % 2 == 0) {
                        System.out.print("_");
                    } else {
                        String content = board[i][j];
                        if (content.equals(" ")) {
                            String blank = "-";
                            System.out.print(blank);
                        } else {
                            System.out.print(content);
                        }
                    }
                } else {
                    if (i % 2 == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print("|");
                    }
                }
            }
            System.out.println();
            // so the board basically can have symbols in
            // [1][1] = 1
            // [1][3] = 2
            // [1][5] = 3
            // [3][1] = 4
            // [3][3] = 5
            // [3][5] =6
            // [5][1]=7
            // [5][3]=8
            // [5][5]=9
        }
        System.out.println("\n__  _  _  _  _  _  _  _  _\n");
    }

    public static int checkBoard(int move) {
        int occupied = 0;
        switch (move) {
            case 1 -> {
                if (board[1][1].equals(" ")) {
                    occupied = 0;
                } else {
                    occupied = -1;
                }
            }
            case 2 -> {
                if (board[1][3].equals(" ")) {
                    occupied = 0;
                } else {
                    occupied = -1;
                }
            }
            case 3 -> {
                if (board[1][5].equals(" ")) {
                    occupied = 0;
                } else {
                    occupied = -1;
                }
            }
            case 4 -> {
                if (board[3][1].equals(" ")) {
                    occupied = 0;
                } else {
                    occupied = -1;
                }
            }
            case 5 -> {
                if (board[3][3].equals(" ")) {
                    occupied = 0;
                } else {
                    occupied = -1;
                }
            }
            case 6 -> {
                if (board[3][5].equals(" ")) {
                    occupied = 0;
                } else {
                    occupied = -1;
                }
            }
            case 7 -> {
                if (board[5][1].equals(" ")) {
                    occupied = 0;
                } else {
                    occupied = -1;
                }
            }
            case 8 -> {
                if (board[5][3].equals(" ")) {
                    occupied = 0;
                } else {
                    occupied = -1;
                }
            }
            case 9 -> {
                if (board[5][5].equals(" ")) {
                    occupied = 0;
                } else {
                    occupied = -1;
                }
            }
        }
        return occupied;
    }

    public static void placeMove(int move, Player player) {
        switch (move) {
            case 1 -> {
                board[1][1] = player.getSymbol();
                System.out.println(player.getName() + " placed " + player.getSymbol() + "\n");
                printBoardInGame();
            }
            case 2 -> {
                board[1][3] = player.getSymbol();
                System.out.println(player.getName() + " placed " + player.getSymbol() + "\n");
                printBoardInGame();
            }
            case 3 -> {
                board[1][5] = player.getSymbol();
                System.out.println(player.getName() + " placed " + player.getSymbol() + "\n");
                printBoardInGame();
            }
            case 4 -> {
                board[3][1] = player.getSymbol();
                System.out.println(player.getName() + " placed " + player.getSymbol() + "\n");
                printBoardInGame();
            }
            case 5 -> {
                board[3][3] = player.getSymbol();
                System.out.println(player.getName() + " placed " + player.getSymbol() + "\n");
                printBoardInGame();
            }
            case 6 -> {
                board[3][5] = player.getSymbol();
                System.out.println(player.getName() + " placed " + player.getSymbol() + "\n");
                printBoardInGame();
            }
            case 7 -> {
                board[5][1] = player.getSymbol();
                System.out.println(player.getName() + " placed " + player.getSymbol() + "\n");
                printBoardInGame();
            }
            case 8 -> {
                board[5][3] = player.getSymbol();
                System.out.println(player.getName() + " placed " + player.getSymbol() + "\n");
                printBoardInGame();
            }
            case 9 -> {
                board[5][5] = player.getSymbol();
                System.out.println(player.getName() + " placed " + player.getSymbol() + "\n");
                printBoardInGame();
            }
        }
    }

}
