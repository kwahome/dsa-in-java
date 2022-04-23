package com.example.algos;

import java.util.ArrayList;
import java.util.List;

import com.example.TestScenario;

import org.junit.Assert;
import org.junit.Test;

public class FirstNonRepeatedCharacterTest {

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
                    FirstNonRepeatedCharacter.getFirstNonRepeatedChar(testScenario.getTestInput()));
        }
    }
}
