/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.caeserrr;

import java.util.Scanner;

/**
 *
 * @author nanribet
 */
public class Caeserrr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("MESSAGE ENCRYPTION & DECRYPTION PROGRAM");
        System.out.println();

        System.out.println("Enter text to be encrypted or decrypted: ");
        String inputText = scanner.nextLine();

        System.out.println("Enter shift value to be used: ");
        int shift = scanner.nextInt();

        // Normalize the shift value
        shift = shift % 26;

        System.out.println("Choose an option: ");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        int choice = scanner.nextInt();

        if (choice == 2) {
            shift = -shift; // Reverse the shift for decryption
        }

        String result = encryptDecrypt(inputText, shift);
        System.out.println("Result: " + result);
    }

    public static String encryptDecrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isUpperCase(ch)) {
                char encryptedChar = (char) (((ch - 'A' + shift + 26) % 26) + 'A');
                result.append(encryptedChar);
            } else if (Character.isLowerCase(ch)) {
                char encryptedChar = (char) (((ch - 'a' + shift + 26) % 26) + 'a');
                result.append(encryptedChar);
            } else {
                result.append(ch); // Non-alphabetic characters remain unchanged
            }
        }

        return result.toString();
    }
}
