package projecteuler.helper;

import java.util.ArrayList;
import java.util.Collections;

/**
 * BigNums helper.
 */
public class BigNum {

  int cycles = 0;
  ArrayList<Integer> value = new ArrayList<Integer>();

  /**
   * Big number from string.
   */
  public BigNum(String strNumber) {
    // reset value
    this.value = new ArrayList<Integer>();

    for (String t : strNumber.split("")) {
      this.value.add(Integer.parseInt(t));
    }
  }

  public BigNum(Integer number) {
    this.bigSum(String.valueOf(number));
  }

  public BigNum(ArrayList<Integer> number) {
    this.value = number;
  }

  /**
   *  Get raw internal value.
   */
  private ArrayList<Integer> getInternalValue() {
    return this.value;
  }

  /**
   *  Get intervanl value as Array.
   */
  public Integer[] toArray() {
    ArrayList<Integer> valueFound = this.getInternalValue();

    return valueFound.toArray(new Integer[valueFound.size()]);
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
  public BigNum bigSum(ArrayList<Integer> numberList) {
    ArrayList<Integer> a = this.getInternalValue();
    ArrayList<Integer> b = numberList;
    ArrayList<Integer> result = new ArrayList<Integer>();

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

    // do the sum
    for (int i = 0; i < a.size(); i++) {
      sum = a.get(i) + b.get(i) + carry;

      if (sum < 10) {
        digit = sum;
        carry = 0;
      } else {
        digit = sum % 10;
        carry = (int) Math.floor(sum / 10);
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
    BigNum result = new BigNum("0");

    for (int i = 0; i < strNumberArr.length; i++) {
      result = this.bigSum(strNumberArr[i]);
    }

    return result;
  }

  /**
   * bigMultiplyRowToBigNum.
   */
  public static BigNum bigMultiplyRowToBigNum(String strNumber, int multiplierDigit) {
    ArrayList<Integer> number = new BigNum(strNumber).getInternalValue();
    Collections.reverse(number);

    ArrayList<Integer> result = new ArrayList<Integer>();

    int mul = 0;
    int carry = 0;
    int digit = 0;

    for (int i = 0; i < number.size(); i++) {
      mul = number.get(i) * multiplierDigit + carry;
      if (mul < 10) {
        digit = mul;
        carry = 0;
      } else {
        digit = (int) Math.floor(mul % 10);
        carry = (int) Math.floor(mul / 10);
      }

      result.add(digit);
    }

    if (carry > 0) {
      result.add(carry);
    }
    Collections.reverse(result);

    return new BigNum(result);
  }

}
