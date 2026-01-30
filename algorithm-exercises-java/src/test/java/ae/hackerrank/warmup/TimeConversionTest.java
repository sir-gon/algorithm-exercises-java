package ae.hackerrank.warmup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class TimeConversionTest {
  public class TimeConversionTestCase {
    public String input;
    public String expected;

    public TimeConversionTestCase(String input, String expected) {
      this.input = input;
      this.expected = expected;
    }
  }

  public List<TimeConversionTestCase> testCases = new ArrayList<>();

  @BeforeAll
  void setup() {
    this.testCases.clear();
    this.testCases.add(new TimeConversionTestCase("12:01:00PM", "12:01:00"));
    this.testCases.add(new TimeConversionTestCase("12:01:00AM", "00:01:00"));
  }

  @Test
  void testStaircase() {
    for (TimeConversionTestCase testCase : this.testCases) {
      String solutionFound = TimeConversion.timeConversion(testCase.input);

      assertEquals(testCase.expected, solutionFound,
          String.format("%s(%s) answer must be: %s",
              "Staircase.staircase",
              testCase.input,
              testCase.expected));
    }
  }
}
