package projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


class PrimeTest {
  class IsPrimeTestCase {
    Long input;
    Boolean answer;

    IsPrimeTestCase(Long input, Boolean answer) {
      this.input = input;
      this.answer = answer;
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
      new IsPrimeTestCase(0L, false),
      new IsPrimeTestCase(1L, false)
    };

    for (IsPrimeTestCase testCase : testCases) {
      assertEquals(testCase.answer, Prime.isPrime(testCase.input));
    }

  }

  @Test void somePrimeNumbersCaseTest() {

    IsPrimeTestCase[] testCases = {
      new IsPrimeTestCase(2L, true),
      new IsPrimeTestCase(7L, true),
      new IsPrimeTestCase(13L, true),
    };

    for (IsPrimeTestCase testCase : testCases) {
      assertEquals(testCase.answer, Prime.isPrime(testCase.input));
    }

  }

  @Test void someNotPrimeNumbersCaseTest() {

    IsPrimeTestCase[] testCases = {
      new IsPrimeTestCase(4L, false),
      new IsPrimeTestCase(10L, false),
      new IsPrimeTestCase(100L, false),
      new IsPrimeTestCase(300L, false),
    };

    for (IsPrimeTestCase testCase : testCases) {
      assertEquals(testCase.answer, Prime.isPrime(testCase.input));
    }

  }
}
