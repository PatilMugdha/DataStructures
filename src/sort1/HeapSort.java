package sort1;

/*public class HeapSort {

	public static void main(String[] args) {
		int[] arr = { 20, 30, 10, 40, 50 };

		heapSort(arr, arr.length);
		printArr(arr);
	}

	private static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
	}

	private static void heapSort(int[] array, int n) {
		// Build our max heap.
		buildMaxHeap(array);

		// Find last element.
		int lastElement = array.length - 1;

		// Continue heap sorting until we have
		// just one element left in the array.
		while (lastElement > 0) {
			swap(array, 0, lastElement);

			heapify(array, 0, lastElement);

			lastElement -= 1;
		}

	}

	private static void buildMaxHeap(int[] array) {
		int i;
		i = array.length / 2 - 1;
		i = (int) Math.floor(i);

		// Build a max heap out of
		// all array elements passed in.
		while (i >= 0) {
			heapify(array, i, array.length);
			i -= 1;
		}
	}

	private static void heapify(int[] heap, int i, int max) {
		int index, leftChild, rightChild;

		while (i < max) {
			index = i;

			leftChild = 2 * i + 1;
			rightChild = leftChild + 1;

			if (leftChild < max && heap[leftChild] > heap[index]) {
				index = leftChild;
			}

			if (rightChild < max && heap[rightChild] > heap[index]) {
				index = rightChild;
			}

			if (index == i) {
				return;
			}

			swap(heap, i, index);

			i = index;
		}
	}

	private static void swap(int[] array, int firstItemIndex, int lastItemInde) {
		int tmp = array[firstItemIndex];
		// Swap first and last items in the array.
		array[firstItemIndex] = array[lastItemInde];
		array[lastItemInde] = tmp;
	}
	
}*/

import java.util.*;

public class HeapSort {
 
   public static void buildheap(int []arr) {
      
    /*
     * As last non leaf node will be at (arr.length-1)/2 
     * so we will start from this location for heapifying the elements
     * */
    for(int i=(arr.length-1)/2; i>=0; i--){
     heapify(arr,i,arr.length-1);
      }
   }
 
   public static void heapify(int[] arr, int i,int size) { 
      int left = 2*i+1;
      int right = 2*i+2;
      int max;
      if(left <= size && arr[left] > arr[i]){
       max=left;
      } else {
       max=i;
      }
 
      if(right <= size && arr[right] > arr[max]) {
       max=right;
      }
      // If max is not current node, exchange it with max of left and right child
      if(max!=i) {
         exchange(arr,i, max);
         heapify(arr, max,size);
      }
   }
 
   public static void exchange(int[] arr,int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t; 
   }
 
   public static int[] heapSort(int[] arr) {
     
      buildheap(arr);
      int sizeOfHeap=arr.length-1;
      for(int i=sizeOfHeap; i>0; i--) {
         exchange(arr,0, i);
         sizeOfHeap=sizeOfHeap-1;
         heapify(arr, 0,sizeOfHeap);
      }
      return arr;
   }
 
   public static void main(String[] args) {
      int[] arr={1,10,16,19,3,5};
      System.out.println("Before Heap Sort : ");
      System.out.println(Arrays.toString(arr));
      arr=heapSort(arr);
      System.out.println("=====================");
      System.out.println("After Heap Sort : ");
      System.out.println(Arrays.toString(arr));
   }
}
