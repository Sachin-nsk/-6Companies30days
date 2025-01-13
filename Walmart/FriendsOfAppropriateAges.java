class Solution {
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        int ans = 0;
        int[] count=  new int[121];
        for(int i=0;i<n;i++){
            count[ages[i]]++;
        }

        for(int i=1;i<=120;i++){
            if(count[i]==0) continue;
            for(int j=1;j<=120;j++){
                if(count[j]==0) continue;
                if(j<=0.5*i+7) continue;
                if(j>i) break;
                ans+=count[i]*count[j];
                if(i==j) ans-=count[i];
            }
        }
        return ans;
    }
}