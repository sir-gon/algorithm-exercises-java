package ae.projecteuler;

import ae.projecteuler.helper.NaturalNumber;
import java.util.ArrayList;
import util.Log;

/**
 * 10001st prime.
 *
 * @link Problem definition [[docs/projecteuler/problem0007.md]]
 */
public class Problem0007 {

  private Problem0007() {}


  /**
   * Problem 0007.
   */
  public static Integer problem0007(Integer top) {
    ArrayList<Integer> primes = new ArrayList<>();
    Integer i = 0;
    Integer j = 2;
    String log;

    while (primes.size() < top) {
      i += 1;
      NaturalNumber number = new NaturalNumber(Long.valueOf(j));
      if (number.isPrime()) {
        primes.add(j);

        log = String.format("Prime found %d put in position: %d", j, primes.size());
        Log.debug(log);
      }

      j = 2 * i + 1;
    }

    log = String.format("primes count: %d", primes.size());
    Log.info(log);

    Integer answer = primes.get(primes.size() - 1);
    Integer cycles = i;

    log = String.format("%d prime number is: %d in %d cycles", top, answer, cycles);
    Log.info(log);

    return answer;
  }
}
