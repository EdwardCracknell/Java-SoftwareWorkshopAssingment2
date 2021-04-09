import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Edward Cracknell
 * 
 *
 */

public class Worksheet2Test {

	// negate all
	@Test
	public void test1() {

		Tree a = new Tree(5, new Tree(3, new Tree(1), new Tree(4)),
				new Tree(8, new Tree(6), new Tree(10, new Tree(9), new Tree())));
		Tree b = new Tree(5, new Tree(-3, new Tree(1), new Tree(-4)), new Tree(8, new Tree(6), new Tree()));

		Tree c = new Tree();

		Tree expected1 = new Tree(-5, new Tree(-3, new Tree(-1), new Tree(-4)),
				new Tree(-8, new Tree(-6), new Tree(-10, new Tree(-9), new Tree())));

		Tree expected2 = new Tree(-5, new Tree(3, new Tree(-1), new Tree(4)), new Tree(-8, new Tree(-6), new Tree()));

		assertEquals(Worksheet2.negateAll(a), expected1);
		assertEquals(Worksheet2.negateAll(b), expected2);
		assertEquals(Worksheet2.negateAll(c), new Tree());
	}

	// mirror
	@Test
	public void test2() {
		Tree a = new Tree(8, new Tree(5), new Tree(10, new Tree(9), new Tree(12)));
		Tree b = new Tree(15, new Tree(5, new Tree(3), new Tree(8)), new Tree(18, new Tree(17), new Tree(19)));
		Tree c = new Tree();

		Tree expected1 = new Tree(8, new Tree(10, new Tree(12), new Tree(9)), new Tree(5));
		Tree expected2 = new Tree(15, new Tree(18, new Tree(19), new Tree(17)), new Tree(5, new Tree(8), new Tree(3)));
		Tree expected3 = new Tree();

		assertEquals(Worksheet2.mirror(a), expected1);
		assertEquals(Worksheet2.mirror(b), expected2);
		assertEquals(Worksheet2.mirror(c), expected3);
	}

	// postOrder
	@Test
	public void test3() {
		Tree a = new Tree(8, new Tree(5, new Tree(2), new Tree(3, new Tree(4), new Tree())),
				new Tree(15, new Tree(6, new Tree(), new Tree(7)), new Tree(19, new Tree(), new Tree(20))));

		Tree b = new Tree(6, new Tree(3), new Tree(8));
		Tree c = new Tree(10, new Tree(7, new Tree(5), new Tree(8)), new Tree(12, new Tree(11), new Tree(15)));
		Tree d = new Tree();

		Tree e = new Tree(15, new Tree(6, new Tree(4, new Tree(), new Tree(5)), new Tree(7)),
				new Tree(23, new Tree(), new Tree(71, new Tree(50), new Tree())));

		List expected1 = new List(2, new List(4, new List(3, new List(5,
				new List(7, new List(6, new List(20, new List(19, new List(15, new List(8, List.empty()))))))))));
		List expected2 = new List(3, new List(8, new List(6, List.empty())));
		List expected3 = new List(5,
				new List(8, new List(7, new List(11, new List(15, new List(12, new List(10, List.empty())))))));

		List expected4 = new List();
		List expected5 = new List(5, new List(4,
				new List(7, new List(6, new List(50, new List(71, new List(23, new List(15, new List()))))))));

		assertEquals(Worksheet2.postOrder(a), expected1);
		assertEquals(Worksheet2.postOrder(b), expected2);
		assertEquals(Worksheet2.postOrder(c), expected3);
		assertEquals(Worksheet2.postOrder(d), expected4);
		assertEquals(Worksheet2.postOrder(e), expected5);

	}

	// all positive
	@Test
	public void test4() {
		Tree a = new Tree(10, new Tree(-20, new Tree(3), new Tree(8)), new Tree(-1, new Tree(17), new Tree(19)));
		Tree b = new Tree(8, new Tree(2), new Tree(15, new Tree(12), new Tree(25)));
		Tree c = new Tree();

		assertEquals(Worksheet2.allPositive(a), false);
		assertEquals(Worksheet2.allPositive(b), true);
		assertEquals(Worksheet2.allPositive(c), true);
	}

	// in search tree
	@Test
	public void test5() {

		Tree a = new Tree(10, new Tree(5), new Tree(25));
		Tree b = new Tree(5, new Tree(6), new Tree(8));
		Tree c = new Tree(10, new Tree(2), new Tree(15, new Tree(12), new Tree(20)));
		Tree d = new Tree(10, new Tree(2), new Tree(15, new Tree(12), new Tree(20)));
		Tree e = new Tree();

		assertEquals(Worksheet2.isSearchTree(a), true);
		assertEquals(Worksheet2.isSearchTree(b), false);
		assertEquals(Worksheet2.isSearchTree(c), true);
		assertEquals(Worksheet2.isSearchTree(d), true);
		assertEquals(Worksheet2.isSearchTree(e), true);

	}

	// Print descending is not being tested because we discussed in tutorial
	// that there was no need for JUnit tests

	// max
	@Test
	public void test7() {

		Tree a = new Tree(5, new Tree(4, new Tree(2), new Tree(5)), new Tree(10, new Tree(7), new Tree(15)));
		Tree b = new Tree(7, new Tree(2), new Tree(10));
		Tree c = new Tree(15, new Tree(10, new Tree(5), new Tree(12)),
				new Tree(25, new Tree(20), new Tree(55, new Tree(40), new Tree(120))));

		assertEquals(Worksheet2.max(a), 15);
		assertEquals(Worksheet2.max(b), 10);
		assertEquals(Worksheet2.max(c), 120);
	}

