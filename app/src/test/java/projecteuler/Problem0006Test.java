package projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class Problem0006Test {

  @Test void problem0006Instance() {
    Problem0006 classUnderTest = new Problem0006();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0006.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0006.class)
    );
  }

  @Test void problem0006() {

    Integer bottom = 1;
    Integer top = 100;

    Integer expectedSolution = 25164150;
    Integer calculated = Problem0006.problem0006(bottom, top);


    assertEquals(expectedSolution, calculated,
        String.format("Problem 0006 answer must be: %d", expectedSolution)
    );
  }
}
