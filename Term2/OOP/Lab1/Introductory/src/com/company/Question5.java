package com.company;

/**
 * Created by Marti on 14/01/16.
 */
public class Question5 {

    public static void main(String[] ags) {
        new Question5().run();
    }

    public void run() {
        testForPalindrome(getInput());
    }

    private String getInput() {
        Input in = new Input();

        while (true) {
            System.out.print("Please enter some text: ");
            if (in.hasNextLine()) {
                return in.nextLine();
            }
            System.out.print("You didn't enter any text, please try again.");
        }
    }

    private void testForPalindrome(String s) {
        s = tidyString(s);
        String reversed = reverseString(s);

        if (check(s, reversed)) {
            System.out.println("The text provided is a palindrome.");
        } else System.out.println("The text provided is not a palindrome.");
    }

    private String tidyString(final String s) {
        return s.replaceAll(" ","").toLowerCase();
    }

    private String reverseString(String s) {
        String reversed = new String();
        for (int i = 1; i < s.length()+1; i++) {
            reversed += Character.toString(s.charAt(s.length()-i));
        }
        return reversed;
    }

    private boolean check(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }


}
