package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marti on 15/01/16.
 */
public class Question2 {

    public static void main(String[] ags) {
        Question2 q = new Question2();
        q.start();
    }

    public void start() {
        System.out.println("The average of the ten doubles is: "+ Math.round(average(inputDoubles())) +"");

    }

    private List<Double> inputDoubles() {
        Input in = new Input();
        List<Double> list = new ArrayList<>();
        int counter = 0;
        System.out.println("Please, input 10 doubles.");

        while (counter < 10) {
            System.out.print("Input double number "+ (counter+1) +": ");
            if (in.hasNextDouble()) {
                list.add(in.nextDouble());
                counter++;
            } else {
                in.next();
            }
        }
        return list;
    }

    private double average(List<Double> list) {
        double sum = 0;

        for (double num : list) {
            sum += num;
        }

        return sum/list.size();
    }
}
