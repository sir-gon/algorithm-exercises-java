package ae.hackerrank.warmup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolveMeFirstTest {

  @Test
  void solveMeFirst() {

    Integer answer = 5;
    Integer a = 2;
    Integer b = 3;

    Integer solutionFound = SolveMeFirst.solveMeFirst(a, b);

    assertEquals(
        answer,
        solutionFound,
        String.format("%s(%d, %d) answer must be: %d", "SolveMeFirst.solveMeFirst", a, b, answer));
  }
}
