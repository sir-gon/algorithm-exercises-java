package ae.projecteuler;

import ae.projecteuler.helper.Divisors;
import ae.projecteuler.helper.Divisors.DivisorsAbundance;
import ae.projecteuler.helper.Sum;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import util.CustomLogger;

/**
 * Non-abundant sums.
 *
 * @link Problem definition [[docs/projecteuler/problem0023.md]]
 */
public class Problem0023 {

  private Problem0023() {}


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
    CustomLogger.info(log);
    log = String.format(
        "abundant nums list result: => %s", abundantNumberList
    );
    CustomLogger.debug(log);

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
    CustomLogger.info(log);

    log = String.format(
        "sumsAbundantNums => %s", abundantNumberList
    );
    CustomLogger.debug(log);

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
    CustomLogger.debug(log);

    // All numbers below limit that not present in list of sums of pair of abundant numbers
    ArrayList<Integer> found = new ArrayList<>();

    for (int i = 1; i <= superLimit; i++) {
      if (!sumsAbundantNums.contains(i)) {
        found.add(i);
      }
    }

    log = String.format("found: %d, found => %s", found.size(), found);
    CustomLogger.debug(log);

    Integer[] foundArr = found.toArray(Integer[]::new);
    Integer result = Sum.sum(foundArr);

    log = String.format("Problem 0023 result: %d", result);
    CustomLogger.info(log);

    return result;
  }
}
