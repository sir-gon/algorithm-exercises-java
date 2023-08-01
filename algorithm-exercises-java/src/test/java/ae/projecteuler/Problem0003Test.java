package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class Problem0003Test {

  private static final String OUTPUT_MESSAGE = "Problem 0003 answer must be: %d";

  @Test void problem0003BorderCaseTest() {

    Integer answer = null;
    Long top = 1L;
    Long solutionFound = Problem0003.problem0003(top);

    assertEquals(answer, solutionFound,
        String.format(OUTPUT_MESSAGE, answer)
    );
  }

  @Test void problem0003ShortCaseTest() {

    Long answer = 2L;
    Long top = 16L;
    Long solutionFound = Problem0003.problem0003(top);

    assertEquals(answer, solutionFound,
        String.format(OUTPUT_MESSAGE, answer)
    );
  }

  @Test void problem0003FulltCaseTest() {

    Long answer = 6857L;
    Long top = 600851475143L;
    Long solutionFound = Problem0003.problem0003(top);

    assertEquals(answer, solutionFound,
        String.format(OUTPUT_MESSAGE, answer)
    );
  }
}
