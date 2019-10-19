package package_lecture1p1;

public class CalculateDistance {

  public static void main(String[] args){
    Point p1 = new Point();
    Point p2 = new Point();

    p1.x1 = 10;
    p2.x2 = 20;
    p1.y1 = 10;
    p2.y2 = 20;
    System.out.println("distance between two points is:" + distance(p1, p2));
  }

  public static double distance(Point p1, Point p2){
  return Math.sqrt(((p2.y2 - p1.y1) * (p2.y2 - p1.y1)) + ((p2.x2 - p1.x1) * (p2.x2 - p1.x1)));
  }
}
