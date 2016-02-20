package com.company;

/**
 * Created by Marti on 17/01/16.
 */
public class Question6 {
    double firstDouble;
    double secondDouble;

    public static void main(String[] ags) {
        Question6 q = new Question6();
        q.storeValues();
    }

    private void storeValues() {
        firstDouble = inputDouble();
        secondDouble = inputDouble();

        System.out.println("The square root of their sum is: " + rootOfSum(firstDouble, secondDouble));
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

