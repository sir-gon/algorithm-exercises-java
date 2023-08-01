package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


class Problem0016Test {

  @Test void problem0016Instance() {
    Problem0016 classUnderTest = new Problem0016();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0016.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0016.class)
    );
  }

  @Test void problem0016() {

    Integer base = 2;
    Integer exponent = 1000;
    String solutionExpected = "1366";

    String solutionFound = Problem0016.problem0016(base, exponent);

    assertEquals(solutionExpected, solutionFound,
        String.format("Problem 0016 answer must be: %s", solutionExpected)
    );
  }
}
