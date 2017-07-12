package one;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
//一开始想用 path 作为 key   log 类存储 count和line 两个参数，却忽略了 path和line是一体的事实，
//但是 使用linkedhashmap 的思路是正确的
//class Log {
//	private String line ; 
//	private static int count = 1;
//	public Log(String line) {
//		this.line = line;
//	}
//	public String getLine() {
//		return line;
//	}
//	public void addCount() {
//		count ++ ; 
//	}
//	public int getCount() {
//		return count;
//	}
//	public String toString() {
//		return line + " " + count;
//	}
//}

public class test7 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LinkedHashMap< String, Integer> loglist = new LinkedHashMap<>();
		String input;
		String path;
		while(in.hasNext()){
			input = in.nextLine();
			String[] log = input.split("\\\\");// 因为涉及到两层,一个是JAVA的转义,一个是源代码的转义 
											   //正则表达式需要转义用\\表示\;  
							                   // 而java的源代码里，字符串中需要转义用\\表示\。  
							                   //因此累加在一起就必须是四个斜线\\\\,这样java转义后就是\\,
			                                   //而\\在正则里转义后为\这样就可以进行匹配了 
			// lastIndexOf('\\')   + substring 
			path = log[log.length -1];
//			System.out.println(path);
			if (loglist.containsKey(path)) {
				loglist.put(path, loglist.get(path) + 1);
			} else {
				loglist.put(path, 1);
			}
		}
		// 关闭 scanner
		in.close();
		// 排序
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(loglist.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return (o2.getValue() - o1.getValue() == 0 ? (o2.getValue() - o1.getValue()): (o2.getValue() - o1.getValue()));
			} // value相同就不变（原始位置） 其他按value排   降序 (o2- o1)
			
		});
		// 
		int m = 0 ;
		for(Map.Entry<String, Integer> entry : list){
			if (m < 8 ) {
				String[] str = entry.getKey().split(" ");
				String file = str[0].length() > 16 ? str[0].substring(str[0].length() - 16) : str[0]; 
				System.out.println(file + " " + str[1] + " " + entry.getValue() );
			} else {
				break ;
			}
			m ++ ;
		}
		
	}
}
