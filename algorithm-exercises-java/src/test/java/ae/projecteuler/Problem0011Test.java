package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ae.projecteuler.data.Problem0011Data;
import org.junit.jupiter.api.Test;


class Problem0011Test {

  @Test void problem0011() throws Exception {

    Integer answer = 70600674;
    Integer[][] inputMatrix = Problem0011Data.getProblem11Data();
    Integer inputInterval = 4;

    Integer solutionFound = Problem0011.problem0011(inputMatrix, inputInterval);

    assertEquals(answer, solutionFound,
        String.format("Problem 0011 answer must be: %d", answer)
    );
  }

  @Test void problem0011WrongData() {

    Integer[][] inputMatrix = Problem0011Data.getProblem11WrongData();
    Integer inputInterval = 0;

    Exception exception = assertThrows(Exception.class, () ->
        Problem0011.problem0011(inputMatrix, inputInterval)
    );

    String expectedMessage = "Not a square matrix";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}
