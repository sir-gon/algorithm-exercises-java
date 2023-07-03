package projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class Problem0017Test {

  @Test void problem0017Instance() {
    Problem0017 classUnderTest = new Problem0017();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0017.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0017.class)
    );
  }

  @Test void problem0017() throws Exception {

    Integer answer = 21124;
    Integer inputInit = 1;
    Integer inputLast = 1000;

    assertEquals(answer, Problem0017.problem0017(inputInit, inputLast),
        String.format("Problem 0017 answer must be: %d", answer)
    );
  }
}
