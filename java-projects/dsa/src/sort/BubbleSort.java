package sort;

public class BubbleSort {
	
	public static void swap(int[] arr, int i, int j) {
		
		if(i==j) {
			return;
		}
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

	public static void main(String[] args) {
		
		int[] arr = {10, 5, 7, -3, 12, 6, 8, 4, 11};
		
		System.out.println("Array before sorting:");
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		for(int lastUnsortedIndex=arr.length-1; lastUnsortedIndex>0; lastUnsortedIndex--) {		
			
			for(int i=0;i<lastUnsortedIndex;i++) {
				
				if(arr[i]>arr[i+1]) {	// compare neighboring elements
					swap(arr, i, i+1);
				}
			}
		}
		
		System.out.println("\nBubble sorted array:");
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

}
