package com.company;

/**
 * Created by Marti on 21/01/16.
 */
public class Question17 {

    static public void main(String[] ags) {
        Question17 q = new Question17();
        q.printPrimes();
    }

    // Iteartes through all long values and prints them if prime
    public void printPrimes () {
        for (long i = 0; i<Long.MAX_VALUE; i++) {
            if (isPrime(i)) System.out.println(i);
        }
    }

    // Evaluates if a long number is prime
    public boolean isPrime(long num) {
        for (int i = (int)Math.sqrt(num); i>1; i--) {
            if (num%i == 0) return false;
        }
        return true;
    }
}


