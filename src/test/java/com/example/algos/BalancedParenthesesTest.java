package com.example.algos;

import java.util.ArrayList;
import java.util.List;

import com.example.TestScenario;

import org.junit.Assert;
import org.junit.Test;

public class BalancedParenthesesTest {

    @Test
    public void shouldReturnTrueIfBracketsAreBalanced() {
        List<TestScenario<String, Boolean>> testScenarios = new ArrayList<>();
        testScenarios.add(new TestScenario<String, Boolean>("{}", true));
        testScenarios.add(new TestScenario<String, Boolean>("{}{}", true));
        testScenarios.add(new TestScenario<String, Boolean>("{{}}", true));
        testScenarios.add(new TestScenario<String, Boolean>("{{}{}}", true));
        testScenarios.add(new TestScenario<String, Boolean>("{}{{}}", true));
        testScenarios.add(new TestScenario<String, Boolean>("{}{{}}", true));
        testScenarios.add(new TestScenario<String, Boolean>("{{}}{}", true));
        testScenarios.add(new TestScenario<String, Boolean>("{{{}}}", true));
        testScenarios.add(new TestScenario<String, Boolean>("{}{{}}{}", true));
        testScenarios.add(new TestScenario<String, Boolean>("{}}", false));
        testScenarios.add(new TestScenario<String, Boolean>("}{}", false));
        testScenarios.add(new TestScenario<String, Boolean>("{", false));
        testScenarios.add(new TestScenario<String, Boolean>("}", false));
        testScenarios.add(new TestScenario<String, Boolean>("}{", false));
        testScenarios.add(new TestScenario<String, Boolean>("}{}{", false));
        testScenarios.add(new TestScenario<String, Boolean>("{}{{}", false));
        testScenarios.add(new TestScenario<String, Boolean>("{{{}}", false));
        testScenarios.add(new TestScenario<String, Boolean>("}}}{{{", false));

        for (TestScenario<String, Boolean> testScenario : testScenarios) {
            System.out.println(testScenario.getTestInput());

            Assert.assertEquals(testScenario.getExpected(),
                    BalancedParentheses.areParenthesesBalanced(testScenario.getTestInput()));
        }
    }
}
