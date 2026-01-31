package ae.hackerrank.interview_preparation_kit.miscellaneous;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import util.JsonLoader;

/** FlippingBitsTflippingBits. */
@TestInstance(Lifecycle.PER_CLASS)
class FlippingBitsTest {
  /** FlippingBitsTestCaseTest. */
  public static class FlippingBitsTestCaseTest {
    public long input;
    public long answer;
  }

  /** FlippingBitsTestCase. */
  public static class FlippingBitsTestCase {
    public String title;
    public List<FlippingBitsTestCaseTest> tests;
  }

  private final List<FlippingBitsTestCase> testCases = new ArrayList<>();

  @BeforeAll
  void setup() throws IOException {
    String path =
        String.join(
            "/",
            "hackerrank",
            "interview_preparation_kit",
            "miscellaneous",
            "flipping_bits.testcases.json");

    this.testCases.clear();
    this.testCases.addAll(JsonLoader.loadJson(path, FlippingBitsTestCase.class));
  }

  @Test
  void testFlippingBits() {
    for (FlippingBitsTestCase tests : testCases) {
      for (FlippingBitsTestCaseTest test : tests.tests) {
        Long result = FlippingBits.flippingBits(test.input);

        assertEquals(
            test.answer,
            result,
            "%s(%s) => must be: %d"
                .formatted("FlippingBits.flippingBits", test.input, test.answer));
      }
    }
  }
}
