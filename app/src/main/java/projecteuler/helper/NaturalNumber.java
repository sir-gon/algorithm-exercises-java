package projecteuler.helper;

import java.util.ArrayList;

// CHECKSTYLE.OFF: JavadocParagraph
/**
 * NaturalNumber.
 */
public class NaturalNumber {

  private Integer __value = null;
  private Integer __nextPrimeFactor = null;
  private Integer __nextDivisor = null;
  private Integer __nextPrimeFactorCycles = null;

  private Integer[] __primeFactors = null;
  private Integer __primeFactorsCycles = null;

  public NaturalNumber(Integer value) {
    this.__value = value;
  }

  public Integer getValue() {
    return this.__value;
  }

  /**
   * Get cycles the next minimal prime factor.
   *
   * If the prime factor has not yet been computed, then it is computed first.
   * That is, this function saves the result in an internal cache.
   */
  public Integer getNextPrimeFactor() {

    if (this.__nextPrimeFactor == null) {
      this.computeNextPrimefactor();
    }

    return __nextPrimeFactor;
  }

  /**
   * Get cycles to compute the next divisor.
   * The divisor is the inverse number of the prime factor,
   * by which the target number is divided to obtain the prime factor.
   *
   * If the prime factor has not yet been computed, then it is computed first.
   * That is, this function saves the result in an internal cache.
   */
  public Integer getNextDivisor() {
    if (this.__nextDivisor == null) {
      this.computeNextPrimefactor();
    }

    return __nextDivisor;
  }

  /**
   * Get cycles to compute the next minimal Prime Factor of a number.
   *
   * If the prime factor has not yet been computed, then it is computed first.
   * That is, this function saves the result in an internal cache.
   */
  public Integer getNextPrimeFactorCycles() {

    if (this.__nextPrimeFactorCycles == null) {
      this.computeNextPrimefactor();
    }

    return __nextPrimeFactorCycles;
  }

  /**
   * Compute the next minimal Prime Factor of a number.
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

  /**
   * Compute a list of prime factors of a number.
   */
  public Integer[] primeFactors() {
    ArrayList<Integer> factors = new ArrayList<Integer>();
    Integer target = Math.abs(this.getValue());
    Integer cycles = 0;

    if (target == 1) {
      factors.add(1);
      this.__primeFactors = factors.toArray(Integer[]::new);
      this.__primeFactorsCycles = cycles;
      return this.__primeFactors;
    }

    Integer partial = target;
    while (partial != 1) {
      NaturalNumber partialNumber = new NaturalNumber(partial);
      Integer primeFactor = partialNumber.getNextPrimeFactor();
      Integer divisor = partialNumber.getNextDivisor();
      cycles += partialNumber.getNextPrimeFactorCycles();

      factors.add(primeFactor);
      partial = divisor;
    }

    this.__primeFactors = factors.toArray(Integer[]::new);
    this.__primeFactorsCycles = cycles;

    return this.__primeFactors;
  }

  /**
   * Get cycles to compute a list of prime factors of a number.
   */
  public Integer getPrimeFactorCycles() {
    if (this.__primeFactorsCycles == null) {
      this.primeFactors();
    }

    return __primeFactorsCycles;
  }
}

//CHECKSTYLE.ON: JavadocParagraph
