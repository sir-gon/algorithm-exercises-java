package ae.projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProductTest {

  @Test
  void productOfEmptyListTest() {

    Long[] input = new Long[] {};
    Long expectedAnswer = 0L;

    // Test static way
    assertEquals(expectedAnswer, Product.product(null));
    assertEquals(expectedAnswer, Product.product(input));
  }

  @Test
  void productByZeroTest() {

    Long[] input = new Long[] {0L, -1L, 2L, -3L, 4L};
    Long expectedAnswer = 0L;

    // Test static way
    assertEquals(expectedAnswer, Product.product(input));
  }

  @Test
  void productOfSomeConsecutiveNumbersTest() {

    Long[] input = new Long[] {1L, -2L, 3L, -4L};
    Long expectedAnswer = 24L;

    // Test static way
    assertEquals(expectedAnswer, Product.product(input));
  }

  @Test
  void productOfSomeNegativeAndPositiveNumbersTest() {

    Long[] input = new Long[] {-1L, -2L, 1L, 2L};
    Long expectedAnswer = 4L;

    // Test static way
    assertEquals(expectedAnswer, Product.product(input));
  }
}
