package projecteuler.helper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Divisors helper.
 */
public class Divisors {

  int cycles = 0;

  /**
   * Calculate divisors of a natural number.
   *
   * @param _number number to calculate their divisors
   * @return Long
   */
  public Long[] calculateDivisors(Long _number) {

    // Reset cycles counter
    this.cycles = 0;

    Long top = Math.abs(_number);
    Long target = Math.abs(_number);

    ArrayList<Long> divs = new ArrayList<Long>();

    divs.add(1L);

    if (top == 1) {
      return divs.toArray(Long[]::new);
    }

    int init = 2;
    int i = init;
    while (i <= top) {

      top = target / i;

      if (top > 2 && target % i == 0) {
        divs.add(Long.valueOf(i));

        if (i < top) {
          divs.add(target / i);
        }
      }
      i += 1;
    }

    cycles = i - init;

    divs.add(target);

    // sort divisors
    Long[] answer = divs.toArray(Long[]::new);
    Arrays.sort(answer);

    return answer;

  }

  public Integer getCycles() {
    return this.cycles;
  }

  /**
   * Calculate divisors of a number.
   */
  public static Long[] divisors(Long _number) {

    Divisors self = new Divisors();
    Long[] result = self.calculateDivisors(_number);

    return result;
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
  public static DivisorsAbundance abundance(Long _number) {
    Long[] divisors = Divisors.divisors(_number);
    Long divSum = Sum.sum(divisors) - _number;

    if (divSum > _number) {
      return DivisorsAbundance.DIVISORS_ABUNDANT;
    }

    if (divSum < _number) {
      return DivisorsAbundance.DIVISORS_DEFICIENT;
    }

    return DivisorsAbundance.DIVISORS_PERFECT;
  }
}
