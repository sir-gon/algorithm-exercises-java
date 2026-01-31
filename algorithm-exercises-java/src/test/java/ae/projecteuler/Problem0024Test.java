package ae.projecteuler;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

class Problem0024Test {
  @Test
  void problem0024small() {

    String strNumber = "HOLA";
    String[] arrNumber = {"H", "O", "L", "A"};

    assertArrayEquals(arrNumber, strNumber.split(""));

    String solutionFound = "ADCB";
    String inputElements = "ABCD";
    Integer inputPermutationToFind = 6;

    assertEquals(solutionFound, Problem0024.problem0024(inputElements, inputPermutationToFind));
  }

  @EnabledIfEnvironmentVariable(named = "BRUTEFORCE", matches = "TRUE")
  @Test
  void problem0024Full() {

    String solutionFound = "2783915460";
    String inputElements = "0123456789";
    Integer inputPermutationToFind = 1000000;

    assertEquals(solutionFound, Problem0024.problem0024(inputElements, inputPermutationToFind));
  }
}
