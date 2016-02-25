package ru.stqa.pft.sandbox;

/**
 * Created by kbal on 24.02.2016.
 */
public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point p1) {
    return Math.sqrt(Math.pow((this.x - p1.x), 2) + Math.pow((this.y - p1.y), 2));

  }

}
