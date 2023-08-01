package ae.projecteuler.helper;

import java.util.ArrayList;

// CHECKSTYLE.OFF: JavadocParagraph
/**
 * NaturalNumber.
 */
public class NaturalNumber {

  private Long __value = null;
  private Long __nextPrimeFactor = null;
  private Long __nextDivisor = null;
  private Integer __nextPrimeFactorCycles = null;

  private Long[] __primeFactors = null;
  private Integer __primeFactorsCycles = null;

  public NaturalNumber(Long value) {
    this.__value = value;
  }

  public Long getValue() {
    return this.__value;
  }

  /**
   * Get cycles the next minimal prime factor.
   *
   * If the prime factor has not yet been computed, then it is computed first.
   * That is, this function saves the result in an internal cache.
   */
  public Long getNextPrimeFactor() {

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
  public Long getNextDivisor() {
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
  public Long computeNextPrimefactor() {
    Long top = Math.abs(this.getValue());

    // default
    Long factor = top;
    Long divisor = 1L;

    final Integer init = 1;
    Integer i = init;

    if (top != 1) {
      do {
        i += 1;
        factor = Long.valueOf(i);
        divisor = top / i;
      } while (top % i != 0);
    }

    this.__nextPrimeFactor = factor;
    this.__nextDivisor = divisor;
    this.__nextPrimeFactorCycles = i - init;

    return __nextPrimeFactor;
  }

  /**
   * Compute a list of prime factors of a number.
   */
  public Long[] primeFactors() {
    ArrayList<Long> factors = new ArrayList<Long>();
    Long target = Math.abs(this.getValue());
    Integer cycles = 0;

    if (target == 1L) {
      factors.add(1L);
      this.__primeFactors = factors.toArray(Long[]::new);
      this.__primeFactorsCycles = cycles;
      return this.__primeFactors;
    }

    Long partial = target;
    while (partial != 1) {
      NaturalNumber partialNumber = new NaturalNumber(partial);
      Long primeFactor = partialNumber.getNextPrimeFactor();
      Long divisor = partialNumber.getNextDivisor();
      cycles += partialNumber.getNextPrimeFactorCycles();

      factors.add(primeFactor);
      partial = divisor;
    }

    this.__primeFactors = factors.toArray(Long[]::new);
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

  /**
   * Checks if number is prime.
   */
  public Boolean isPrime() {
    Long primeFactor = this.getNextPrimeFactor();
    if (primeFactor != 1 && primeFactor.equals(this.getValue())) {
      return true;
    }

    return false;
  }

  /**
   * Checks if number is prime. Static way.
   */
  public static Boolean isPrime(Long _number) {
    return new NaturalNumber(_number).isPrime();
  }
}

//CHECKSTYLE.ON: JavadocParagraph
