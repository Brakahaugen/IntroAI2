import java.util.ArrayList;

public class Node {
	public int g, h, f;
	boolean accessible;
	Node parent;
	ArrayList<Node> kids;
	
	public Node() {
		super();
		this.g = 0;
		this.h = 0;
		this.f = 0;
		this.accessible = true;
		this.parent = null;
		this.kids = new ArrayList<Node>();
		
	}
	public Node(int g, int h, int f, Node parent) {
		super();
		this.g = g;
		this.h = h;
		this.f = f;
		this.accessible = true;
		this.parent = parent;
		this.kids = new ArrayList<Node>();
	}
}
