/**
 * This class represent a doubly linked list of nodes of the class DoubleNode
 * 
 * @author Nicole Ni
 * @param head:         this is a reference to the first node in the list
 * @param rear:         this is a reference to the last node in the list
 * @param numDataItems: this is the number of nodes in the list
 */
public class DoubleList<T> {
	private DoubleNode<T> head;
	private DoubleNode<T> rear;
	private int numDataItems;

	/**
	 * this creats an empty list with zero nodes
	 */
	public DoubleList() {
		head = null;
		rear = null;
		numDataItems = 0;
	}

	/**
	 * This method add a new node to the list storing newData
	 */
	public void addData(int index, T newData) throws InvalidPositionException {
		DoubleNode<T> newNode = new DoubleNode<T>(newData);
		if (index < 0 || index > numDataItems) {
			throw new InvalidPositionException("Invalid Position Index");
		}
		if (head == null) { // the list is empty, index is 0
			head = newNode;
			rear = newNode;
		} else if (index == 0) { // insert the newNode before head
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
		} else if (index == numDataItems) { // insert the newNode after rear
			newNode.setPrev(rear);
			rear.setNext(newNode);
			rear = newNode;
		} else { // insert the newNode in the middle of the list
			DoubleNode<T> nodeTem = head;
			for (int i = 1; i < index; i++) {
				nodeTem = nodeTem.getNext(); // find the node before the newNode
			}
			newNode.setNext(nodeTem.getNext());
			nodeTem.setNext(newNode);
			newNode.getNext().setPrev(newNode);
			newNode.setPrev(nodeTem);
		}
		numDataItems++;
	}

	/**
	 * Return the node that is at the index position of the list
	 */
	public DoubleNode<T> getNode(int index) throws InvalidPositionException {
		DoubleNode<T> currentNode = new DoubleNode<T>();
		if (index < 0 || index >= numDataItems) {
			throw new InvalidPositionException("Invalid Position Index");
		} else if (index == 0) { // index points to the head
			currentNode = head;
		} else {
			currentNode = head;
			for (int i = 0; i < numDataItems;) {
				if (i != index) {
					currentNode = currentNode.getNext();
					i++;
				} else {
					break;
				}
			}
		}
		return currentNode;
	}

	/**
	 * Remove the node that is at the index position of the list
	 */
	public void removeData(int index) throws InvalidPositionException {
		// DoubleList<T> newDoubleList = new DoubleList<T>();
		DoubleNode<T> currentNode = this.getNode(index); // find the index node
		if (index == 0 && numDataItems > 1) { // remove the first node and there are more than 1 item in the linked list
			head = currentNode.getNext();
		} else if (index == numDataItems - 1 && numDataItems > 1) { // remove the last node and there are more than 1
																	// item in the linked list
			rear = currentNode.getPrev();
		} else if (index == 0 && numDataItems == 1) { // remove the only item in the linked list
			head = null;
			rear = null;
		} else { // general case
			currentNode.getPrev().setNext(currentNode.getNext());
			currentNode.getNext().setPrev(currentNode.getPrev());
		}
		numDataItems--;
	}

	/**
	 * Return the data stored in the node located at the index position of the list
	 */
	public T getData(int index) throws InvalidPositionException {
		DoubleNode<T> currentNode = new DoubleNode<T>();
		currentNode = this.getNode(index);
		T currentData = currentNode.getData();
		return currentData;
	}

	/**
	 * Store newData at the node in position index of the list
	 */
	public void setData(int index, T newData) throws InvalidPositionException {
		// DoubleList<T> newDoubleList = new DoubleList<T>();
		DoubleNode<T> currentNode = this.getNode(index); // find the index node
		currentNode.setData(newData);
	}

}
