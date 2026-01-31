package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Problem0015Test {
  @Test
  void problem0015() {

    Integer input = 20;
    Long answer = 137846528820L;
    Long solutionFound = Problem0015.problem0015(input);

    assertEquals(answer, solutionFound, String.format("Problem 0015 answer must be: %d", answer));
  }

  @Test
  void problem0015edgeCase() {

    Integer input = 0;
    Long answer = 0L;
    Long solutionFound = Problem0015.problem0015(input);

    assertEquals(answer, solutionFound, String.format("Problem 0015 answer must be: %d", answer));

    input = -1;
    answer = 0L;
    solutionFound = Problem0015.problem0015(input);
    assertEquals(answer, solutionFound, String.format("Problem 0015 answer must be: %d", answer));
  }
}
