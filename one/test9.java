package one;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//  update test8
public class test9 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line;
		while(in.hasNext()){ 
			line = in.nextLine();
			if (line.contains("joker JOKER")) {     // 最开始就判断joker
				System.out.println("joker JOKER");
			} else {
			String [] str = line.split("-");
			System.out.println(compare(str[0], str[1]));
			}
		}
	}
	public static String compare(String a , String b) {
		String[] origin = {"3","4","5","6","7","8","9","10","J","Q","K","A","2","joker","JOKER"};
		ArrayList<String> list = new ArrayList<>(Arrays.asList(origin));
		String[] aStr = a.split(" ");  // a 的手牌
		String[] bStr = b.split(" ");  // b 的手牌
		if (aStr.length == bStr.length) {
				if (list.indexOf(aStr[0]) - list.indexOf(bStr[0])> 0) {
					return a;
				} else 
					return b;
		} 
		Integer[] abLength = {aStr.length, bStr.length};
		ArrayList<String []> abStrings = new ArrayList<>();
		abStrings.add(aStr);abStrings.add(bStr);
		ArrayList<Integer> lengths = new ArrayList<>(Arrays.asList(abLength));
		int indexFour = lengths.indexOf(4);
		//改进算法，直接在一开始就考虑joker 情况， 后续只需要考虑 4 就行
		if (indexFour>=0 ) {    // 4 and 2
			return indexFour == 0? a : b ;
		} else {
			return "ERROR";
		}
	}
}
