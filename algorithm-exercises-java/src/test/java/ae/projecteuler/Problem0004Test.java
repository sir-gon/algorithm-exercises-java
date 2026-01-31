package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Problem0004Test {

  @Test
  void problem0004() {

    Integer answer = 906609;
    Integer bottom = 111;
    Integer top = 999;
    Integer solutionFound = Problem0004.problem0004(bottom, top);

    assertEquals(answer, solutionFound, String.format("Problem 0004 answer must be: %d", answer));
  }
}
