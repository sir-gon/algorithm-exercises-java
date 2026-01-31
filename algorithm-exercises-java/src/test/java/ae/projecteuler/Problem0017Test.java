package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Problem0017Test {
  @Test
  void problem0017() throws Exception {

    Integer answer = 21124;
    Integer inputInit = 1;
    Integer inputLast = 1000;

    assertEquals(
        answer,
        Problem0017.problem0017(inputInit, inputLast),
        String.format("Problem 0017 answer must be: %d", answer));
  }
}
