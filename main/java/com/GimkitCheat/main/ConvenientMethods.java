package com.GimkitCheat.main;

public class ConvenientMethods {
    public static void sleep(int x) {
        try {
            Thread.sleep(x);
        } catch(InterruptedException e) {}
    }
}
