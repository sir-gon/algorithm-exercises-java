package ae.projecteuler.lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
class BinaryNodeTest {

  @Test void instanceCaseTest() {
    BinaryNode<Integer> classUnderTest = new BinaryNode<Integer>(0);

    assertNotNull(classUnderTest);
    assertInstanceOf(
        BinaryNode.class,
        classUnderTest,
        String.format("Must be an instance of %s", BinaryNode.class));
  }

  @Test void getValueTest() {

    Integer value = 5;
    BinaryNode<Integer> testNodeA = new BinaryNode<Integer>(5);

    assertEquals(value, testNodeA.getValue());

    BinaryNode<Integer> testNodeB = new BinaryNode<Integer>(testNodeA);

    assertEquals(value, testNodeB.getValue());

    BinaryNode<Integer> testNodeC = new BinaryNode<Integer>();
    testNodeC.setValue(value);

    assertEquals(value, testNodeC.getValue());

    BinaryNode<Integer> testNodeD = new BinaryNode<Integer>(testNodeC);

    assertEquals(value, testNodeD.getValue());
  }

  @Test void binaryNodeLeftTest() {
    String valueA = "A";
    String valueLeft = "Z";

    BinaryNode<String> testNodeA = new BinaryNode<String>(valueA);
    testNodeA.setLeft(new BinaryNode<String>(valueLeft));

    assertNotNull(testNodeA.getLeft());
    assertEquals(valueLeft, testNodeA.getLeft().getValue());
  }

  @Test void binaryNodeRightTest() {
    String valueA = "A";
    String valueRight = "Z";

    BinaryNode<String> testNodeA = new BinaryNode<String>(valueA);
    testNodeA.setRight(new BinaryNode<String>(valueRight));

    assertNotNull(testNodeA.getRight());
    assertEquals(valueRight, testNodeA.getRight().getValue());
  }

  @Test void binaryNodeBothBranchesTest() {
    String valueA = "A";
    String valueLeft = "X";
    String valueRight = "Y";

    BinaryNode<String> testNodeA = new BinaryNode<String>(valueA,
        new BinaryNode<String>(valueLeft),
        new BinaryNode<String>(valueRight)
    );

    assertNotNull(testNodeA.getLeft());
    assertNotNull(testNodeA.getRight());
    assertEquals(valueLeft, testNodeA.getLeft().getValue());
    assertEquals(valueRight, testNodeA.getRight().getValue());
  }

  @Test void binaryNodeIsLeafTest() {
    String valueA = "A";

    // both branches are null
    BinaryNode<String> testNodeA = new BinaryNode<String>(valueA);

    assertEquals(true, testNodeA.isLeaf());

    // both child branches has values
    testNodeA = new BinaryNode<String>(valueA,
        new BinaryNode<String>(valueA),
        new BinaryNode<String>(valueA)
    );

    assertEquals(false, testNodeA.isLeaf());

    // left branch is null
    testNodeA = new BinaryNode<String>(valueA,
        null,
        new BinaryNode<String>(valueA)
    );

    assertEquals(false, testNodeA.isLeaf());

    // right branch is null
    testNodeA = new BinaryNode<String>(valueA,
        new BinaryNode<String>(valueA),
        null
    );

    assertEquals(false, testNodeA.isLeaf());
  }

  @Test void binaryNodeEqualityTest() {
    // Same instance
    BinaryNode<String> testNodeA = new BinaryNode<String>("A");
    assertEquals(testNodeA, testNodeA);

    // Comparing to incompatible object
    assertNotEquals("A", new BinaryNode<String>("A"));

    // Same type, both with null type
    assertEquals(new BinaryNode<String>(),  new BinaryNode<String>());

    // Two null values of different types can't be compared, so... both will be "equal"
    assertEquals(new BinaryNode<Integer>(), new BinaryNode<String>());

    // Test different value types:
    assertNotEquals(new BinaryNode<String>("A"), new BinaryNode<Integer>(1));

    // Test same value types, but different values:
    assertNotEquals(new BinaryNode<String>("A"), new BinaryNode<String>("B"));
    assertNotEquals(new BinaryNode<Integer>(1), new BinaryNode<Integer>(0));

    // Test same value types and values:
    assertEquals(new BinaryNode<Integer>(1), new BinaryNode<Integer>(1));
    assertEquals(new BinaryNode<String>("A"), new BinaryNode<String>("A"));

    // One value is null
    assertNotEquals(new BinaryNode<String>(), new BinaryNode<String>("A"));
    assertNotEquals(new BinaryNode<String>("A"), new BinaryNode<String>());
  }
}
