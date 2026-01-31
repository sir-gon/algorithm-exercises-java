package ae.projecteuler.helper;

import java.util.LinkedHashMap;

/** WordScore helper. */
public class WordScore {
  private WordScore() {}

  private static final LinkedHashMap<String, Integer> _scoreLetter = new LinkedHashMap<>();

  static {
    _scoreLetter.put("A", 1);
    _scoreLetter.put("B", 2);
    _scoreLetter.put("C", 3);
    _scoreLetter.put("D", 4);
    _scoreLetter.put("E", 5);
    _scoreLetter.put("F", 6);
    _scoreLetter.put("G", 7);
    _scoreLetter.put("H", 8);
    _scoreLetter.put("I", 9);
    _scoreLetter.put("J", 10);
    _scoreLetter.put("K", 11);
    _scoreLetter.put("L", 12);
    _scoreLetter.put("M", 13);
    _scoreLetter.put("N", 14);
    _scoreLetter.put("O", 15);
    _scoreLetter.put("P", 16);
    _scoreLetter.put("Q", 17);
    _scoreLetter.put("R", 18);
    _scoreLetter.put("S", 19);
    _scoreLetter.put("T", 20);
    _scoreLetter.put("U", 21);
    _scoreLetter.put("V", 22);
    _scoreLetter.put("W", 23);
    _scoreLetter.put("X", 24);
    _scoreLetter.put("Y", 25);
    _scoreLetter.put("Z", 26);
  }

  /** WordScore. */
  public static Integer wordScore(String word) {

    int result = 0;
    int i;

    char[] chars = word.toCharArray();

    for (i = 0; i < chars.length; i++) {
      String key = String.valueOf(chars[i]);

      if (_scoreLetter.containsKey(key)) {
        result += _scoreLetter.get(key);
      }
    }

    return result;
  }
}
