package projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


class DivisorsTest {

  private class DivisorsOfNumberTestCase {
    Long input;
    Long[] answer;
    Integer cycles;

    DivisorsOfNumberTestCase(Long input, Long[] answer, Integer cycles) {
      this.input = input;
      this.answer = answer;
      this.cycles = cycles;
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
      new DivisorsOfNumberTestCase(1L, new Long[] { 1L }, 0)
    };

    for (DivisorsOfNumberTestCase testCase : testCases) {
      assertArrayEquals(testCase.answer, Divisors.divisors(testCase.input));
    }
  }

  @Test void listOfDivisorsOfNumberTest() {

    DivisorsOfNumberTestCase[] testCases = {
      new DivisorsOfNumberTestCase(2L, new Long[] { 1L, 2L }, 1),
      new DivisorsOfNumberTestCase(8L, new Long[] { 1L, 2L, 4L, 8L}, 2),
      new DivisorsOfNumberTestCase(9L, new Long[] { 1L, 3L, 9L }, 2),
      new DivisorsOfNumberTestCase(16L, new Long[] { 1L, 2L, 4L, 8L, 16L}, 3)
    };

    for (DivisorsOfNumberTestCase testCase : testCases) {

      // Test the instance way
      Divisors classUnderTest = new Divisors();
      Long[] answer = classUnderTest.calculateDivisors(testCase.input);
      Integer cycles = classUnderTest.getCycles();

      assertArrayEquals(testCase.answer, answer);
      assertEquals(testCase.cycles, cycles);

      // Test static way
      assertArrayEquals(testCase.answer, Divisors.divisors(testCase.input));
    }

  }

  private class NextPrimeFactorOfNumberTestCase {
    Integer input;
    Divisors.PrimeFactor answer;

    NextPrimeFactorOfNumberTestCase(Integer input, Divisors.PrimeFactor answer) {
      this.input = input;
      this.answer = answer;
    }
  }

  @Test void nextPrimeFactorOfNumberTest() {

    NextPrimeFactorOfNumberTestCase[] testCases = {
      new NextPrimeFactorOfNumberTestCase(
          1,
          Divisors.primeFactor(1, 1, 0)
      ),
      new NextPrimeFactorOfNumberTestCase(
          2,
          Divisors.primeFactor(2, 1, 1)
      ),
      new NextPrimeFactorOfNumberTestCase(
          4,
          Divisors.primeFactor(2, 1, 1)
      ),
      new NextPrimeFactorOfNumberTestCase(
          9,
          Divisors.primeFactor(3, 3, 2)
      ),
      new NextPrimeFactorOfNumberTestCase(
          7,
          Divisors.primeFactor(7, 1, 6)
      )
    };

    for (NextPrimeFactorOfNumberTestCase testCase : testCases) {
      // Test static way
      Divisors.PrimeFactor answer = Divisors.nextPrimeFactor(testCase.input);
      assertNotNull(answer);
      assertInstanceOf(
          Divisors.PrimeFactor.class,
          answer,
          String.format("Must be an instance of %s", Divisors.PrimeFactor.class));

      assertEquals(testCase.answer.factor, answer.factor);
      assertEquals(testCase.answer.cycles, answer.cycles);
    }

  }
}
