package ae.hackerrank.interview_preparation_kit.dictionaries_and_hashmaps;

import java.util.Set;
import java.util.stream.Collectors;

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

    Set<String> dictionary =
        s1.chars().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.toSet());

    return s2.chars().mapToObj(c -> String.valueOf((char) c)).anyMatch(dictionary::contains);
  }

  public static String twoStrings(String s1, String s2) {
    return twoStringsCompute(s1, s2) ? YES : NO;
  }
}
