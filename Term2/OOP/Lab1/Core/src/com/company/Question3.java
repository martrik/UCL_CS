package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Marti on 15/01/16.
 */
public class Question3 {
    public static void main(String[] ags) {
        Question3 q = new Question3();
        q.start();
    }

    public void start() {
        System.out.println("These are the words reversed and in sorted order: "+ reverseAndSortArray(inputWords()) +"");
    }

    private ArrayList<String> inputWords() {
        Input in = new Input();
        ArrayList<String> list = new ArrayList<>();
        int counter = 0;
        System.out.println("Please, input 10 words.");

        while (counter < 10) {
            System.out.print("Input word number "+ (counter+1) +": ");
            if (in.hasNext()) {
                list.add(in.next());
                counter++;
            } else {
                in.next();
            }
        }
        System.out.println(list);
        return list;
    }

    private ArrayList<String> reverseAndSortArray(ArrayList<String> list) {
        for (String word : list) {
            list.set(list.indexOf(word), reverseString(word));
        }
        Collections.sort(list);
        return list;
    }

    private String reverseString(String s) {
        String reversed = new String();
        for (int i = 1; i < s.length()+1; i++) {
            reversed += Character.toString(s.charAt(s.length()-i));
        }
        return reversed;
    }

}
