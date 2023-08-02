package ae;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class Problem0000Test {

  @Test void problem0000() {

    Integer answer = null;
    // Integer input = 0;
    Integer solutionFound = Problem0000.problem0000();

    assertEquals(answer, solutionFound,
        String.format("Problem 0000 answer must be: %d", answer)
    );
  }
}
