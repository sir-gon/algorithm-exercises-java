package ae.hackerrank.interview_preparation_kit.dictionaries_and_hashmaps;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * SherlockAndAnagrams.
 *
 * @link Problem definition [[docs/hackerrank/interview_preparation_kit/dictionaries_and_hashmaps/sherlock_and_anagrams.md]]
 * @link Solution notes [[docs/hackerrank/interview_preparation_kit/dictionaries_and_hashmaps/sherlock_and_anagrams-solution-notes.md]]
 */
public class SherlockAndAnagrams {
  private SherlockAndAnagrams() {}

  /**
   * factorial().
   */
  public static BigInteger factorial(int number) {
    BigInteger result = BigInteger.ONE;
    for (int i = 1; i <= number; i++) {
      result = result.multiply(new BigInteger(Integer.toString(i)));
    }

    return result;
  }

  /**
   * sherlockAndAnagrams.
   */
  public static int sherlockAndAnagrams(String sWord) {

    Map<String, List<String>> candidates = new HashMap<>();
    int size = sWord.length();

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size - i; j++) {
        String substr = sWord.substring(i, size - j);

        // Add substrings to a candidate list.
        // two strings are anagrams if sorted strings are the same.
        String anagramCandidate = Arrays.stream(substr.split(""))
                                         .sorted()
                                         .collect(Collectors.joining());


        // Append candidates to dictionary by "sorted string" key
        if (candidates.containsKey(anagramCandidate)) {
          candidates.get(anagramCandidate).add(substr);
        } else {
          ArrayList<String> anagrams = new ArrayList<>();
          anagrams.add(substr);
          candidates.put(anagramCandidate, anagrams);
        }
      }
    }

    int total = 0;

    // Final Anagram list
    for (Map.Entry<String, List<String>> entry : candidates.entrySet()) {
      int quantityOfAnagrams = entry.getValue().size();
      int k = 2;

      if (quantityOfAnagrams > 1) {
        // Binomial coefficient: https://en.wikipedia.org/wiki/Binomial_coefficient
        int count = factorial(quantityOfAnagrams).divide(
            (factorial(k).multiply(factorial(quantityOfAnagrams - k)))
        ).intValue();
        total += count;
      }
    }

    return total;
  }
}
