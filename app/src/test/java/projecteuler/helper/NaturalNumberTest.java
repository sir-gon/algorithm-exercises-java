package projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


class NaturalNumberTest {

  @Test void instanceCaseTest() {
    NaturalNumber classUnderTest = new NaturalNumber(0);

    assertNotNull(classUnderTest);
    assertInstanceOf(
        NaturalNumber.class,
        classUnderTest,
        String.format("Must be an instance of %s", NaturalNumber.class));
  }

  private class NextPrimeFactorOfNumberTestCase {
    Integer input;
    Integer factor;
    Integer divisor;
    Integer cycles;

    NextPrimeFactorOfNumberTestCase(
        Integer input, Integer factor, Integer divisor, Integer cycles) {
      this.input = input;
      this.factor = factor;
      this.divisor = divisor;
      this.cycles = cycles;
    }
  }

  @Test void nextPrimeFactorOfNumberTest() {

    NextPrimeFactorOfNumberTestCase[] testCases = {
      new NextPrimeFactorOfNumberTestCase(1, 1, 1, 0),
      new NextPrimeFactorOfNumberTestCase(2, 2, 1, 1),
      new NextPrimeFactorOfNumberTestCase(4, 2, 2, 1),
      new NextPrimeFactorOfNumberTestCase(9, 3, 3, 2),
      new NextPrimeFactorOfNumberTestCase(7, 7, 1, 6),
    };

    for (NextPrimeFactorOfNumberTestCase expected : testCases) {

      NaturalNumber answer = new NaturalNumber(Integer.valueOf(expected.input));

      assertNotNull(answer);
      assertInstanceOf(
          NaturalNumber.class,
          answer,
          String.format("Must be an instance of %s", NaturalNumber.class));

      final Integer answer_factor = answer.getNextPrimeFactor();
      final Integer answer_divisor = answer.getNextDivisor();
      final Integer answer_cycles = answer.getNextPrimeFactorCycles();

      assertEquals(expected.factor, answer_factor);
      assertEquals(expected.divisor, answer_divisor);
      assertEquals(expected.cycles, answer_cycles);
    }
  }


}
