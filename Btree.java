import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Btree {
	Node root;
	private static int i = 0;
	private static ArrayList<Integer> list = new ArrayList<Integer>();
	public Btree(int[] arr){
		this.root = create(arr);
	}
	private Node create(int[] arr){
		Node temp;
		int data = arr[i];
		i++;
		if(data==-1)
			return null;
		list.add(data);
		temp = new Node(data);
		temp.left = create(arr);
		temp.right = create(arr);
		return temp;
	}
	public void preOrder(Node n){//middle->left->right
		if (n != null) {
			System.out.print(n.data+" ");
			preOrder(n.left);
			preOrder(n.right);
		}
	}
	public void postOrder(Node n) {//left->rirht->middle
		if (n!=null) {
			postOrder(n.left);
			postOrder(n.right);
			System.out.print(n.data+" ");
		}
	}
	public void inOrder(Node n) {//left->middle->right
		if (n != null) {
			inOrder(n.left);
			System.out.print(n.data+" ");
			inOrder(n.right);
		}
	}
	public void printAll(Node n) {//printall node small~big
		System.out.print("\nPrintAll: ");
		Collections.sort(list, new Comparator<Integer>(){//Sort ArrayList
			@Override 
			public int compare(Integer a, Integer b){
				return a.compareTo(b);
			}
		});
		for (int i = 0; i <= list.size()-1; i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	public void size() {//treesize
		System.out.print("\nSize: "+list.size());
	}
}
