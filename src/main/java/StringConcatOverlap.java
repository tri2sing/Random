
public class StringConcatOverlap {

	/***
	 * Given two strings with overlap at the start or end, 
	 * return the smallest string that combines them at the overlap. 
	 * For example: cat + catch = catch 
	 * cat + attach = cattch 
	 * walmart + mart = walmart
	 * walmart + artist = walmartist
	 * carforcan + can = carforcan
	 */
	public static String concatOverlaps(String a, String b) {
		String left = null, right = null;
		String shorter, longer;
		if (a.equals(b))
			return a;
		if (a == null || b == null)
			return null;

		if (a.length() <= b.length()) {
			shorter = a;
			longer = b;
		} else {
			shorter = b;
			longer = a;
		}
		int shorterLen = shorter.length();
		int longerLen = longer.length();
		
		// Check the overlap on the left
		boolean match = false;
		for (int i = shorterLen; i > 0 &&  match == false; i--) {
			for (int j = 0; j < i; j++) {
				if (longer.substring(0, i - j).equals(shorter.substring(j, i))) {
					left = shorter + longer.substring(i - j, longerLen);
					match = true;
					break;
				}
			}
		}
		
		// Check the overlap on the right
		match = false;
		for (int i = shorter.length(); i > 0 &&  match == false; i--) {
			for (int j = 0; j < i; j++) {
				if (longer.substring(longerLen - i + j, longerLen).equals(shorter.substring(0, i - j))) {
					right = longer + shorter.substring(i - j, shorterLen);
					match = true;
					break;
				}
			}
		}

		if (left == null && right == null) return null;
		if (left == null && right != null) return right;
		if (left != null && right == null) return left;
		// There is a match at both ends.
		// Return the smaller, break tie arbitrarily
		if (left.length() <= right.length()) return left;
		else return right;
		
	}

	public static void main(String[] args) {
		System.out.println(StringConcatOverlap.concatOverlaps("cat", "catch"));
		System.out.println(StringConcatOverlap.concatOverlaps("cat", "attach"));
		System.out.println(StringConcatOverlap.concatOverlaps("walmart", "mart"));
		System.out.println(StringConcatOverlap.concatOverlaps("walmart", "artist"));
		System.out.println(StringConcatOverlap.concatOverlaps("carforcan", "can"));
			}

}
