package projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class Problem0002Test {

  @Test void problem0002Instance() {
    Problem0002 classUnderTest = new Problem0002();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0002.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0002.class)
    );
  }

  @Test void problem0002() {
    int answer = 4613732;
    int top = 4000000;
    int solutionFound = Problem0002.problem0002(top);

    assertEquals(answer, solutionFound,
        String.format("Problem 00002 answer must be: %d", answer)
    );
  }
}
