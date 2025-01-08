class Solution {
    
    public int ways(int i,int k,boolean isDown,int jump){
        int count = 0;
        if(i==k){
            count++;
        }
        if( i>k+1) return 0 ;
        
        if(isDown){
            count+= ways(i+(int)Math.pow(2,jump),k,true,jump+1);
            count+= ways(i-1,k,false,jump+1);
        }else{
            count+= ways(i+(int)Math.pow(2,jump),k,true,jump+1);
        }

    
        return count;
    

    }
    public int waysToReachStair(int k) {
        return ways(1,k,true,0);
    
    }
}