package package_lecture1p1;

import java.awt.*;

public class HelloWorld {

  public static void main(String[] args) {
    System.out.println("Hello World");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со сторонами " + s.l + " = " +s.area());

    Rectangle r = new Rectangle(5, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

  }

}