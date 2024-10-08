package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import util.Log;


class Problem0005SimpleTest {


  @Test void problem0005SmallTest() {

    Integer answer = 2520;
    Integer bottom = 1;
    Integer top = 10;
    Integer startFrom = 1;

    Integer solutionFound = Problem0005Simple.problem0005(bottom, top, startFrom);

    assertEquals(answer, solutionFound,
        String.format("Problem 0005 answer must be: %d", answer)
    );

  }

  @Test void problem0005BruteForceCuttedTest() {

    String log;
    log = "Problem 00005 BRUTE FORCE stars...";
    Log.info(log);

    Integer answer = 232792560;
    Integer bottom = 1;
    Integer top = 20;
    Integer startFrom = answer - 1000;
    Integer solutionFound = Problem0005Simple.problem0005(bottom, top, startFrom);

    assertEquals(answer, solutionFound,
        String.format("Problem 0005 BRUTE-FORCE answer must be: %d", answer)
    );

    log = "Problem 00005 BRUTE FORCE ends.";
    Log.info(log);
  }

  @EnabledIfEnvironmentVariable(named = "BRUTEFORCE", matches = "TRUE")
  @Test void problem0005BruteForceFull() {

    String log;
    log = "Problem 00005 BRUTE FORCE stars...";
    Log.info(log);

    Integer answer = 232792560;
    Integer bottom = 1;
    Integer top = 20;
    Integer startFrom = 1;
    Integer solutionFound = Problem0005Simple.problem0005(bottom, top, startFrom);

    assertEquals(answer, solutionFound,
        String.format("Problem 0005 BRUTE-FORCE answer must be: %d", answer)
    );

    log = "Problem 00005 BRUTE FORCE ends.";
    Log.info(log);
  }
}
