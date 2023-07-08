package projecteuler;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import projecteuler.helper.BigNum;

class Problem0020Test {

  @Test void problem0020Instance() {
    Problem0020 classUnderTest = new Problem0020();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0020.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0020.class)
    );
  }

  @Test void problem0020() {

    Integer inputLimit = 100;
    BigNum answer = new BigNum("648");
    BigNum solutionFound = Problem0020.problem0020(inputLimit);

    assertArrayEquals(answer.toArray(), solutionFound.toArray(),
        String.format("Problem 0020 answer must be: %s", answer.toString())
    );
  }
}
