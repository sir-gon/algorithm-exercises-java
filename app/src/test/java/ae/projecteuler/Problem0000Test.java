package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


class Problem0000Test {

  @Test void problem0000Instance() {
    Problem0000 classUnderTest = new Problem0000();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0000.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0000.class)
    );
  }

  @Test void problem0000() {

    Integer answer = null;
    // Integer input = 0;
    Integer solutionFound = Problem0000.problem0000();

    assertEquals(answer, solutionFound,
        String.format("Problem 0000 answer must be: %d", answer)
    );
  }
}
