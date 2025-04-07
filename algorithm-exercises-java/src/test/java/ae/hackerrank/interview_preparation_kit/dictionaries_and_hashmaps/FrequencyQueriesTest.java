package ae.hackerrank.interview_preparation_kit.dictionaries_and_hashmaps;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

  @BeforeAll
  public void setup() throws IOException {
    String path;
    path = String.join("/",
        "hackerrank",
        "interview_preparation_kit",
        "dictionaries_and_hashmaps",
        "frequency_queries.testcases.json");

    this.testCases = JsonLoader.loadJson(path, FrequencyQueriesTestCase.class);
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
}
