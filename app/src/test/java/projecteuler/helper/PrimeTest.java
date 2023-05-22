package projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


class PrimeTest {
  class IsPrimeTestCase {
    Integer input;
    Boolean answer;

    IsPrimeTestCase(Integer input, Boolean answer) {
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
      new IsPrimeTestCase(0, false),
      new IsPrimeTestCase(1, false)
    };

    for (IsPrimeTestCase testCase : testCases) {
      assertEquals(testCase.answer, Prime.isPrime(testCase.input));
    }

  }

  @Test void somePrimeNumbersCaseTest() {

    IsPrimeTestCase[] testCases = {
      new IsPrimeTestCase(2, true),
      new IsPrimeTestCase(7, true),
      new IsPrimeTestCase(13, true),
    };

    for (IsPrimeTestCase testCase : testCases) {
      assertEquals(testCase.answer, Prime.isPrime(testCase.input));
    }

  }

  @Test void someNotPrimeNumbersCaseTest() {

    IsPrimeTestCase[] testCases = {
      new IsPrimeTestCase(4, false),
      new IsPrimeTestCase(10, false),
      new IsPrimeTestCase(100, false),
      new IsPrimeTestCase(300, false),
    };

    for (IsPrimeTestCase testCase : testCases) {
      assertEquals(testCase.answer, Prime.isPrime(testCase.input));
    }

  }
}
