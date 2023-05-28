package projecteuler.helper;

/**
 * Product helper.
 */
public class Sum {

  /**
   * Producto of array of numbers.
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
