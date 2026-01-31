package ae.hackerrank.interview_preparation_kit.dictionaries_and_hashmaps;

import java.util.HashSet;
import java.util.Set;

/**
 * TwoStrings.
 *
 * @link Problem definition
 *     [[docs/hackerrank/interview_preparation_kit/dictionaries_and_hashmaps/two-strings.md]]
 * @link Solution notes
 *     [[docs/hackerrank/interview_preparation_kit/dictionaries_and_hashmaps/two-strings-solution-notes.md]]
 */
public class TwoStrings {
  private TwoStrings() {}

  private static final String YES = "YES";
  private static final String NO = "NO";

  /** twoStringsCompute. */
  public static boolean twoStringsCompute(String s1, String s2) {

    Set<String> dictionary = new HashSet<>();

    for (char occurrence : s1.toCharArray()) {
      dictionary.add("%c".formatted(occurrence));
    }

    for (char occurrence : s2.toCharArray()) {
      if (dictionary.contains("%c".formatted(occurrence))) {
        return true;
      }
    }

    return false;
  }

  public static String twoStrings(String s1, String s2) {
    return twoStringsCompute(s1, s2) ? YES : NO;
  }
}
