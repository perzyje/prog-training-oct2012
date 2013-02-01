package com.tora.tree;

final class Node {
	private Node a, b;
	private final int value;
	
	Node(int value) {
		this(null, null, value);
	}
	
	Node(Node a, Node b, int value) {
		this.a = a;
		this.b = b;
		this.value = value;
	}

	int getValue() { return value; }

	Node getLeft() { return a; }
	Node getRight() { return b; }
	void setLeft(Node left) { this.a = left; }
	void setRight(Node right) { this.b = right; }

	Node getPrevious() { return a; }
	Node getNext() { return b; }
	void setPrevious(Node previous) { this.a = previous; }
	void setNext(Node next) { this.b = next; }
}
