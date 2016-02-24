package ru.stqa.pft.sandbox;

public class MyFirstProgram {
	
	public static void main(String[] args){
		hello("world");
		hello("user");
		hello("Konstantin");

		Square s = new Square(5);
		System.out.println("Площадь квадрата со сторой " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(4,6);

		System.out.println("Площадь прямоугольника со сторонам " + r.a + " и " + r.b + " = " + r.area());

	}

	public static void hello(String somebody) {
		System.out.println("hello, " + somebody + "!");

	}


}