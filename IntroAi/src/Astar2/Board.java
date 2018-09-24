package Astar2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Astar2.Node;
/**
 * A simple example program that reads a text file line by line and display each line.
 */

public class Board {
	

	//Calculates the manhattan values of g,h, and f
	
	public static void calculate(Node a, Node start, Node end) {

		if (a.parent != null) {
			a.g = a.parent.g + a.cost;
		} else {
			a.g = (Math.abs(a.i - start.i) + Math.abs(a.j - start.j))*avgcost;
		}
		a.h = (Math.abs(a.i - end.i) + Math.abs(a.j - end.j))*avgcost;	
		a.f = a.g+a.h;
	}	
	
	public static Node[][] grid;
	public static int avgcost;

		// Lager et grid av noder
	
	    public static void main(String[] args) {
			
	    	//Declares variables at start
	    	Node start = null;
			Node end = null;
	    	String output = "";
	    	grid = new Node[10][40];
	    	avgcost = 0;
	        BufferedReader br = null;
	        int i=0;
	    	ArrayList<Node> open = new ArrayList<Node>();
			ArrayList<Node> closed = new ArrayList<Node>();
			
			
//	        This reader reads in the inputfile, and then makes a node at each place in the grid
//			The boolean accessible was not really neccessary. 
//			I declared a type for each Node so I could represent it visually in the end.
	        try {
	            br = new BufferedReader(new FileReader("boards\\board-2-1.txt"));
	            String line;
	            
	            while ((line = br.readLine()) != null) {
	            	for(int j = 0; j < line.length(); j++) {
	            		if (line.charAt(j) == 'w') {
	            			grid[i][j] = new Node(i,j,line.charAt(j), 100); // Her må jeg regne ut funksjoner
	            			
	            		} else if (line.charAt(j) == 'm') { 
	            			grid[i][j] = new Node(i,j,line.charAt(j), 50);
	            			closed.add(grid[i][j]);
	            			
	            		} else if (line.charAt(j) == 'f') {
	            			grid[i][j] = new Node(i,j,line.charAt(j), 10);
	            			start = grid[i][j];
	            			
	            		} else if (line.charAt(j) == 'g') {
	            			grid[i][j] = new Node(i,j,line.charAt(j), 5);
	            			end = grid[i][j];
	            			
	            		} else if (line.charAt(j) == 'r') {
	            			grid[i][j] = new Node(i,j,line.charAt(j), 1);
	            			end = grid[i][j];
	            			
	            		} else if (line.charAt(j) == 'A') {
	            			grid[i][j] = new Node(i,j,line.charAt(j), 0);
	            			start = grid[i][j];
            			
	            		} else if (line.charAt(j) == 'B') {
	            			grid[i][j] = new Node(i,j,line.charAt(j), 0);
	            			end = grid[i][j];
	            		}
	            		avgcost += grid[i][j].cost;
		            }
	            	i++;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (br != null) {
	                    br.close();
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }	
	        }
	        
	        avgcost = avgcost/400;
	        System.out.println(avgcost);
	        //Her starter algoritme for A star
//			Starter med å legge til startnoden (A0)
			
			open.add(start);
			
			
//			Den beste måten jeg kom på for å finne den noden med best f verdi fra open-listen
//			Breaker hvis man finner en child-node som har h verdi lik 0, for da er dette mål-noden
				while (!open.isEmpty()) {
					Node a = open.get(0);
					calculate(a, start, end);
					for (Node node : open) {
						if (a.h == 0) {
							break;
						}
						calculate(node, start, end);
						System.out.println(node.g);
						System.out.println(node.h);
						
						if (node.f < a.f) {
							a = node;
						}
					}
					System.out.println();
					a.type = 'X';
					System.out.println(a.type);
					for (i = 0; i < 10; i++) {
						for (int j = 0; j < 40; j++) {
							output += grid[i][j].type;
						}
						System.out.println(output);
						output = "";
					}	
					open.remove(a);
					calculate(a, start, end);
						if (a.h == 0) {
//							Backtracer lenken for å komme til mål. 
							System.out.println(a.h);
							System.out.println(a.i+ "  " + a.j);
							while (a.parent != null) {
								a.parent.type = 'o';
								a = a.parent;
								System.out.println("x:" + a.i + "   y:" + a.j);
							}
							start.type = 'A';
							end.type = 'B';
							
							System.out.println("found solution:");
							for (i = 0; i < 10; i++) {
								for (int j = 0; j < 40; j++) {
									output += grid[i][j].type;
								}
								System.out.println(output);
								output = "";
							}
							return;
						}
					a.addKids(grid);
					closed.add(a);
					for (Node kid : a.kids) {
						if (closed.contains(kid)) {
							continue;
						} else if (!open.contains(kid)) {
							open.add(kid);
							kid.attach(grid, a, end, avgcost);
						} else if (kid.eval(grid, a, end, avgcost) < kid.f) {
							open.add(kid);
							kid.attach(grid, a, end, avgcost);
						}
					}
				}
	    }
	}