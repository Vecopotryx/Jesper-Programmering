package com.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[10];
        for(int i = 0; i < 10; i++) {
            numbers[i] = input.nextInt();
        }
        int[] modulus = new int[10];
        for(int i = 0; i < 10; i++) {
            modulus[i] = numbers[i]%42;
        }

        int distinct = 0;
        top:
        for (int i = 0; i < 10; i++) {
            int id = modulus[i];
            for (int j = i + 1; j < 10; j++) {
                if (id == modulus[j]) continue top;
            }
            distinct++;
        }
        System.out.println(distinct);
    }
}
