package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class Problem0015Test {
  @Test void problem0015() {

    Integer input = 20;
    Long answer = 137846528820L;
    Long solutionFound = Problem0015.problem0015(input);

    assertEquals(answer, solutionFound,
        String.format("Problem 0015 answer must be: %d", answer)
    );
  }
}
