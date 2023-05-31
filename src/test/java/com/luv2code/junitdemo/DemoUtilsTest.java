package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@TestMethodOrder(MethodOrderer.MethodName.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class DemoUtilsTest {

    DemoUtils demoUtils;


    @BeforeAll
    static void setupBeforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    static void setupAfterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
        //System.out.println("Before Each");
    }

    @AfterEach
    void setupAfterEach() {
        //System.out.println("After Each");
    }

    @Test
    void test_Equals_And_Not_Equals() {
        assertEquals(6, demoUtils.add(2, 4), "2 + 4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1 + 9 must not equals 6");
    }

    @Test
    void test_Null_And_Not_Null() {

        String str1 = null;
        String str2 = "luv2code";
        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @Test
    void test_Same_And_Not_Same() {
        String str = "Luv2Code";
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Object should refer to the same object");
        assertNotSame(str, demoUtils.getAcademy(), "Object should not refer to same object");
    }

    @Test
    void test_True_False() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
    }

    @DisplayName("Array Equals")
    @Test
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};
        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Array should be the same");
    }

    @DisplayName("Iterable Equals")
    @Test
    void testIterableEquals(){
        List<String> theList = List.of("luv","2","code");
        assertIterableEquals(theList, demoUtils.getAcademyInList(),"Expected list should be same as actual list");
    }

    @DisplayName("Lines match")
    @Order(0)
    @Test
    void testLineMatch() {
        List<String> theList = List.of("luv","2","code");
        assertLinesMatch(theList, demoUtils.getAcademyInList(),"Lines should match");
    }

    @DisplayName("Throw and Does Not Throw")
    @Order(1)
    @Test
    void testThrowAndDoesNotThrow() {
        assertThrows(Exception.class, () -> {demoUtils.throwException(-1); }, "should throw exception");
        assertDoesNotThrow(() -> {demoUtils.throwException(9);}, "should not throw exception");
    }

    @DisplayName("Timeout")
    @Order(2)
    @Test
    void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> { demoUtils.checkTimeout(); }, "Method should execute in 3 seconds");
    }

    @DisplayName("Multiply")
    @Test
    void testMultiply() {
        assertEquals(12, demoUtils.multiply(4, 3), "4*3 must be 12");
    }
}
