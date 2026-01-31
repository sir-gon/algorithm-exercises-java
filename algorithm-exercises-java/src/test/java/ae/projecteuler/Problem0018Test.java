package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ae.projecteuler.data.Problem0018Data;
import org.junit.jupiter.api.Test;

class Problem0018Test {

  @Test
  void problem0018() {

    Integer answer = 23;
    Integer[][] input = {{3}, {7, 4}, {2, 4, 6}, {8, 5, 9, 3}};

    assertEquals(
        answer,
        Problem0018.problem0018(input),
        String.format("Problem 0018 answer must be: %d", answer));
  }

  @Test
  void problem0018full() {

    Integer answer = 1074;
    Integer[][] triangle = Problem0018Data.getProblem18Data();

    assertEquals(
        answer,
        Problem0018.problem0018(triangle),
        String.format("Problem 0018 answer must be: %d", answer));
  }
}
