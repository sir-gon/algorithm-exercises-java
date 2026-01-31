package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Problem0010Test {
  @Test
  void problem0010SmallTest() {

    Long expectedSolution = 17L;
    Long bottom = 1L;
    Long top = 10L;
    Long solutionFound = Problem0010.problem0010(bottom, top);

    assertEquals(
        expectedSolution,
        solutionFound,
        String.format("Problem 0010 answer must be: %d", expectedSolution));
  }
}
