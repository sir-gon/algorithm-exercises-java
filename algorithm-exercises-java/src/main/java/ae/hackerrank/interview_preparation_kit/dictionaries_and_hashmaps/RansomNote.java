package ae.hackerrank.interview_preparation_kit.dictionaries_and_hashmaps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.Log;

/**
 * RansomNote.
 *
 * @link Problem definition
 *     [[docs/hackerrank/interview_preparation_kit/dictionaries_and_hashmaps/ctci-ransom-note.md]]
 */
public class RansomNote {
  /** InvalidValueException. */
  public class InvalidValueException extends Exception {
    // constructor for the InvalidAgeException class
    public InvalidValueException(String msg) {
      Log.error(msg);
    }
  }

  protected RansomNote() {}

  private static final String YES = "Yes";
  private static final String NO = "No";

  /** checkMagazineCompute. */
  public static boolean checkMagazineCompute(List<String> magazine, List<String> note) {
    Map<String, Integer> dictionary = new HashMap<>();

    for (String word : magazine) {
      if (dictionary.putIfAbsent(word, 1) != null) {
        Integer currentValue = dictionary.get(word);
        dictionary.put(word, currentValue + 1);
      }
    }

    for (String word : note) {
      try {
        dictionary.put(word, dictionary.get(word) - 1);
        if (dictionary.get(word) < 0) {
          throw new RansomNote().new InvalidValueException("Value can't go below 0");
        }
      } catch (Exception e) {
        return false;
      }
    }

    return true;
  }

  /** checkMagazine. */
  public static String checkMagazine(List<String> magazine, List<String> note) {
    return checkMagazineCompute(magazine, note) ? YES : NO;
  }
}
