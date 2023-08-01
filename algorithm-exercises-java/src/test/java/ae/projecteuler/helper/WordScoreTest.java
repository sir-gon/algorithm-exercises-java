package ae.projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


class WordScoreTest {

  @Test void instanceCaseTest() {
    WordScore classUnderTest = new WordScore();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        WordScore.class,
        classUnderTest,
        String.format("Must be an instance of %s", WordScore.class));
  }

  @Test void wordScoreTest() {
    // Test static way
    assertEquals(1 + 2 + 3, WordScore.wordScore("ABC"));
    assertNotEquals(0, WordScore.wordScore("ABC"));

    assertEquals(15 * 2 + 20 * 2, WordScore.wordScore("OTTO"));
    assertNotEquals(0, WordScore.wordScore("OTTO"));

    assertEquals(53, WordScore.wordScore("COLIN"));
    assertNotEquals(0, WordScore.wordScore("COLIN"));
  }

  @Test void wordScoreWrongCasesTest() {
    assertEquals(0, WordScore.wordScore(""));
    assertEquals(0, WordScore.wordScore("1"));
    assertEquals(0, WordScore.wordScore("#"));
  }
}
