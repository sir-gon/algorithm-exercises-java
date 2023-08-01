package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


class Problem0012Test {

  @Test void problem0012Instance() {
    Problem0012 classUnderTest = new Problem0012();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0012.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0012.class)
    );
  }

  @Test void problem0012() {

    Long expectedSolution = (long) 576;
    Long inputTop = (long) 500;

    Long solutionFound = Problem0012.problem0012(inputTop);

    assertEquals(expectedSolution, solutionFound,
        String.format("Problem 0012 answer must be: %d", expectedSolution)
    );
  }
}
