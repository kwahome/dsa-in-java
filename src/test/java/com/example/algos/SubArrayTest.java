package com.example.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.TestScenario;

import org.junit.Assert;
import org.junit.Test;

public class SubArrayTest {

    @Test
    public void shouldReturnTrueIfArrayHasSubarrayWithSum() {
        List<TestScenario<Integer[], Boolean>> testScenarios = new ArrayList<>();
        testScenarios
                .add(new TestScenario<Integer[], Boolean>(new Integer[] { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }, true));
        testScenarios
                .add(new TestScenario<Integer[], Boolean>(new Integer[] { 3, 4, }, false));
        testScenarios
                .add(new TestScenario<Integer[], Boolean>(new Integer[] { 0, }, true));

        for (TestScenario<Integer[], Boolean> testScenario : testScenarios) {
            System.out.println(testScenario.getTestInput());

            Assert.assertEquals(testScenario.getExpected(),
                    SubArray.hasSubarrayWithSum(testScenario.getTestInput(), 0));
        }

        // testScenarios = new ArrayList<>();
        // testScenarios
        // .add(new TestScenario<Integer[], Boolean>(new Integer[] { 3, 4, -7, 3, 1, 3,
        // 1, -4, -2, -2 }, true));
        // testScenarios
        // .add(new TestScenario<Integer[], Boolean>(new Integer[] { 3, 4, 6 }, false));
        // testScenarios
        // .add(new TestScenario<Integer[], Boolean>(new Integer[] { 0, }, false));
        // testScenarios
        // .add(new TestScenario<Integer[], Boolean>(new Integer[] { 9, }, true));
        // testScenarios
        // .add(new TestScenario<Integer[], Boolean>(new Integer[] { -1, 0, 1, 7 },
        // false));

        // for (TestScenario<Integer[], Boolean> testScenario : testScenarios) {
        // System.out.println(Arrays.toString(testScenario.getTestInput()));

        // Assert.assertEquals(testScenario.getExpected(),
        // SubArray.hasSubarrayWithSum(testScenario.getTestInput(), 9));
        // }
    }
}
