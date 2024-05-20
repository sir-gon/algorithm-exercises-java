package ae.projecteuler.helper;

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

    BigNum solutionFoundB = new BigNum(input);
    solutionFoundB.bigSum(solutionFound);

    assertArrayEquals(
        expectedAnswer,
        solutionFoundB.toArray()
    );
  }

  @Test void bigMultiplyRowToBigNumTest() {
    BigNum solutionFound;

    // Test sum operation
    Integer input = 0;
    solutionFound = new BigNum(input);
    solutionFound.bigSum(6);

    assertArrayEquals(
        new Integer[]{ 4 },
        BigNum.bigMultiplyRowToBigNum("2", 2).toArray()
    );

    assertArrayEquals(
        new Integer[]{ 2, 4 },
        BigNum.bigMultiplyRowToBigNum("12", 2).toArray()
    );

    assertArrayEquals(
        new Integer[]{ 4, 8 },
        BigNum.bigMultiplyRowToBigNum("12", 4).toArray()
    );

    assertArrayEquals(
        new Integer[]{ 8, 9, 9, 1 },
        BigNum.bigMultiplyRowToBigNum("999", 9).toArray()
    );
  }

  @Test void bigMultiplyTest() {
    assertArrayEquals(
      new BigNum("4").toArray(),
      new BigNum("2").bigMultiply("2").toArray()
    );

    assertArrayEquals(
      new BigNum("44").toArray(),
      new BigNum("2").bigMultiply("22").toArray()
    );

    assertArrayEquals(
      new BigNum("998001").toArray(),
      new BigNum("999").bigMultiply("999").toArray()
    );

    assertArrayEquals(
      new BigNum("152415787532388367501905199875019052100").toArray(),
      new BigNum("12345678901234567890").bigMultiply("12345678901234567890").toArray()
    );
  }

  @Test void bigPowerTest() {

    assertArrayEquals(
      new BigNum("4").toArray(),
      new BigNum("2").bigPower(2).toArray()
    );
    assertArrayEquals(
      new BigNum("16").toArray(),
      new BigNum("2").bigPower(4).toArray()
    );
    assertArrayEquals(
      new BigNum("32").toArray(),
      new BigNum("2").bigPower(5).toArray()
    );
    assertArrayEquals(
      new BigNum(
          "10715086071862673209484250490600018105614048117055"
        + "33607443750388370351051124936122493198378815695858"
        + "12759467291755314682518714528569231404359845775746"
        + "98574803934567774824230985421074605062371141877954"
        + "18215304647498358194126739876755916554394607706291"
        + "4571196477686542167660429831652624386837205668069376").toArray(),
      new BigNum("2").bigPower(1000).toArray()
    );

  }

  @Test void bigFactorialTest() {
    assertArrayEquals(
        new BigNum("2").toArray(),
        BigNum.bigFactorial(2).toArray()
    );
    assertArrayEquals(
        new BigNum("6").toArray(),
        BigNum.bigFactorial(3).toArray()
    );
    assertArrayEquals(
        new BigNum("120").toArray(),
        BigNum.bigFactorial(5).toArray()
    );
    assertArrayEquals(
        new BigNum("3628800").toArray(),
        BigNum.bigFactorial(10).toArray()
    );
  }
}
