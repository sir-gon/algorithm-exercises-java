package ae.projecteuler;

import ae.projecteuler.helper.WordScore;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import util.CustomLogger;

/**
 * Names scores.
 *
 * @link Problem definition [[docs/projecteuler/problem0022.md]]
 */
public class Problem0022 {

  private Problem0022() {}


  /**
   * Problem 0022.
   */
  public static Integer problem0022(String[] listOfNames) {
    List<String> names = Arrays.asList(listOfNames);
    Collections.sort(names);

    int result = 0;

    for (int i = 0; i < names.size(); i++) {
      result += (i + 1) * WordScore.wordScore(names.get(i));
    }

    String log;

    log = String.format("Problem 00022 solved: %d", result);
    CustomLogger.info(log);

    return result;
  }
}
