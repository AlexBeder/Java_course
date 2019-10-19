package zadanie2;

public class Point {

 public Point(double x, double y) {
  this.x = x;
  this.y = y;


 }

 public double x;
 public double y;


 public double distance(Point p2) {
  return Math.sqrt(((p2.y - y) * (p2.y - y)) + ((p2.x - x) * (p2.x - x)));
 }
 }