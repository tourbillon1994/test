package one;
/*
 *  最大子序列和
*/
public class test3 {
	public static void main (String args[]){
		System.out.println( maxSubSum4(new int[]{1,2,2,-2,-4,4}) );
	}
	
	public static int maxSubSum4(int[] a) {
		int maxSum = 0 , thisSum = 0;
		for(int i = 0 ; i < a.length ; i ++){
			thisSum += a[i];
			if (thisSum > maxSum){
				maxSum = thisSum;
			} else if (thisSum < 0) {
				thisSum = 0;
			}
		}
		return maxSum;
	}
}
