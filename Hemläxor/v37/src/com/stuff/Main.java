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

        input.nextLine(); // denna linjen behövs tydligen, om jag inte har denna här så skippar den Scanner delen för adressen.

        System.out.print("Vad är ditt postnummer? ");
        String postalCode = input.next();

        input.nextLine(); // samma sak som ovan, den ignorerar en Scanner annars.

        System.out.print("Vilken stad bor du i? ");
        String city = input.next();

        getPhone();

        // ta bort extra spaces.
        name = name.trim();
        address = address.trim();
        postalCode = postalCode.trim();
        city = city.trim();

        // Detta nedan skriver ut informationen.
        System.out.println();
        System.out.println("Information:");
        System.out.println("Namn:     " + name);
        System.out.println("Ålder:    " + age);
        System.out.println("Address:  " + address);
        System.out.println("          " + postalCode + " " + city);
        System.out.println("Telefon   " + phone);

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
