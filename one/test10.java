package one;
import java.util.LinkedList;
import java.util.Scanner;
public class test10 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String line ;
		while(in.hasNext()){
			line = in.nextLine();
			LinkedList<Character> stack = new LinkedList<>(); 
			for(int i = 0 ; i < line.length() ; i ++){
				char ch = line.charAt(i);
				
				switch (ch) {
				case '(':
				case '[':
				case '{':
					stack.push(ch);
					break;
				case ')':
				case ']':
				case '}':
					if (!stack.isEmpty()) {
						char x = stack.pop();   // 这里应该考虑错误情况
						if (ch =='}' && x !='{' 
						  ||ch ==']' && x !='['
						  ||ch ==')' && x !='(') {
							System.out.println("error : "+ ch +" at "+ i );
							break;
							}
					} else 
						System.out.println("error : "+ ch +" at "+ i );
					break;
				default:
					break;
				}
			}
			if (!stack.isEmpty()) {
				System.out.println(" error ");
			}
		}
	}
}
