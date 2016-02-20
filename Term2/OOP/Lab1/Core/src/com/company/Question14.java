package com.company;

/**
 * Created by Marti on 21/01/16.
 */
public class Question14 {

    static public void main(String[] ags) {
        Question14 q = new Question14();
        q.start();
    }

    public void start() {
        printStingFormated(getString());
    }

    // Prints string centered in a 80 char line
    private void printStingFormated(String st) {
        int difference = (80-st.length())/2;
        for (int i = 0; i<80; i++) {
            if (i<difference) System.out.print(" ");
            else if (i>difference && i<difference+st.length()+1) System.out.print(st.charAt(i-difference-1));
            else System.out.print(" ");
        }
    }

    // Asks for a string
    private String getString() {
        Input in = new Input();

        while (true) {
            System.out.print("Please input some text of no more than 80 characters: ");

            if (in.hasNextLine()) {
                String input = in.nextLine();
                if (input.length() <= 80) return input;
            }
        }
    }
}
