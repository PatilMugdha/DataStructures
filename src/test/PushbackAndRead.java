package test;

import java.util.Stack;

/**
 * 
 * @author patil
 *
 */
public class PushbackAndRead {

	private static final char ADDRESS = '@';
	private static final char DOT = '.';

	public static void main(String[] args) {

		String str = "t.y.lin@sjsu.edu";

		Stack<Character> stack = new Stack();
		int i = 0;

		for (i = 0; i < str.length() - 1; i++) {
			if (!stack.isEmpty()) {
				System.out.println("Item popped and read from Pushback: " + stack.pop());
			} else {
				System.out.println("Normal read operation: " + str.charAt(i));
			}
			if (str.charAt(i + 1) == PushbackAndRead.ADDRESS || str.charAt(i + 1) == PushbackAndRead.DOT) {
				System.out.println("Pushing character '" + str.charAt(i + 1) + "' in stack");
				stack.push(str.charAt(i + 1));
			}
		}

		if (!stack.isEmpty()) {
			System.out.println("Item popped from Pushback: " + stack.pop());
		} else {
			System.out.println("Normal read operation: " + str.charAt(i));
		}
	}

}
