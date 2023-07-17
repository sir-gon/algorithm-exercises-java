package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


class Problem0001Test {
  @Test void problem0001Instance() {
    Problem0001 classUnderTest = new Problem0001();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0001.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0001.class)
    );
  }

  @Test void problem0001() {

    Integer solutionFound = 233168;
    Integer top = 1000;
    Integer answer = Problem0001.problem0001(top);

    assertEquals(answer, solutionFound,
        String.format("Problem 00011 answer must be: %d", answer)
    );
  }
}
