package sort;

public class CountingSort {
	
	public static void countingSort(int input[], int min, int max) {
		
		int[] count = new int[(max-min)+1];	
		
		for(int i=0;i<input.length; i++) {
			count[input[i]-min]++;
		}
		System.out.println("\nCount array:");
		for(int i=0;i<count.length;i++)
			System.out.print(count[i]+" ");
		
		System.out.println("\nCounting sorted array:");
		int i=0;
		for(int j=min;j<=max;j++) {
			while(count[j-min]>0&&i<input.length) {
				input[i++]=j;
				count[j-min]--;
			}
		}
		for(i=0;i<input.length;i++) {
			System.out.print(input[i]+" ");
		}
	}

	public static void main(String[] args) {
		
		int[] arr = {4,9,3,6,2,5,9,10,8,7,5};
		int min = arr[0];
		int max = arr[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		
		System.out.println("Array before sorting:");
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		countingSort(arr, min, max);
		
	}
}
