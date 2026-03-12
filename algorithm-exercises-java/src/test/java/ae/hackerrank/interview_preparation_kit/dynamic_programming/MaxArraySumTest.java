package ae.hackerrank.interview_preparation_kit.dynamic_programming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import util.JsonLoader;

/** MaxArraySumTest. */
@TestInstance(Lifecycle.PER_CLASS)
class MaxArraySumTest {
  public static class MaxArraySumTestCase {
    public String title;
    public List<Integer> input;
    public Integer expected;
  }

  private final List<MaxArraySumTestCase> testCases = new ArrayList<>();

  @BeforeAll
  void setup() throws IOException {
    String path =
        String.join(
            "/",
            "hackerrank",
            "interview_preparation_kit",
            "dynamic_programming",
            "max_array_sum.testcases.json");

    this.testCases.clear();
    this.testCases.addAll(JsonLoader.loadJson(path, MaxArraySumTestCase.class));
  }

  @Test
  void testMaxArraySum() {
    for (MaxArraySumTestCase test : testCases) {
      int solutionFound = MaxArraySum.maxSubsetSum(test.input);

      assertEquals(
          test.expected,
          solutionFound,
          "%s(%s) answer must be: %d"
              .formatted("MaxArraySum.maxSubsetSum", test.input.toString(), test.expected));
    }
  }

  @Test
  void testMaxArraySumZero() {
    List<Integer> testInput = List.of();
    int testExpected = 0;
    int solutionFound = MaxArraySum.maxSubsetSum(testInput);

    assertEquals(
        testExpected,
        solutionFound,
        "%s(%s) answer must be: %d"
            .formatted("MaxArraySum.maxSubsetSum", testInput.toString(), testExpected));
  }

  @Test
  void testMaxArraySumSingle() {
    List<Integer> testInput = List.of(1);
    int testExpected = 1;
    int solutionFound = MaxArraySum.maxSubsetSum(testInput);

    assertEquals(
        testExpected,
        solutionFound,
        "%s(%s) answer must be: %d"
            .formatted("MaxArraySum.maxSubsetSum", testInput.toString(), testExpected));
  }
}
