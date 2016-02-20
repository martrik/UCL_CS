package com.company;

import java.util.Collections;

/**
 * Created by Marti on 20/01/16.
 */
public class Question7 {

    public static void main(String[] ags) {
        Question7 q = new Question7();
        System.out.println(q.toBase(8,2));
    }

    // Converts base 10 number to any other base
    public String toBase(int number, int base) {
        String result = "";

        while (number != 0) {
            int remainder = number % base;
            number /= base;
            result = remainder + result;
        }

        return result;
    }
}
