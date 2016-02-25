package ru.stqa.pft.sandbox;

import com.sun.org.apache.xpath.internal.SourceTree;

public class MyFirstProgram {
	
	public static void main(String[] args){
		hello("world");
		hello("user");
		hello("Konstantin");

		Square s = new Square(5);
		System.out.println("Площадь квадрата со сторой " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(4,6);

		System.out.println("Площадь прямоугольника со сторонам " + r.a + " и " + r.b + " = " + r.area());

		Point p = new Point(1,2);
		Point p1 = new Point(4,5);
		System.out.println("Расстояние между точками (" + p.x + ", " + p.y + ") и (" + p1.x + ", " + p1.y + ") = " + p.distance(p1));
	}

	public static void hello(String somebody) {
		System.out.println("hello, " + somebody + "!");

	}




}