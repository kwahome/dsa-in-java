package com.example.algos;

import java.util.ArrayList;
import java.util.List;

import com.example.TestScenario;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {

    @Test
    public void shouldCheckIfStringIsPalindrome() {
        List<TestScenario<String, Boolean>> testScenarios = new ArrayList<>();
        testScenarios.add(new TestScenario<String, Boolean>("aba", true));
        testScenarios.add(new TestScenario<String, Boolean>("mom", true));
        testScenarios.add(new TestScenario<String, Boolean>("dad", true));
        testScenarios.add(new TestScenario<String, Boolean>("a", true));
        testScenarios.add(new TestScenario<String, Boolean>("aa", true));
        testScenarios.add(new TestScenario<String, Boolean>("evil olive", true));
        testScenarios.add(new TestScenario<String, Boolean>("borrow or rob", true));
        testScenarios.add(new TestScenario<String, Boolean>("never odd or even", true));
        testScenarios.add(new TestScenario<String, Boolean>("this is not a palindrome", false));

        for (TestScenario<String, Boolean> testScenario : testScenarios) {
            System.out.println(testScenario.getTestInput());

            Assert.assertEquals(testScenario.getExpected(),
                    Palindrome.isPalindrome(testScenario.getTestInput()));
        }
    }

    @Test
    public void shouldReturnTheLongestSubsequenceThatIsAPalindrome() {
        List<TestScenario<String, String>> testScenarios = new ArrayList<>();
        testScenarios.add(new TestScenario<String, String>("aba", "aba"));
        testScenarios.add(new TestScenario<String, String>("ABBDCACB", "BCACB"));
        testScenarios.add(new TestScenario<String, String>("", ""));

        for (TestScenario<String, String> testScenario : testScenarios) {
            System.out.println(testScenario.getTestInput());

            Assert.assertEquals(testScenario.getExpected(),
                    Palindrome.findLongestPalindromicSubsequence(testScenario.getTestInput()));
        }
    }

    @Test
    public void shouldReturnTheLongestSubstringThatIsAPalindrome() {
        List<TestScenario<String, String>> testScenarios = new ArrayList<>();
        testScenarios.add(new TestScenario<String, String>("aba", "aba"));
        testScenarios.add(new TestScenario<String, String>("ABBDCACB", "CAC"));
        testScenarios.add(new TestScenario<String, String>("bananas", "anana"));
        testScenarios.add(new TestScenario<String, String>("abdcbcdbdcbbc", "bdcbcdb"));
        testScenarios.add(new TestScenario<String, String>("", ""));

        for (TestScenario<String, String> testScenario : testScenarios) {
            System.out.println(testScenario.getTestInput());

            Assert.assertEquals(testScenario.getExpected(),
                    Palindrome.findLongestPalindromicSubstring(testScenario.getTestInput()));
        }
    }

    @Test
    public void shouldReturnMinimumDeletionsToMakePalindrome() {
        // spaces ignored
        List<TestScenario<String, Integer>> testScenarios = new ArrayList<>();
        testScenarios.add(new TestScenario<String, Integer>("aba", 0));
        testScenarios.add(new TestScenario<String, Integer>("mom", 0));
        testScenarios.add(new TestScenario<String, Integer>("dad", 0));
        testScenarios.add(new TestScenario<String, Integer>("a", 0));
        testScenarios.add(new TestScenario<String, Integer>("aa", 0));
        testScenarios.add(new TestScenario<String, Integer>("evil olive", 0));
        testScenarios.add(new TestScenario<String, Integer>("borrow or rob", 0));
        testScenarios.add(new TestScenario<String, Integer>("never odd or even", 0));
        testScenarios.add(new TestScenario<String, Integer>("aebcbda", 2));
        testScenarios.add(new TestScenario<String, Integer>("this is not a palindrome", 15));

        for (TestScenario<String, Integer> testScenario : testScenarios) {
            System.out.println(testScenario.getTestInput());

            Assert.assertEquals(testScenario.getExpected(),
                    Palindrome.minDeletionsToPalindrome(testScenario.getTestInput(), true));
        }

        // spaces not ignored
        testScenarios = new ArrayList<>();
        testScenarios.add(new TestScenario<String, Integer>("aba", 0));
        testScenarios.add(new TestScenario<String, Integer>("mom", 0));
        testScenarios.add(new TestScenario<String, Integer>("dad", 0));
        testScenarios.add(new TestScenario<String, Integer>("a", 0));
        testScenarios.add(new TestScenario<String, Integer>("aa", 0));
        testScenarios.add(new TestScenario<String, Integer>("evil olive", 1));
        testScenarios.add(new TestScenario<String, Integer>("borrow or rob", 2));
        testScenarios.add(new TestScenario<String, Integer>("never odd or even", 3));
        testScenarios.add(new TestScenario<String, Integer>("aebcbda", 2));
        testScenarios.add(new TestScenario<String, Integer>("this is not a palindrome", 17));

        for (TestScenario<String, Integer> testScenario : testScenarios) {
            System.out.println(testScenario.getTestInput());

            Assert.assertEquals(testScenario.getExpected(),
                    Palindrome.minDeletionsToPalindrome(testScenario.getTestInput(), false));
        }
    }

}
