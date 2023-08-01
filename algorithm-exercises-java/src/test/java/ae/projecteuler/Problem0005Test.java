package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.MessageFormat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;


class Problem0005Test {

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

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

    String log;
    log = "Problem 00005 BRUTE FORCE stars...";
    logger.info(log);

    Integer answer = 232792560;
    Integer bottom = 1;
    Integer top = 20;
    Integer solutionFound = Problem0005.problem0005(bottom, top);

    log = MessageFormat.format("Problem 0005 BRUTE-FORCE answer must be: {0}", answer);
    assertEquals(answer, solutionFound,
        log
    );

    log = "Problem 00005 BRUTE FORCE ends.";
    logger.info(log);
  }
}
