import java.util.Scanner;

public class Binarytree {
	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private Node root = null;
	private int size = 0;

	public Binarytree() {
		Scanner sc = new Scanner(System.in);
		this.root = takeInput(sc, null, false);
	}

	private Node takeInput(Scanner sc, Node parent, Boolean isLeftOrRight) {

		if (parent == null) {
			System.out.println("Enter Root node : ");
		} else {
			if (isLeftOrRight) {
				System.out.println("Enter LEFT child of :" + parent.data);
			} else {
				System.out.println("Enter RIGHT child of :" + parent.data);
			}
		}

		int NewNodevalue = sc.nextInt();
		Node newNode = new Node(NewNodevalue, null, null);
		this.size++;

		boolean choise = false;
		System.out.println("left child? "+ newNode.data);
		choise = sc.nextBoolean();
		if (choise) {
			newNode.left = takeInput(sc, newNode, true);
		}
		choise = false;
		System.out.println("Right child? "+newNode.data);
		choise = sc.nextBoolean();
		if (choise) {
			newNode.right = takeInput(sc, newNode, false);
		}

		return newNode;
	}
		public void Display() {
		this.Display(this.root);
	}
	private void Display(Node node) {
		String str = "";
		if(node.left!=null) {
			str += node.left.data + "=>";
		}else {
			str +="End=>";
		}
		str += node.data; 
		if(node.right!=null) {
			str += "<="+node.right.data ;
		}else {
			str +="<=End";
		}
		System.out.println(str);
		if(node.left!=null)
			Display(node.left);
		if (node.right!=null) 
			Display(node.right);
	}


	public int height() {
		return height(this.root);
	}

	private int height(Node node) {
		if (node == null)
			return -1;
		int Lhight = height(node.left);
		int Rhight = height(node.right);
		int max = Math.max(Lhight, Rhight) + 1;

		return max;
	}
    


}