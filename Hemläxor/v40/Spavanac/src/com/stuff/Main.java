package com.stuff;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int H = input.nextInt();
        int M = input.nextInt();
        M = M - 45;
        if (M < 0) {
            H--;
            M = M + 60;
        }

        if (H < 0) {
            H = H + 24;
        }

        System.out.println(H + " " + M);
    }
}
