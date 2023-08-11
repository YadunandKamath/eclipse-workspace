package sort;

public class QuickSort {

	public static void main(String[] args) {
		
		int[] arr = {10, 5, 7, -3, -12, 6, 8, 4, 11};
		
		System.out.println("Array before sorting:");
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		quickSort(arr, 0, arr.length);
		
		System.out.println("\nQuick sorted array:");
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

	}
	
	public static void quickSort(int[] input, int start, int end) {
		
		if(end-start < 2) {
			return;
		}
		
		int pivotIndex = partition(input,start,end);
		quickSort(input, start, pivotIndex);
		quickSort(input, pivotIndex+1, end);
	}

	public static int partition(int[] input, int start, int end) {
		
		int pivot = input[start];
		int i = start;
		int j = end;
		
		while(i<j) {
			
			while(i<j && input[--j]>=pivot);
				
			if(i<j) {					
				input[i] = input[j];
			}
			
			while(i<j && input[++i]<=pivot);
			
			if(i<j) {					
				input[j] = input[i];
			}
		}
		
		input[j] = pivot;
		return j;
	}
	
}
