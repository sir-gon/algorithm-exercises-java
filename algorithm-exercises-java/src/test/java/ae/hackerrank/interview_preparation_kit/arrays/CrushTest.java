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
class CrushTest {

  public static class CrushTestCase {
    public String title;
    public Integer n;
    public List<List<Integer>> queries;
    public long expected;
  }

  List<CrushTestCase> testCases;

  @BeforeAll
  public void setup() throws IOException {
    String path = String.join("/", "hackerrank",
        "interview_preparation_kit",
        "arrays",
        "crush.testcases.json");

    this.testCases = JsonLoader.loadJson(path, CrushTestCase.class);
  }

  @Test void testArrayManipulation() {
    for (CrushTestCase testCase : testCases) {
      long solutionFound = CrushOptimized
          .arrayManipulation(testCase.n, testCase.queries);

      assertEquals(testCase.expected, solutionFound,
          String.format("%s(%d, %s) answer must be: %s",
            "CrushOptimized.arrayManipulation",
            testCase.n,
            testCase.queries.toString(),
            testCase.expected
          )
      );
    }
  }
}
