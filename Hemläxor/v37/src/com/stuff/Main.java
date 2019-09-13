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

        System.out.print("Vad är din address? ");
        String address = input.nextLine(); // vet inte varför den beter sig så konstigt, men JRE ignorerar den första scannern efter try/catch..

        System.out.print("Vad är ditt postnummer? ");
        String postalCode = input.nextLine();

        System.out.print("Vilken stad bor du i? ");
        String city = input.nextLine();

        System.out.print("Vad är ditt telefonnummer? ");
        String phone = input.nextLine();  // ville inte lagra det i en string, men jaja.

        System.out.println(name);
        System.out.println(age);


    }
}
