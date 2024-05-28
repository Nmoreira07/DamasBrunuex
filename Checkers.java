import java.io.IOException;

public class Checkers {
  private Board board;
  private Player redPlayer;
  private Player blackPlayer;
  private Player currentPlayer;

  public Checkers() {
    board = new Board();
    redPlayer = new Player('r');
    blackPlayer = new Player('b');
    currentPlayer = redPlayer;
  }

  public void play() throws IOException {
    board.printBoard();
    while (!gameOver()) {
      System.out.println("É a sua vez, " + (currentPlayer.getColor() == 'r' ? "vermelho" : "preto") + ".");
      Move move = currentPlayer.getNextMove();
      if (validMove(move)) {
        executeMove(move);
        switchPlayer();
      } else {
        System.out.println("Esse foi um movimento inválido, tente novamente.");
      }
      board.printBoard();
    }
    System.out.println("O vencedor é " + winnerIs());
  }

  private boolean validMove(Move move) {
    if (!move.isWithinBounds())
      return false;

    int fromX = move.getFromX();
    int fromY = move.getFromY();
    int toX = move.getToX();
    int toY = move.getToY();

    if (board.getPiece(fromX, fromY).getColor() != currentPlayer.getColor() || !board.getPiece(toX, toY).isEmpty()) {
      return false;
    }

    if (move.isSimpleMove()) {
      if (currentPlayer.getColor() == 'r' && toY - fromY == 1)
        return true;
      if (currentPlayer.getColor() == 'b' && toY - fromY == -1)
        return true;
    } else if (move.isJump()) {
      if (currentPlayer.getColor() == 'r' && toY - fromY == 2
          && board.getPiece((fromX + toX) / 2, (fromY + toY) / 2).getColor() == 'b')
        return true;
      if (currentPlayer.getColor() == 'b' && toY - fromY == -2
          && board.getPiece((fromX + toX) / 2, (fromY + toY) / 2).getColor() == 'r')
        return true;
    }

    return false;
  }

  private void executeMove(Move move) {
    int fromX = move.getFromX();
    int fromY = move.getFromY();
    int toX = move.getToX();
    int toY = move.getToY();

    board.setPiece(fromX, fromY, '_');
    board.setPiece(toX, toY, currentPlayer.getColor());
    if (move.isJump()) {
      board.setPiece((fromX + toX) / 2, (fromY + toY) / 2, '_');
    }
  }

  private void switchPlayer() {
    currentPlayer = (currentPlayer == redPlayer) ? blackPlayer : redPlayer;
  }

  private boolean gameOver() {
    return redPlayer.getColor() == 0 || blackPlayer.getColor() == 0;
  }

  private String winnerIs() {
    return (redPlayer.getColor() == 0) ? "preto" : "vermelho";
  }

  public static void main(String[] args) throws IOException {
    Checkers game = new Checkers();
    game.play();
  }
}
