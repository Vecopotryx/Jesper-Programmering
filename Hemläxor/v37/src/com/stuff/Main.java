package com.stuff;

import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static byte age; // definera age.
    public static int phone;

    public static void main(String[] args) {

        System.out.print("Vad är ditt namn? ");
        String name = input.nextLine();

        getAge();

        System.out.print("Vad är din address? ");
        String address = input.next();

        System.out.print("Vad är ditt postnummer? ");
        String postalCode = input.next();

        System.out.print("Vilken stad bor du i? ");
        String city = input.next();

        getPhone();

    }

    public static Byte getAge() {
        try {
            System.out.print("Hur gammal är du? ");
            age = input.nextByte();
        }
        catch(Exception e) {
            System.out.println("Ange något rimligt värde...");
        }
        return age;
    }

    public static Integer getPhone() {
        try {
            System.out.print("Vad är ditt telefonnummer? ");
            phone = input.nextInt();
        }
        catch(Exception e) {
            System.out.println("Det där liknar inte ett telefonnummer...");
        }
        return phone;
    }
}
