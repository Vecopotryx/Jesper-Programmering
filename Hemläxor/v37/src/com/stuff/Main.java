package com.stuff;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Definerar input som en ny Scanner.

        System.out.print("Vad är ditt namn? ");
        String namn = input.next();

        System.out.println(namn);


    }
}
