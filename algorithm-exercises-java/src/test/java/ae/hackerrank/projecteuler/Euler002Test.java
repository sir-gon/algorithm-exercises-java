package ae.hackerrank.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class Euler002Test {

  @ParameterizedTest
  @CsvSource({
      "10, 10, Sample Test case 0 -> 1",
      "100, 44, Sample Test case 0 -> 2",
  })
  void euler001(
      int n,
      long answer,
      String testCase) {

    Long solutionFound = Euler002.euler002(n);

    String log = String.format("Problem 002 %s answer must be: %d", testCase, answer);
    assertEquals(answer, solutionFound, log);
  }
}
