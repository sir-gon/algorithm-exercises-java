package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class Problem0021Test {

  @Test void problem0021() {

    int inputStart = 1;
    int inputLimit = 10000;
    String answer = "31626";
    String solutionFound = Problem0021.problem0021(inputStart, inputLimit);

    assertEquals(answer, solutionFound,
        String.format("Problem 0021 answer must be: %s", answer)
    );
  }
}
