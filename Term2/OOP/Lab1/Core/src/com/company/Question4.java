package com.company;

import java.util.List;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Marti on 15/01/16.
 */
public class Question4 {

    public static void main(String[] ags) {
        Question4 q = new Question4();
        q.start();
    }

    public void start() {
        List<Double> values = generateRandom(10000);
        System.out.println("After generating 10000 random values in the range (-1,1) the smallest double has" +
                " been: "+values.get(0)+", the biggest: "+values.get(1)+" and the average: "+values.get(2)+"");
    }

    public List<Double> generateRandom(int n) {
        double smallest = 0;
        double biggest = 0;
        double sum = 0;
        Random gen = new Random();

        for (int i = 0; i < n; i++) {
            double num = gen.nextDouble();

            // This allows us to have the negative doubles
            if (gen.nextBoolean()) num *= -1;

            // Checks to update biggest number
            if (num > biggest) biggest = num;
            // Checks to update smallest number
            if (num < smallest) smallest = num;

            sum += num;
        }

        double average = sum/n;
        return Arrays.asList(smallest, biggest, average);
    }
}
