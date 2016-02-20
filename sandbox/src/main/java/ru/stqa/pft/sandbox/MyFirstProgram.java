package ru.stqa.pft.sandbox;

public class MyFirstProgram {
	
	public static void main(String[] args){
		hello("world");
		hello("user");
		hello("Konstantin");

		double l = 5;
		System.out.println("Площадь квадрата со сторой " + l + " = " + area(l));

		double a = 4;
		double b = 6;

		System.out.println("Площадь прямоугольника со сторонам " + a + " и " + b + " = " + area(a,b));

	}

	public static void hello(String somebody) {
		System.out.println("hello, " + somebody + "!");

	}

	public static double area (double len) {
		return len * len;
	}

	public static double area (double a, double b) {
		return a * b;
	}
}