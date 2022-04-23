package com.example.algos;

import java.util.HashMap;
import java.util.Map;

public class CharacterFrequencies {

    public static Character getFirstNonRepeatedChar(String input) {
        if (input == null || input.length() < 1) {
            return null;
        }

        // we need to determine a count of the frequencies
        // of characters in the input string

        // we can use a map to store this count
        Map<Character, Integer> charFrequencies = getCharacterFrequencies(input);

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

    /**
     * Time: O(N) + O(N) = O(N)
     * Space: O(256)
     * 
     * @param input
     * @return
     */
    public static Character getFirstRepeatedCharacter(String input) {
        if (input == null || input.length() < 1) {
            return null;
        }

        Map<Character, Integer> charFrequencies = getCharacterFrequencies(input);

        for (int i = 0; i < input.length(); i++) {
            // O(N)
            Character current = input.charAt(i);

            if (charFrequencies.get(current) > 1) {
                return current;
            }
        }

        return null;
    }

    private static Map<Character, Integer> getCharacterFrequencies(String input) {
        Map<Character, Integer> charFrequencies = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            // O(N)
            Character current = input.charAt(i);

            if (charFrequencies.containsKey(current)) {
                int frequency = charFrequencies.get(current);
                frequency = frequency + 1;
                charFrequencies.put(current, frequency);
            } else {
                charFrequencies.put(current, 1);
            }
        }

        return charFrequencies;
    }
}
