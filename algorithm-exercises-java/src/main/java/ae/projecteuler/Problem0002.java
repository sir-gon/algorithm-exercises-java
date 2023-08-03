// CHECKSTYLE.OFF: JavadocParagraph

package ae.projecteuler;

import java.text.MessageFormat;
import java.util.logging.Logger;

/**
 * Even Fibonacci numbers.
 */
public class Problem0002 {

  private Problem0002() {}

  static Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem template method.
   */
  public static Integer problem0002(int top) {

    int i = 0;
    int last1 = 1;
    int last2 = 0;
    int evenSum = 0;

    int fibo = 0;
    do {
      fibo = last2 + last1;

      String log = MessageFormat.format("Fibonacci({0}) = {1}", i, fibo);
      logger.fine(log);

      if (fibo % 2 == 0) {
        evenSum += fibo;
      }

      // next keys:
      last2 = last1;
      last1 = fibo;
      i += 1;
    } while (fibo < top);

    String log = MessageFormat.format("Problem 0002 result: {0}", evenSum);
    logger.info(log);

    return evenSum;
  }

}

//CHECKSTYLE.ON: JavadocParagraph