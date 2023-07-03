package projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class NumberToWordTest {

  @Test void instanceCaseTest() {
    NumberToWord classUnderTest = new NumberToWord();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        NumberToWord.class,
        classUnderTest,
        String.format("Must be an instance of %s", NumberToWord.class));
  }

  @Test void numberToWordTwoDigitsTest() throws Exception {
    // Test static way
    assertEquals("one", NumberToWord.number_to_word(1));
    assertEquals("sixteen", NumberToWord.number_to_word(16));
    assertEquals("twenty", NumberToWord.number_to_word(20));
    assertEquals("thirty", NumberToWord.number_to_word(30));
    assertEquals("sixty-four", NumberToWord.number_to_word(64));
  }

  @Test void numberToWordThreeDigitsTest() throws Exception {
    // Test static way
    assertEquals("three hundred and one", NumberToWord.number_to_word(301));
    assertEquals("three hundred and forty-eight", NumberToWord.number_to_word(348));
    assertEquals("five hundred", NumberToWord.number_to_word(500));
  }

  @Test void numberToWordBorderCasesTest() throws Exception {
    // Test static way
    assertEquals("one thousand", NumberToWord.number_to_word(1000));

    Exception exception;
    String expectedMessage;
    String actualMessage;

    exception = assertThrows(Exception.class, () -> {
      NumberToWord.number_to_word(-1);
    });

    expectedMessage = "Invalid value";
    actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));

    exception = assertThrows(Exception.class, () -> {
      NumberToWord.number_to_word(1001);
    });

    expectedMessage = "Invalid value";
    actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }
}
