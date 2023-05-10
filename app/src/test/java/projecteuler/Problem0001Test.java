package projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Problem0001Test {
  @Test void problem0001() {

    Problem0001 classUnderTest = new Problem0001();

    Integer solutionFound = 233168;
    Integer top = 1000;
    Integer answer = classUnderTest.problem0001(top);

    assertEquals(answer, solutionFound, "PROBLEM 0001 solution found: ${}");
  }
}
