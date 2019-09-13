package com.stuff;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Vad är ditt namn? ");
        String name = input.nextLine();

        byte age = 0; // definera age

        try {
            System.out.print("Hur gammal är du? ");
            age = input.nextByte();
        }
        catch(Exception e) {
            System.out.println("Ange något rimligt värde...");
        }


        System.out.println(name);
        System.out.println(age);


    }
}
