package ae.hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class SolveMeFirstTest {

  @Test void solveMeFirst() {

    Integer answer = 5;
    Integer[] input = {2, 3};

    Integer solutionFound = SolveMeFirst.solveMeFirst(input);

    assertEquals(answer, solutionFound,
        String.format("Problem 0000 answer must be: %d", answer)
    );
  }
}
