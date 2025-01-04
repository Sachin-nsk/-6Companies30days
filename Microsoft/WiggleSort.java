class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int half;
        if(nums.length%2==0)  half = (nums.length / 2) ;
        else  half = (nums.length / 2) +1;
        
        int[] left = new int[half];
        int[] right = new int[nums.length - half];
        
        for (int i = 0; i < half; i++) {
            left[i] = nums[i];
        }
        for (int i = 0; i < nums.length - half; i++) {
            right[i] = nums[half + i];
        }
        
        for (int i = 0; i < half; i++) {
            nums[2 * i] = left[half - 1 - i];
        }
        for (int i = 0; i < right.length; i++) {
            nums[2 * i + 1] = right[right.length - 1 - i];
        }
    }
}

/**
 * 1. Sort the array
2. if n is even then half  =n/2 else half = n/2 +1
3. create  two array left & right with size half & n-half
4. 1st half of the array is left & 2nd half of the array is right.
5. In even index of the nums put left in reverse order.
6. In odd index of the nums put right in reverse order.

 */