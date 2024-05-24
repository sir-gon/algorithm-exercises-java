package ae.hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


class VeryBigSumTest {

  @Test void test_aVeryBigSum() {

    Long answer = 5000000015L;
    List<Long> arr = Arrays.asList(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L);

    Long solutionFound = VeryBigSum.aVeryBigSum(arr);

    assertEquals(answer, solutionFound,
        String.format("Problem 0000 answer must be: %d", answer)
    );
  }
}
