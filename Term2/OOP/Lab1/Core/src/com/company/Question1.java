package com.company;

/**
 * Created by Marti on 15/01/16.
 */
public class Question1 {

    public static void main(String[] ags) {
        Question1 q = new Question1();
        q.start();
    }

    public void start() {
        Input in = new Input();

        String inputText = new String();

        while (inputText.compareTo("stop") != 0) {
            if (in.hasNextLine()) {
                inputText = in.nextLine();
            }
        }
    }
}
