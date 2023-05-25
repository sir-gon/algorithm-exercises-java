package projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
class NaturalNumberTest {

  public class NextPrimeFactorOfNumberTestCase {
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

  private List<NextPrimeFactorOfNumberTestCase> testCases;

  @BeforeAll
  void init() {
    testCases = new ArrayList<NextPrimeFactorOfNumberTestCase>(Arrays.asList(
      new NextPrimeFactorOfNumberTestCase(1, 1, 1, 0),
      new NextPrimeFactorOfNumberTestCase(2, 2, 1, 1),
      new NextPrimeFactorOfNumberTestCase(4, 2, 2, 1),
      new NextPrimeFactorOfNumberTestCase(9, 3, 3, 2),
      new NextPrimeFactorOfNumberTestCase(7, 7, 1, 6)
    ));
  }

  @Test void instanceCaseTest() {
    NaturalNumber classUnderTest = new NaturalNumber(0);

    assertNotNull(classUnderTest);
    assertInstanceOf(
        NaturalNumber.class,
        classUnderTest,
        String.format("Must be an instance of %s", NaturalNumber.class));
  }

  @Test void nextPrimeFactorOfNumberTest() {

    for (NextPrimeFactorOfNumberTestCase expected : this.testCases) {

      NaturalNumber answer = new NaturalNumber(Integer.valueOf(expected.input));

      assertNotNull(answer);
      assertInstanceOf(
          NaturalNumber.class,
          answer,
          String.format("Must be an instance of %s", NaturalNumber.class));

      final Integer answer_factor = answer.getNextPrimeFactor();
      final Integer answer_cached_factor = answer.getNextPrimeFactor();

      assertEquals(expected.factor, answer_factor);
      assertEquals(expected.factor, answer_cached_factor);
    }
  }

  @Test void nextDivisorOfNumberTest() {

    for (NextPrimeFactorOfNumberTestCase expected : this.testCases) {

      NaturalNumber answer = new NaturalNumber(Integer.valueOf(expected.input));

      assertNotNull(answer);
      assertInstanceOf(
          NaturalNumber.class,
          answer,
          String.format("Must be an instance of %s", NaturalNumber.class)
      );

      final Integer answer_divisor = answer.getNextDivisor();
      final Integer answer_cached_divisor = answer.getNextDivisor();

      assertEquals(expected.divisor, answer_divisor);
      assertEquals(expected.divisor, answer_cached_divisor);
    }
  }

  @Test void nextPrimeFactorCyclesTest() {

    for (NextPrimeFactorOfNumberTestCase expected : this.testCases) {

      NaturalNumber answer = new NaturalNumber(Integer.valueOf(expected.input));

      assertNotNull(answer);
      assertInstanceOf(
          NaturalNumber.class,
          answer,
          String.format("Must be an instance of %s", NaturalNumber.class)
      );

      final Integer answer_cycles = answer.getNextPrimeFactorCycles();
      final Integer answer_cached_cycles = answer.getNextPrimeFactorCycles();

      assertEquals(expected.cycles, answer_cycles);
      assertEquals(expected.cycles, answer_cached_cycles);
    }
  }
}
