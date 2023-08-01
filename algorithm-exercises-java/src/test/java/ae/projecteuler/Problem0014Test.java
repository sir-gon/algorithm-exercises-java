package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


class Problem0014Test {

  @Test void problem0014() throws Exception {

    Long answer = 837799L;
    Integer inputBottom = 1;
    Integer inputTop = 1000000;

    Long solutionFound = Problem0014.problem0014(inputBottom, inputTop);

    assertEquals(answer, solutionFound,
        String.format("Problem 0014 answer must be: %d", answer)
    );
  }

  @Test void problem0014borderCase() {

    Integer inputBottom = -1;
    Integer inputTop = 10;

    Exception exception = assertThrows(Exception.class, () -> {
      Problem0014.problem0014(inputBottom, inputTop);
    });

    String expectedMessage = "bottom must be a positive integer";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test void problem0014WrongParameterCase() {

    Integer inputBottom = 10;
    Integer inputTop = 1;

    Exception exception = assertThrows(Exception.class, () -> {
      Problem0014.problem0014(inputBottom, inputTop);
    });

    String expectedMessage = "top must be and integer, higher than bottom";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}
