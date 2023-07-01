package projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class Problem0015Test {

  @Test void problem0015Instance() {
    Problem0015 classUnderTest = new Problem0015();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0015.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0015.class)
    );
  }

  @Test void problem0015() {

    Integer input = 20;
    Long answer = 137846528820L;
    Long solutionFound = Problem0015.problem0015(input);

    assertEquals(answer, solutionFound,
        String.format("Problem 0015 answer must be: %d", answer)
    );
  }
}
