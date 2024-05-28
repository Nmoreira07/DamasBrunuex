public class Move {
  private int fromX;
  private int fromY;
  private int toX;
  private int toY;

  public Move(int from, int to) {
    this.fromX = from / 10 - 1;
    this.fromY = from % 10 - 1;
    this.toX = to / 10 - 1;
    this.toY = to % 10 - 1;
  }

  public int getFromX() {
    return fromX;
  }

  public int getFromY() {
    return fromY;
  }

  public int getToX() {
    return toX;
  }

  public int getToY() {
    return toY;
  }

  public boolean isWithinBounds() {
    return fromX >= 0 && fromX < 8 && fromY >= 0 && fromY < 8 && toX >= 0 && toX < 8 && toY >= 0 && toY < 8;
  }

  public boolean isSimpleMove() {
    return Math.abs(fromX - toX) == 1;
  }

  public boolean isJump() {
    return Math.abs(fromX - toX) == 2;
  }
}
