package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class Problem0023Test {
  @ParameterizedTest
  @CsvSource({
      "12, 24, 276, Test Case 1",
      "12, 25, 301, Test Case 2",
  })
  void problem0023smallCase1(
      int inputUnderLimit,
      int inputSuperLimit,
      int answer,
      String testCase) {

    Integer solutionFound = Problem0023.problem0023(inputUnderLimit, inputSuperLimit);

    String log = String.format("Problem 0023 %s answer must be: %d", testCase, answer);
    assertEquals(answer, solutionFound, log);
  }

  @EnabledIfEnvironmentVariable(named = "BRUTEFORCE", matches = "TRUE")
  @Test void problem0023fullCase() {

    Integer answer = 4179871;
    Integer inputUnderLimit = 12;
    Integer inputSuperLimit = 28123;
    Integer solutionFound = Problem0023.problem0023(inputUnderLimit, inputSuperLimit);

    assertEquals(answer, solutionFound,
        String.format("Problem 0023 answer must be: %d", answer)
    );
  }
}
