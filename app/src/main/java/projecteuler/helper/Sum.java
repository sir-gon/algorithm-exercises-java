package projecteuler.helper;

/**
 * Sum helper.
 */
public class Sum {
  /**
   * Sum of array of numbers.
   */
  public static Integer sum(Integer[] _numList) {

    if (_numList == null || _numList.length == 0) {
      return 0;
    }

    Integer result = 0;

    for (int i = 0; i < _numList.length; i++) {
      result += _numList[i];
    }

    return result;
  }

  /**
   * Sum of array of numbers.
   */
  public static Long sum(Long[] _numList) {

    if (_numList == null || _numList.length == 0) {
      return 0L;
    }

    Long result = 0L;

    for (int i = 0; i < _numList.length; i++) {
      result += _numList[i];
    }

    return result;
  }
}
