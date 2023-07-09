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

    Long expectedAnswer = 0L;

    // Test static way
    Long[] inputNull = null;
    assertEquals(expectedAnswer, Sum.sum(inputNull));

    Long[] inputEmpty = new Long[]{};
    assertEquals(expectedAnswer, Sum.sum(inputEmpty));
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

    Long expectedAnswer = 0L;

    // Test static way
    Long[] inputNull = null;
    assertEquals(expectedAnswer, Sum.sum(inputNull));

    Long[] inputEmpty = new Long[]{};
    assertEquals(expectedAnswer, Sum.sum(inputEmpty));

    Integer expectediAnswer = 0;

    Integer[] inputiNull = null;
    assertEquals(expectediAnswer, Sum.sum(inputiNull));

    Integer[] inputiEmpty = new Integer[]{};
    assertEquals(expectediAnswer, Sum.sum(inputiEmpty));
  }
}
