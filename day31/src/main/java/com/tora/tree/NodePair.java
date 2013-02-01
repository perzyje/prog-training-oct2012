package com.tora.tree;

final class NodePair {
	private final Node head, tail;
	
	NodePair(Node head, Node tail) {
		this.head = head;
		this.tail = tail;
	}

	public Node getHead() { return head; }

	public Node getTail() {	return tail; }
}
