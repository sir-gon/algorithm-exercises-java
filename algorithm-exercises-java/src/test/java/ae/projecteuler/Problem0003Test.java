package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


class Problem0003Test {

  @Test void problem0003InstanceTest() {

    Problem0003 classUnderTest = new Problem0003();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0003.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0003.class));
  }

  @Test void problem0003BorderCaseTest() {

    Integer answer = null;
    Long top = 1L;
    Long solutionFound = Problem0003.problem0003(top);

    assertEquals(answer, solutionFound,
        String.format("Problem 00003 answer must be: %d", answer)
    );
  }

  @Test void problem0003ShortCaseTest() {

    Long answer = 2L;
    Long top = 16L;
    Long solutionFound = Problem0003.problem0003(top);

    assertEquals(answer, solutionFound,
        String.format("Problem 00003 answer must be: %d", answer)
    );
  }

  @Test void problem0003FulltCaseTest() {

    Long answer = 6857L;
    Long top = 600851475143L;
    Long solutionFound = Problem0003.problem0003(top);

    assertEquals(answer, solutionFound,
        String.format("Problem 00003 answer must be: %d", answer)
    );
  }
}
