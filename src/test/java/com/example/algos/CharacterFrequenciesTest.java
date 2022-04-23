package com.example.algos;

import java.util.ArrayList;
import java.util.List;

import com.example.TestScenario;

import org.junit.Assert;
import org.junit.Test;

public class CharacterFrequenciesTest {

    @Test
    public void shouldReturnFirstNonRepeatedChar() {
        List<TestScenario<String, Character>> testScenarios = new ArrayList<>();
        testScenarios.add(new TestScenario<String, Character>("a", 'a'));
        testScenarios.add(new TestScenario<String, Character>("ab", 'a'));
        testScenarios.add(new TestScenario<String, Character>("aab", 'b'));
        testScenarios.add(new TestScenario<String, Character>("aba", 'b'));
        testScenarios.add(new TestScenario<String, Character>("baa", 'b'));
        testScenarios.add(new TestScenario<String, Character>("aabb", null));
        testScenarios.add(new TestScenario<String, Character>("ababbabbac", 'c'));

        for (TestScenario<String, Character> testScenario : testScenarios) {
            System.out.println(testScenario.getTestInput());

            Assert.assertEquals(testScenario.getExpected(),
                    CharacterFrequencies.getFirstNonRepeatedChar(testScenario.getTestInput()));
        }
    }

    @Test
    public void shouldReturnEarliestRepeatedCharacter() {
        /**
         * firstRepeatedCharacter("ABCA") returns A
         * 
         * firstRepeatedCharacter("BCABA") returns B
         * 
         * firstRepeatedCharacter("glovol") returns l
         * 
         * firstRepeatedCharacter("ABC") returns null
         */

        List<TestScenario<String, Character>> testScenarios = new ArrayList<>();
        testScenarios.add(new TestScenario<String, Character>("a", null));
        testScenarios.add(new TestScenario<String, Character>("ab", null));
        testScenarios.add(new TestScenario<String, Character>("aab", 'a'));
        testScenarios.add(new TestScenario<String, Character>("aba", 'a'));
        testScenarios.add(new TestScenario<String, Character>("baa", 'a'));
        testScenarios.add(new TestScenario<String, Character>("aabb", 'a'));
        testScenarios.add(new TestScenario<String, Character>("ababbabbac", 'a'));
        testScenarios.add(new TestScenario<String, Character>("ABCA", 'A'));
        testScenarios.add(new TestScenario<String, Character>("BCABA", 'B'));
        testScenarios.add(new TestScenario<String, Character>("glovol", 'l'));
        testScenarios.add(new TestScenario<String, Character>("ABC", null));
        testScenarios.add(new TestScenario<String, Character>("", null));
        testScenarios.add(new TestScenario<String, Character>(null, null));

        for (TestScenario<String, Character> testScenario : testScenarios) {
            System.out.println(testScenario.getTestInput());

            Assert.assertEquals(testScenario.getExpected(),
                    CharacterFrequencies.getFirstRepeatedCharacter(testScenario.getTestInput()));
        }
    }
}
