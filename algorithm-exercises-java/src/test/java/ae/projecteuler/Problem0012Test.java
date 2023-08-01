package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class Problem0012Test {

  @Test void problem0012() {

    Long expectedSolution = (long) 576;
    Long inputTop = (long) 500;

    Long solutionFound = Problem0012.problem0012(inputTop);

    assertEquals(expectedSolution, solutionFound,
        String.format("Problem 0012 answer must be: %d", expectedSolution)
    );
  }
}
