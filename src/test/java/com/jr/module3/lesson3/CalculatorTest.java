package com.jr.module3.lesson3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 1 sec 96 ms
@TestInstance(TestInstance.Lifecycle.PER_METHOD) // 1 sec 82 ms
class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void beforeAll() { // Very rarely used
        System.out.println("beforeAll CalculatorTest");
    }

    @AfterAll
    static void afterAll() { // Very rarely used
        System.out.println("afterAll");
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        Calculator.reset();
    }

    @AfterEach
    void tearDown() { // Very rarely used
        Calculator.reset();
    }

    @Test
    @Timeout(5)
    void stuckSum() {
        final int expected = 2;

        calculator.sum(1, 1);
        final int actual = calculator.stuckSum(1, 1);

        Assertions.assertEquals(expected, actual);
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class LastResultCheck {

        @BeforeAll
        static void beforeAll() { // Very rarely used
            System.out.println("beforeAll LastResultCheck");
        }

        @Test
        @Order(2)
        void lastResultBeforeAnyOperation() {
            final int expected = 0;

            final int actual = Calculator.getLastResult();

            Assertions.assertEquals(expected, actual);
        }

        @Test
        @Order(1)
        void lastResultAfterAnyOperation() {
            final int expected = 2;

            calculator.sum(1, 1);
            final int actual = Calculator.getLastResult();

            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    class SumChecks {
        @Test
        @DisplayName("Check sum of two positive numbers")
        void test1() {
            // Init
            final int expected = 2;

            // Test
            final int actual = calculator.sum(1, 1);

            // Checks
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void sumNegativeNumbers() {
            // Init
            final int expected = -2;

            // Test
            final int actual = calculator.sum(-1, -1);

            // Checks
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void sum_zeroNumbers() {
            // Init
            final int expected = 0;

            // Test
            final int actual = calculator.sum(0, 0);

            // Checks
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void sumNegativeAndPositiveNumbers() {
            // Init
            final int expected = 3;

            // Test
            final int actual = calculator.sum(-3, 6);

            // Checks
            Assertions.assertEquals(expected, actual);
        }

        @RepeatedTest(5)
        void repeatedSumNegativeAndPositiveNumbers() {
            // Init
            final int expected = 3;

            // Test
            final int actual = calculator.sum(-3, 6);

            // Checks
            Assertions.assertEquals(expected, actual);
        }
    }


    @Nested
    class DivCheck {

        @Test
        void divPositiveNumbers() {
            Assertions.assertDoesNotThrow(() -> calculator.div(1, 1));
        }

        @Test
        void divNegativeNumbers() {
            Assertions.assertDoesNotThrow(() -> calculator.div(-1, -1));
        }

        @Test
        void divFirstZeroNumber() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.div(0, 5));
            Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.div(0, 5), "A mustn't be zero");
        }

        @Test
        void divSecondZeroNumber() {
            Assertions.assertDoesNotThrow(() -> calculator.div(5, 0));
        }
    }

}