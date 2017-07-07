package one;

public class test4 {
	public static void main(String[] args) {
		int [] a = {1,2,3,42,221,242};
		System.out.println(new test4().find(44, a));
	}	
	
	
	public int find(int sKey, int[] array) {
		int lowIdx = 0;
		int highIdx = array.length -1 ;
		int midIdx ;
		while (true) {
			midIdx = ( lowIdx + highIdx )/2;
			if (lowIdx >= highIdx ) {
				return - midIdx;
			} else if (sKey == array[midIdx]) {
				return midIdx;
			} else if (sKey < array[midIdx] ) {
				highIdx = midIdx-1;
			} else if (sKey > array[midIdx]){
				lowIdx = midIdx + 1 ;
			}
		}
	}
}
	



