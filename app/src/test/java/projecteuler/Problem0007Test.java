package projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

class Problem0007Test {

  @Test void problem0007Instance() {
    Problem0007 classUnderTest = new Problem0007();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0007.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0007.class)
    );
  }

  @Test void problem0007SmallTest() {

    Integer expectedSolution = 13;
    Integer top = 6;
    Integer solutionFound = Problem0007.problem0007(top);

    assertEquals(expectedSolution, solutionFound,
        String.format("Problem 0007 answer must be: %d", expectedSolution)
    );
  }

  @EnabledIfEnvironmentVariable(named = "BRUTEFORCE", matches = "TRUE")
  @Test void problem0007FullTest() {

    Integer expectedSolution = 13;
    Integer top = 6;
    Integer solutionFound = Problem0007.problem0007(top);

    assertEquals(expectedSolution, solutionFound,
        String.format("Problem 0007 answer must be: %d", expectedSolution)
    );
  }
}
