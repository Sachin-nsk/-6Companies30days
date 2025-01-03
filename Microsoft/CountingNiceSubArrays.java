class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int currsum = 0 , ans = 0;
        HashMap<Integer,Integer>prefixSum = new HashMap<>();
        prefixSum.put(currsum,1);
        for(int i=0;i<n;i++){
            currsum+=nums[i]%2;
            if(prefixSum.containsKey(currsum-k)){
                ans+=prefixSum.get(currsum-k);
            }
           prefixSum.put(currsum,prefixSum.getOrDefault(currsum,0)+1);
        }
        return ans;
    }

    
}

/**
 * 1. Brute force  --> O(n^2)
    a. Make a boolean arr to compute if a element is odd or even.
   b. Then using two loop find the no. of sub arr.

2. Hash Map --> O(n)
 a. Convert the arr such if it is odd then 1 else 0.
 b. Make a prefixSum hash map 
 c. ans+=prefixSum(currSum-k)
 d. prefixSum(currSum) = 0 or prefixSum(curSum)++.
 */