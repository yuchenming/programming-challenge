package qlik;

/**
I choose quicksort and mergesort.
Quicksort is a divide and conquer algorithm which relies on partition, it can be done in efficient runtime with average O(nlogn) runtime and O(logn) memory.
Mergesort is also an efficient and comparison based sorting algorithm with O(nlogn) runtime and O(n) memory.
**/

public class question1 {
	
	public static void main(String args[]) {
		int[] nums = new int[100];
		//random generate 100 integers between 1 and 99
		for(int i = 0; i < 100; i++) {
			nums[i] = (int)(Math.random() * 99) + 1;
		}

        // switch the qucikSort and mergeSort by editing here
		int[] sortedArray = quickSort(nums);
		//int[] sortedArray = mergeSort(nums);
		for(int i = 0; i < 100; i++) {
			System.out.println(sortedArray[i]);
		}

	}
	
	//Quick Sort: O(n^2) - O(nlog(n)) runtime
	public static int[] quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
		return nums;
	}

	public static void quickSort(int[] nums, int start, int end){
		//stop when start is over end
        if(start >= end) return;
        //partition the current array
        int temp = partition(nums, start, end);
        //partition the part before pivot and after pivot
        quickSort(nums, start, temp-1);
        quickSort(nums, temp+1, end);
    }
    
    public static int partition(int[] nums, int start, int end){
    	//set index as the first position of the array
        int index = start;
        //select the last number in the array as pivot
        int pivot = nums[end];
        for(int i = start; i < end; i++){
        	//if the number is smaller than pivot, change position with index, then move index to next position
            if(nums[i] < pivot){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index ++;
            }
        }
        //change position of index and pivot
        //make all numbers before pivot is smaller than pivot and all numbers after pivot is larger than pivot
        nums[end] = nums[index];
        nums[index] = pivot;
        return index;
    }
    
    //Merge Sort: O(nlogn) runtime
    private static int[] mergeSort(int[] nums){
    	//return array if only one element
    	if(nums.length <= 1) {
            return nums;
    	}
    	//divide the array into two subarrays
        int[] left = new int[nums.length/2];
        int[] right = new int[nums.length - left.length];
        for(int i =0; i < left.length; ++i){
            left[i] = nums[i];
            right[i] = nums[i + left.length];
        }
        //deal with odd number element situation
        if(right.length > left.length) {
            right[right.length - 1] = nums[nums.length - 1];
        }
        //continue merge left part and right part
        int[] leftSort = mergeSort(left);
        int[] rightSort = mergeSort(right);
        return merge(leftSort, rightSort);
    }
    
    private static int[] merge(int[] left, int[] right){
        int leftCount = 0; //counter for left array
        int rightCount = 0; //counter for right array
        int sortCount = 0; //counter for sort array
        int[] sort = new int[left.length + right.length]; //sort array
        //sort the left array and right array by comparing each element
        while(leftCount < left.length && rightCount < right.length){
            if(left[leftCount] < right[rightCount]) {
            	sort[sortCount++] = left[leftCount++];
            }
            else {
            	sort[sortCount++] = right[rightCount++];
            }
        }
        //if there is remaining element in left array
        while(leftCount < left.length) {
        	sort[sortCount++] = left[leftCount++];
        }
        //if there is remaining element in right array
        while(rightCount < right.length) {
        	sort[sortCount++] = right[rightCount++];
        }
        return sort;
    }
    
    
}