	// delete
	@Test
	public void test8() {
		Tree a = new Tree(5, new Tree(2), new Tree(7));

		Tree b = new Tree(15, new Tree(10, new Tree(5), new Tree(12)), new Tree(18));
		Tree c = new Tree(8, new Tree(5, new Tree(4), new Tree(7)),
				new Tree(15, new Tree(12), new Tree(20, new Tree(18), new Tree(22))));
		Tree d = new Tree(7, new Tree(5, new Tree(3, new Tree(2), new Tree(4)), new Tree(6)), new Tree(10));

		// simple case
		Tree expected1 = new Tree(2, new Tree(), new Tree(7));
		Tree expected2 = new Tree(5, new Tree(), new Tree(7));
		Tree expected3 = new Tree(5, new Tree(2), new Tree());

		Tree expected4 = new Tree(12, new Tree(10, new Tree(5), new Tree()), new Tree(18));
		Tree expected5 = new Tree(7, new Tree(5, new Tree(4), new Tree()),
				new Tree(15, new Tree(12), new Tree(20, new Tree(18), new Tree(22))));
		Tree expected6 = new Tree(6, new Tree(5, new Tree(3, new Tree(2), new Tree(4)), new Tree()), new Tree(10));

		Tree expected7 = new Tree(8, new Tree(5, new Tree(4), new Tree()),
				new Tree(15, new Tree(12), new Tree(20, new Tree(18), new Tree(22))));
		Tree expected8 = new Tree(8, new Tree(5, new Tree(4), new Tree(7)),
				new Tree(12, new Tree(), new Tree(20, new Tree(18), new Tree(22))));
		Tree expected9 = new Tree(7, new Tree(5, new Tree(3, new Tree(2), new Tree(4)), new Tree(6)), new Tree(10));

		assertEquals(Worksheet2.delete(a, 5), expected1);
		assertEquals(Worksheet2.delete(a, 2), expected2);
		assertEquals(Worksheet2.delete(a, 7), expected3);

		assertEquals(Worksheet2.delete(b, 15), expected4);
		assertEquals(Worksheet2.delete(c, 8), expected5);
		assertEquals(Worksheet2.delete(d, 7), expected6);

		assertEquals(Worksheet2.delete(c, 7), expected7);
		assertEquals(Worksheet2.delete(c, 15), expected8);
		assertEquals(Worksheet2.delete(d, 111111), expected9);

	}

	// PART B

	// isHeightBalanced
	@Test
	public void test9() {
		Tree a = new Tree(5, new Tree(2), new Tree(7));

		Tree b = new Tree(15, new Tree(10, new Tree(5), new Tree(12)), new Tree(18));

		Tree c = new Tree(20, new Tree(5),
				new Tree(50, new Tree(25, new Tree(23), new Tree(27)), new Tree(70, new Tree(60), new Tree(100))));

		assertEquals(Worksheet2.isHeightBalanced(a), true);
		assertEquals(Worksheet2.isHeightBalanced(b), true);
		assertEquals(Worksheet2.isHeightBalanced(c), false);

	}

	// insert HB
	@Test
	public void test10() {
		Tree a = new Tree(10, new Tree(5), new Tree());

		Tree b = new Tree(10, new Tree(), new Tree(15));

		Tree c = new Tree(-10, new Tree(-12, new Tree(-15), new Tree()), new Tree(5));

		Tree expected1 = new Tree(5, new Tree(2), new Tree(10));
		Tree expected2 = new Tree(12, new Tree(10), new Tree(15));
		Tree expected3 = new Tree(15, new Tree(10), new Tree(18));
		Tree expected4 = new Tree(-10, new Tree(-15, new Tree(-30), new Tree(-12)), new Tree(5));

		// LR
		assertEquals(Worksheet2.insertHB(2, a), expected1);
		// RL
		assertEquals(Worksheet2.insertHB(12, b), expected2);
		// RR
		assertEquals(Worksheet2.insertHB(18, b), expected3);
		// LL
		assertEquals(Worksheet2.insertHB(-30, c), expected4);

	}

	// delete HB
	@Test
	public void test11() {

		Tree a = new Tree(10, new Tree(5, new Tree(2), new Tree()), new Tree(15));

		Tree b = new Tree(4, new Tree(3), new Tree(10, new Tree(5), new Tree(55)));

		Tree c = new Tree(10, new Tree(5, new Tree(), new Tree(8)), new Tree(15));

		Tree d = new Tree(20, new Tree(7), new Tree(30, new Tree(25), new Tree()));

		Tree expected1 = new Tree(5, new Tree(2), new Tree(10));
		Tree expected2 = new Tree(10, new Tree(4, new Tree(), new Tree(5)), new Tree(55));

		Tree expected3 = new Tree(8, new Tree(5), new Tree(10));
		Tree expected4 = new Tree(25, new Tree(20), new Tree(30));
		// LL
		assertEquals(Worksheet2.deleteHB(a, 15), expected1);
		// RR
		assertEquals(Worksheet2.deleteHB(b, 3), expected2);
		// LR
		assertEquals(Worksheet2.deleteHB(c, 15), expected3);
		// RL
		assertEquals(Worksheet2.deleteHB(d, 7), expected4);

	}

}
