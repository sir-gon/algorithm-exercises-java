package projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import projecteuler.data.Problem0013Data;

class Problem0013Test {

  @Test void problem0013Instance() {
    Problem0013 classUnderTest = new Problem0013();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0013.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0013.class)
    );

    Problem0013Data dataClassUnderTest = new Problem0013Data();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0013Data.class,
        dataClassUnderTest,
        String.format("Must be an instance of %s", Problem0013Data.class)
    );
  }

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
