package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class Problem0002Test {

  @Test void problem0002() {
    int answer = 4613732;
    int top = 4000000;
    int solutionFound = Problem0002.problem0002(top);

    assertEquals(answer, solutionFound,
        String.format("Problem 00002 answer must be: %d", answer)
    );
  }
}
