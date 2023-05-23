package projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class Problem0004Test {

  @Test void problem0004InstanceTest() {

    Problem0004 classUnderTest = new Problem0004();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0004.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0004.class));
  }

  @Test void problem0004() {

    Integer answer = 906609;
    Integer bottom = 111;
    Integer top = 999;
    Integer solutionFound = Problem0004.problem0004(bottom, top);

    assertEquals(answer, solutionFound,
        String.format("Problem 0004 answer must be: %d", answer)
    );
  }
}
