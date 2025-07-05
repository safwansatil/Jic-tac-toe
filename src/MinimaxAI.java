public class MinimaxAI {

    // Convert board position (1-9) to array indices
    private static int[] positionToIndices(int position) {
        return switch (position) {
            case 1 -> new int[] { 1, 1 };
            case 2 -> new int[] { 1, 3 };
            case 3 -> new int[] { 1, 5 };
            case 4 -> new int[] { 3, 1 };
            case 5 -> new int[] { 3, 3 };
            case 6 -> new int[] { 3, 5 };
            case 7 -> new int[] { 5, 1 };
            case 8 -> new int[] { 5, 3 };
            case 9 -> new int[] { 5, 5 };
            default -> new int[] { -1, -1 };
        };
    }

    
    private static boolean isAvailable(int position) {
        int[] indices = positionToIndices(position);
        return Board.board[indices[0]][indices[1]].equals(" ");
    }

    
    private static int[] getAvailableMoves(String[][] board) {
        int[] moves = new int[9];
        int count = 0;
        for (int i = 1; i <= 9; i++) {
            int[] indices = positionToIndices(i);
            if (board[indices[0]][indices[1]].equals(" ")) {
                moves[count++] = i;
            }
        }
        int[] result = new int[count];
        System.arraycopy(moves, 0, result, 0, count);
        return result;
    }
    // for current , realtime
    private static int[] getAvailableMoves() {
        return getAvailableMoves(Board.board);
    }

    
    private static void makeMove(int position, String symbol, String[][] board) {
        int[] indices = positionToIndices(position);
        board[indices[0]][indices[1]] = symbol;
    }

    
    private static int checkGameState(String[][] board, String player1Symbol, String player2Symbol) {
        // Rows
        for (int i = 1; i < 6; i += 2) {
            if (board[i][1].equals(player1Symbol) && board[i][3].equals(player1Symbol)
                    && board[i][5].equals(player1Symbol)) {
                return 1;
            } else if (board[i][1].equals(player2Symbol) && board[i][3].equals(player2Symbol)
                    && board[i][5].equals(player2Symbol)) {
                return 2;
            }
        }

        // Cols
        for (int i = 1; i < 6; i += 2) {
            if (board[1][i].equals(player1Symbol) && board[3][i].equals(player1Symbol)
                    && board[5][i].equals(player1Symbol)) {
                return 1;
            } else if (board[1][i].equals(player2Symbol) && board[3][i].equals(player2Symbol)
                    && board[5][i].equals(player2Symbol)) {
                return 2;
            }
        }

        // Diagonals
        if (board[1][1].equals(player1Symbol) && board[3][3].equals(player1Symbol)
                && board[5][5].equals(player1Symbol)) {
            return 1;
        } else if (board[1][1].equals(player2Symbol) && board[3][3].equals(player2Symbol)
                && board[5][5].equals(player2Symbol)) {
            return 2;
        }

        if (board[1][5].equals(player1Symbol) && board[3][3].equals(player1Symbol)
                && board[5][1].equals(player1Symbol)) {
            return 1;
        } else if (board[1][5].equals(player2Symbol) && board[3][3].equals(player2Symbol)
                && board[5][1].equals(player2Symbol)) {
            return 2;
        }

        // Check for draw
        for (int i = 1; i < 6; i += 2) {
            for (int j = 1; j < 6; j += 2) {
                if (board[i][j].equals(" ")) {
                    return -1; // Game continues
                }
            }
        }
        return 0; // Draw
    }

    
    private static String[][] copyBoard() {
        String[][] copy = new String[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                copy[i][j] = Board.board[i][j];
            }
        }
        return copy;
    }

    // Minimax algorithm
    private static int minimax(String[][] board, int depth, boolean isMaximizing, String player1Symbol,
            String player2Symbol) {
        int gameState = checkGameState(board, player1Symbol, player2Symbol);

        switch (gameState) {
            case 1 -> {
                return 10 - depth; // maximizer
            }
            case 2 -> {
                return depth - 10; // minimizer
            }
            case 0 -> {
                return 0; // Draw
            }
            default -> {
            }
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            int[] availableMoves = getAvailableMoves(board);

            for (int move : availableMoves) {
                int[] indices = positionToIndices(move);
                if (board[indices[0]][indices[1]].equals(" ")) {
                    makeMove(move, player1Symbol, board);
                    int score = minimax(board, depth + 1, false, player1Symbol, player2Symbol);
                    board[indices[0]][indices[1]] = " "; // Undo move
                    bestScore = Math.max(score, bestScore);
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            int[] availableMoves = getAvailableMoves(board);

            for (int move : availableMoves) {
                int[] indices = positionToIndices(move);
                if (board[indices[0]][indices[1]].equals(" ")) {
                    makeMove(move, player2Symbol, board);
                    int score = minimax(board, depth + 1, true, player1Symbol, player2Symbol);
                    board[indices[0]][indices[1]] = " "; // Undo move
                    bestScore = Math.min(score, bestScore);
                }
            }
            return bestScore;
        }
    }

    // exec minimax
    public static int getBestMove(String player1Symbol, String player2Symbol, boolean isPlayer1Turn) {
        int bestScore = isPlayer1Turn ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int bestMove = -1;
        int[] availableMoves = getAvailableMoves();

        for (int move : availableMoves) {
            if (isAvailable(move)) {
                String[][] boardCopy = copyBoard();
                String currentSymbol = isPlayer1Turn ? player1Symbol : player2Symbol;
                makeMove(move, currentSymbol, boardCopy);

                int score = minimax(boardCopy, 0, !isPlayer1Turn, player1Symbol, player2Symbol);

                if (isPlayer1Turn) {
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = move;
                    }
                } else {
                    if (score < bestScore) {
                        bestScore = score;
                        bestMove = move;
                    }
                }
            }
        }

        return bestMove;
    }
}