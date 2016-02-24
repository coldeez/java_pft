package ru.stqa.pft.sandbox;

/**
 * Created by kbal on 24.02.2016.
 */
public class Lesson1 {

  public static void main(String[] args){

    Point p1 = new Point();
    p1.x = 1;
    p1.y = 2;
    Point p2 = new Point();
    p2.x = 4;
    p2.y = 5;

    System.out.println("Расстояние между точками (" + p1.x + ", " + p1.y + ") и (" + p2.x + ", " + p2.y + ") = " + distance(p1,p2));

  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x)+(p1.y - p2.y)*(p1.y - p2.y));

  }
}
