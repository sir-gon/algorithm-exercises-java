package projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


class DivisorsTest {

  private class DivisorsOfNumberTestCase {
    Long input;
    Long[] answer;

    DivisorsOfNumberTestCase(Long input, Long[] answer) {
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
      new DivisorsOfNumberTestCase(1L, new Long[] { 1L })
    };

    for (DivisorsOfNumberTestCase testCase : testCases) {
      assertArrayEquals(testCase.answer, Divisors.divisors(testCase.input));
    }
  }

  @Test void listOfDivisorsOfNumberTest() {

    DivisorsOfNumberTestCase[] testCases = {
      new DivisorsOfNumberTestCase(2L, new Long[] { 1L, 2L }),
      new DivisorsOfNumberTestCase(8L, new Long[] { 1L, 2L, 4L, 8L }),
      new DivisorsOfNumberTestCase(9L, new Long[] { 1L, 3L, 9L }),
      new DivisorsOfNumberTestCase(16L, new Long[] { 1L, 2L, 4L, 8L, 16L })
    };

    for (DivisorsOfNumberTestCase testCase : testCases) {
      assertArrayEquals(testCase.answer, Divisors.divisors(testCase.input));
    }

  }
}
