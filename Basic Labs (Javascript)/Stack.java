import java.util.Arrays;

public class Stack<E> {
	private static final int INITSIZE = 10; //initial array size
	private E[] items;
	private int numItems; //the number of items on the stack
	private int top; //the index of top of the stack
	/*
	 * NOTE: top refers to the next available index to insert an element, so in a sense the index after the last element of the stack
	 * For example, if stack = [0, 3, 2, 4, null, null, ...]
	 *                                        ^ top
	 */
	
	/**
	 * Constructor
	 */
	public Stack() {
		items = (E[]) new Object[INITSIZE];
		numItems = 0;
		top = 0;
	}
	
	/**
	 * Pushes the specified parameter onto the stack
	 * @param obj
	 */
	public void push(E obj) {
		//TODO: implement push method
		growIfNecessary();
		items[top] = obj;
		top++;
		numItems++;
	}
	
	/**
	 * Removes the top element from the stack and returns its value
	 * Return null if the stack is empty
	 * @return the removed element on the stack
	 */
	public E pop() {
		//TODO: implement pop method
		if(items[0] == null || top == 0) {
			return null;
		}
		else {
			E ans = items[top-1];
			items[top-1] = null;
			top--;
			numItems--;
			return ans;
		}
	}
	
	/**
	 * Grows the stack if it is already full
	 */
	private void growIfNecessary() {
		if(top == items.length) {
			//double the length of the original stack
			E[] newItems = (E[]) new Object[2*items.length];
			
			//copy the items from the original stack into the new stack
			for(int i = 0; i < items.length; i++) {
				newItems[i] = items[i];
			}
			
			//set the stack to be the new stack
			items = newItems;
		}
	}
	
	/**
	 * Peeks at the top element on the stack, but doesn't remove it
	 * Return null if stack is empty
	 * @return the top element of the stack
	 */
	public E peek() {
		//TODO: implement peek method
		if(items[0] == null || top == 0) {
			return null;
		}
		else {
			return items[top-1];
		}
	}
	
	/**
	 * @return whether the queue is empty or not
	 */
	public boolean isEmpty() {
		//TODO: implement isEmpty method
		if(items[0] == null || top == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Prints the stack as an array
	 */
	public void printStack() {
		String stack = "";
		for(int i = 0; i < numItems; i++) {
			stack += items[i] + " ";
		}
		System.out.println("Stack of Size " + numItems + ": [" + stack + "]");
	}
	
	//for main method testing
	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		System.out.println(s.isEmpty());
		s.push("a");
		System.out.println(s.isEmpty());
		s.push("b");
		s.printStack();
		System.out.println(s.peek());
		s.push("c");
		s.push("d");
		System.out.println(s.pop());
		s.printStack();
		
		
	}
}