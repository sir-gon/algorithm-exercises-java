package projecteuler.helper;

/**
 * Prime number helper.
 */
public class Prime {

  int cycles = 0;

  /**
   * Check if a natural number is prime.
   *
   * @param _number number to calculate prime property
   * @return Boolean
   */
  public Boolean calculateIsPrime(Long _number) {
    this.cycles = 0;

    if (_number == 0 || _number == 1) {
      return false;
    }

    int init = 2;

    for (int i = init; i < _number; i++) {
      this.cycles = i - init;

      if (_number % i == 0) {
        return false;
      }
    }

    return true;
  }

  public Integer getCycles() {
    return this.cycles;
  }

  /**
   * Checks if number is prime.
   */
  public static Boolean isPrime(Long _number) {
    Prime self = new Prime();
    Boolean result = self.calculateIsPrime(_number);

    return result;
  }
}
