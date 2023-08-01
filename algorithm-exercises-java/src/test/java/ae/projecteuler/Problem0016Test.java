package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class Problem0016Test {
  @Test void problem0016() {

    Integer base = 2;
    Integer exponent = 1000;
    String solutionExpected = "1366";

    String solutionFound = Problem0016.problem0016(base, exponent);

    assertEquals(solutionExpected, solutionFound,
        String.format("Problem 0016 answer must be: %s", solutionExpected)
    );
  }
}
