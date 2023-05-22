package projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


class PrimeTest {
  class IsPrimeTestCase {
    Long input;
    Boolean answer;
    Integer cycles;

    IsPrimeTestCase(Long input, Boolean answer, Integer cycles) {
      this.input = input;
      this.answer = answer;
      this.cycles = cycles;
    }
  }

  @Test void instanceCaseTest() {
    Prime classUnderTest = new Prime();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Prime.class,
        classUnderTest,
        String.format("Must be an instance of %s", Prime.class));
  }

  @Test void notPrimeBorderCasesCaseTest() {

    IsPrimeTestCase[] testCases = {
      new IsPrimeTestCase(0L, false, 0),
      new IsPrimeTestCase(1L, false, 0)
    };

    for (IsPrimeTestCase testCase : testCases) {
      assertEquals(testCase.answer, Prime.isPrime(testCase.input));
    }

  }

  @Test void somePrimeNumbersCaseTest() {

    IsPrimeTestCase[] testCases = {
      new IsPrimeTestCase(2L, true, 1),
      new IsPrimeTestCase(7L, true, 7),
      new IsPrimeTestCase(13L, true, 13),
    };

    for (IsPrimeTestCase testCase : testCases) {
      assertEquals(testCase.answer, Prime.isPrime(testCase.input));
    }

  }

  @Test void someNotPrimeNumbersCaseTest() {

    IsPrimeTestCase[] testCases = {
      new IsPrimeTestCase(4L, false, 1),
      new IsPrimeTestCase(10L, false, 1),
      new IsPrimeTestCase(100L, false, 1),
      new IsPrimeTestCase(300L, false, 1),
    };

    for (IsPrimeTestCase testCase : testCases) {
      assertEquals(testCase.answer, Prime.isPrime(testCase.input));
    }

  }
}
