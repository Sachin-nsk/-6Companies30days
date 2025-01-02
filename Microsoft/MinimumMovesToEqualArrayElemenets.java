class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int median  = nums[n/2];
        int moves = 0;
        for(int i=0;i<n;i++){
            moves+=Math.abs(median - nums[i]);
        }
        return moves;
    }
}

/*
1. Find the median of the arrays --> n/2
2. Find the sum of the difference b/w the items and the median .
3. The sum is the min moves.
*/