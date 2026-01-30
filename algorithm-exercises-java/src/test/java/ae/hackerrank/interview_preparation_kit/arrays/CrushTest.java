package ae.hackerrank.interview_preparation_kit.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import util.JsonLoader;

@TestInstance(Lifecycle.PER_CLASS)
class CrushTest {

  public static class CrushTestCase {
    public String title;
    public Integer n;
    public List<List<Integer>> queries;
    public long expected;
  }

  private final List<CrushTestCase> testCases = new ArrayList<>();

  @BeforeAll
  void setup() throws IOException {
    String path = String.join("/", "hackerrank",
        "interview_preparation_kit",
        "arrays",
        "crush.testcases.json");

    this.testCases.clear();
    this.testCases.addAll(JsonLoader.loadJson(path, CrushTestCase.class));
  }

  @Test
  void testArrayManipulation() {
    for (CrushTestCase testCase : testCases) {
      long solutionFound = CrushOptimized
          .arrayManipulation(testCase.n, testCase.queries);

      assertEquals(testCase.expected, solutionFound,
          "%s(%d, %s) answer must be: %s".formatted(
              "CrushOptimized.arrayManipulation",
              testCase.n,
              testCase.queries.toString(),
              testCase.expected));
    }
  }
}
