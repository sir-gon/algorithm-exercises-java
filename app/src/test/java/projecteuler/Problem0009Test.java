package projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class Problem0009Test {

  @Test void problem0009Instance() {
    Problem0009 classUnderTest = new Problem0009();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0009.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0009.class)
    );
  }

  @Test void problem0009EmptyTest() {

    Integer expectedSolution = null;
    Integer inputLimit = 1;
    Integer solutionFound = Problem0009.problem0009(inputLimit);

    assertEquals(expectedSolution, solutionFound,
        String.format("Problem 0000 answer must be: %d", expectedSolution)
    );
  }

  @Test void problem0009EdgeTest() {

    Integer expectedSolution = null;
    Integer inputLimit = 10;
    Integer solutionFound = Problem0009.problem0009(inputLimit);

    assertEquals(expectedSolution, solutionFound,
        String.format("Problem 0000 answer must be: %d", expectedSolution)
    );
  }

  @Test void problem0009BasicTest() {

    Integer expectedSolution = 3 * 4 * 5;
    Integer inputLimit = 3 + 4 + 5;
    Integer solutionFound = Problem0009.problem0009(inputLimit);

    assertEquals(expectedSolution, solutionFound,
        String.format("Problem 0000 answer must be: %d", expectedSolution)
    );
  }

  @Test void problem0009FullTest() {

    Integer expectedSolution = 200 * 375 * 425;
    Integer inputLimit = 200 + 375 + 425;
    Integer solutionFound = Problem0009.problem0009(inputLimit);

    assertEquals(expectedSolution, solutionFound,
        String.format("Problem 0000 answer must be: %d", expectedSolution)
    );
  }
}
