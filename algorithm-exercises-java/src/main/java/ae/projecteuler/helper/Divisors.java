package ae.projecteuler.helper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Divisors helper.
 */
public class Divisors {

  long cycles = 0;

  /**
   * Calculate divisors of a natural number.
   *
   * @param number number to calculate their divisors
   * @return Long
   */
  public Long[] calculateDivisors(Long number) {

    // Reset cycles counter
    this.cycles = 0;

    Long target = Math.abs(number);
    Long top = Math.abs(number);

    ArrayList<Long> divs = new ArrayList<>();

    divs.add(1L);

    if (top == 1) {
      return divs.toArray(Long[]::new);
    }

    long init = 2;
    long i = init;
    long remainder;
    while (i <= top) {

      top = target / i;
      remainder = target % i;

      if (top > 2 && remainder == 0) {

        if (i <= top) {
          divs.add(i);
        }
        if (i < top) {
          divs.add(top);
        }
      }
      i += 1;
    }

    divs.add(target);

    cycles = i - init;


    // sort divisors
    Long[] answer = divs.toArray(Long[]::new);
    Arrays.sort(answer);

    return answer;

  }

  public Long getCycles() {
    return this.cycles;
  }

  /**
   * Calculate divisors of a number.
   */
  public static Long[] divisors(Long number) {
    return new Divisors().calculateDivisors(number);
  }

  /**
   * DivisorsAbundance.
   */
  public enum DivisorsAbundance {
    DIVISORS_ABUNDANT,
    DIVISORS_DEFICIENT,
    DIVISORS_PERFECT;
  }

  /**
   * Calculate abundance of a number.
   */
  public static DivisorsAbundance abundance(Long number) {
    Long[] divisors = Divisors.divisors(number);
    Long divSum = Sum.sum(divisors) - number;

    if (divSum > number) {
      return DivisorsAbundance.DIVISORS_ABUNDANT;
    }

    if (divSum < number) {
      return DivisorsAbundance.DIVISORS_DEFICIENT;
    }

    return DivisorsAbundance.DIVISORS_PERFECT;
  }
}
