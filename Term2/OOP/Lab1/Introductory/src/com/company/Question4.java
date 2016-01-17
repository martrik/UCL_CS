package com.company;

/**
 * Created by Marti on 14/01/16.
 */

import java.util.ArrayList;
import java.util.Collections;

public class Question4 {

    private ArrayList<Integer> numbers = new ArrayList<Integer>();

    public static void main(String[] ags) {
        new Question4().run();
    }

    public void run() {
        inputListOfNumbers();
        sortNumbers();
        displayNumbers();
    }

    private void displayNumbers() {
        for (int i : numbers) {
            System.out.println(i);
        }
    }

    private void sortNumbers() {
        Collections.sort(numbers);
    }

    private void inputListOfNumbers() {
        Input in = new Input();

        while (true) {
            System.out.print("How many numbers do you want to input? ");
            if (in.hasNextInt()) {
                int t = in.nextInt();
                for (int i = 0; i < t; i++) {
                    while (true) {
                        System.out.print("Enter integer (" + i + "): ");
                        if (in.hasNextInt()) {
                            numbers.add(in.nextInt());
                            break;
                        }
                        System.out.print("This is not an integer, try again.");
                    }
                }
                break;
            }
            System.out.print("This is not an integer, try again.");
        }
    }
}
