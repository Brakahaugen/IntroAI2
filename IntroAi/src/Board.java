import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * A simple example program that reads a text file line by line and display each line.
 */

public class Board {
	
	public static Node[][] grid;

		// Lager et grid av noder
	
	    public static void main(String[] args) {
	    	grid = new Node[20][7];
	        BufferedReader br = null;
	        int y=0;
	        
	        try {
	            br = new BufferedReader(new FileReader("boards\\board-1-1.txt"));
	            String line;
	            while ((line = br.readLine()) != null) {
	            	for(int x = 0; x < line.length(); x++) {
	            		if (line.charAt(x) == '.') {
	            			grid[x][y] = new Node(); // Her må jeg regne ut funksjoner
	            			grid[x][y].accessible = true;
	            		} else if (line.charAt(x) == '#') { 
	            			grid[x][y] = new Node(); // Her må jeg regne ut funksjoner
	            			grid[x][y].accessible = false;
	            		} else if (line.charAt(x) == 'A') {
	            			grid[x][y] = new Node(); // Her må jeg regne ut funksjoner
	            			grid[x][y].accessible = false;
	            		} else if (line.charAt(x) == 'A') {
	            			grid[x][y] = new Node(); // Her må jeg regne ut funksjoner
	            			grid[x][y].accessible = false; 
	            	}
	            y++;
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
	    }
	}