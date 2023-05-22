package projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Problem0003Test {

  @Test void problem0003BorderCaseTest() {

    Integer answer = 2;
    Integer top = 16;
    Integer solutionFound = Problem0003.problem0003(top);

    assertEquals(answer, solutionFound,
        String.format("Problem 00003 answer must be: %d", answer)
    );
  }
}
