// CHECKSTYLE.OFF: JavadocParagraph
/**
 * Non-abundant sums
 *
 * https://projecteuler.net/problem=23
 *
 * A perfect number is a number for which the sum of its proper
 * divisors is exactly equal to the number. For example, the sum
 * of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28,
 * which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is
 * less than n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the
 * smallest number that can be written as the sum of two abundant numbers is 24.
 * By mathematical analysis, it can be shown that all integers greater
 * than 28123 can be written as the sum of two abundant numbers.
 * However, this upper limit cannot be reduced any further by analysis
 * even though it is known that the greatest number that cannot be expressed
 *  as the sum of two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as
 * the sum of two abundant numbers.
 */

package ae.projecteuler;

import ae.projecteuler.helper.Divisors;
import ae.projecteuler.helper.Divisors.DivisorsAbundance;
import ae.projecteuler.helper.Sum;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Problem 0023.
 */
public class Problem0023 {

  private Problem0023() {}

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  /**
   * Problem 0023.
   */
  public static Integer problem0023(int underLimit, int superLimit) {
    ArrayList<Integer> abundantNumberList = new ArrayList<>();

    // Produce a list of abundant numbers below limit
    for (int i = underLimit; i <= superLimit; i++) {
      DivisorsAbundance abundancyOf = Divisors.abundance((long) i);

      if (abundancyOf == DivisorsAbundance.DIVISORS_ABUNDANT) {
        abundantNumberList.add(i);
      }
    }

    String log;

    log = String.format(
        "abundant nums list size => %d", abundantNumberList.size()
    );
    logger.info(log);
    log = String.format(
        "abundant nums list result: => %s", abundantNumberList
    );
    logger.fine(log);

    ArrayList<Integer> sumsAbundantNums = new ArrayList<>();

    // Produce a list of sums of pair of abundant numbers below limit
    for (int i = 0; i < abundantNumberList.size(); i++) {
      for (int j = 0;
          j < abundantNumberList.size();
          j++
      ) {
        if (abundantNumberList.get(i) + abundantNumberList.get(j) <= superLimit) {
          sumsAbundantNums.add(abundantNumberList.get(i) + abundantNumberList.get(j));
        }
      }
    }

    log = String.format(
        "sumsAbundantNums size => %d", abundantNumberList.size()
    );
    logger.info(log);

    log = String.format(
        "sumsAbundantNums => %s", abundantNumberList
    );
    logger.fine(log);

    ////////////////////
    // filter duplicates
    ////////////////////

    // Create a new LinkedHashSet
    Set<Integer> set = new LinkedHashSet<>();

    // Add the elements to set
    set.addAll(sumsAbundantNums);

    // Clear the list
    sumsAbundantNums.clear();

    // add the elements of set
    // with no duplicates to the list
    sumsAbundantNums.addAll(set);

    log = String.format(
        "sumsAbundantNums size: %d. result => %s",
        sumsAbundantNums.size(),
        sumsAbundantNums);
    logger.fine(log);

    // All numbers below limit that not present in list of sums of pair of abundant numbers
    ArrayList<Integer> found = new ArrayList<>();

    for (int i = 1; i <= superLimit; i++) {
      if (!sumsAbundantNums.contains(i)) {
        found.add(i);
      }
    }

    log = String.format("found: %d, found => %s", found.size(), found);
    logger.fine(log);

    Integer[] foundArr = found.toArray(Integer[]::new);
    Integer result = Sum.sum(foundArr);

    log = String.format("Problem 0023 result: %d", result);
    logger.info(log);

    return result;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
