package sort1;

public class Comparison {

	public static void main(String[] args) {
		int arr[]= {100,5,2,3,33,78,4,5};
		//anotherInsertion(arr);
		//selectionSort(arr);
		bubble_sort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.println("a["+i+"]:"+arr[i]);
		}

	}
	
	static void insertionSort(int a[]){

		int j=0;
		for(int i=1;i<a.length;i++){
		   int k=a[i];
		   j=i-1;
		   while(j>=0 && a[j]>k){
		      a[j+1]=a[j];
		      j--;
		   }
		   a[j+1]=k;
		}
	}
	
	static void anotherInsertion(int a[]) {
		int key=0;
		int N=a.length;
		int j=0;
		for(int i=1;i<N;i++) {
			key=a[i];
			for(j=i-1;j>=0 && a[j]>key;j--) {
				a[j+1]=a[j];
			}
			a[j+1]=key;
		}
	}
	
	static void selectionSort(int a[]) {
		//int min=0;
		int N=a.length;
		int j=0;
		for(int i=0;i<N-1;i++) {
			int min=i;
			for(j=i+1;j<N;j++) {
				if(a[j]<a[min]) {
					min=j;
				}
			}
			int temp=a[min];
			a[min]=a[i];
			a[i]=temp;
		}
		
	}
	
	static void bubble_sort(int a[]) {
		int n=a.length;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-i-1;j++) {
				if(a[j]>a[j+1]) {
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
	//All are O(n^2)

}
