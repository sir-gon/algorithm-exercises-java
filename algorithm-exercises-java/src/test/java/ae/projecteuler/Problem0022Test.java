package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ae.projecteuler.data.Problem0022Data;
import org.junit.jupiter.api.Test;


class Problem0022Test {
  @Test void problem0022full() {

    Integer answer = 871198282;

    Integer solutionFound = Problem0022.problem0022(Problem0022Data.problem0022Data);

    assertEquals(answer, solutionFound,
        String.format("Problem 0022 answer must be: %d", answer)
    );
  }
}
