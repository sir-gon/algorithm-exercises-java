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
 * AngryFloristTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class AngryFloristTest {
  public static class AngryFloristTestCase {
    public String title;
    public Integer k;
    public List<Integer> arr;
    public Integer expected;
  }

  private List<AngryFloristTestCase> testCases;

  @BeforeAll
  void setup() throws IOException {
    String path = String.join("/",
        "hackerrank",
        "interview_preparation_kit",
        "greedy_algorithms",
        "angry_children.testcases.json");
    this.testCases = JsonLoader.loadJson(path, AngryFloristTestCase.class);
  }

  @Test
  void testLuckBalance() {
    for (AngryFloristTestCase test : testCases) {
      Integer result = AngryFlorist.maxMin(test.k, test.arr);

      assertEquals(test.expected, result,
          "%s(%s) => must be: %d".formatted(
              "AngryFlorist.maxMin",
              test.arr.toString(),
              test.expected));
    }
  }
}
