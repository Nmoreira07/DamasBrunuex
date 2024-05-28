import java.util.Scanner;

public class Player {
  private char color; // 'r' para vermelho, 'b' para preto

  public Player(char color) {
    this.color = color;
  }

  public char getColor() {
    return color;
  }

  public Move getNextMove() {
    Scanner stdin = new Scanner(System.in);
    System.out.println("Digite o quadrado de onde você gostaria de mover.");
    System.out.print("Digite como um número de 2 dígitos. (por exemplo, se você estivesse movendo de ");
    System.out.println("x=1, y=3, digite 13");
    int movefrom = stdin.nextInt();

    System.out.print("Digite o quadrado para onde você gostaria de mover, ");
    System.out.println("usando a mesma convenção.");
    int moveto = stdin.nextInt();

    return new Move(movefrom, moveto);
  }
}
