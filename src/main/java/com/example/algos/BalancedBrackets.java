package com.example.algos;

import java.util.HashMap;
import java.util.Map;

import com.example.ds.stack.LinkedListBasedStack;
import com.example.ds.stack.Stack;

public class BalancedBrackets {

    public static boolean areBracketsBalanced(String input) {
        // a map to store the bracket pairs
        // The key is the opening half
        // while the value is the closing half
        Map<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put('(', ')');
        bracketPairs.put('{', '}');
        bracketPairs.put('[', ']');
        bracketPairs.put('<', '>');

        // a stack to track the balance in the pairs
        Stack<Character> stack = new LinkedListBasedStack<>(input.length());

        for (int i = 0; i < input.length(); i++) {
            Character current = input.charAt(i);

            if (bracketPairs.get(current) != null) {
                // this is an opening pair
                // we want to push it to the stack
                stack.push(current);

                continue;
            }

            if (stack.peek() != null && bracketPairs.get(stack.peek()).equals(current)) {
                // this is the matching pair for the currently open bracket
                // we want to pop the stack
                stack.pop();

                continue;
            }

            // the current char is unknown or is a closing
            // pair coming before an opening one
            return false;
        }

        return stack.isEmpty();
    }

}
