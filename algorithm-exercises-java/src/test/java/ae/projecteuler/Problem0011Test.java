package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ae.projecteuler.data.Problem0011Data;
import org.junit.jupiter.api.Test;


class Problem0011Test {

  @Test void problem0011Instance() {
    Problem0011 classUnderTest = new Problem0011();
    Problem0011Data dataClassUnderTest = new Problem0011Data();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0011.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0011.class)
    );

    assertInstanceOf(
        Problem0011Data.class,
        dataClassUnderTest,
        String.format("Must be an instance of %s", Problem0011Data.class)
    );
  }

  @Test void problem0011() throws Exception {

    Integer answer = 70600674;
    Integer[][] inputMatrix = Problem0011Data.problem0011Data;
    Integer inputInterval = 4;

    Integer solutionFound = Problem0011.problem0011(inputMatrix, inputInterval);

    assertEquals(answer, solutionFound,
        String.format("Problem 0011 answer must be: %d", answer)
    );
  }

  @Test void problem0011WrongData() {

    Integer[][] inputMatrix = Problem0011Data.problem0011WrongData;
    Integer inputInterval = 0;

    Exception exception = assertThrows(Exception.class, () -> {
      Problem0011.problem0011(inputMatrix, inputInterval);
    });

    String expectedMessage = "Not a square matrix";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}
