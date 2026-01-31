package ae.hackerrank.warmup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class VeryBigSumTest {

  @Test
  void test_aVeryBigSum() {

    Long answer = 5000000015L;
    List<Long> arr = Arrays.asList(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L);

    Long solutionFound = VeryBigSum.aVeryBigSum(arr);

    assertEquals(
        answer,
        solutionFound,
        String.format(
            "%s(%s) answer must be: %d", "VeryBigSum.aVeryBigSum", arr.toString(), answer));
  }
}
