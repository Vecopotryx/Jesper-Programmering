package com.stuff;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv in 10 heltal: ");
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {     // put the input into array
            numbers[i] = input.nextInt();
        }

        int max = Arrays.stream(numbers).max().getAsInt();
        int min = Arrays.stream(numbers).min().getAsInt();

        // calculate average
        float sum = Arrays.stream(numbers).sum();
        float average = sum / 10;

        // results
        System.out.println("--------------------------"); // for aesthetic reasons

        System.out.println(Arrays.toString(numbers));
        System.out.println("Högst: " + max);
        System.out.println("Lägst: " + min);
        System.out.println("Medelvärde: " + average);
    }
}
