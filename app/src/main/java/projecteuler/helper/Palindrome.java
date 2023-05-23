package projecteuler.helper;

/**
 * Palindrome helper.
 */
public class Palindrome {

  /**
   * Checks that a number is a palindrome
   * (reads the same in both directions: left-to-right / right-to-left).
   *
   * @param _number Number to test if it is a palindrome
   * @return Boolean
   */
  public static Boolean isPalindrome(Long _number) {
    String original = _number.toString();
    String reversed = new StringBuffer(original).reverse().toString();

    return original.equals(reversed);
  }

}
