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
class NewYearChaosTest {

  public static class NewYearChaosTestCase {
    public String title;
    public List<Integer> input;
    public String expected;
  }

  private final List<NewYearChaosTestCase> testCases = new ArrayList<>();

  @BeforeAll
  void setup() throws IOException {

    String path =
        String.join(
            "/",
            "hackerrank",
            "interview_preparation_kit",
            "arrays",
            "new_year_chaos.testcases.json");

    this.testCases.clear();
    this.testCases.addAll(JsonLoader.loadJson(path, NewYearChaosTestCase.class));
  }

  @Test
  void testMinimumBribesText() {

    for (NewYearChaosTestCase test : this.testCases) {
      String solutionFound = NewYearChaos.minimumBribesText(test.input);
      NewYearChaos.minimumBribes(test.input);

      assertEquals(
          test.expected,
          solutionFound,
          "%s(%s) answer must be: %s"
              .formatted("NewYearChaosTestCase.minimumBribesText", test.input, test.expected));
    }
  }
}
