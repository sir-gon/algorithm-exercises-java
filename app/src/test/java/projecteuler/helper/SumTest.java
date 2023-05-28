package projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


class SumTest {

  @Test void instanceCaseTest() {
    Sum classUnderTest = new Sum();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Sum.class,
        classUnderTest,
        String.format("Must be an instance of %s", Sum.class));
  }

  @Test void productOfEmptyListTest() {

    Long[] input = new Long[]{};
    Long expectedAnswer = 0L;

    // Test static way
    assertEquals(expectedAnswer, Sum.sum(null));
    assertEquals(expectedAnswer, Sum.sum(input));
  }

  @Test void sumOfSomeConsecutiveNumbersTest() {

    Long[] input = new Long[]{1L, 2L, 3L, 4L};
    Long expectedAnswer = 10L;

    // Test static way
    assertEquals(expectedAnswer, Sum.sum(input));
  }

  @Test void sumOfSomepositiveAndNegativeNumbersTest() {

    Long[] input = new Long[]{-1L, -2L, 1L, 2L};
    Long expectedAnswer = 0L;

    // Test static way
    assertEquals(expectedAnswer, Sum.sum(input));
  }

  @Test void sumOfEmptyListTest() {

    Long[] input = new Long[]{};
    Long expectedAnswer = 0L;

    // Test static way
    assertEquals(expectedAnswer, Sum.sum(null));
    assertEquals(expectedAnswer, Sum.sum(input));
  }
}
