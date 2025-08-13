package com.jay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Collegetest {
    public static List<Double> getNumbers() {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = new ArrayList<>();

        System.out.print("Enter numbers: ");
        String[] input = scanner.nextLine().split(" ");

        for (String num : input) {
            try {
                numbers.add(Double.parseDouble(num));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + num);
            }
        }

        return numbers;
    }
    public static double getMax(List<Double> numbers) {
        return numbers.stream().max(Double::compare).orElse(Double.NaN);
    }
    public static double getMin(List<Double> numbers) {
        return numbers.stream().min(Double::compare).orElse(Double.NaN);
    }

    public static double getSum(List<Double> numbers) {
        return numbers.stream().mapToDouble(Double::doubleValue).sum();
    }

    public static double getAvg(List<Double> numbers) {
        return numbers.isEmpty() ? Double.NaN : getSum(numbers) / numbers.size();
    }


    public static void main(String[] args) {
        System.out.println("The maximum value of the given: " + getMax(getNumbers()));
        System.out.println("The Min of the given no is: " + getMin(getNumbers()));
        System.out.println("The Sum of the given no is: " + getSum(getNumbers()));
        System.out.println("The Average of the given no is: " + getAvg(getNumbers()));
    }


}
