package ae.hackerrank.interview_preparation_kit.greedy_algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import util.JsonLoader;

/**
 * GreedyFloristTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class GreedyFloristTest {
  public static class GreedyFloristTestCase {
    public String title;
    public List<Integer> c;
    public Integer k;
    public Integer expected;
  }

  private List<GreedyFloristTestCase> testCases;

  @BeforeAll
  void setup() throws IOException {
    String path = String.join("/",
        "hackerrank",
        "interview_preparation_kit",
        "greedy_algorithms",
        "greedy_florist.testcases.json");
    this.testCases = JsonLoader.loadJson(path, GreedyFloristTestCase.class);
  }

  @Test
  void testLuckBalance() {
    for (GreedyFloristTestCase test : testCases) {
      int[] inputArray = test.c.stream().mapToInt(Integer::intValue).toArray();
      Integer result = GreedyFlorist.getMinimumCost(test.k, inputArray);

      assertEquals(test.expected, result,
          "%s(%s) => must be: %d".formatted(
              "GreedyFlorist.getMinimumCost",
              test.c.toString(),
              test.expected));
    }
  }
}
