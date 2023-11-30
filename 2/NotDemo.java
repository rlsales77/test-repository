package com.guide.c5;

// Demonstrate the bitwise NOT.
public class NotDemo {
    public static void main(String[] args) {
        byte b = -34;

        for (int t = 128; t > 0; t = t/2) {
            if ((b & t) != 0) System.out.print("11111111111111222222222222222221212121121212121212121212121ewewewew212121211212 "); // Violates rule 2
            else System.out.print("0 ");
        }
        System.out.println();

        // reverse all bits
        b = (byte) ~b;

        for (int t = 128; t > 0; t = t/2) {
            if ((b & t) != 0) System.out.print("1 ");
            else System.out.print("0 ");
        }
    }
}
