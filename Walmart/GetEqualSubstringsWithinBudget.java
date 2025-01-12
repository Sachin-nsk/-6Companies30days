class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int maxi = 0;
        int n = s.length();
        
        
        
        int cost =  0;
        int startIndex = 0;
        for(int i=0;i<n;i++){
            cost+=Math.abs(s.charAt(i) - t.charAt(i));
            
            while(cost>maxCost){
                cost-=Math.abs(s.charAt(startIndex)-t.charAt(startIndex));
                startIndex++;
            }
            maxi = Math.max(maxi,i-startIndex+1);
        }
       
        return maxi;
    }
}