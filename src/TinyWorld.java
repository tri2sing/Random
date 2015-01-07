import java.io.*;
import java.util.*;

public class TinyWorld {
	
	public TinyWorld () {
		
	}
	
	public void read(String filepath)  throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(filepath);
		Scanner scan = new Scanner(fis);
		long num = 0;
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			num++;
			if (num % 100 == 0) System.out.println(num + ": " + line);
		}
	}
	
	public void sort() {
		
	}
	
	public void write() {
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// Expect a path to the file to read as first argument 
		TinyWorld tw = new TinyWorld();
		tw.read(args[0]);
		
	}

}
