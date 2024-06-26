// ////////////////////////////////////////////////////////////////////////////
// Solution found:
// Sum of first 100 squares = 338350
// Base for Square Of Sum of first 100 = 5050
// Square Of Sum of first 100 = 25502500
// Difference found 25502500 - 338350 =  25164150
// ////////////////////////////////////////////////////////////////////////////

package ae.projecteuler;

/**
 * Sum square difference.
 *
 * @link Problem definition [[docs/projecteuler/problem0006.md]]
 */
class Problem0006 {

  private Problem0006() {}

  static java.util.logging.Logger logger = util.CustomLogger.getLogger();

  /**
   * Problem 0006.
   */
  public static Integer problem0006(Integer bottom, Integer top) {
    Integer answer = 0;

    Integer sumOfSquares = 0;
    Integer baseForSquareOfSum = 0;
    Integer squareOfSum = 0;

    for (Integer i = bottom; i <= top; i++) {
      sumOfSquares += (int) Math.pow(i, 2);
      baseForSquareOfSum += i;
    }

    squareOfSum = (int) Math.pow(baseForSquareOfSum, 2);
    answer = squareOfSum - sumOfSquares;

    String log;
    log = String.format("Sum of first %d squares = %d", top, sumOfSquares);
    logger.fine(log);
    log = String.format("Base for Square Of Sum of first %d = %d", top, baseForSquareOfSum);
    logger.fine(log);
    log = String.format("Square Of Sum of first %d = %d", top, squareOfSum);
    logger.fine(log);

    log = String.format("Difference found %d - %d = %d",
        squareOfSum,
        sumOfSquares,
        squareOfSum - sumOfSquares);
    logger.fine(log);

    log = String.format("Problem 00006 solved: %d", answer);
    logger.info(log);

    return answer;
  }

}
