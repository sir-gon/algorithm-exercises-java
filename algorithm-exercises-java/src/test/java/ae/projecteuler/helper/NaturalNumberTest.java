package ae.projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
    Boolean isPrime;
    Integer cycles;

    NextPrimeFactorOfNumberTestCase(
        Integer input, Integer factor, Integer divisor, Boolean isPrime, Integer cycles) {
      this.input = input;
      this.factor = factor;
      this.divisor = divisor;
      this.isPrime = isPrime;
      this.cycles = cycles;
    }
  }

  private List<NextPrimeFactorOfNumberTestCase> nextPrimeFactorTestCases;

  public class PrimeFactorsOfNumberTestCase {
    Integer input;
    Long[] factors;
    Integer cycles;

    PrimeFactorsOfNumberTestCase(
        Integer input, Long[] factors, Integer cycles) {
      this.input = input;
      this.factors = factors;
      this.cycles = cycles;
    }
  }


  @BeforeAll
  void initNextPrimeFactorOfNumberTestCases() {
    nextPrimeFactorTestCases = new ArrayList<NextPrimeFactorOfNumberTestCase>(Arrays.asList(
      new NextPrimeFactorOfNumberTestCase(1, 1, 1, false, 0),
      new NextPrimeFactorOfNumberTestCase(2, 2, 1, true, 1),
      new NextPrimeFactorOfNumberTestCase(4, 2, 2, false, 1),
      new NextPrimeFactorOfNumberTestCase(9, 3, 3, false, 2),
      new NextPrimeFactorOfNumberTestCase(7, 7, 1, true, 6)
      ));
  }

  private List<PrimeFactorsOfNumberTestCase> primeFactorsTestCases;

  @BeforeAll
  void initPrimeFactorsOfNumberTestCases() {
    primeFactorsTestCases = new ArrayList<PrimeFactorsOfNumberTestCase>(Arrays.asList(
      new PrimeFactorsOfNumberTestCase(1, new Long[]{ 1L }, 0),
      new PrimeFactorsOfNumberTestCase(2, new Long[]{ 2L }, 1),
      new PrimeFactorsOfNumberTestCase(6, new Long[]{ 2L, 3L }, 3),
      new PrimeFactorsOfNumberTestCase(12, new Long[]{ 2L, 2L, 3L }, 4),
      new PrimeFactorsOfNumberTestCase(120, new Long[]{ 2L, 2L, 2L, 3L, 5L }, 9)
    ));
  }

  @Test void instanceCaseTest() {
    NaturalNumber classUnderTest = new NaturalNumber(0L);

    assertNotNull(classUnderTest);
    assertInstanceOf(
        NaturalNumber.class,
        classUnderTest,
        String.format("Must be an instance of %s", NaturalNumber.class));
  }

  @Test void nextPrimeFactorOfNumberTest() {

    for (NextPrimeFactorOfNumberTestCase expected : this.nextPrimeFactorTestCases) {

      NaturalNumber answer = new NaturalNumber(Long.valueOf(expected.input));

      assertNotNull(answer);
      assertInstanceOf(
          NaturalNumber.class,
          answer,
          String.format("Must be an instance of %s", NaturalNumber.class));

      final Long answer_factor = answer.getNextPrimeFactor();
      final Long answer_cached_factor = answer.getNextPrimeFactor();

      assertEquals(Long.valueOf(expected.factor), answer_factor,
          String.format(
            "NaturalNumber'%d'.getNextPrimeFactor() => %d",
            expected.input,
            expected.factor
          )
      );
      assertEquals(Long.valueOf(expected.factor), answer_cached_factor,
          String.format(
            "NaturalNumber'%d'.getNextPrimeFactor() => %d",
            expected.input,
            expected.factor
          )
      );
    }
  }

  @Test void nextDivisorOfNumberTest() {

    for (NextPrimeFactorOfNumberTestCase expected : this.nextPrimeFactorTestCases) {

      NaturalNumber answer = new NaturalNumber(Long.valueOf(expected.input));

      assertNotNull(answer);
      assertInstanceOf(
          NaturalNumber.class,
          answer,
          String.format("Must be an instance of %s", NaturalNumber.class)
      );

      final Long answer_divisor = answer.getNextDivisor();
      final Long answer_cached_divisor = answer.getNextDivisor();

      assertEquals(Long.valueOf(expected.divisor), answer_divisor);
      assertEquals(Long.valueOf(expected.divisor), answer_cached_divisor);
    }
  }

  @Test void nextPrimeFactorCyclesTest() {

    for (NextPrimeFactorOfNumberTestCase expected : this.nextPrimeFactorTestCases) {

      NaturalNumber answer = new NaturalNumber(Long.valueOf(expected.input));

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

  @Test void primeFactorsTest() {

    for (PrimeFactorsOfNumberTestCase expected : this.primeFactorsTestCases) {

      NaturalNumber answer = new NaturalNumber(Long.valueOf(expected.input));

      assertNotNull(answer);
      assertInstanceOf(
          NaturalNumber.class,
          answer,
          String.format("Must be an instance of %s", NaturalNumber.class)
      );

      final Long[] answer_prime_factors = answer.primeFactors();
      final Integer answer_prime_factors_cycles = answer.getPrimeFactorCycles();

      assertArrayEquals(expected.factors, answer_prime_factors);
      assertEquals(expected.cycles, answer_prime_factors_cycles);
    }
  }

  @Test void primeFactorsCyclesWithoutCacheTest() {

    for (PrimeFactorsOfNumberTestCase expected : this.primeFactorsTestCases) {

      NaturalNumber answer = new NaturalNumber(Long.valueOf(expected.input));

      assertNotNull(answer);
      assertInstanceOf(
          NaturalNumber.class,
          answer,
          String.format("Must be an instance of %s", NaturalNumber.class)
      );

      final Integer answer_prime_factors_cycles = answer.getPrimeFactorCycles();

      assertEquals(expected.cycles, answer_prime_factors_cycles);
    }
  }

  @Test void someNotPrimeNumbersCaseTest() {

    for (NextPrimeFactorOfNumberTestCase expected : this.nextPrimeFactorTestCases) {

      // Test the instance way
      NaturalNumber answer = new NaturalNumber(Long.valueOf(expected.input));
      Boolean answerIsPrime = answer.isPrime();
      Integer answerCycles = answer.getNextPrimeFactorCycles();

      assertEquals(expected.isPrime, answerIsPrime);
      assertEquals(expected.cycles, answerCycles);

      // Test Static way
      assertEquals(expected.isPrime, NaturalNumber.isPrime(Long.valueOf(expected.input)));
      assertEquals(expected.cycles, answerCycles);
    }

  }
}
