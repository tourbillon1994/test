package one;

public class test1 {
	public static void main(String[] args) {
//		printInt(231);
		MemoryCell<Integer> cell1 = new MemoryCell();
		cell1.write(1994);
		Object cell = cell1;
		MemoryCell<String> cell3 = (MemoryCell<String>)cell;
		String s = cell3.read();
		
	}
	
	public static void printInt(int n) {
		if (n>= 10) {
			printInt(n/10);
		}
		System.out.println(n%10);;
	}
}

class MemoryCell<T>{
	T storeValue;
	T read() {
		return storeValue;
	}
	void write (T object) {
		storeValue = object;
	}
}

