class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int ans = 0;
        for(int num:nums){
            mpp.put(num,mpp.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer>entry:mpp.entrySet()){
            if(k==0){
                if(entry.getValue()>1) ans++;
            }
            else if(mpp.containsKey(entry.getKey() - k)) ans++;
        }
        return ans;
    }
}