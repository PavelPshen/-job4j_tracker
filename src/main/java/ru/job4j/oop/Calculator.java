package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(20);
        System.out.println(result);
        System.out.println(Calculator.minus(20));
        Calculator calculator = new Calculator();
        System.out.println(calculator.divide(20));
        System.out.println(calculator.multiply(20));
        System.out.println(calculator.sumAllOperation(20));
    }
}