package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import ae.projecteuler.constants.Date;
import org.junit.jupiter.api.Test;


class Problem0019Test {

  @Test void problem0019Instance() {
    Date constantsClassUnderTest = new ae.projecteuler.constants.Date();

    assertInstanceOf(
        ae.projecteuler.constants.Date.class,
        constantsClassUnderTest,
        String.format("Must be an instance of %s", ae.projecteuler.constants.Date.class)
    );
  }

  @Test void problem0019SmallCase() {

    Integer answer = 2;
    Integer solutionFound = Problem0019.problem0019(
        ae.projecteuler.constants.Date.__SUNDAY__,
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
        ae.projecteuler.constants.Date.__SUNDAY__,
        1901,
        2000
    );

    assertEquals(answer, solutionFound,
        String.format("Problem 0019 answer must be: %d", answer)
    );
  }
}
