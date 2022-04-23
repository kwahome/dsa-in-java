package com.example.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.TestScenario;

import org.junit.Assert;
import org.junit.Test;

public class MexicanWaveSortTest {

    @Test
    public void shouldSortInWaveForm() {
        List<Integer[]> testScenarios = new ArrayList<>();

        testScenarios.add(new Integer[] { 10, 5, 6, 3, 2, 20, 100, 80 });
        testScenarios.add(new Integer[] { 2, 4, 6, 8, 10, 20 });

        for (Integer[] testScenario : testScenarios) {
            assertSortedInWave(MexicanWaveSort.sort(testScenario));
        }
    }

    private void assertSortedInWave(Integer[] array) {

        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length - 1; i++) {
            if (i % 2 == 0) {
                Assert.assertTrue(array[i] <= array[i + 1]);
            } else {
                Assert.assertTrue(array[i] >= array[i + 1]);
            }
        }
    }
}
