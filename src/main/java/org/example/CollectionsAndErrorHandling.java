package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsAndErrorHandling {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(4);
        numbers.add(8);
        numbers.add(8);
        numbers.add(10);
        numbers.add(12);
        numbers.add(14);

        System.out.println("Original list: " + numbers);

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        int sum = 0;
        double average = 0.0;

        try {
            for (int number : uniqueNumbers) {
                sum += number;
            }
            if (!uniqueNumbers.isEmpty()) {
                average = (double) sum / uniqueNumbers.size();
            } else {
                throw new ArithmeticException("Cannot divide by zero - the set is empty.");
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + average);
            System.out.println("List without duplicates: " + uniqueNumbers);
        }

        try {
            System.out.println(numbers.get(10));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException caught: " + e.getMessage());
        }

        try {
            int invalidNumber = Integer.parseInt("abc");
            System.out.println("Parsed invalid number: " + invalidNumber);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        }
    }
}
