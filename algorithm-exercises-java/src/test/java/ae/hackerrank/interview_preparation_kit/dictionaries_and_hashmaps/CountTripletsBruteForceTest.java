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
 * CountTripletsBruteForceTest.
 */
@TestInstance(Lifecycle.PER_CLASS)
class CountTripletsBruteForceTest {
  public static class CountTripletsBruteForceTestCase {
    public String title;
    public List<Long> input;
    public Long r;
    public Long expected;
  }

  private List<CountTripletsBruteForceTestCase> smallTestCases;

  @BeforeAll
  void setup() throws IOException {
    String path;
    path = String.join("/",
        "hackerrank",
        "interview_preparation_kit",
        "dictionaries_and_hashmaps",
        "count_triplets_1.small.testcases.json");

    this.smallTestCases = JsonLoader.loadJson(path, CountTripletsBruteForceTestCase.class);
  }

  @Test
  void testCountTriplets() {
    for (CountTripletsBruteForceTestCase test : smallTestCases) {
      Long solutionFound = CountTripletsBruteForce.countTriplets(test.input, test.r);

      assertEquals(test.expected, solutionFound,
          "%s(%s, %d) answer must be: %d".formatted(
              "CountTripletsBruteForce.countTriplets",
              test.input.toString(),
              test.r,
              test.expected));
    }
  }
}
