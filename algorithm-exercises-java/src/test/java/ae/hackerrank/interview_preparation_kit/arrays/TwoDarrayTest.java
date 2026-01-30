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
class TwoDarrayTest {

  public static class TwoDarrayTestCase {
    public String title;
    public List<List<Integer>> input;
    public long expected;
  }

  private final List<TwoDarrayTestCase> testCases = new ArrayList<>();

  @BeforeAll
  void setup() throws IOException {
    String path = String.join("/", "hackerrank",
        "interview_preparation_kit",
        "arrays",
        "2d_array.testcases.json");

    this.testCases.clear();
    this.testCases.addAll(JsonLoader.loadJson(path, TwoDarrayTestCase.class));
  }

  @Test
  void testHourglassSum() {
    for (TwoDarrayTestCase testCase : testCases) {
      long solutionFound = TwoDarray.hourglassSum(testCase.input);

      assertEquals(testCase.expected, solutionFound,
          "%s(%s) answer must be: %s".formatted(
              "TwoDarray.hourglassSum",
              testCase.input.toString(),
              testCase.expected));
    }
  }

  @Test
  void testHourglassSumEdgeCases() {
    List<List<Integer>> input = null;
    Integer expected = null;
    Integer solutionFound = TwoDarray.hourglassSum(null);
    assertEquals(expected, solutionFound,
        "%s(%s) answer must be: %s".formatted(
            "TwoDarray.hourglassSum",
            input,
            expected));

    input = new ArrayList<List<Integer>>();
    expected = null;
    solutionFound = TwoDarray.hourglassSum(null);

    assertEquals(expected, solutionFound,
        "%s(%s) answer must be: %s".formatted(
            "TwoDarray.hourglassSum",
            input,
            expected));
  }
}
