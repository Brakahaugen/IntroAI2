package Astar2;
import java.util.ArrayList;
import java.util.Arrays;

public class Node {
	public int g, h, f, i, j, cost;
	public Node parent;
	public ArrayList<Node> kids;
	public char type;
	
	public Node(int i, int j, char type, int cost) {
		super();
		this.i = i;
		this.j = j;
		this.type = type;
		kids = new ArrayList<Node>();
		this.g = 9999; this.h = 9999; this.f = 9999;
		this.cost = cost;
	}
	
	// the evaluate part of attach-n-eval
	public int eval(Node[][] grid, Node p, Node end, int avgcost) {
		
		int g = p.g + this.cost;
		int h = (Math.abs(this.i - end.i) + Math.abs(this.j - end.j))*avgcost;	
		int f = this.g+this.h;
		return f;
	} 
	
//	attach part of attach-n-eval
	public void attach(Node[][] grid, Node p, Node end, int avgcost) {
		int g = p.g + this.cost;
		int h = (Math.abs(this.i - end.i) + Math.abs(this.j - end.j))*avgcost;	
		int f = this.g+this.h;
		this.parent = p;
	}
	
	// checks if its possible to add kids in all directions and then adds.
	public void addKids(Node[][] grid) {
		if (this.j+1 < 40 && this.j+1 >= 0)
			this.kids.add(grid[this.i][this.j+1]);
		if (this.j-1 < 40 && this.j-1 >= 0)
			this.kids.add(grid[this.i][this.j-1]);
		if (this.i+1 < 10 && this.i+1 >= 0)
			this.kids.add(grid[this.i+1][this.j]);
		if (this.i-1 < 10 && this.i-1 >= 0)
			this.kids.add(grid[this.i-1][this.j]);
		}
}
