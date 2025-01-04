class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int prev = -1;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                boolean isvalid = true;
                for(int k=0;k<i;k++){
                    if(k>0 && nums[k-1]>=nums[k]){
                        isvalid = false;
                        break;
                    }
                    prev = nums[k];
                }
                if(isvalid && j+1<n &&  prev >= nums[j+1]){
                    isvalid = false;
                }

                if(isvalid){
                    for(int k=j+1;k<n;k++){
                        if(k>j+1 && nums[k-1]>=nums[k]){
                            isvalid = false;
                            break;
                        }
                    }
                }

                if(isvalid) ans++;

            }
        }
        return ans;
        
    }
}