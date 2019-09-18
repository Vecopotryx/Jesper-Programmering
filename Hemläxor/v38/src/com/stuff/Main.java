package com.stuff;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv in 10 heltal: ");
        int[] nummer = new int[10];
        for (int i = 0; i < 10; i++) {
            nummer[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(nummer));

        int min = Arrays.stream(nummer).min().getAsInt();
        System.out.println("Lägst: " + min);
    }
}
