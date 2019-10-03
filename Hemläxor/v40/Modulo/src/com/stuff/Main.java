package com.stuff;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[10];
        for(int i = 0; i < 10; i++) {
            numbers[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(numbers));
        int[] modulus = new int[10];
        for(int i = 0; i < 10; i++) {
            modulus[i] = numbers[i]%42;
        }
        System.out.println(Arrays.toString(modulus));
    }
}
