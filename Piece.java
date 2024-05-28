public class Piece {
  private char color; // 'r' para vermelho, 'b' para preto, '_' para vazio

  public Piece(char color) {
    this.color = color;
  }

  public char getColor() {
    return color;
  }

  public void setColor(char color) {
    this.color = color;
  }

  public boolean isEmpty() {
    return color == '_';
  }
}
