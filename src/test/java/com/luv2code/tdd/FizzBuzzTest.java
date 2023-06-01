package com.luv2code.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    @DisplayName("Divisible by three")
    @Order(1)
    @Test
    void testForDivisibleByThree() {
        String str = "Fizz";
        assertEquals(str, FizzBuzz.compute(3), "Should return Fizz");
    }

    @DisplayName("Divisible by five")
    @Order(2)
    @Test
    void testForDivisibleByFive() {
        String str = "Buzz";
        assertEquals(str, FizzBuzz.compute(5), "Should return Buzz");
    }

    @DisplayName("Divisible by three and five")
    @Order(3)
    @Test
    void testForDivisibleByThreeAndFive() {
        String str = "FizzBuzz";
        assertEquals(str, FizzBuzz.compute(15), "Should return FizzBuzz");
    }

    @DisplayName("Not Divisible by three or five")
    @Order(4)
    @Test
    void testForNotDivisibleByThreeOrFive() {
        String str = "1";
        assertEquals(str, FizzBuzz.compute(1), "Should return 1");
    }

    @DisplayName("Testing with small data file")
    @Order(5)
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    void testForSmallTestDataFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }

    @DisplayName("Testing with medium data file")
    @Order(6)
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/medium-test-data.csv")
    void testForMediumTestDataFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }

    @DisplayName("Testing with large data file")
    @Order(7)
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    void testForLargeTestDataFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }
}
