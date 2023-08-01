package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;


class Problem0005Test {

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  @Test void problem0005InstanceTest() {
    Problem0005 classUnderTest = new Problem0005();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0005.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0005.class)
    );
  }

  @Test void problem0005() {

    Integer answer = 2520;
    Integer bottom = 1;
    Integer top = 10;
    Integer solutionFound = Problem0005.problem0005(bottom, top);

    assertEquals(answer, solutionFound,
        String.format("Problem 0005 answer must be: %d", answer)
    );

  }

  @EnabledIfEnvironmentVariable(named = "BRUTEFORCE", matches = "TRUE")
  @Test void problem0005BruteForce() {

    Integer answer = 232792560;
    Integer bottom = 1;
    Integer top = 20;
    Integer solutionFound = Problem0005.problem0005(bottom, top);

    logger.info(String.format("Problem 00005 BRUTE FORCE stars..."));

    assertEquals(answer, solutionFound,
        String.format("Problem 0005 BRUTE-FORCE answer must be: %d", answer)
    );

    logger.info(String.format("Problem 00005 BRUTE FORCE ends."));
  }
}
