package ae.hackerrank.interview_preparation_kit.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import util.JsonLoader;


@TestInstance(Lifecycle.PER_CLASS)
class MinimumSwaps2Test {

  public static class MinimumSwaps2TestCase {
    public String title;
    public List<Integer> input;
    public long expected;
  }

  List<MinimumSwaps2TestCase> testCases;

  @BeforeAll
  public void setup() throws IOException {
    String path = String.join("/", "hackerrank",
        "interview_preparation_kit",
        "arrays",
        "minimum_swaps_2.testcases.json");

    this.testCases = JsonLoader.loadJson(path, MinimumSwaps2TestCase.class);
  }

  @Test void testArrayManipulation() {
    for (MinimumSwaps2TestCase testCase : testCases) {
      int[] input = testCase.input
          .stream()
          .mapToInt(Integer::intValue)
          .toArray();
      long solutionFound = MinimumSwaps2.minimumSwaps(input);

      assertEquals(testCase.expected, solutionFound,
          "%s(%s) answer must be: %s".formatted(
          "MinimumSwaps2.minimumSwaps",
          testCase.input.toString(),
          testCase.expected
          )
      );
    }
  }
}
