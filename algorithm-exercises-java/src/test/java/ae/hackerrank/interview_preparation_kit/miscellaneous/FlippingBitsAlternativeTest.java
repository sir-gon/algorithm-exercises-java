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
 * FlippingBitsTflippingBits.
 */
@TestInstance(Lifecycle.PER_CLASS)
class FlippingBitsAlternativeTest {
  /**
   * FlippingBitsAlternativeTestCaseTest.
   */
  public static class FlippingBitsAlternativeTestCaseTest {
    public long input;
    public long answer;
  }

  /**
   * FlippingBitsAlternativeTestCase.
   */
  public static class FlippingBitsAlternativeTestCase {
    public String title;
    public List<FlippingBitsAlternativeTestCaseTest> tests;
  }

  private List<FlippingBitsAlternativeTestCase> testCases;

  @BeforeAll
  void setup() throws IOException {
    String path = String.join("/",
        "hackerrank",
        "interview_preparation_kit",
        "miscellaneous",
        "flipping_bits.testcases.json");

    this.testCases = JsonLoader.loadJson(path, FlippingBitsAlternativeTestCase.class);
  }

  @Test
  void testFlippingBitsAlternative() {
    for (FlippingBitsAlternativeTestCase tests : testCases) {
      for (FlippingBitsAlternativeTestCaseTest test : tests.tests) {
        Long result = FlippingBitsAlternative.flippingBits(test.input);

        assertEquals(test.answer, result,
            "%s(%s) => must be: %d".formatted(
              "FlippingBits.flippingBits",
              test.input,
              test.answer));
      }
    }
  }
}
