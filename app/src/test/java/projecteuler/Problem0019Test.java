package projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import projecteuler.constants.Date;


class Problem0019Test {

  @Test void problem0019Instance() {
    Problem0019 classUnderTest = new Problem0019();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0019.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0019.class)
    );

    Date constantsClassUnderTest = new projecteuler.constants.Date();

    assertNotNull(constantsClassUnderTest);
    assertInstanceOf(
        projecteuler.constants.Date.class,
        constantsClassUnderTest,
        String.format("Must be an instance of %s", projecteuler.constants.Date.class)
    );
  }

  @Test void problem0019SmallCase() {

    Integer answer = 2;
    Integer solutionFound = Problem0019.problem0019(
        projecteuler.constants.Date.__SUNDAY__,
        1900,
        1901
    );

    assertEquals(answer, solutionFound,
        String.format("Problem 0019 answer must be: %d", answer)
    );
  }

  @Test void problem0019FullCase() {

    Integer answer = 171;
    Integer solutionFound = Problem0019.problem0019(
        projecteuler.constants.Date.__SUNDAY__,
        1901,
        2000
    );

    assertEquals(answer, solutionFound,
        String.format("Problem 0019 answer must be: %d", answer)
    );
  }
}
