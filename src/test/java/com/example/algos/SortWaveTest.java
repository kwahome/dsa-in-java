package com.example.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.TestScenario;

import org.junit.Assert;
import org.junit.Test;

public class SortWaveTest {

    @Test
    public void shouldSortInWaveForm() {
        List<TestScenario<Integer[], Integer[]>> testScenarios = new ArrayList<>();

        testScenarios.add(new TestScenario<Integer[], Integer[]>(
                new Integer[] { 10, 5, 6, 3, 2, 20, 100, 80 },
                new Integer[] { 3, 2, 6, 5, 20, 10, 100, 80 }));

        testScenarios.add(new TestScenario<Integer[], Integer[]>(
                new Integer[] { 2, 4, 6, 8, 10, 20 },
                new Integer[] { 4, 2, 8, 6, 20, 10 }));

        for (TestScenario<Integer[], Integer[]> testScenario : testScenarios) {
            Integer[] actual = SortWave.sortInWave(testScenario.getTestInput());

            System.out.println(Arrays.toString(testScenario.getTestInput()));
            System.out.println(Arrays.toString(actual));

            Assert.assertArrayEquals(testScenario.getExpected(), actual);
        }
    }
}
