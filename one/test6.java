package one;

import java.util.ArrayList;
import java.util.Scanner;

public class test6 {
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int[] grade;
		while(in.hasNext()){
			// reading part 
			String[] firstL = in.nextLine().split(" ");
			int num = Integer.valueOf(firstL[0]);
			int move = Integer.valueOf(firstL[1]);
			grade = new int[num];   // grade array
			String[] secondL = in.nextLine().split(" ");
			for(int i = 0 ; i < num ; i ++){
				grade[i] = Integer.valueOf(secondL[i]);
			}
			
			for(int i = 0; i < move ; i ++) {   // operate move
				int re = command(in.nextLine(), grade);
				if (re > 0) {
					System.out.println(re);
				}
			}
			//
		}
		
	}
	
	public static int command(String s, int[] array){ 
		String[] com = s.split(" "); 
		int a = Integer.valueOf(com[1]) - 1;
		int b = Integer.valueOf(com[2]) - 1;
		if (com[0].equals("Q")) {
			int max = array[a];
			// A > B OR A < B TWO SITUATION  
			//这里也可以用Math.max
			if (a < b ) {
				for( int i = a; i <= b; i ++ ){
					if (array[i] > max) {
						max = array[i];
					}
				}
			} else {
				for( int i = b; i <= a; i ++ ){
					if (array[i] > max) {
						max = array[i];
					}
				}
			}
			return max;
		} else if (com[0].equals("U")) {
			array[a] = b + 1  ;  // compensate b - 1 for U operate ;
			return -2 ;
		}
		return -1;
	}
}
