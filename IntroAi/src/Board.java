import java.io.BufferedReader;
import java.io.FileReader;

public class Board {
	
	public static Node[][] grid = [10][10];

	
	BufferedReader br = new BufferedReader(new FileReader("file.txt"));
	try {
	    StringBuilder sb = new StringBuilder();
	    String line = br.readLine();

	    while (line != null) {
	        sb.append(line);
	        sb.append(System.lineSeparator());
	        line = br.readLine();
	    }
	    String everything = sb.toString();
	} finally {
	    br.close();
	}
}
