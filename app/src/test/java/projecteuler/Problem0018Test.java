package projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import projecteuler.data.Problem0018Data;


class Problem0018Test {

  @Test void problem0018Instance() {
    Problem0018 classUnderTest = new Problem0018();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0018.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0018.class)
    );

    Problem0018Data dataClassUnderTest = new Problem0018Data();
    assertNotNull(dataClassUnderTest);
    assertInstanceOf(
        Problem0018Data.class,
        dataClassUnderTest,
        String.format("Must be an instance of %s", Problem0018Data.class)
    );
  }

  @Test void problem0018() {

    Integer answer = 23;
    Integer[][] input = {
      {3},
      {7, 4},
      {2, 4, 6},
      {8, 5, 9, 3}
    };

    assertEquals(answer, Problem0018.problem0018(input),
        String.format("Problem 0018 answer must be: %d", answer)
    );
  }

  @Test void problem0018full() {

    Integer answer = 1074;
    Integer[][] triangle = Problem0018Data.problem0018Data;

    assertEquals(answer, Problem0018.problem0018(triangle),
        String.format("Problem 0018 answer must be: %d", answer)
    );
  }
}
