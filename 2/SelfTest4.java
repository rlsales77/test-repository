package com.guide.c2;

public class SelfTest4 {
    public static void main(String[] args) {
        System.out.println("One\nTwo\nThree");
    }
}

// Violates rule 4
class anotherClass {

    // Violates rule 3
    void anotherMethod() {
        
    }
}
