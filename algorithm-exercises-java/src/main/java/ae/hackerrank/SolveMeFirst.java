package ae.hackerrank;

/**
 * Solve Me First.
 *
 * @link Problem definition [[docs/hackerrank/SolveMeFirst.md]]
 */
public class SolveMeFirst {

  private SolveMeFirst() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * solveMeFirst.
   */
  public static Integer solveMeFirst(Integer[] inputs) {

    int total = 0;

    for (Integer name : inputs) {
      total += name;
    }

    String log = String.format("solveMeFirst solved: %d", total);
    logger.info(log);

    return total;
  }
}
