package zadanie3;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import zadanie2.Point;

import static zadanie2.CalculateDistance.distance;

public class TestDistPoint {


  @Test
  public void TestDistance(){
    Point p1 = new Point(10, 10);
    Point p2 = new Point(20, 20);
    Assert.assertEquals(p1.distance(p2), 14.142135623730951);
    Assert.assertTrue(p1.distance(p2) > 10);



  }

}
