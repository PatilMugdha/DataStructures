package tree;

class Node{
	Node left;
	Node right;
	int val;
	public Node(int val){
		this.left=null;
		this.right=null;
		this.val=val;
	}
}


public class BinaryTree {
    
	public static void main(String args[]) {
		BinaryTree bt=new BinaryTree();
		Node head=null;
        head = bt.add(10, head);
        head = bt.add(15, head);
        head = bt.add(19, head);
        head = bt.add(17, head);
        head = bt.add(11, head);

        head = bt.add(-11, head);
        
        TreeTraversals tt = new TreeTraversals();
        System.out.println("Morris Inorder Traversal: ");
        tt.morrisTraversalInOrder(head);

        System.out.println("\nInorder Traversal with one stack: ");
        tt.inOrderItrOneStack(head);
        
        System.out.println("\nMorris Preorder Traversal: ");
        tt.morrisTraversalPreOrder(head);
        
        System.out.println("\nPreorder Traversal with one stack: ");
        tt.preOrderItrOneStack(head);
        
        System.out.println("\nPostorder Traversal with two stacks: ");
        tt.postOrderItrTwoStacks(head);
        
        System.out.println("\nPostorder Traversal with one stack: ");
        tt.postOrderItrOneStack(head);
        
        System.out.println("\nVertical Order Traversal: ");
        tt.verticalTraversal(head);
		
		
	}

	private int height(Node head) {
		if(head==null) return 0;
		int hleft=height(head.left);
		int hright=height(head.right);
		return 1+Math.max(hleft, hright);
	}

	private Node add(int val, Node head) {
		Node n = new Node(val);
		Node tmpHead=head;
		if(head==null) {
			head=n;
			return head;
		}
		
		Node prev=null;
		while(head!=null) {
			prev=head;
			if(val<head.val) {
				head=head.left;
			}else {
				head=head.right;
			}
		}
		if(prev.val<val) {
			prev.right=n;
		}else {
			prev.left=n;
		}
		return tmpHead;
	}
	
}
