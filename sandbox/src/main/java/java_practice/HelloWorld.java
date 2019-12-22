package java_practice;

public class HelloWorld {

  public static void main(String[] args) {
    System.out.println("Hello World");

    Square s = new Square(5);
    System.out.println("Ploshad kvadrata so storonami " + s.l + " = " +s.area());

    Rectangle r = new Rectangle(5, 6);
    System.out.println("Ploshad treugolnika so storonami " + r.a + " и " + r.b + " = " + r.area());

  }

}