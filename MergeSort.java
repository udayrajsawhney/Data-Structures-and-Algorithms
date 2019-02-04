import java.util.*;

class MergeSort {

	private int[] nums;
	private int[] tempArray;

	public MergeSort(int[] nums) {
		this.nums = nums;
		tempArray = new int[nums.length];
	}

	public void merge(int low, int high,int middle) {
		int i = low;
		int j = middle +1;
		int k = low;
		for (int a=low; a<=high; a++) {
			tempArray[a]=nums[a];
		}
		while( i<=middle && j<=high ){
			if (tempArray[i] <= tempArray[j]) {
				nums[k]=tempArray[i];
				i++;
			} else {
				nums[k]=tempArray[j];
				j++;
			}
			k++;
		}
		while(i<=middle) {
				nums[k]=tempArray[i];
				i++; k++;
		}
	}

	public void mergeSort(int low, int high) {
		if (low >= high) return; 
		int middle = (low+high)/2;
		mergeSort(low,middle);
		mergeSort(middle+1,high);
		merge(low,high,middle);
	}

	public void sort() {
        mergeSort(0, nums.length - 1);
    }

	public void showArray() {
		for(int i : nums) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		int[] nums = {23, 6, 4, -1, 0, 12, 8, 3, 1};
		MergeSort mergesort = new MergeSort(nums);
		mergesort.sort();
		mergesort.showArray();
	}
}