package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import ae.projecteuler.helper.BigNum;
import org.junit.jupiter.api.Test;

class Problem0020Test {
  @Test void problem0020() {

    Integer inputLimit = 100;
    BigNum answer = new BigNum("648");
    BigNum solutionFound = Problem0020.problem0020(inputLimit);

    assertArrayEquals(answer.toArray(), solutionFound.toArray(),
        String.format("Problem 0020 answer must be: %s", answer.toString())
    );
  }
}
