// CHECKSTYLE.OFF: JavadocParagraph

package ae.projecteuler;

import java.text.MessageFormat;

/**
 * Problem 0011.
 */
public class Problem0011 {

  private Problem0011() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();
  private static final String ROW_MESSAGE = "row: i {0}, column: {1}, step {2} => {3}";

  /**
   * Problem 0011.
   *
   * @throws Exception invalid input (matrix or interval lentht)
   */
  public static Integer problem0011(Integer[][] squareMatrix, Integer interval)
      throws IllegalArgumentException {
    Integer top = squareMatrix.length;
    Integer result = 0;
    Integer acum = 0;

    String log;

    for (Integer i = 0; i < top; i++) {

      if (top != squareMatrix[i].length) {
        throw new IllegalArgumentException("Not a square matrix");
      }

      for (Integer j = 0; j < top; j++) {
        log = MessageFormat.format("i: {0}, j: {1}", i, j);
        logger.fine(log);

        acum = 1;

        if (i < top - (interval - 1)) {
          logger.fine("---- VERTICAL ------------------------------------------");
          // vertical

          for (Integer k = 0; k < interval; k++) {
            log = MessageFormat.format(
                Problem0011.ROW_MESSAGE,
                i + k, j, k, squareMatrix[i + k][j]);
            logger.fine(log);
            acum *= squareMatrix[i + k][j];
          }
        }

        result = Math.max(acum, result);

        acum = 1;
        if (j < top - (interval - 1)) {
          logger.fine("---- HORIZONTAL ----------------------------------------");
          // horizontal

          for (Integer k = 0; k < interval; k++) {
            log = MessageFormat.format(
                  Problem0011.ROW_MESSAGE,
                  i, j + k, k, squareMatrix[i][j + k]
            );
            logger.fine(log);
            acum *= squareMatrix[i][j + k];
          }
        }

        result = Math.max(acum, result);

        acum = 1;
        if (i + (interval - 1) < top && j + (interval - 1) < top) {
          // diagonal top left -> bottom right
          logger.fine("---- DIAG \\ ---------------------------------------------");

          for (Integer k = 0; k < interval; k++) {
            log = MessageFormat.format(
              Problem0011.ROW_MESSAGE,
                i, j + k, k, squareMatrix[i + k][j + k]
            );
            logger.fine(log);
            acum *= squareMatrix[i + k][j + k];
          }
        }

        result = Math.max(acum, result);

        acum = 1;
        if (i + (interval - 1) < top && j + (interval - 1) < top) {
          // diagonal top rigth -> bottom left
          logger.fine("---- DIAG / ---------------------------------------------");

          for (Integer k = 0; k < interval; k++) {
            log = MessageFormat.format(
                Problem0011.ROW_MESSAGE,
                i, j + k, k, squareMatrix[i + k][j + (interval - 1) - k]
            );
            logger.fine(log);
            acum *= squareMatrix[i + k][j + (interval - 1) - k];
          }
        }

        result = Math.max(acum, result);
      }
    }

    log = MessageFormat.format("Problem 00011 solved: %{0}", result);
    logger.info(log);

    return result;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
