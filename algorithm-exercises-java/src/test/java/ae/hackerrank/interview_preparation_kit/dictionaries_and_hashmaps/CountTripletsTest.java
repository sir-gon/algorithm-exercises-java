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
 * CountTripletsTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class CountTripletsTest {
  public static class CountTripletsTestCase {
    public String title;
    public List<Long> input;
    public Long r;
    public Long expected;
  }

  private List<CountTripletsTestCase> smallTestCases;
  private List<CountTripletsTestCase> bigTestCases;

  @BeforeAll
  void setup() throws IOException {
    String path;
    path = String.join("/",
        "hackerrank",
        "interview_preparation_kit",
        "dictionaries_and_hashmaps",
        "count_triplets_1.small.testcases.json");

    this.smallTestCases = JsonLoader.loadJson(path, CountTripletsTestCase.class);

    path = String.join("/",
        "hackerrank",
        "interview_preparation_kit",
        "dictionaries_and_hashmaps",
        "count_triplets_1.big.testcases.json");

    this.bigTestCases = JsonLoader.loadJson(path, CountTripletsTestCase.class);

  }

  @Test
  void testCountTriplets() {
    for (CountTripletsTestCase test : smallTestCases) {
      Long solutionFound = CountTriplets.countTriplets(test.input, test.r);

      assertEquals(test.expected, solutionFound,
          "%s(%s, %d) answer must be: %d".formatted(
              "CountTriplets.countTriplets",
              test.input.toString(),
              test.r,
              test.expected));
    }
  }

  @Test
  void testCountTripletsBigCases() {
    for (CountTripletsTestCase test : bigTestCases) {
      Long solutionFound = CountTriplets.countTriplets(test.input, test.r);

      assertEquals(test.expected, solutionFound,
          "%s(%s, %d) answer must be: %d".formatted(
              "CountTriplets.countTriplets",
              test.input.toString(),
              test.r,
              test.expected));
    }
  }
}
