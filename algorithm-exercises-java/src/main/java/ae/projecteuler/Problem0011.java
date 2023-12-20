package ae.projecteuler;


/**
 * Largest product in a grid.
 *
 * @link Problem definition [[docs/projecteuler/problem0011.md]]
 */
public class Problem0011 {

  private Problem0011() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0011.
   *
   * @throws Exception invalid input (matrix or interval lentht)
   */
  public static Integer problem0011(Integer[][] squareMatrix, Integer interval)
      throws IllegalArgumentException {
    Integer top = squareMatrix.length;
    Integer result = 0;
    int quadrantSize = interval;
    int matrixLimit = squareMatrix.length - (interval - 1);

    String log;

    for (int i = 0; i < matrixLimit; i++) {
      if (top != squareMatrix[i].length) {
        throw new IllegalArgumentException("Not a square matrix");
      }

      for (int j = 0; j < matrixLimit; j++) {
        log = String.format("start point => i: %d, j: %d", i, j);
        logger.fine(log);

        // reset diagonals
        int diag1Acum = 1;
        int diag2Acum = 1;
        for (int k = 0; k < quadrantSize; k++) {
          log = String.format(
            "diag1 coordinate: (i, j) = (%d, %d)",
            i + k,
            j + k
          );
          logger.fine(log);
          log = String.format(
            "diag2 coordinate: (i, j) = (%d, %d)",
            i + k,
            j + (quadrantSize - 1) - k
          );
          logger.fine(log);

          diag1Acum *= squareMatrix[i + k][j + k];
          diag2Acum *= squareMatrix[i + k][j + (quadrantSize - 1) - k];

          result = Math.max(diag1Acum, result);
          result = Math.max(diag2Acum, result);

          // reset lines
          int verticalAcum = 1;
          int horizontalAcum = 1;

          for (int l = 0; l < quadrantSize; l++) {
            log = String.format(
              "vertical coordinate: (i, j) = (%d, %d)",
              i + k,
              j + l
            );
            logger.fine(log);
            log = String.format(
              "horizontal coordinate: (i, j) = (%d, %d)",
              i + l,
              j + k
            );
            logger.fine(log);

            verticalAcum *= squareMatrix[i + k][j + l];
            horizontalAcum *= squareMatrix[i + l][j + k];

            result = Math.max(verticalAcum, result);
            result = Math.max(horizontalAcum, result);
          }
        }
      }
    }

    log = String.format("Problem 0011 solved: %d", result);
    logger.info(log);

    return result;
  }
}
