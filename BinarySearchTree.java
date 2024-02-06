class Node {
	int data;
	Node left;
	Node right;
}

class BST{
	public Node creatNewNode(int k) {
		Node a = new Node();
		a.data = k;
		a.left  = null;
		a.right = null;
		return a;
	}
	public Node insert(Node node , int val) {
		if(node == null) {
			return creatNewNode(val);
		}
		if(val < node.data) {
			node.left = insert(node.left , val);
		}
		else if(val > node.data) {
			node.right = insert(node.right , val);
		}
		return node;
	}
	public Node delete(Node node , int val) {
		if(node == null) {
			return null;
		}
		if(val < node.data) {
			node.left = delete(node.left , val);
		}
		else if(val > node.data) {
			node.right = delete(node.right , val);
		}
		else {
			if(node.left == null || node.right == null) {
				Node temp = null;
				temp = node.left == null ? node.right : node.left;

				if(temp == null) {
					return null;
				}
				else {
					return node;
				}
			} 
			else {
				Node successor = getSuccesor(node);
				node.data = successor.data;
				node.right = delete(node.right , 4);
				return node;
			}
		}
		return node;
	}
	public Node getSuccesor(Node node) {
		if(node == null) {
			return null;
		}
		Node temp = node.right;

		while(temp != null) {
			temp = temp.left;
		}
		return temp;
	}

	public void inorder(Node node) {
		if(node == null) {
			return;
		}

		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}

	public void preorder(Node node) {
		if(node == null) {
			return;
		}
		System.out.println(node.data);
		preorder(node.left);
		preorder(node.right);
	}

	public void postorder(Node node) {
		if(node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.println(node.data);
	}

	public boolean ifNodePresent(Node node , int val) {
		if(node == null) {
			return false;
		}
		boolean isPresent = false;

		while(node != null) {
			if(val < node.data) {
				node = node.left;
			}
			else if(val > node.data) {
				node = node.right;
			}
			else {
				isPresent = true;
				break;
			}
		}
		return isPresent;
	}
}


public class BinarySearchTree {
	public static void main (String[] args) {
		BST a = new BST();
		Node root = null;

		root = a.insert(root , 8);
		root = a.insert(root , 3);  
		root = a.insert(root , 6);
		root = a.insert(root , 10);
		root = a.insert(root , 4);
		root = a.insert(root , 7);
		root = a.insert(root , 1);
		root = a.insert(root , 14);
		root = a.insert(root , 13);

		root = a.delete(root, 7);

		a.inorder(root);
		a.preorder(root);
		a.postorder(root);
		System.out.println(a.ifNodePresent(root, 3));


	}

}
