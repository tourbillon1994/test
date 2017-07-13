
package one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test8 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String[] str = in.nextLine().split("-");
			System.out.println(compare(str[0], str[1]));
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
		int indexTwo = lengths.indexOf(2);
		// 
		if (indexFour>=0 && indexTwo >=0) {    // 4 and 2
			if (abStrings.get(indexTwo)[0].equals( "JOKER") || abStrings.get(indexTwo)[0].equals("joker") )  {
				return indexTwo == 0 ?  a :  b; 
			} else
				return indexFour == 0? a : b ;
		} else if (indexFour>=0 && indexTwo <0){  // has 4 and not 2 
			return indexFour == 0 ? a : b ;
		} else if (indexFour < 0 && indexTwo >= 0) { // has 2 and not 4
			if (abStrings.get(indexTwo)[0].equals( "JOKER") || abStrings.get(indexTwo)[0].equals("joker") ){
				return indexTwo == 0 ?  a :  b; 
			} else
				return "ERROR";
		} else {
			return "ERROR";
		}
	}
}
