package ae.hackerrank.interview_preparation_kit.greedy_algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import util.JsonLoader;

/**
 * MinimumAbsoluteDifferenceInAnArrayTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class MinimumAbsoluteDifferenceInAnArrayTest {
  public static class MinimumAbsoluteDifferenceInAnArrayTestCase {
    public String title;
    public List<Integer> input;
    public Integer expected;
  }

  private final List<MinimumAbsoluteDifferenceInAnArrayTestCase> testCases = new ArrayList<>();

  @BeforeAll
  void setup() throws IOException {
    String path = String.join("/",
        "hackerrank",
        "interview_preparation_kit",
        "greedy_algorithms",
        "minimum_absolute_difference_in_an_array.testcases.json");
    this.testCases.clear();
    this.testCases.addAll(
        JsonLoader.loadJson(path, MinimumAbsoluteDifferenceInAnArrayTestCase.class));
  }

  @Test
  void testMinimumAbsoluteDifferenceInAnArray() {
    for (MinimumAbsoluteDifferenceInAnArrayTestCase test : testCases) {
      Integer result = MinimumAbsoluteDifferenceInAnArray.minimumAbsoluteDifference(test.input);

      assertEquals(test.expected, result,
          "%s(%s) => must be: %d".formatted(
              "MinimumAbsoluteDifferenceInAnArray.minimumAbsoluteDifference",
              test.input.toString(),
              test.expected));
    }
  }
}
