package ae.hackerrank.interview_preparation_kit.dictionaries_and_hashmaps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import util.JsonLoader;

@TestInstance(Lifecycle.PER_CLASS)
class FrequencyQueriesTest {

  public static class FrequencyQueriesTestCase {
    public String title;
    public List<List<Integer>> input;
    public List<Integer> expected;
  }

  List<FrequencyQueriesTestCase> testCases;
  List<FrequencyQueriesTestCase> testCase6;
  List<FrequencyQueriesTestCase> testCaseBorderCases;
  List<FrequencyQueriesTestCase> testCaseBorderCaseException;

  @BeforeAll
  void setup() throws IOException {
    String path;
    path = String.join("/",
        "hackerrank",
        "interview_preparation_kit",
        "dictionaries_and_hashmaps",
        "frequency_queries.testcases.json");

    this.testCases = JsonLoader.loadJson(path, FrequencyQueriesTestCase.class);

    path = String.join("/",
        "hackerrank",
        "interview_preparation_kit",
        "dictionaries_and_hashmaps",
        "frequency_queries.testcase6.json");
    this.testCase6 = JsonLoader.loadJson(path, FrequencyQueriesTestCase.class);

    path = String.join("/",
      "hackerrank",
      "interview_preparation_kit",
      "dictionaries_and_hashmaps",
      "frequency_queries.testcase_border_cases.json");
    this.testCaseBorderCases = JsonLoader.loadJson(path, FrequencyQueriesTestCase.class);

    path = String.join("/",
      "hackerrank",
      "interview_preparation_kit",
      "dictionaries_and_hashmaps",
      "frequency_queries.testcase_border_case_exception.json");
    this.testCaseBorderCaseException = JsonLoader.loadJson(path, FrequencyQueriesTestCase.class);
  }

  @Test
  void testFrequencyQueries() {
    List<Integer> solutionFound;

    for (FrequencyQueriesTestCase test : testCases) {
      solutionFound = FrequencyQueries.freqQuery(test.input);

      assertEquals(test.expected, solutionFound,
          "%s(%s) answer must be: %s".formatted(
              "FrequencyQueriesTest.freqQuery",
              test.input,
              test.expected));
    }
  }

  @Test
  void testFrequencyQueriesBigCases() {
    List<Integer> solutionFound;

    for (FrequencyQueriesTestCase test : testCase6) {

      solutionFound = FrequencyQueries.freqQuery(test.input);

      assertEquals(test.expected, solutionFound,
          "%s(%s) answer must be: %s".formatted(
              "FrequencyQueriesTest.freqQuery",
              test.input,
              test.expected));
    }
  }

  @Test
  void testFrequencyQueriesBorderCases() {
    List<Integer> solutionFound;

    for (FrequencyQueriesTestCase test : testCaseBorderCases) {

      solutionFound = FrequencyQueries.freqQuery(test.input);

      assertEquals(test.expected, solutionFound,
          "%s(%s) answer must be: %s".formatted(
              "FrequencyQueriesTest.freqQuery",
              test.input,
              test.expected));
    }
  }

  @Test
  void testFrequencyQueriesBorderCaseException() {
    for (FrequencyQueriesTestCase test : testCaseBorderCaseException) {
      Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        FrequencyQueries.freqQuery(test.input);
      });

      String expectedMessage = "Operation 4 not supported";
      String actualMessage = exception.getMessage();

      assertTrue(actualMessage.contains(expectedMessage));
    }
  }
}
