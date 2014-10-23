
public class PalindromeDeletions {

	public boolean isPalindrome (char [] arr) {

		if(arr.length == 1) return true;
		
		boolean result = true;
		int right = arr.length - 1;
		int left = 0;
		
		while(left < right) {
			left++;
			right--;
		}
		
		return result;
	}
	
	public static void main(String[] args) {

	}

}
