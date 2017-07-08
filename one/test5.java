package one;

public class test5 {
	public static void main(String[] args) {
		int[] a = {2,34,1,43,121,211};
		selectSort(a);
		for(int i :a ){
			System.out.print( i + " ");
		}
	}
	
	
	// bubble sort 1
	public static int[] bubbleSort1(int[] array) {
		for(int j = 1; j < array.length - 1 ; j++){
			for (int i = 0 ; i < array.length-j  ; i ++) {
				if (array[i] > array[i+1] ) {
					swap(array,i,i+1);
				}
			}
		}
		return array;
	}
	// bubble sort 2
	public static int[] bubbleSort2(int[] array) {
		int out , in ;
		for(out = array.length -1 ; out > 0 ; out --){
			for(in = 0 ; in < out; in ++){
				if (array[in] > array[in+1]) {
					swap(array,in ,in+1);
				}
			}
			
		}
		return array;
	}
	
	public static int[] selectSort(int[] array) {
		int out , in, min ;
		for(out = 0 ; out < array.length - 1 ; out ++) {
			min = out;
			for (in = out + 1 ; in < array.length ; in ++) {  // not < array.length-1  because in can equal array.length-1 
				if (array[in] < array[min]) {
					min = in;
				}
			}
			swap(array ,out, min);
		}
		return array; 
	}
	
	
	
	// swap function
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
}
