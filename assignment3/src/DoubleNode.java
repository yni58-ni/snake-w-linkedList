
/**
 * This class represents the nodes in a doubly linked list
 * 
 * @author Nicole Ni
 *
 * @param next: A reference to the next node in the list
 * @param prev: A reference to the previous node in the list
 * @param data: The data stored in this node
 */
public class DoubleNode<T> {
	private DoubleNode<T> next;
	private DoubleNode<T> prev;
	private T data;

	/**
	 * Creats an empty node, where all instance variables are null
	 */
	public DoubleNode() {
		next = null;
		prev = null;
		data = null;
	}

	/**
	 * creats a node storing the given data in which next and prev are null
	 */
	public DoubleNode(T newData) {
		next = null;
		prev = null;
		data = newData;
	}

	/**
	 * Return the nalue of next
	 */
	public DoubleNode<T> getNext() {
		return next;
	}

	/**
	 * Return the value of prev.
	 */
	public DoubleNode<T> getPrev() {
		return prev;
	}

	/**
	 * return the value of data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Store nextNode in next
	 */
	public void setNext(DoubleNode<T> nextNode) {
		next = nextNode;
	}

	/**
	 * stores prevNode in prev
	 */
	public void setPrev(DoubleNode<T> prevNode) {
		prev = prevNode;
	}

	public void setData(T newData) {
		data = newData;
	}
}
