package ae.projecteuler.helper;

import java.util.ArrayList;

// CHECKSTYLE.OFF: JavadocParagraph
/**
 * NaturalNumber.
 */
public class NaturalNumber {

  private Long value = null;
  private Long nextPrimeFactor = null;
  private Long nextDivisor = null;
  private Integer nextPrimeFactorCycles = null;

  private Integer primeFactorsCycles = null;

  public NaturalNumber(Long value) {
    this.value = value;
  }

  public Long getValue() {
    return this.value;
  }

  /**
   * Get cycles the next minimal prime factor.
   *
   * If the prime factor has not yet been computed, then it is computed first.
   * That is, this function saves the result in an internal cache.
   */
  public Long getNextPrimeFactor() {

    if (this.nextPrimeFactor == null) {
      this.computeNextPrimefactor();
    }

    return nextPrimeFactor;
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
    if (this.nextDivisor == null) {
      this.computeNextPrimefactor();
    }

    return nextDivisor;
  }

  /**
   * Get cycles to compute the next minimal Prime Factor of a number.
   *
   * If the prime factor has not yet been computed, then it is computed first.
   * That is, this function saves the result in an internal cache.
   */
  public Integer getNextPrimeFactorCycles() {

    if (this.nextPrimeFactorCycles == null) {
      this.computeNextPrimefactor();
    }

    return nextPrimeFactorCycles;
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

    this.nextPrimeFactor = factor;
    this.nextDivisor = divisor;
    this.nextPrimeFactorCycles = i - init;

    return nextPrimeFactor;
  }

  /**
   * Compute a list of prime factors of a number.
   */
  public Long[] primeFactors() {
    Long[] primeFactors = null;
    ArrayList<Long> factors = new ArrayList<>();
    Long target = Math.abs(this.getValue());
    Integer cycles = 0;

    if (target == 1L) {
      factors.add(1L);
      primeFactors = factors.toArray(Long[]::new);
      this.primeFactorsCycles = cycles;
      return primeFactors;
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

    primeFactors = factors.toArray(Long[]::new);
    this.primeFactorsCycles = cycles;

    return primeFactors;
  }

  /**
   * Get cycles to compute a list of prime factors of a number.
   */
  public Integer getPrimeFactorCycles() {
    if (this.primeFactorsCycles == null) {
      this.primeFactors();
    }

    return primeFactorsCycles;
  }

  /**
   * Checks if number is prime.
   */
  public boolean isPrime() {
    Long primeFactor = this.getNextPrimeFactor();
    return primeFactor != 1 && primeFactor.equals(this.getValue());
  }

  /**
   * Checks if number is prime. Static way.
   */
  public static Boolean isPrime(Long number) {
    return new NaturalNumber(number).isPrime();
  }
}

//CHECKSTYLE.ON: JavadocParagraph
