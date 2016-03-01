package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by kbal on 01.03.2016.
 */
public class PointTests {

  @Test
  public void testDistance() {
    Point p = new Point(4,5);
    Point p1 = new Point (5,6);
    Assert.assertEquals(p.distance(p1),Math.sqrt(2));

  }

}
