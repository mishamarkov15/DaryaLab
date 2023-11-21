public class Chess {
    public static void main(String[] args) {
        char[][] board = new char[8][8];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0;  j < board[i].length; ++j) {
                if ((i + j) % 2 == 0) {
                    board[i][j] = 'X';
                } else {
                    board[i][j] = 'Y';
                }
            }
        }

        System.out.println("  A B C D E F G H");

        for (int i = 0; i < board.length; ++i) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < board[i].length; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
