
public class BST {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BST(int[] arr) {
		this.root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int low, int high) {

		// base case
		if (low > high)
			return null;
		// mid
		int mid = (low + high) / 2;
		// creat new node
		Node newNode = new Node();
		newNode.data = arr[mid];

		newNode.left = construct(arr, low, mid - 1);
		newNode.right = construct(arr, mid + 1, high);

		return newNode;
	}

	void Display() {
		Display(this.root);
	}

	private void Display(Node node) {
		if (node == null)
			return;
		String str = " ";
		if (node.left == null)
			str += ".";
		else {
			str += node.left.data;
		}
		str += "->" + node.data + "<-";

		if (node.right == null)
			str += ".";
		else {
			str += node.right.data;
		}
		System.out.println(str);
		Display(node.left);
		Display(node.right);

	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {
		if (node == null)
			return false;

		if (item > node.data)
			return find(node.right, item);
		else if (item < node.data)
			return find(node.left, item);
		else
			return true;

	}

	public int maxelement() {
		return maxelement(this.root);
	}

	private int maxelement(Node node) {
		if (node.right == null)
			return node.data;
		return maxelement(node.right);
	}

	public void addItem(int item) {
		addItem(this.root, item);
	}

	private void addItem(Node node, int item) {
		if (item > node.data) {
			if (node.right == null) {
				Node newNode = new Node();
				newNode.data = item;
				node.right = newNode;
			} else {
				addItem(node.right, item);
			}
		} else {
			if (node.left == null) {
				Node newNode = new Node();
				newNode.data = item;
				node.left = newNode;
			} else {
				addItem(node.left, item);
			}
		}
	}

	public void removeItem(int item) {
		removeItem(this.root, null, false, item);
	}

	private void removeItem(Node node, Node parent, boolean ilc, int item) {

		if (item > node.data) {
			removeItem(node.right, node, false, item);
		} else if (item < node.data) {
			removeItem(node.left, node, true, item);
		} else {
			if (node.left == null && node.right == null) {
				if (ilc)
					parent.left = null;
				else
					parent.right = null;
			} else if (node.left == null && node.right != null) {
				if (ilc) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}
			} else if (node.left != null && node.right == null) {
				if (ilc) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
			}else {
				int max = maxelement(node.left);
				node.data = max;
				removeItem(node.left,node,true,max);
			}

		}

	}

}
