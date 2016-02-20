package com.company;

/**
 * Created by Marti on 20/01/16.
 */
public class Question15 {

    public static void main(String[] ags) {
        Question15 q = new Question15();
        q.start();
    }

    public void start() {
        int[] input = getTwoInts();
        System.out.println("This is the result: "+ multiply(input[0], input[1]));
    }

    // Recursively calculates the multiplication of low*low+1*...*up
    static int multiply(int low, int up) {
        if (low == up) return low;
        else return multiply(low+1,up)*low;
    }

    // Asks for two ints
    static int[] getTwoInts() {
        Input in = new Input();

        while (true) {
            System.out.println("Input two integers separated with a space: ");
            if (in.hasNextInt() && in.hasNext()) {
                int ints[] = {in.nextInt(), in.nextInt()};
                return ints;
            }
        }
    }
}
