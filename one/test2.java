package one;
/*
 * ȫ����˼·��
 * ����ѡһ������һ���С������ߴ����ң���ͷ���Ժ����n-1��������ȫ����
 * 1. start for loop 
 * 2. change first element to i ( begin...end) 
 * 3.  full permute ( str , begin+1 ,end )���2��Ԫ�ص�n��ȫ����
 * 4. ���ı��Ԫ�ر�أ� ���е�2��Ԫ�����һ��Ԫ�صĽ���
 * 
 * ֱ�� begin = end  �ݹ����
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
	
	public static boolean is_swap(char[] str , int begin , int k) { // �ظ��ж�  ��֤��[begin, k) ֮��û����k��ͬ��Ԫ��
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
				if (is_swap(str, begin , i )) {    // ��֤ ����Ԫ��֮��û���ظ� 
					swap(str, begin, i);              // 2. change first element to i ( begin...end) 
					permute(str, begin + 1 , end);   // �ݹ�
					swap(str, begin, i);   // ����  
				}
			}
		}
	}
}
