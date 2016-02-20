package com.company;

/**
 * Created by Marti on 21/01/16.
 */
public class Question12 {

    static public void main(String[] ags) {
        Question12 q = new Question12();
        q.start();
    }

    public void start() {
        reverseAndSaveFile(getFileName());
    }

    // Asks for a file path
    private String getFileName() {
        Input in = new Input();
        while (true) {
            System.out.print("Please enter a text file path:");
            if (in.hasNext()) {
                return in.next();
            }
            System.out.print("You didn't type anything, try again.");
        }
    }

    // Saves a txt reversed copy of a file
    private void reverseAndSaveFile(String path) {
        FileInput in = new FileInput(path);
        FileOutput out = new FileOutput("reverse.txt");

        while (in.hasNextLine()) {
            out.writeString(reverseString(in.nextLine()));
            out.writeEndOfLine();
        }

        out.close();
    }

    // Reverses a string of characters
    private String reverseString(String s) {
        String reversed = new String();
        for (int i = 1; i < s.length()+1; i++) {
            reversed += Character.toString(s.charAt(s.length()-i));
        }
        return reversed;
    }
}
