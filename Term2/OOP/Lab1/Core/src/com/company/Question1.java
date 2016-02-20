package com.company;

/**
 * Created by Marti on 15/01/16.
 */
public class Question1 {

    public static void main(String[] ags) {
        Question1 q = new Question1();
        q.start();
    }

    // Keeps asking for words until you input stop
    public void start() {
        Input in = new Input();

        String inputText = new String();

        while (inputText.compareTo("stop") != 0) {
            System.out.println("Please input a word: ");
            if (in.hasNextLine()) {
                inputText = in.nextLine();
            }
        }
    }
}
