package ae.projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;


class CollatzTest {

  @Test void instanceCaseTest() {
    Collatz classUnderTest = new Collatz();

    assertNotNull(classUnderTest);
    assertInstanceOf(
        Collatz.class,
        classUnderTest,
        String.format("Must be an instance of %s", Collatz.class));
  }


  @Test void collatzSequenceFirstTest() {

    // Test static way
    assertEquals(40, Collatz.collatz((long) 13));
    assertEquals(20, Collatz.collatz((long) 40));
    assertEquals(10, Collatz.collatz((long) 20));
    assertEquals(5, Collatz.collatz((long) 10));
    assertEquals(16, Collatz.collatz((long) 5));
  }

  @Test void collatzSequenceSecondTest() {

    // Test static way
    assertEquals(8, Collatz.collatz((long) 16));
    assertEquals(20, Collatz.collatz((long) 40));
    assertEquals(10, Collatz.collatz((long) 20));
    assertEquals(5, Collatz.collatz((long) 10));
    assertEquals(16, Collatz.collatz((long) 5));
  }
}
