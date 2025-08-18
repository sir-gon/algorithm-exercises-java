package ae.hackerrank.interview_preparation_kit.miscellaneous;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import util.JsonLoader;

/**
 * TimeComplexityPrimalityTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class TimeComplexityPrimalityTest {
  /**
   * TimeComplexityPrimalityTestCaseTest.
   */
  public static class TimeComplexityPrimalityTestCaseTest {
    public int input;
    public String answer;
  }

  /**
   * TimeComplexityPrimalityTestCase.
   */
  public static class TimeComplexityPrimalityTestCase {
    public String title;
    public List<TimeComplexityPrimalityTestCaseTest> tests;
  }

  private List<TimeComplexityPrimalityTestCase> testCases;

  @BeforeAll
  void setup() throws IOException {
    String path = String.join("/",
        "hackerrank",
        "interview_preparation_kit",
        "miscellaneous",
        "ctci_big_o.testcases.json");

    this.testCases = JsonLoader.loadJson(path, TimeComplexityPrimalityTestCase.class);
  }

  @Test
  void testTimeComplexityPrimality() {
    for (TimeComplexityPrimalityTestCase tests : testCases) {
      for (TimeComplexityPrimalityTestCaseTest test : tests.tests) {
        String result = TimeComplexityPrimality.primality(test.input);

        assertEquals(test.answer, result,
            "%s(%s) => must be: %s".formatted(
              "TimeComplexityPrimality.primality",
              test.input,
              test.answer));
      }
    }
  }
}
