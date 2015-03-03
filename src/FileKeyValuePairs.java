import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class FileKeyValuePairs {

	private Scanner in1;
	private Scanner in2;
	private HashMap<String, String> lookup;
	
	public FileKeyValuePairs(String inPath1, String inPath2 ) throws FileNotFoundException {
		in1 = new Scanner(new File(inPath1));
		in2 = new Scanner(new File(inPath2));
		lookup = new HashMap<String, String>();
	}
	
	// Both files have the same set of keys, hence the same length
	
	public void processStream() {
		while(in1.hasNextLine()) {
			String l1 = in1.nextLine();
			String[] parts1 = l1.split(",");
			String l2 = in2.nextLine();
			String[] parts2 = l2.split(",");
			
			// If by chance we get the same keys at the same line on both files,
			// we do not need to even insert the key, value into our lookup
			if(parts1[0].equals(parts2[0])) System.out.println(parts1[1] + "," + parts2[1]);
			
			if(lookup.containsKey(parts1[0])) {  // We have already seen this key from the other stream
				System.out.println(parts1[1] + "," + lookup.get(parts1[0]));
				lookup.remove(parts1[0]);  // As the whole data will not fit into memory
			}
			else {
				lookup.put(parts1[0], parts1[1]);  // insert into lookup for future occurrence in other stream
			}

			if(lookup.containsKey(parts2[0])) {  // We have already seen this key from the other stream
				System.out.println(parts2[1] + "," + lookup.get(parts2[0]));
				lookup.remove(parts2[0]); // As the whole data will not fit into memory
			}
			else {
				lookup.put(parts2[0], parts2[1]);   // insert into lookup for future occurrence in other stream
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		FileKeyValuePairs fkvp = new FileKeyValuePairs(args[0], args[1]);
		fkvp.processStream();
		System.exit(0);
	}

}
