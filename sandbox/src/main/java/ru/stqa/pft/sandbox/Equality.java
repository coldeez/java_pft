package ru.stqa.pft.sandbox;

/**
 * Created by kosty on 11.03.2016.
 */
public class Equality {
    public static void main(String[] args){
        String s1 = "firefox";
        String s2 = "fire" + "fox";

        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
    }
}
