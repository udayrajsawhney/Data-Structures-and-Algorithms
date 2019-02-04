import java.util.*;

class QuickSort {
	private int[] nums;
	
	public QuickSort(int[] nums) {
		this.nums = nums;
	}

	private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

	private int partition(int low, int high) {
        int pivotIndex = (low + high) / 2; 
        swap(pivotIndex, high);  
        int i = low;
        for (int j = low; j < high; ++j) {
            if (nums[j] <= nums[high]) {
                swap(i, j);
                i++;
            }
        }
        swap(i, high); 
        return i;
    }

	private void quicksort(int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(low, high);
        quicksort(low, pivotIndex - 1);
        quicksort(pivotIndex + 1, high);
    }

	public void sort() {
        quicksort(0, nums.length - 1);
    }

	public void showArray() {
		for(int i : nums) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		int[] nums = {23, 6, 4, -1, 0, 12, 8, 3, 1};
		QuickSort quicksort = new QuickSort(nums);
		quicksort.sort();
		quicksort.showArray();
	}

}