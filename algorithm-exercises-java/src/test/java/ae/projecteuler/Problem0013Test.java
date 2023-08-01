package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ae.projecteuler.data.Problem0013Data;
import org.junit.jupiter.api.Test;


class Problem0013Test {
  @Test void problem0013() {

    String expectedSolution = "5537376230";
    Integer firtsDigits = 10;
    String[] arrayOfNumbers = Problem0013Data.problem0013Data;

    String solutionFound = Problem0013.problem0013(arrayOfNumbers, firtsDigits);

    assertEquals(expectedSolution, solutionFound,
        String.format("Problem 0013 answer must be: %s", expectedSolution)
    );
  }
}
