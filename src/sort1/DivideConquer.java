package sort1;

public class DivideConquer {

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 3, 5, 7, 6, 1, 8 };
		// mergeSort(arr, 0, arr.length - 1);

		quickSort(arr, 0, arr.length - 1);
		for (int k = 0; k < arr.length - 1; k++) {
			System.out.println("a[" + k + "]:" + arr[k]);
		}
	}

	private static void quickSort(int[] arr, int low, int high) {

		if (low >= high) {
			return;
		}
		int pivot = arr[(low + high) / 2];
		int index = partition(arr, low, high, pivot);
		quickSort(arr, low, index - 1);
		quickSort(arr, index, high);
	}

	private static int partition(int[] arr, int low, int high, int pivot) {
		while (low <= high) {
			while (arr[low] < pivot)
				low++;
			while (arr[high] > pivot)
				high--;
			if (low <= high) {
				swap(arr, low, high);
				low++;
				high--;
			}
		}
		return low;
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	private static void mergeSort(int[] arr, int low, int high) {

		int mid = (high + low) / 2;
		if (low < high) {
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}

	}

	//stable, outplace
	private static void merge(int[] a, int low, int mid, int high) {
		int n = high - low + 1;

		int[] b = new int[n];// temp array

		int left = low, right = mid + 1, bIdx = 0;

		while (left <= mid && right <= high) {
			b[bIdx++] = (a[left] <= a[right]) ? a[left++] : a[right++];

		}
		while (left <= mid)
			b[bIdx++] = a[left++];
		while (right <= high)
			b[bIdx++] = a[right++];

		for (int k = 0; k < n; k++) {
			a[k + low] = b[k];
		}
	}
}
