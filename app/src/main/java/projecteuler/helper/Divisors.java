package projecteuler.helper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Divisors helper.
 */
public class Divisors {

  /**
   * Calculate divisors of a number.
   */
  public static Long[] divisors(Long _top) {
    Long top = Math.abs(_top);
    Long target = Math.abs(_top);

    ArrayList<Long> divs = new ArrayList<Long>();

    divs.add(1L);

    if (top == 1) {
      return divs.toArray(Long[]::new);
    }

    Long i = 2L;
    while (i <= top) {

      top = target / i;

      if (top > 2 && target % i == 0) {
        divs.add(i);

        if (i < top) {
          divs.add(target / i);
        }
      }
      i += 1;
    }

    divs.add(target);

    // sort divisors
    Long[] answer = divs.toArray(Long[]::new);
    Arrays.sort(answer);

    return answer;
  }
}
