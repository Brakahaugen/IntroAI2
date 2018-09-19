import java.util.ArrayList;

public class Node {
	public int g, h, f;
	boolean closed;
	Node parent;
	ArrayList<Node> kids;
	
	public Node(int g, int h, int f, boolean closed, Node parent) {
		super();
		this.g = g;
		this.h = h;
		this.f = f;
		this.closed = closed;
		this.parent = parent;
		this.kids = new ArrayList<Node>();
	}
}
