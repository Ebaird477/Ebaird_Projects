import java.util.Arrays;

public class Queue<E> {
	private static final int INITSIZE = 10; //initial array size
	private E[] items;
	private int numItems;
	private int head; //the index of beginning of the queue
	private int tail; //the index of end of the queue
	/*
	 * NOTE: tail refers to the next available index to insert an element, so in a sense the index after the last element of the queue
	 * For example, if queue = [0, 3, 2, 4, null, null, ...]
	 *                          ^head        ^ tail
	 */
	
	/**
	 * Constructor
	 */
	public Queue() {
		items = (E[]) new Object[INITSIZE];
		numItems = 0;
		head = 0; 
		tail = 0;
	}
	
	/**
	 * Adds the element to the end of the queue
	 * @param object to add to the queue
	 */
	public void enqueue(E obj) {
		//TODO: implement the enqueue method
		if(tail == 9) {
			tail = 0;
		}
		items[tail] = obj;
		tail++;
		if(numItems != 10) {
		numItems++;
		}
	}
	
	/**
	 * Removes from the front of the queue
	 * Return null if the queue is empty
	 * @return the value removed
	 */
	public E dequeue() {
		//TODO: implement the dequeue method
		if(tail == 0) {
			return null;
		}
		else {
			E ans = items[head];
			items[head] = null;
			head++;
			numItems--;
			return ans;
		}
	}
	
	/**
	 * @return whether the queue is empty or not
	 */
	public boolean isEmpty() {
		//TODO: implement isEmpty method
		if(tail == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void growIfNecessary() {
		if(head == tail && numItems > 0) {
			//double the length of the original stack
			E[] newItems = (E[]) new Object[2*items.length];
			
			int index = 0; //index to insert in the new array
			int count = 0;
			while(count < numItems) {
				newItems[index] = items[head];
				
				//increment head and index
				index ++;
				head ++;
				count ++;
				
				//if head is past the length of the array, loop back around to 0
				if(head >= items.length) {
					head = 0;
				}
			}
			
			//set the queue to be the new queue
			items = newItems;
			
			//set the head of the queue to be 0
			head = 0;
			
			//set the tail of the queue to be numItems
			tail = numItems;
		}
	}
	
	/**
	 * Prints the queue
	 */
	public void printQueue() {
		String queue = "";
		int index = head;
		int count = 0;
		while(count < numItems) {
			queue += items[index] + " ";
			count ++;
			index ++;
			if(index >= items.length - 1) {
				index = 0;
			}
		}
		
		System.out.println("Queue of Size " + numItems + ": " + queue);
		System.out.println("Queue in Array Form: " + Arrays.toString(items));
	}
	
	/**
	 * Reverses the given queue using a stack
	 * Use the stack that you implemented earlier in the lab
	 * @param queue: the queue you want to flip
	 */
	public static <T> Queue reverseQueue(Queue<T> queue ) {
		//TODO: implement reverseQueue method
		Stack<T> s = new Stack<>();
		Queue<T> q = new Queue<>();
		if(queue.tail == 0) {
			return null;
		}
		for (int i = queue.head; i <(queue.tail); i++) {
			s.push(queue.dequeue());
		}
		while(!(s.isEmpty())) {
			q.enqueue(s.pop());
			
		}
		return q;
	}
	
	//for main method testing
	public static void main(String[] args) {
		Queue<String> q = new Queue<>();
		System.out.println(q.isEmpty());
		q.enqueue("0");
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		q.enqueue("4");
		q.enqueue("5");
		q.enqueue("6");
		q.enqueue("7");
		q.enqueue("8");
		q.enqueue("9");
		q.enqueue("10");
		q.printQueue();
		q.dequeue();
		q.printQueue();
		
		
	
	}
}