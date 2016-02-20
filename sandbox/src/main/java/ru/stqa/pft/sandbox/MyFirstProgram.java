package ru.stqa.pft.sandbox;

public class MyFirstProgram {
	
	public static void main(String[] args){
		hello("world");
		hello("user");
		hello("Konstantin");

		Square s = new Square(5);
		System.out.println("Площадь квадрата со сторой " + s.l + " = " + area(s));

		Rectangle r = new Rectangle(4,6);

		System.out.println("Площадь прямоугольника со сторонам " + r.a + " и " + r.b + " = " + area(r));

	}

	public static void hello(String somebody) {
		System.out.println("hello, " + somebody + "!");

	}

	public static double area (Square s) {
		return s.l * s.l;
	}

	public static double area (Rectangle r) {
		return r.a * r.b;
	}
}