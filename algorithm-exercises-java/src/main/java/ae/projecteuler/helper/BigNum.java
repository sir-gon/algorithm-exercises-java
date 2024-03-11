package ae.projecteuler.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BigNums helper.
 */
public class BigNum {

  static java.util.logging.Logger logger = ae.projecteuler.util.CustomLogger.getLogger();

  int cycles = 0;
  List<Integer> value = new ArrayList<>();

  /**
   * Big number from string.
   */
  public BigNum(String strNumber) {
    // reset value
    this.value = new ArrayList<>();

    for (String t : strNumber.split("")) {
      this.value.add(Integer.parseInt(t));
    }
  }

  public BigNum(Integer number) {
    this.bigSum(String.valueOf(number));
  }

  public BigNum(List<Integer> number) {
    this.value = number;
  }

  /**
   *  Get raw internal value.
   */
  private List<Integer> getInternalValue() {
    return this.value;
  }

  /**
   *  Get intervanl value as Array.
   */
  public Integer[] toArray() {
    List<Integer> valueFound = this.getInternalValue();

    return valueFound.toArray(new Integer[valueFound.size()]);
  }

  /**
   *  Get value as String.
   */
  public String toString() {
    return this.value
      .stream()
      .map(Object::toString)
      .collect(Collectors.joining(""));
  }

  /**
   * Calculate the sum of internal value with a new.
   */
  public BigNum bigSum(Integer number) {
    return this.bigSum(String.valueOf(number));
  }

  /**
   * Calculate the sum of internal value with a new.
   */
  public BigNum bigSum(String strNumber) {
    return this.bigSum(new BigNum(strNumber).getInternalValue());
  }

  /**
   * Calculate the sum of internal value with a new.
   */
  public BigNum bigSum(BigNum bigNum) {
    return this.bigSum(bigNum.getInternalValue());
  }

  /**
   * Calculate the sum of internal value with a new.
   */
  public BigNum bigSum(List<Integer> numberList) {
    List<Integer> a = this.getInternalValue();
    List<Integer> b = numberList;

    Collections.reverse(a);
    Collections.reverse(b);

    int sum = 0;
    int carry = 0;
    int digit = 0;

    if (a.size() > b.size()) {
      for (int i = b.size(); i < a.size(); i++) {
        b.add(0);
      }
    } else if (b.size() > a.size()) {
      for (int i = a.size(); i < b.size(); i++) {
        a.add(0);
      }
    }

    ArrayList<Integer> result = new ArrayList<>();
    // do the sum
    for (int i = 0; i < a.size(); i++) {
      sum = a.get(i) + b.get(i) + carry;

      if (sum < 10) {
        digit = sum;
        carry = 0;
      } else {
        digit = sum % 10;
        carry = (int) Math.floor((double) sum / 10);
      }

      result.add(digit);
    }
    if (carry > 0) {
      result.add(carry);
    }

    Collections.reverse(result);

    this.value = result;
    return this;
  }

  /**
   * Calculate the sum of many BigNum as a list of strings.
   */
  public BigNum bigSumMany(String[] strNumberArr) {
    for (int i = 0; i < strNumberArr.length; i++) {
      this.bigSum(strNumberArr[i]);
    }

    return this;
  }

  /**
   * Calculate the sum of many BigNum as a list of integers.
   */
  public BigNum bigSumMany(Integer[] numberArr) {
    for (int i = 0; i < numberArr.length; i++) {
      this.bigSum(numberArr[i]);
    }

    return this;
  }

  /**
   * bigMultiplyRowToBigNum.
   */
  public static BigNum bigMultiplyRowToBigNum(String strNumber, int multiplierDigit) {
    List<Integer> number = new BigNum(strNumber).getInternalValue();
    Collections.reverse(number);

    ArrayList<Integer> result = new ArrayList<>();

    int mul = 0;
    int carry = 0;
    int digit = 0;

    for (int i = 0; i < number.size(); i++) {
      mul = number.get(i) * multiplierDigit + carry;
      if (mul < 10) {
        digit = mul;
        carry = 0;
      } else {
        digit = (int) Math.floor((double) mul % 10);
        carry = (int) Math.floor((double) mul / 10);
      }

      result.add(digit);
    }

    if (carry > 0) {
      result.add(carry);
    }
    Collections.reverse(result);

    return new BigNum(result);
  }

  /**
   * Calculate the sum of many BigNum as a list of strings.
   */
  public BigNum bigMultiply(String strNumMultiplier) {
    String strMultiply = this.toString();

    ArrayList<String> collector = new ArrayList<>();

    List<Integer> bigNumMultiplier = new BigNum(strNumMultiplier).getInternalValue();
    Collections.reverse(bigNumMultiplier);

    for (int i = 0; i < bigNumMultiplier.size(); i++) {
      // Product of multiply digits as rows by every multiplier digit
      StringBuilder row = new StringBuilder();
      String rowProduct = bigMultiplyRowToBigNum(strMultiply, bigNumMultiplier.get(i)).toString();

      row.append(rowProduct);

      // padding position by row
      for (int j = 0; j < i; j++) {
        row.append("0");
      }

      collector.add(row.toString());
    }

    this.value = new ArrayList<>();
    return this.bigSumMany(collector.toArray(new String[collector.size()]));
  }

  /**
   * .
   */
  public BigNum bigPower(int exponent) {
    BigNum result = new BigNum(1);
    String base = this.toString();

    for (int i = 1; i < exponent; i++) {
      result = this.bigMultiply(base);
    }

    return result;
  }

  /**
   * .
   */
  public static BigNum bigFactorial(int number) {
    BigNum acum = new BigNum(1);

    for (int multiplier = 1; multiplier <= number; multiplier++) {
      acum = acum.bigMultiply(String.valueOf(multiplier));
    }

    return acum;
  }
}
