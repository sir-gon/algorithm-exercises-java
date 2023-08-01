package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;


class Problem0023Test {
  @Test void problem0023smallCase1() {

    Integer answer = 276;
    Integer inputUnderLimit = 12;
    Integer inputSuperLimit = 24;
    Integer solutionFound = Problem0023.problem0023(inputUnderLimit, inputSuperLimit);

    assertEquals(answer, solutionFound,
        String.format("Problem 0023 answer must be: %d", answer)
    );
  }

  @Test void problem0023smallCase2() {

    Integer answer = 301;
    Integer inputUnderLimit = 12;
    Integer inputSuperLimit = 25;
    Integer solutionFound = Problem0023.problem0023(inputUnderLimit, inputSuperLimit);

    assertEquals(answer, solutionFound,
        String.format("Problem 0023 answer must be: %d", answer)
    );
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
