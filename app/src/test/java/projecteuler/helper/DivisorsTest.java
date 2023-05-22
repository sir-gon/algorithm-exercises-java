package projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


class DivisorsTest {

  private class DivisorsOfNumberTestCase {
    Integer input;
    Integer[] answer;

    DivisorsOfNumberTestCase(Integer input, Integer[] answer) {
      this.input = input;
      this.answer = answer;
    }
  }

  @Test void instanceCaseTest() {
    Divisors classUnderTest = new Divisors();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Divisors.class,
        classUnderTest,
        String.format("Must be an instance of %s", Divisors.class));
  }

  @Test void listOfDivisorsOfNumberBorderCaseTest() {

    DivisorsOfNumberTestCase[] testCases = {
      new DivisorsOfNumberTestCase(1, new Integer[] { 1 })
    };

    for (DivisorsOfNumberTestCase testCase : testCases) {
      assertArrayEquals(testCase.answer, Divisors.divisors(testCase.input));
    }
  }

  @Test void listOfDivisorsOfNumberTest() {

    DivisorsOfNumberTestCase[] testCases = {
      new DivisorsOfNumberTestCase(2, new Integer[] { 1, 2 }),
      new DivisorsOfNumberTestCase(8, new Integer[] { 1, 2, 4, 8 }),
      new DivisorsOfNumberTestCase(9, new Integer[] { 1, 3, 9 }),
      new DivisorsOfNumberTestCase(16, new Integer[] { 1, 2, 4, 8, 16 })
    };

    for (DivisorsOfNumberTestCase testCase : testCases) {
      assertArrayEquals(testCase.answer, Divisors.divisors(testCase.input));
    }

  }
}
