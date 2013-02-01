package com.tora.tree;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class NodeTransformerTest {
	private Node root;
	
	@Before
	public void setUp() throws Exception {
		root = new Node(3);
		root.setLeft(new Node(1));
		root.setRight(new Node(5));
		
		Node left = root.getLeft();
		Node right = root.getRight();
		
		left.setRight(new Node(2));
		right.setLeft(new Node(4));
		right.setRight(new Node(6));
	}

	@Test
	public void testNodeTranformer() {
		List<Integer> tree = walkTree(root);
		NodePair list = NodeTransformer.tree2list(root);
		assertEquals(tree, walkList(list));
		assertEquals(tree, walkListReverse(list));
	}
	
	private List<Integer> walkTree(Node n) {
		if (n == null) { return Collections.emptyList(); }
		List<Integer> result = new LinkedList<Integer>();
		result.addAll(walkTree(n.getLeft()));
		result.add(n.getValue());
		result.addAll(walkTree(n.getRight()));
		return result;
	}
	
	private List<Integer> walkList(NodePair p) {
		Node curr = p.getHead();
		List<Integer> result = new LinkedList<Integer>();
		while (curr != null) {
			result.add(curr.getValue());
			curr = curr.getNext();
		}
		return result;
	}
	
	private List<Integer> walkListReverse(NodePair p) {
		Node curr = p.getTail();
		LinkedList<Integer> result = new LinkedList<Integer>();
		while (curr != null) {
			result.addFirst(curr.getValue());
			curr = curr.getPrevious();
		}
		return result;
	}	
}
