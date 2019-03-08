package searching;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[]= {20,45,56,78,89,90,123};
		int key=90;
		System.out.println("Found key at "+binarySearch(arr, 0,arr.length-1,key));

	}

	private static int binarySearch(int[] arr, int low, int high, int key) {
		
		while(low<=high) {
			int mid=(low+high)/2;
			if(arr[mid]>key) {
				high=mid-1;
			}else
			if(arr[mid]<key) {
				low=mid+1;
			}else
				if(arr[mid]==key) {
					return mid;
				}
		}
		return -1;
		
	}

}
