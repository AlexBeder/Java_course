package zadanie2;

public class CalculateDistance {

  public static void main(String[] args){
    Point po1 = new Point(10, 10);
    Point po2 = new Point(20, 20);

    System.out.println("distance between two points is:" + distance(po1, po2));

    System.out.println("distance between two points is:" + po1.distance(po2));


  }

  public static double distance(Point p1, Point p2){
  return Math.sqrt(((p2.y - p1.y) * (p2.y - p1.y)) + ((p2.x - p1.x) * (p2.x - p1.x)));
  }
}
