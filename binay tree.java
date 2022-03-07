import java.util.Scanner;

public class Binarytree {
	public static class Node {
		int data;
		Node leftNode;
		Node rightNode;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.leftNode = left;
			this.rightNode = right;
		}
	}

	private Node root = null;
	int size = 0;

	public Binarytree() {
		Scanner scanner = new Scanner(System.in);
		this.root = takeInput(scanner, null, false);

	}

	private Node takeInput(Scanner s, Node parentnNode, boolean isLeftOrRight) {

		if (parentnNode == null) {
			System.out.println("Enter Root: ");
		} else {
			if (isLeftOrRight) {
				System.out.println("Enter the data for left child of " + parentnNode.data);
			} else {
				System.out.println("Enter the data for left child of " + parentnNode.data);
			}
		}

		int val = s.nextInt();
		Node newNode = new Node(val, null, null);
		this.size++;
		// for left child
		boolean choise = false;
		System.out.println("do you have left child of " + newNode.data);
		choise = s.nextBoolean();
		if (choise) {
			newNode.leftNode = takeInput(s, newNode, true);
		}
		// for right child
		choise = false;
		System.out.println("do you have Right child of " + newNode.data);
		choise = s.nextBoolean();
		if (choise) {
			newNode.rightNode = takeInput(s, newNode, false);
		}

		return newNode;
	}

	// display
	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		String str = "";
		if (node.leftNode != null) {
			str = str + node.leftNode.data + "=>";
		} else {
			str = str + "END=>";
		}
		str = str + node.data;
		if (node.rightNode != null) {
			str = str + "<=" + node.leftNode.data;
		} else {
			str = str + "<=END";
		}

		System.out.println(str);
		if (node.leftNode != null) {
			this.display(node.leftNode);
		}
		if (node.rightNode != null) {
			this.display(node.rightNode);
		}
	}

	// hight of a tree
	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		if (node == null)
			return -1;
		int lheight = this.height(node.leftNode);
		int rheight = this.height(node.rightNode);
		int height = Math.max(lheight, rheight) + 1;
		return height;
	}

	// preOder
	public void preorder() {
		this.preorder(this.root);
		System.out.println("*********");
	}

	private void preorder(Node node) {
		if (node == null)
			return;
		System.out.println(node.data + ",");
		preorder(node.leftNode);
		preorder(node.rightNode);
	}

	// inOrdr
	public void inorder() {
		this.inorder(this.root);
		System.out.println("*********");
	}

	private void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.leftNode);
		System.out.println(node.data + ",");
		inorder(node.rightNode);
	}

	// postorder
	public void postorder() {
		this.postorder(this.root);
		System.out.println("*********");
	}

	private void postorder(Node node) {
		if (node == null)
			return;
		postorder(node.leftNode);
		postorder(node.rightNode);
		System.out.println(node.data + ",");

	}

	// 50 true 25 true 38 false false true 48 true 18 false false false false
	public static void main(String[] args) {
		Binarytree bt = new Binarytree();
		bt.display();

		System.out.println(bt.height());
		bt.preorder();
		bt.inorder();
		bt.postorder();
	}

}
