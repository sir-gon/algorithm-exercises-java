package ae.hackerrank.interview_preparation_kit.greedy_algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import util.JsonLoader;

/**
 * LuckBalanceTest.
*/
@TestInstance(Lifecycle.PER_CLASS)
class LuckBalanceTest {
  public static class LuckBalanceTestCase {
    public String title;
    public Integer k;
    public List<List<Integer>> contests;
    public Integer expected;
  }

  private List<LuckBalanceTestCase> testCases;

  @BeforeAll
  public void setup() throws IOException {
    String path = String.join("/",
         "hackerrank",
        "interview_preparation_kit",
        "greedy_algorithms",
        "luck_balance.testcases.json");

    this.testCases = JsonLoader.loadJson(path, LuckBalanceTestCase.class);
  }

  @Test void testLuckBalance() {
    for (LuckBalanceTestCase test : testCases) {
      Integer result = LuckBalance.luckBalance(test.k, test.contests);

      assertEquals(test.expected, result,
          "%s(%d, %s) => must be: %s".formatted(
            "LuckBalance.luckBalance",
            test.k,
            test.contests,
            test.expected
          )
      );
    }
  }
}
