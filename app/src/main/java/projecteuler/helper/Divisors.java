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

  static class PrimeFactor {
    Integer factor;
    Integer carry;
    Integer cycles;

    PrimeFactor(Integer factor, Integer carry, Integer cycles) {
      this.factor = factor;
      this.carry = carry;
      this.cycles = cycles;
    }
  }

  /**
   * Prime factor Factory.
   *
   * @param factor prime factor
   * @param carry divisor
   * @param cycles number of cycles in which it was calculated
   * @return PrimeFactor
   */
  public static PrimeFactor primeFactor(Integer factor, Integer carry, Integer cycles) {
    Divisors.PrimeFactor result = new PrimeFactor(factor, carry, cycles);

    return result;
  }

  /**
   * Calculate the next minimal prime factor of a number.
   *
   * @param _target number to get the first next prime factor
   * @return PrimeFactor
   */
  public static PrimeFactor nextPrimeFactor(Integer _target) {
    Integer top = Math.abs(_target);

    // default
    Integer factor = top;
    Integer carry = 1;

    final Integer init = 1;
    Integer i = init;

    if (top != 1) {
      do {
        i += 1;
        factor = i;
        carry = top / i;
      } while (i <= top && top % i != 0);
    }

    return new PrimeFactor(factor, carry, i - init);
  }

}
