
/**
 * @author Edward Cracknell
 * 
 *         This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface {
	// Exercise 1

	/**
	 * @param a
	 *            is the Tree we are negating
	 * @return Tree that is the same as the previous tree except that every node
	 *         has been multiplied by -1 (negated)
	 */
	public static Tree negateAll(Tree a) {
		if (a.getEmpty()) {
			return new Tree();
		} else
			return new Tree((-1) * a.getValue(), negateAll(a.getLeft()), negateAll(a.getRight()));

	}
	// Exercise 2

	/**
	 * @param a
	 *            is the Tree we are mirroring
	 * @return Tree that is the mirror image of the previous tree
	 */
	public static Tree mirror(Tree a) {
		if (a.getEmpty()) {
			return new Tree();
		} else
			return new Tree(a.getValue(), mirror(a.getRight()), mirror(a.getLeft()));
	}
	// Exercise 3

	/**
	 * @param a
	 *            is the Tree we are finding the postOrder of
	 * @return List that is found for any node on our tree by visiting the left
	 *         subtrees node, followed by the right subtrees node followed by
	 *         the node we are at. To make the recursive method into a list we
	 *         have used the ListOps.append method.
	 */
	public static List postOrder(Tree a) {
		if (a.getEmpty()) {
			return List.empty();
		} else
			return ListOps.append(ListOps.append(postOrder(a.getLeft()), postOrder(a.getRight())),
					new List(a.getValue(), List.empty()));

	}

	// Exercise 4

	/**
	 * @param a
	 *            is the Tree we are checking if every node is positive
	 * @return Boolean if every node is positive will return true, if any node
	 *         is negative it will return false
	 */
	public static boolean allPositive(Tree a) {
		if (a.getEmpty()) {
			return true;
		} else {
			if (a.getValue() >= 0) {
				return allPositive(a.getLeft()) && allPositive(a.getRight());
			} else
				return false;
		}
	}
	// Exercise 5

	/**
	 * @param a
	 *            is the Tree we are checking if it satisfies the search tree
	 *            properties
	 * @return boolean True if the Tree satisfies the search tree property or
	 *         false if it fails.
	 */
	public static boolean isSearchTree(Tree a) {
		if (a.getEmpty()) {
			return true;
		} else if (a.getLeft().getEmpty() && a.getRight().getEmpty()) {
			return true;
		} else if ((a.getLeft().getValue() < a.getValue()) && (a.getRight().getValue() > a.getValue())) {
			return isSearchTree(a.getLeft()) && isSearchTree(a.getRight());
		} else {
			return false;
		}
	}

	// Exercise 6

	/**
	 * 
	 * @param a
	 *            Tree we are printing from This method will print out the
	 *            values in our Tree in descending order. It does this by
	 *            recursively visiting every node starting from the largest and
	 *            making its way to the smallest node and printing out the
	 *            result.
	 */
	public static void printDescending(Tree a) {
		if (a.getEmpty()) {
			System.out.print(" ");
		} else if (a.getHeight() == 1) {
			System.out.print(a.getValue() + " ");
		} else {
			printDescending(a.getRight());
			System.out.print(a.getValue() + " ");
			printDescending(a.getLeft());
		}
	}

	// Exercise 7

	/**
	 * @param a
	 *            is the Tree we are finding the maximum value of
	 * @return int maximum value of the Tree gathered by recursively going down
	 *         to the most bottom right tree and retrieving the value found at
	 *         the node with a right subtree that is empty.
	 */
	public static int max(Tree a) {
		if (a.getEmpty()) {
			return 0;
		} else if (a.getRight().empty == false) {
			return max(a.getRight());
		} else
			return a.getValue();
	}

	// Exercise 8

	/**
	 * @param a
	 *            the tree we are deleting from
	 * @param x
	 *            int value that is being deleted
	 * @return Tree with the node that has the value of x deleted. If the node
	 *         is the same as the value of the root node then we replace the
	 *         node with the maximum value in the left subtree ( but then we
	 *         also need to delete the maximum value of the subtree when making
	 *         our new tree). If the node is bigger or smaller then we
	 *         recursively call the delete function on the left or right subtree
	 *         till we find a value equal to the value of x we want to delete.
	 */
	public static Tree delete(Tree a, int x) {
		if (a.empty) {
			return new Tree();
		} else {
			if (x == a.getValue()) {
				if (max(a.getLeft()) == 0) {
					return new Tree();
				} else {
					return new Tree(max(a.getLeft()), delete(a.getLeft(), max(a.getLeft())), a.getRight());
				}
			} else if (x < a.getValue()) {
				return new Tree(a.getValue(), delete(a.getLeft(), x), a.getRight());
			} else
				return new Tree(a.getValue(), a.getLeft(), delete(a.getRight(), x));
		}
	}

	// Exercise 9

	/**
	 * @param a
	 *            Tree were checking for height balance
	 * @return boolean true if the difference in height of any tree and subtree
	 *         is <= 1 and false if it is >1 for any tree and subtree
	 *         combination
	 */
	public static boolean isHeightBalanced(Tree a) {
		if (a.getEmpty()) {
			return true;
		} else if (Math.abs(a.getLeft().getHeight() - a.getRight().getHeight()) > 1) {
			return false;
		} else {
			if (isHeightBalanced(a.getLeft()) && isHeightBalanced(a.getRight())) {
				return true;
			} else
				return false;
		}
	}

	// Exercise 10
	/*
	 * For exercise 10 I have used helper functions for the LL, LR, RL and RR
	 * rotations. These helper methods are used by the balance method which is
	 * used for insertHB and deleteHB.
	 */
	/**
	 * 
	 * @param a
	 *            Tree
	 * @return balanced Tree from the LL heavy tree.
	 */
	public static Tree LL(Tree a) {
		return new Tree(a.getLeft().getValue(), a.getLeft().getLeft(),
				new Tree(a.getValue(), a.getLeft().getRight(), a.getRight()));
	}

	// make LL from LR
	/**
	 * 
	 * @param a
	 *            Tree
	 * @return LL heavy tree from a RL heavy tree.
	 */
	public static Tree LR(Tree a) {
		return new Tree(a.getValue(),
				new Tree(a.getLeft().getRight().getValue(),
						new Tree(a.getLeft().getValue(), a.getLeft().getLeft(), a.getLeft().getRight().getLeft()),
						a.getLeft().getRight().getRight()),
				a.getRight());
	}

	/**
	 * 
	 * @param a
	 *            Tree
	 * @return RR heavy tree from a RL heavy tree
	 */
	public static Tree RL(Tree a) {
		return new Tree(a.getValue(), a.getLeft(),
				new Tree(a.getRight().getLeft().getValue(), a.getRight().getLeft().getLeft(),
						new Tree(a.getRight().getValue(), a.getRight().getLeft().getRight(), a.getRight().getRight())));
	}

	/**
	 * 
	 * @param a
	 *            Tree
	 * @return balanced tree from a RR heavy tree
	 */
	public static Tree RR(Tree a) {
		return new Tree(a.getRight().getValue(), new Tree(a.getValue(), a.getLeft(), a.getRight().getLeft()),
				a.getRight().getRight());
	}

	/*
	 * The RBal and LBal methods come in useful when we consider the deleteHB
	 * method as there could be a case were the right or left of our node is
	 * heavy but its subtree has a neutral height balance
	 */
	/**
	 * 
	 * @param a
	 *            Tree
	 * @return Tree that is balanced form a Tree that has a Right heavy root
	 *         node and a balanced right subtree
	 */
	public static Tree RBal(Tree a) {
		return new Tree(a.getRight().getValue(), new Tree(a.getValue(), new Tree(), a.getRight().getLeft()),
				a.getRight().getRight());
	}

	/**
	 * 
	 * @param a
	 *            Tree
	 * @return Tree that is balanced form a Tree that has a Left heavy root node
	 *         and a balanced left subtree
	 */
	public static Tree LBal(Tree a) {
		return new Tree(a.getLeft().getValue(), a.getLeft().getLeft(),
				new Tree(a.getValue(), a.getLeft().getRight(), new Tree()));
	}

	/**
	 * 
	 * @param a
	 *            Tree
	 * @return Balance factor is just the left subtree height - the right
	 *         subtree height
	 */
	public static int balanceFactor(Tree a) {
		return ((a.getLeft().getHeight()) - (a.getRight().getHeight()));
	}

	/**
	 * 
	 * @param a
	 *            Tree that is being balanced
	 * @return Tree that has gone through the necessary rotations to be balanced
	 * 
	 */
	public static Tree balance(Tree a) {
		if (balanceFactor(a) == 2) {
			if (balanceFactor(a.getLeft()) == -1) {
				a = LL(LR(a));
			} else if (balanceFactor(a.getLeft()) == 1) {
				a = LL(a);
			} else if (balanceFactor(a.getLeft()) == 0) {
				a = LBal(a);
			}
			return a;

		} else {
			if (balanceFactor(a) == -2) {
				if (balanceFactor(a.getRight()) == 1) {
					a = RR(RL(a));
				} else if (balanceFactor(a.getRight()) == -1) {
					a = RR(a);
				} else if (balanceFactor(a.getRight()) == 0) {
					a = RBal(a);
				}
			}

		}
		return a;

	}

	/**
	 * 
	 * @param x
	 *            value being inserted
	 * @param a
	 *            Tree that is having the value inserted
	 * @return a height balanced tree that satisfies the binary search tree
	 *         properties because of undergoing the necessary rotations using
	 *         the balance method after the insertion of x has been made
	 */
	public static Tree insertHB(int x, Tree a) {
		if (a.getEmpty()) {
			return new Tree(x, new Tree(), new Tree());
		} else if (x < a.getValue()) {
			Tree b = new Tree(a.getValue(), insertHB(x, a.getLeft()), a.getRight());
			return balance(b);
		} else {
			Tree c = new Tree(a.getValue(), a.getLeft(), insertHB(x, a.getRight()));
			return balance(c);
		}
	}

	/**
	 * 
	 * @param a
	 *            Tree that is having the x deleted
	 * @param x
	 *            int that is being deleted from our tree
	 * @return Tree height balanced without the value x by implementing the
	 *         delete method and balance method to return a balanced tree
	 */
	public static Tree deleteHB(Tree a, int x) {
		return balance(delete(a, x));
	}
}
