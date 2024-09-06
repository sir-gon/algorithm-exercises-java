package ae.hackerrank.interview_preparation_kit.dictionaries_and_hashmaps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import util.JsonLoader;

@TestInstance(Lifecycle.PER_CLASS)
class RansomNoteTest {

  public static class RansomNoteTestCase {
    public String title;
    public List<String> magazine;
    public List<String> note;
    public String expected;
  }

  List<RansomNoteTestCase> testCases;

  @BeforeAll
  public void setup() throws IOException {
    String path = String.join("/", "hackerrank",
        "interview_preparation_kit",
        "dictionaries_and_hashmaps",
        "ctci_ransom_note.testcases.json");

    this.testCases = JsonLoader.loadJson(path, RansomNoteTestCase.class);
  }

  @Test void testArrayManipulation() {
    for (RansomNoteTestCase test : testCases) {
      String solutionFound = RansomNote.checkMagazine(test.magazine, test.note);

      assertEquals(test.expected, solutionFound,
          "%s(%s, %s) answer must be: %s".formatted(
            "RansomNote.checkMagazine",
            test.magazine,
            test.note,
            test.expected
          )
      );
    }
  }
}
