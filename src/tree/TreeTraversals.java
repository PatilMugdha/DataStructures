package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeTraversals {

	public void morrisTraversalInOrder(Node head) {
		Node cur = head;
		while (cur != null) {
			if (cur.left == null) {
				System.out.print(" " + cur.val);
				cur = cur.right;
			} else {
				Node predecessor = cur.left;
				while (predecessor.right != null && predecessor.right != cur) {
					predecessor = predecessor.right;
				}
				if (predecessor.right == null) {
					predecessor.right = cur;
					cur = cur.left;
				} else { // predecessor.left is current
					predecessor.right = null;
					System.out.print(" " + cur.val);
					cur = cur.right;
				}
			}
		}
	}
	
	public void morrisTraversalPreOrder(Node head) {
		Node cur = head;
		while (cur != null) {
			if (cur.left == null) {
				System.out.print(" " + cur.val);
				cur = cur.right;
			} else {
				Node predecessor = cur.left;
				while (predecessor.right != null && predecessor.right != cur) {
					predecessor = predecessor.right;
				}
				if (predecessor.right == null) {
					predecessor.right = cur;
					System.out.print(" " + cur.val);
					cur = cur.left;
				} else { // predecessor.left is current
					predecessor.right = null;
					cur = cur.right;
				}
			}
		}
	}

	public void inOrderItrOneStack(Node head) {
		Deque<Node> st  = new LinkedList<Node>();
		Node node=head;
		while(true) {
			if(node!=null) {
				st.addFirst(node);
				node=node.left;
			}
			else {
				if(st.isEmpty())break;
				node=st.pollFirst();
				System.out.print(" "+node.val);
				node=node.right;
			}
		}	
	}
	
	public void preOrderItrOneStack(Node head) {
		Deque<Node> st  = new LinkedList<Node>();
		Node node=head;
		st.addFirst(node);
		while(!st.isEmpty()) {
			node=st.pollFirst();
			System.out.print(" "+node.val);
			//add right first then left
			if(node.right!=null) {
				st.addFirst(node.right);
			}
			if(node.left!=null) {
				st.addFirst(node.left);
			}
		}	
	}

	public void postOrderItrTwoStacks(Node head) {
		Deque<Node> stack1  = new LinkedList<Node>();
		Deque<Node> stack2  = new LinkedList<Node>();
		stack1.addFirst(head);
		while(!stack1.isEmpty()) {
			Node node = stack1.pollFirst();
			stack2.addFirst(node);
			if(node.left!=null) {
				stack1.push(node.left);
			}
			if(node.right!=null) {
				stack1.push(node.right);
			}	
		}
		while(!stack2.isEmpty()) {
			System.out.print(" "+stack2.pollFirst().val);
		}
	}

	public void postOrderItrOneStack(Node head) {
		Node cur=head;
		Deque<Node> stack = new LinkedList<Node>();
		while(!stack.isEmpty()||cur!=null) {
			if(cur!=null) {
				stack.addFirst(cur);
				cur=cur.left;
			}else {
				Node temp=stack.peek().right;
				if(temp==null) {
					temp=stack.poll();
					System.out.print(" "+temp.val);
					while(!stack.isEmpty() && temp==stack.peek().right) {
						temp=stack.poll();
						System.out.print(" "+temp.val);
					}
				}else {
					cur=temp;
				}
			}
		}
	}
	
	public void verticalTraversal(Node head) {
		HashMap<Integer, List<Integer>> hm  = new HashMap<Integer, List<Integer>>();
		Deque<Node> queue = new LinkedList<Node>();
		LinkedList<Integer> level = new LinkedList<Integer>();
		int hd=0;
		queue.offer(head);
		level.offer(hd);
		
		int min=0;
		int max=0;
		System.out.println("Inside");
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int l=level.poll();
			
			min=Math.min(min, l);
			max=Math.max(max, l);
			
			if(hm.containsKey(l)) {
				hm.get(l).add(cur.val);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(cur.val);
				hm.put(l, list);
			}
			
			if(cur.left!=null) {
				queue.offer(cur.left);
				level.offer(l-1);
			}
			
			if(cur.right!=null) {
				queue.offer(cur.right);
				level.offer(l+1);
			}
		}
		
		for(int i=min;i<max;i++) {
			if(hm.containsKey(i)) {
				System.out.println(hm.get(i));
			}
		}
	}
}
