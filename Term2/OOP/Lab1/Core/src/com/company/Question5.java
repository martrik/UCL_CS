package com.company;

/**
 * Created by Marti on 15/01/16.
 */
public class Question5 {

    public static void main(String[] ags) {
        Question5 q = new Question5();
        System.out.println("The square root of their sum is: " + q.rootOfSum(q.inputDouble(), q.inputDouble()));
    }

    public double inputDouble() {
        Input in = new Input();

        while (true) {
            System.out.print("Please enter a double: ");
            if (in.hasNextDouble()) return in.nextDouble();
        }
    }

    public double rootOfSum(double first, double second) {
        return Math.sqrt(first+second);
    }
}
