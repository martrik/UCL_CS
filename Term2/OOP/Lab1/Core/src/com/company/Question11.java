package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marti on 20/01/16.
 */
public class Question11 {

    Map<String, Integer> stats = new HashMap<>();

    public static void main(String[] ags) {
        Question11 q = new Question11();
        q.showFile();
    }

    public  void showFile() {
        countChar(getFileName());
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

    // Given a file path counts the repetitions of each character
    private void countChar(String name) {
        FileInput in = new FileInput(name);

        while (in.hasNextChar()) {
            String c = String.valueOf(in.nextChar());
            Integer value;

            // Key present in map
            if (stats.get(c) != null) {
                value = stats.get(c) +1;
            } else value = 1;

            stats.put(c, value);
        }

        System.out.println(stats);
    }
}
