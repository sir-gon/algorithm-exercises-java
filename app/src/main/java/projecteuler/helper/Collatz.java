package projecteuler.helper;

/**
 * Collatz helper.
 */
public class Collatz {

  /**
   * Collatz of array of numbers.
   */
  public static Long collatz(Long n) {

    if (n % 2 == 0) {
      return n / 2;
    }
    return 3 * n + 1;
  }
}
