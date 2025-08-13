package ru.netology;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int a = 10;
        int b = 2;
        int result = calculator.add(a, b);
        System.out.println(result);
    }
}