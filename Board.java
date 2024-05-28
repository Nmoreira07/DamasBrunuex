public class Board {
  private final static int SIZE = 8;
  private Piece[][] board;

  public Board() {
    board = new Piece[SIZE][SIZE];
    initializeBoard();
  }

  private void initializeBoard() {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        board[i][j] = new Piece('_');
      }
    }

    for (int i = 1; i < SIZE; i += 2) {
      board[i][1].setColor('r');
      board[i][5].setColor('b');
      board[i][7].setColor('b');
    }
    for (int i = 0; i < SIZE; i += 2) {
      board[i][0].setColor('r');
      board[i][2].setColor('r');
      board[i][6].setColor('b');
    }
  }

  public Piece getPiece(int x, int y) {
    return board[x][y];
  }

  public void setPiece(int x, int y, char color) {
    board[x][y].setColor(color);
  }

  public void printBoard() {
    System.out.println("  1 2 3 4 5 6 7 8 x");
    for (int i = 0; i < SIZE; i++) {
      System.out.print((i + 1) + " ");
      for (int j = 0; j < SIZE; j++) {
        System.out.print(board[j][i].getColor() + " ");
      }
      System.out.println();
    }
    System.out.println("y");
  }
}
