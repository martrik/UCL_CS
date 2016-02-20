package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marti on 21/01/16.
 */
public class Question16 {

    static public void main(String[] ags) {
        Question16 q = new Question16();
        char[] one = {'h', 'e', 'l', 'l', 'o', 'e', 'l', 'l', 'h', 'o'};
        char[] two = {'e', 'l', 'l', 'h', 'o', 'h', 'e', 'l', 'l', 'o'};

        System.out.println(q.compareCharArrays(one, two));
    }

    // Compares two char arrays not taking into account char positions
    public boolean compareCharArrays(char[] one, char[] two) {
        Map<Character, Integer> oneStat = new HashMap<>();
        Map<Character, Integer> twoStat = new HashMap<>();

        fillMap(one, oneStat);
        fillMap(two, twoStat);

        if (oneStat.keySet().size() == twoStat.keySet().size()) {
            for (Character c : oneStat.keySet()) {
                if (oneStat.get(c) != twoStat.get(c)) return false;
            }
            return true;
        } else return false;
    }

    // Fills map with a char array, using characters as keys and occurrences as values
    private void fillMap(char[] chars, Map<Character, Integer> map) {
        for (char c : chars) {
            Integer value;

            // If key already exists
            if (map.get(Character.valueOf(c)) != null) {
                value = map.get(Character.valueOf(c)) +1;
            } else value = 1;

            map.put(Character.valueOf(c), value);
        }
    }
}
