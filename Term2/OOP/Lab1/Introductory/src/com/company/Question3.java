package com.company;

/**
 * Created by Marti on 14/01/16.
 */
public class Question3 {
    public static void main(String[] ags) {
        new Question3().requestMultiplicationTable();
    }

    public void requestMultiplicationTable() {
        Input in = new Input();
        while(true) {
            System.out.print("Enter a number between 2 and 12: ");
            if (in.hasNextInt()) {
                int n = in.nextInt();
                if (n >= 2 && n <= 12) {
                    displayTable(n);
                    break;
                }
                System.out.print("The number isn't between the desired range, try again.");
            }
        }
    }

    private void displayTable(int n) {
        System.out.println("This is the multiplication table of number " + n + ":");
        for (int i = 1; i < 11; i++) {
            System.out.println(n + "x" + i + " = " + i*n);
        }
    }
}
