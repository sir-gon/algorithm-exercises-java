package ae.projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class NumberToWordTest {
  @Test
  void numberToWordTwoDigitsTest() throws Exception {
    // Test static way
    assertEquals("one", NumberToWord.numberToWord(1));
    assertEquals("sixteen", NumberToWord.numberToWord(16));
    assertEquals("twenty", NumberToWord.numberToWord(20));
    assertEquals("thirty", NumberToWord.numberToWord(30));
    assertEquals("sixty-four", NumberToWord.numberToWord(64));
  }

  @Test
  void numberToWordThreeDigitsTest() throws Exception {
    // Test static way
    assertEquals("three hundred and one", NumberToWord.numberToWord(301));
    assertEquals("three hundred and forty-eight", NumberToWord.numberToWord(348));
    assertEquals("five hundred", NumberToWord.numberToWord(500));
  }

  @Test
  void numberToWordBorderCasesTest() throws Exception {
    // Test static way
    assertEquals("one thousand", NumberToWord.numberToWord(1000));

    Exception exception;
    String expectedMessage;
    String actualMessage;

    exception =
        assertThrows(
            Exception.class,
            () -> {
              NumberToWord.numberToWord(-1);
            });

    expectedMessage = "Invalid value";
    actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));

    exception =
        assertThrows(
            Exception.class,
            () -> {
              NumberToWord.numberToWord(1001);
            });

    expectedMessage = "Invalid value";
    actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}
