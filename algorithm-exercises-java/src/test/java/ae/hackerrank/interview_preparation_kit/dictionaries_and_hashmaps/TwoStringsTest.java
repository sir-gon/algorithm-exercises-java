package ae.hackerrank.interview_preparation_kit.dictionaries_and_hashmaps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import util.JsonLoader;

/**
 * TwoStringsTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class TwoStringsTest {
  public static class TwoStringsTestCase {
    public String title;
    public String s1;
    public String s2;
    public String expected;
  }

  private List<TwoStringsTestCase> testCases;

  @BeforeAll
  void setup() throws IOException {
    String path = String.join("/",
        "hackerrank",
        "interview_preparation_kit",
        "dictionaries_and_hashmaps",
        "two_strings.testcases.json");

    this.testCases = JsonLoader.loadJson(path, TwoStringsTestCase.class);
  }

  @Test
  void testTwoStrings() {
    for (TwoStringsTestCase test : testCases) {
      String solutionFound = TwoStrings.twoStrings(test.s1, test.s2);

      assertEquals(test.expected, solutionFound,
          "%s(%s, %s) answer must be: %s".formatted(
              "TwoStrings.twoStrings",
              test.s1,
              test.s2,
              test.expected));
    }
  }
}
