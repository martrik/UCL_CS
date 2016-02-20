package com.company;

/**
 * Created by Marti on 20/01/16.
 */
public class Question9 {

    public static void main(String[] ags) {
        Question9 q = new Question9();
        System.out.println(q.isPalindrome(113411));
    }

    // Checks if a natural number is a palindrome
    public boolean isPalindrome(int number) {
        String st = "";
        st += number;
        return st.equals(new StringBuilder(st).reverse().toString());
    }
}
