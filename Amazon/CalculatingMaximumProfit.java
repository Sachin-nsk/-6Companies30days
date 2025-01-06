class Solution {

    public int maxi(int i,int k,int[] prices,boolean buy,int n,int[][][] dp){
        if(i==n || k==0) return 0;
        int pick=0,notpick=0;
        if(dp[i][buy? 1:0][k]!=-1) return dp[i][buy? 1:0][k];
        if(buy){
           pick = -prices[i] + maxi(i+1,k,prices,false,n,dp);
           notpick = 0 + maxi(i+1,k,prices,true,n,dp);
            
        }else{
            pick = prices[i] + maxi(i+1,k-1,prices,true,n,dp);
            notpick = 0 + maxi(i+1,k,prices,false,n,dp);
        }
        
        return dp[i][buy? 1:0][k] =  Math.max(pick,notpick);
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp= new int[n][2][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return maxi(0,k,prices,true,n,dp);
    }
}