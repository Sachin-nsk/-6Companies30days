class Solution {
    public int maxRotateFunction(int[] nums) {
       int n = nums.length;
       int F = 0;
       int sum = 0;
       for(int i=0;i<n;i++){
          sum+=nums[i];
          F+=i*nums[i];
       }
       int maxi = F;
       for(int k=1;k<n;k++){
        F=F+sum-n*nums[n-k];
        maxi=Math.max(maxi,F);
       }
       return maxi;
    }
}