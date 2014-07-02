import java.util.*;

public class ListProblems {
	
	public static void simpleList () {

		LinkedList<String> ls = new LinkedList<String>();
		
		ls.add("Hello!");
		ls.add("I");
		ls.add("am");
		ls.add("Sameer");
		
		for(String s: ls) {
			System.out.print(s + " ");
		}
		System.out.println();
	}

	public static void arrayOfLists () {

		LinkedList<String>[] arr = new LinkedList[2];
		arr[0] = new LinkedList<String>();
		arr[1] = new LinkedList<String>();
		
		arr[0].add("Hello 1");
		arr[0].add("I 1");
		arr[0].add("am 1");
		arr[0].add("Sam 1");

		arr[1].add("Hello 2");
		arr[1].add("I 2");
		arr[1].add("am 2");
		arr[1].add("Sam 2");

		for(String s: arr[0]) {
			System.out.print(s + " ");
		}
		System.out.println();

		for(String s: arr[1]) {
			System.out.print(s + " ");
		}
		System.out.println();		
	}
	
	public static void mapOfLists () {
		
		HashMap<Integer, LinkedList<String>> hm = new HashMap<Integer, LinkedList<String>>();
		
		if(hm.get(0) == null) {
			LinkedList<String> l = new LinkedList<String>();
			l.add("Hello HM 0!");
			hm.put(0, l);
		}
		LinkedList<String> l = hm.get(0);
		for(String s: l) {
			System.out.print(s + " ");
		}

		System.out.println();
		l = hm.get(0);
		l.add("Here I am again HM 0.");
		hm.put(0, l);
		
		l = hm.get(0);
		for(String s: l) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {

		ListProblems.mapOfLists ();
		
	}
	

}
