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

/** AngryChildrenTest. */
@TestInstance(Lifecycle.PER_CLASS)
class AngryChildrenTest {
  public static class AngryChildrenTestCase {
    public String title;
    public Integer k;
    public List<Integer> arr;
    public Integer expected;
  }

  private final List<AngryChildrenTestCase> testCases = new ArrayList<>();

  @BeforeAll
  void setup() throws IOException {
    String path =
        String.join(
            "/",
            "hackerrank",
            "interview_preparation_kit",
            "greedy_algorithms",
            "angry_children.testcases.json");
    this.testCases.clear();
    this.testCases.addAll(JsonLoader.loadJson(path, AngryChildrenTestCase.class));
  }

  @Test
  void testAngryChildren() {
    for (AngryChildrenTestCase test : testCases) {
      Integer result = AngryChildren.maxMin(test.k, test.arr);

      assertEquals(
          test.expected,
          result,
          "%s(%s) => must be: %d"
              .formatted("AngryChildren.maxMin", test.arr.toString(), test.expected));
    }
  }
}
