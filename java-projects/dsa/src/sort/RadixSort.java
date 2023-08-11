package sort;

public class RadixSort {
	
	public static void radixSort(int[] input, int radix, int width) {
		
		for(int i=0;i<width;i++) {
			radixSingleSort(input,i,radix);
		}
		
	}
	
	public static void radixSingleSort(int[] input, int position, int radix) {
		
		int num = input.length;
		
		int[] count = new int[radix];
		
		for(int value:input) {
			count[getDigit(position,value,radix)]++;
		}
		for(int j=1;j<radix;j++) {
			count[j] += count[j-1];
		}
		
		int[] temp = new int[num];
		for(int t=num-1; t>=0;t--) {
			temp[--count[getDigit(position, input[t], radix)]] = input[t];
		}
		
		for(int t=0;t<num;t++) {
			input[t] = temp[t];
		}
	}
	
	public static int getDigit(int position, int value, int radix) {
		return value / (int) Math.pow(radix, position) % radix;
	}

	public static void main(String[] args) {
		
		int arr[] = {4725, 4586, 1330, 8792, 1594, 5729};
		System.out.println("Array before sorting:");
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		radixSort(arr, 10, 4);
		
		System.out.println("\nRadix sorted array:");
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
