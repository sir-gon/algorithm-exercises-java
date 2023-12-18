package ae.hackerrank.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class Euler001Test {

  @ParameterizedTest
  @CsvSource({
      "3, 5, 10, 23, Test Case 1",
      "3, 5, 100, 2318, Test Case 2",
      "3, 5, 1000, 233168, Test Case 3"
  })
  void euler001(
      int a,
      int b,
      int n,
      long answer,
      String testCase) {

    Long solutionFound = Euler001.euler001(a, b, n);

    String log = String.format("Problem 0023 {0} answer must be: {1}", testCase, answer);
    assertEquals(answer, solutionFound, log);
  }
}
