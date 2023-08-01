package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import ae.projecteuler.data.Problem0022Data;
import org.junit.jupiter.api.Test;


class Problem0022Test {

  @Test void problem0022Instance() {
    Problem0022 classUnderTest = new Problem0022();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Problem0022.class,
        classUnderTest,
        String.format("Must be an instance of %s", Problem0022.class)
    );

    Problem0022Data dataClassUnderTest = new Problem0022Data();

    assertNotNull(dataClassUnderTest);
    assertInstanceOf(
        Problem0022Data.class,
        dataClassUnderTest,
        String.format("Must be an instance of %s", Problem0022Data.class)
    );
  }

  @Test void problem0022full() {

    Integer answer = 871198282;

    Integer solutionFound = Problem0022.problem0022(Problem0022Data.problem0022Data);

    assertEquals(answer, solutionFound,
        String.format("Problem 0022 answer must be: %d", answer)
    );
  }
}
