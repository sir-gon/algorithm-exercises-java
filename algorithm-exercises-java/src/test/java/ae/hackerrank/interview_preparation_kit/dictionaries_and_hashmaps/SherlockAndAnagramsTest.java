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
 * SherlockAndAnagrams.
 *
 * @link Problem definition [[docs/hackerrank/interview_preparation_kit/dictionaries_and_hashmaps/two-strings.md]]
 */
@TestInstance(Lifecycle.PER_CLASS)
class SherlockAndAnagramsTest {

  /**
   * SherlockAndAnagramsTestCase.
   */
  public static class SherlockAndAnagramsTestCase {
    /**
     * SherlockAndAnagramsTestCase.TestCase.
     */
    public static class TestCase {
      public String input;
      public Integer expected;
    }

    public String title;
    public List<TestCase> tests;
  }

  List<SherlockAndAnagramsTestCase> testCases;

  /**
   * Sets up the test environment by loading test cases from a JSON file.
   * The JSON file is located in the specified path relative to the project structure.
   *
   * @throws IOException if an error occurs while reading the JSON file.
   */
  @BeforeAll
  void setup() throws IOException {
    String path = String.join("/", "hackerrank",
        "interview_preparation_kit",
        "dictionaries_and_hashmaps",
        "sherlock_and_anagrams.testcases.json");

    this.testCases = JsonLoader.loadJson(path, SherlockAndAnagramsTestCase.class);
  }

  private SherlockAndAnagramsTest() {}

  /**
   * sherlockAndAnagrams.
   */
  @Test void sherlockAndAnagrams() {
    for (SherlockAndAnagramsTestCase _testCases : this.testCases) {

      for (SherlockAndAnagramsTestCase.TestCase test : _testCases.tests) {
        Integer solutionFound = SherlockAndAnagrams.sherlockAndAnagrams(test.input);

        assertEquals(test.expected, solutionFound,
            "%s(%s) answer must be: %s".formatted(
              "SherlockAndAnagrams.sherlockAndAnagrams",
              test.input,
              test.expected
            )
        );
      }
    }
  }
}
