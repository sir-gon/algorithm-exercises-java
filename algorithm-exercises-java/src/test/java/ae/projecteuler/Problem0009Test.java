package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class Problem0009Test {

  private static final String OUTPUT_MESSAGE = "Problem 0009 answer must be: %d";

  @Test void problem0009EmptyTest() {

    Integer expectedSolution = null;
    Integer inputLimit = 1;
    Integer solutionFound = Problem0009.problem0009(inputLimit);

    assertEquals(expectedSolution, solutionFound,
        String.format(OUTPUT_MESSAGE, expectedSolution)
    );
  }

  @Test void problem0009EdgeTest() {

    Integer expectedSolution = null;
    Integer inputLimit = 10;
    Integer solutionFound = Problem0009.problem0009(inputLimit);

    assertEquals(expectedSolution, solutionFound,
        String.format(OUTPUT_MESSAGE, expectedSolution)
    );
  }

  @Test void problem0009BasicTest() {

    Integer expectedSolution = 3 * 4 * 5;
    Integer inputLimit = 3 + 4 + 5;
    Integer solutionFound = Problem0009.problem0009(inputLimit);

    assertEquals(expectedSolution, solutionFound,
        String.format(OUTPUT_MESSAGE, expectedSolution)
    );
  }

  @Test void problem0009FullTest() {

    Integer expectedSolution = 200 * 375 * 425;
    Integer inputLimit = 200 + 375 + 425;
    Integer solutionFound = Problem0009.problem0009(inputLimit);

    assertEquals(expectedSolution, solutionFound,
        String.format(OUTPUT_MESSAGE, expectedSolution)
    );
  }
}
