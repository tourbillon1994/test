package one;

public class test2 {
	static int count ;
	public static void main(String[] args) {
		
	}
	
	public static void swap(char[] str , int one , int two) {
		char temp = str[one];
		str[one] = str[two];
		str[two] = temp;
	}
	
	boolean is_swap(char[] str , int begin , int k) { // еп╤о
		int i ;
		for (i = begin ; i < k ; i ++) {
			if (str[i] == str[k]) {
				return false;
			}
		}
		return true;
	}
	
	private static void permute(char[] str , int low , int high){
		if (low == high) {
			
		}
	}
}
