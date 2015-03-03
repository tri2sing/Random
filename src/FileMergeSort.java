import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.F2D;

// Assumption: The three input files are individually sorted.

public class FileMergeSort {
	
	private Scanner in1;
	private Scanner in2;
	private Scanner in3;
	private FileWriter fw;
	
	public FileMergeSort(String inPath1, String inPath2, String inPath3, String outPath) throws IOException {
		in1 = new Scanner(new File(inPath1));
		in2 = new Scanner(new File(inPath2));
		in3 = new Scanner(new File(inPath3));
		fw = new FileWriter(new File(outPath));
		
	}
	
	// Return 1 if s1 is smallest, 2 is s2 is smallest, 3 if s3 is smallest
	// As some of the streams can get consumed ahead of others,
	// this function can get called with some null parameters.
	
	private int compareStrings(String s1, String s2, String s3) {

		if (s1 == null && s2 != null && s3 != null) {
			return (s2.compareTo(s3) <= 0 ? 2 : 3); 
		}
		
		if (s1 != null && s2 == null && s3 != null) {
			return (s1.compareTo(s3) <= 0 ? 1 : 3); 
		}
		
		if (s1 != null && s2 != null && s3 == null) {
			return (s1.compareTo(s2) <= 0 ? 1 : 2); 
		}

		if(s1 == null && s2 == null) return 3;
		
		if (s2 == null && s3 == null) return 1;
		
		if (s3 == null && s1 == null) return 1;
		
		// At this point s1 != null, s2 != null, s3 != null
		
		if(s1.compareTo(s2) <= 0) {
			if (s1.compareTo(s3) <= 0) return 1;  // s1 <= s2 & & s1 <= s3
			else return 3; // s3 < s1 && s1<= s2
		}
		else {
			if(s2.compareTo(s3) <= 0)  return 2; // s1 > s2 and s3 >= s2
			else return 3;  // s1 > s2 and s2 > s3
		}
	}
	
	public void processStream() throws IOException {
		Boolean done1 = false, done2 = false, done3 = false;
		String l1 = null, l2 = null, l3 = null;

		while(true){
			if(l1 == null && !done1) l1 = in1.nextLine();
			if(l2 == null && !done2) l2 = in2.nextLine();
			if(l3 == null && !done3) l3 = in3.nextLine();

			//System.out.println(l1 + ", " + l2 + ",  " + l3);
			int smallest = compareStrings(l1, l2, l3);
			if(smallest == 1) {
				System.out.println(l1);
				fw.write(l1 + "\n");
				l1 = null;
			}
			if(smallest == 2) {
				System.out.println(l2);
				fw.write(l2 + "\n");
				l2 = null;
			}
			if(smallest == 3) {
				System.out.println(l3);
				fw.write(l3 + "\n");
				l3 = null;
			}
			
			if(l1 == null && l2 == null && l3 == null) break;
			
			if(!in1.hasNextLine()) {
				done1 = true;
			} 
			if(!in2.hasNextLine()) {
				done2 = true;
			} 
			if(!in3.hasNextLine()) {
				done3 = true;
			} 
		}
		
		//System.out.println("processed stream");
		in1.close();
		in2.close();
		in3.close();
		fw.flush();
		fw.close();
		return;
	}

	public static void main(String [] args) throws IOException {
		
		FileMergeSort fms = new FileMergeSort(args[0], args[1], args[2], args[3]);
		fms.processStream();
		System.exit(0);
		
	}
}
