package ae.hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


class SimpleArraySumTest {

  @Test void testSimpleArraySum() {

    Integer answer = 5;
    List<Integer> ar = Arrays.asList(2, 3);

    Integer solutionFound = SimpleArraySum.simpleArraySum(ar);

    assertEquals(answer, solutionFound,
        String.format("Problem 0000 answer must be: %d", answer)
    );
  }
}
