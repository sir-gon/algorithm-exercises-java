package projecteuler.helper;

/**
 * Product helper.
 */
public class Product {

  /**
   * Producto of array of numbers.
   */
  public static Long product(Long[] _numList) {

    if (_numList == null || _numList.length == 0) {
      return 0L;
    }

    Long result = 1L;

    for (int i = 0; i < _numList.length; i++) {
      result *= _numList[i];
    }

    return result;
  }
}
