package projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;


class BigNumTest {

  @Test void instanceCaseTest() {
    BigNum classUnderTest = new BigNum(0);

    assertNotNull(classUnderTest);
    assertInstanceOf(
        BigNum.class,
        classUnderTest,
        String.format("Must be an instance of %s", BigNum.class));
  }

  @Test void bigNumInitialiceTest() {

    BigNum solutionFound;
    Integer[] expectedAnswer = { 0 };

    // Test Integer input
    Integer input = 0;
    solutionFound = new BigNum(input);

    assertArrayEquals(
        expectedAnswer,
        solutionFound.toArray()
    );

    // Test string input
    String inputString = "0";
    solutionFound = new BigNum(inputString);

    assertArrayEquals(
        expectedAnswer,
        solutionFound.toArray()
    );

    // Test ArrayList input
    ArrayList<Integer> inputList = new ArrayList<Integer>(Arrays.asList(0));
    solutionFound = new BigNum(inputList);

    assertArrayEquals(
        expectedAnswer,
        solutionFound.toArray()
    );

  }

  @Test void bigNumbigSumTest() {
    BigNum solutionFound;

    // Test sum operation
    Integer input = 0;
    solutionFound = new BigNum(input);
    solutionFound.bigSum(6);

    Integer[] expectedAnswer = { 6 };

    assertArrayEquals(
        expectedAnswer,
        solutionFound.toArray()
    );

    solutionFound = solutionFound.bigSum(new BigNum(6));

  }
}
