package ae.projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class PalindromeTest {

  private class PalindromTestCase {
    Long input;
    Boolean answer;

    PalindromTestCase(Long input, Boolean answer) {
      this.input = input;
      this.answer = answer;
    }
  }

  // @Test void instanceCaseTest() {
  //   Palindrome classUnderTest = new Palindrome();

  //   assertNotNull(classUnderTest);
  //   assertInstanceOf(
  //       Palindrome.class,
  //       classUnderTest,
  //       String.format("Must be an instance of %s", Palindrome.class));
  // }

  @Test void listOfPalindromBorderCaseTest() {

    PalindromTestCase[] testCases = {
      new PalindromTestCase(1L, true)
    };

    for (PalindromTestCase testCase : testCases) {
      assertEquals(testCase.answer, Palindrome.isPalindrome(testCase.input));
    }
  }


}
