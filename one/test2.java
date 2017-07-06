package one;
/*
 * 全排列思路：
 * 任意选一个数（一般从小到大或者从左到右）打头，对后面的n-1个数进行全排列
 * 1. start for loop 
 * 2. change first element to i ( begin...end) 
 * 3.  full permute ( str , begin+1 ,end )求第2个元素到n的全排列
 * 4. 将改变的元素变回， 进行第2个元素与第一个元素的交换
 * 
 * 直到 begin = end  递归出口
*/
public class test2 {
	static int count ;
	public static void main(String[] args) {
		char str[] = {'a', 'b', 'b'};
		permute(str, 0, 2);
		System.out.println(count);
	}
	
	public static void swap(char[] str , int one , int two) {
		char temp = str[one];
		str[one] = str[two];
		str[two] = temp;
	}
	
	public static boolean is_swap(char[] str , int begin , int k) { // 重复判断  保证从[begin, k) 之间没有与k相同的元素
		int i ;
		for (i = begin ; i < k ; i ++) {
			if (str[i] == str[k]) {
				return false;
			}
		}
		return true;
	}
	
	public static void permute(char[] str , int begin , int end){  
		if (begin == end) {    
			System.out.println(str);
			count ++ ;
			return ;
		} else {
			for (int i = begin ; i <= end ; i++ ) {   // 1. start for loop 
				if (is_swap(str, begin , i )) {    // 保证 交换元素之间没有重复 
					swap(str, begin, i);              // 2. change first element to i ( begin...end) 
					permute(str, begin + 1 , end);   // 递归
					swap(str, begin, i);   // 回溯  
				}
			}
		}
	}
}
