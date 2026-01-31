package ae.hackerrank.warmup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class SimpleArraySumTest {

  @Test
  void testSimpleArraySum() {

    Integer answer = 5;
    List<Integer> ar = Arrays.asList(2, 3);

    Integer solutionFound = SimpleArraySum.simpleArraySum(ar);

    assertEquals(
        answer,
        solutionFound,
        String.format(
            "%s(%s) answer must be: %d", "SimpleArraySum.simpleArraySum", ar.toString(), answer));
  }
}
