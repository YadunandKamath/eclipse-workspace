package sort;

public class InsertionSort {
	
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
		
		// without swap (using shifting)
		
		for(int firstUnsortedIndex=1; firstUnsortedIndex<arr.length; firstUnsortedIndex++) {
			
			int newElement = arr[firstUnsortedIndex];
			
			int i;
			
			for(i=firstUnsortedIndex; i>0 && arr[i-1]>newElement; i--) {
				arr[i] = arr[i-1];
			}
			
			arr[i] = newElement;
		}
		
		/*
		  
		// with swapping
		 
		for(int sortedIndex=0; sortedIndex<arr.length; sortedIndex++) {
			
			for(int firstUnsortedIndex=sortedIndex+1; firstUnsortedIndex<arr.length; firstUnsortedIndex++) {

				int temp2 = sortedIndex;
				
				while(temp2>=0) {
					if(arr[firstUnsortedIndex]<arr[sortedIndex]) {
						swap(arr,firstUnsortedIndex,sortedIndex);
					}
					temp2--;
				}
				
			}
		}
		*/
		
		System.out.println("\nInsertion sorted array:");
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
}
