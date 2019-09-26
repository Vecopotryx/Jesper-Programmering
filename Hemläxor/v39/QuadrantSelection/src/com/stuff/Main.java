package com.stuff;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        if ((-1000 <= x && x <= 1000) && -1000 <= y && y <= 1000) {
            if (x > 0) {
                if (y > 0) {
                    System.out.println(1);
                } else {
                    System.out.println(4);
                }
            } else if(x < 0) {
                if (y > 0) {
                    System.out.println(2);
                } else {
                    System.out.println(3);
                }
            }
        }
    }
}
