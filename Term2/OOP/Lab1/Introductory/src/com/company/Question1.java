package com.company;

/**
 * Created by Marti on 14/01/16.
 */

public class Question1 {

    public static void main(String[] args) {
        new Question1().inputAndProcess();
    }

    public int sumOfDigits(int n)
    {
        int sum = 0;
        n = Math.abs(n);
        while (n > 0)
        {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    public void inputAndProcess() {
        Input in = new Input();
        int n;
        while (true) {
            System.out.print("Type an integer: ");
            if (in.hasNextInt()) {
                n = in.nextInt();
                break;
            }
            in.nextLine();
            System.out.println("You did not type an integer, try again.");
        }
        System.out.print("The sum of the digits of: " + n);
        System.out.println(" is: " + sumOfDigits(n));
    }
}
