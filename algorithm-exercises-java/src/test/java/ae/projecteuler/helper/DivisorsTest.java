package ae.projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


class DivisorsTest {

  private class DivisorsOfNumberTestCase {
    Long input;
    Long[] answer;
    Long cycles;

    DivisorsOfNumberTestCase(Long input, Long[] answer, Long cycles) {
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
      new DivisorsOfNumberTestCase(1L, new Long[] { 1L }, 0L)
    };

    for (DivisorsOfNumberTestCase testCase : testCases) {
      assertArrayEquals(testCase.answer, Divisors.divisors(testCase.input));
    }
  }

  @Test void listOfDivisorsOfNumberTest() {

    DivisorsOfNumberTestCase[] testCases = {
      new DivisorsOfNumberTestCase(2L, new Long[] { 1L, 2L }, 1L),
      new DivisorsOfNumberTestCase(8L, new Long[] { 1L, 2L, 4L, 8L}, 2L),
      new DivisorsOfNumberTestCase(9L, new Long[] { 1L, 3L, 9L }, 2L),
      new DivisorsOfNumberTestCase(16L, new Long[] { 1L, 2L, 4L, 8L, 16L}, 3L)
    };

    for (DivisorsOfNumberTestCase testCase : testCases) {

      // Test the instance way
      Divisors classUnderTest = new Divisors();
      Long[] answer = classUnderTest.calculateDivisors(testCase.input);
      Long cycles = classUnderTest.getCycles();

      assertArrayEquals(testCase.answer, answer);
      assertEquals(testCase.cycles, cycles);

      // Test static way
      assertArrayEquals(testCase.answer, Divisors.divisors(testCase.input));
    }
  }

  @Test void abundanceTest() {
    assertEquals(Divisors.DivisorsAbundance.DIVISORS_DEFICIENT, Divisors.abundance(10L));
    assertEquals(Divisors.DivisorsAbundance.DIVISORS_ABUNDANT, Divisors.abundance(12L));
    assertEquals(Divisors.DivisorsAbundance.DIVISORS_PERFECT, Divisors.abundance(28L));
  }

  @Test void abundanceBorderCasesTest() {
    assertNotEquals(Divisors.DivisorsAbundance.DIVISORS_ABUNDANT, Divisors.abundance(110L));
    assertNotEquals(Divisors.DivisorsAbundance.DIVISORS_ABUNDANT, Divisors.abundance(18632L));
  }
}
