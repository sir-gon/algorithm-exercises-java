package projecteuler.helper;

/**
 * NaturalNumber.
 */
public class NaturalNumber {

  private Integer __value = null;
  private Integer __nextPrimeFactor = null;
  private Integer __nextDivisor = null;
  private Integer __nextPrimeFactorCycles = null;

  NaturalNumber(Integer value) {
    this.__value = value;
  }

  public Integer getValue() {
    return this.__value;
  }

  /**
   * getNextPrimeFactor.
   */
  public Integer getNextPrimeFactor() {

    if (this.__nextPrimeFactor == null) {
      this.computeNextPrimefactor();
    }

    return __nextPrimeFactor;
  }

  /**
   * getNextDivisor.
   */
  public Integer getNextDivisor() {
    if (this.__nextDivisor == null) {
      this.computeNextPrimefactor();
    }

    return __nextDivisor;
  }

  /**
   * getNextPrimeFactorCycles.
   */
  public Integer getNextPrimeFactorCycles() {

    if (this.__nextPrimeFactorCycles == null) {
      this.computeNextPrimefactor();
    }

    return __nextPrimeFactorCycles;
  }

  /**
   * computeNextPrimefactor.
   */
  public Integer computeNextPrimefactor() {
    Integer top = Math.abs(this.getValue());

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
      } while (top % i != 0);
    }

    this.__nextPrimeFactor = factor;
    this.__nextDivisor = carry;
    this.__nextPrimeFactorCycles = i - init;

    return __nextPrimeFactor;
  }

}
