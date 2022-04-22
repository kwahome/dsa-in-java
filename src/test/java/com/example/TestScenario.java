package com.example;

public class TestScenario<TestInputType, ExpectedType> {
    private TestInputType testInput;
    private ExpectedType expected;

    public TestScenario(TestInputType testInput, ExpectedType expected) {
        this.testInput = testInput;
        this.expected = expected;
    }

    public TestInputType getTestInput() {
        return this.testInput;
    }

    public ExpectedType getExpected() {
        return this.expected;
    }
}
