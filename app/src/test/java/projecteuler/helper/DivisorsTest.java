package projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;


class DivisorsTest {
  @Test void listOfDivisorsOfNumberTest() {

    Integer[] answer = { 1, 2, 3, 4 };

    Divisors classUnderTest = new Divisors();

    assertArrayEquals(answer, classUnderTest.divisors(0));

  }
}
