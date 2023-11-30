package com.guide.c6;

// This program contains an error and will not compile!
// Compilation error: reference to vaTest is ambiguous
public class VarArgs4 {
    // Violates rule 3
    static void vaTest(int ... v) {

    }

    // Violates rule 3
    static void vaTest(boolean ... v) {

    }

    public static void main(String[] args) {
        vaTest(1, 2, 3); // OK
        vaTest(true, false, false); // OK

//         vaTest(); // Ambiguous!
    }
}
