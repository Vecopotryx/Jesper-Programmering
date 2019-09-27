package com.stuff;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt() + 1;
        if (1 <= N && N <= 101) {
            for (int i = 1; i < N; i++) {
                System.out.println(i + " Abracadabra");
            }
        }
    }
}
