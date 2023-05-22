package projecteuler.helper;

/**
 * Prime number helper.
 */
public class Prime {

  /**
   * Checks if number is prime.
   */
  public static Boolean isPrime(int _number) {

    if (_number == 0 || _number == 1) {
      return false;
    }

    for (int i = 2; i < _number; i++) {
      if (_number % i == 0) {
        return false;
      }
    }

    return true;
  }
}
