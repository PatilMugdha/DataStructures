package coding;

import java.util.*;

public class UnmatchingParenthesis {
	public static void main(String args[]) {

		List<String> expressions = new ArrayList<String>();

		expressions.add("<>");
		expressions.add("<>><");

		// expressions.add("<>>>");
		// expressions.add("<<<><><>");
		List<Integer> maxReplacements = new ArrayList<Integer>();
		maxReplacements.add(1);
		maxReplacements.add(0);
		List<Integer> res = balancedOrNot(expressions, maxReplacements);
		for (int i : res) {
			System.out.println(i);
		}
	}

	public static List<Integer> balancedOrNot(List<String> expressions, List<Integer> maxReplacements) {
		List<Integer> countList = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		for (String s : expressions) {
			Stack<Character> st = new Stack<Character>();
			int count = 0;
			for (char c : s.toCharArray()) {
				if (c == '<') {
					st.push('>');
				} else if (!st.isEmpty() && st.peek() == c) {
					st.pop();
				} else if (st.isEmpty() || st.peek() != c) {
					count++;
				}
			}
			while (!st.isEmpty()) {
				count++;
				st.pop();
			}
			// System.out.println("Count=" + count);
			countList.add(count);
		}

		for (int i = 0; i < countList.size(); i++) {

			// System.out.println(countList.get(i));
			// System.out.println(maxReplacements.get(i));
			if (countList.get(i) <= maxReplacements.get(i)) {
				System.out.println("1");
				result.add(1);
			} else {
				result.add(0);
				System.out.println("0");
			}
		}

		return result;
	}
}
