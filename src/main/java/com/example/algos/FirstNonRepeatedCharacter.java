package com.example.algos;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

    public static Character getFirstNonRepeatedChar(String input) {
        // we need to determine a count of the frequencies
        // of characters in the input string

        // we can use a map to store this count
        Map<Character, Integer> charFrequencies = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            Character current = input.charAt(i);

            Integer charFrequency = charFrequencies.get(current);

            if (charFrequency == null) {
                // we are seeing this char for the first time
                charFrequencies.put(current, 1);
            } else {
                charFrequencies.put(current, charFrequency + 1);
            }
        }

        // we then loop through the chars in the input string
        // to get the first non repeated, i.e., where count is 1

        for (int i = 0; i < input.length(); i++) {
            Character current = input.charAt(i);

            if (charFrequencies.get(current) == 1) {
                return current;
            }
        }

        return null;
    }
}
