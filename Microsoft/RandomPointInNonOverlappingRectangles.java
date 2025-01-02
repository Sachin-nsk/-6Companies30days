class Solution {
    int numPts;
    int[] rectCumCount;
    int[][] rects;
    Random random;

    public Solution(int[][] rects) {
        this.numPts = 0;
        this.rects = rects;
        this.random = new Random();
        this.rectCumCount = new int[rects.length];

        for(int i=0;i<rects.length;i++){
            int[] rect  = rects[i];
            int pointsInRect = (rect[2]-rect[0]+1)*(rect[3]-rect[1]+1);
            numPts+=pointsInRect;
            rectCumCount[i] = numPts;
        }
    }
    
    public int[] pick() {
        int ptInd = random.nextInt(numPts);
        int l = 0,r = rects.length - 1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(rectCumCount[mid]<=ptInd) l=mid+1;
            else r=mid;
        }

        int[] rect = rects[l];
        int x = rect[2]-rect[0]+1;
        int y = rect[3]-rect[1]+1;
        int ptsInRect = x*y;
        int pt = rectCumCount[l]-ptsInRect;
        int offset = ptInd - pt;
        return new int[]{rect[0]+offset%x,rect[1]+offset/x};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */

/**
 * 1. Initialize
   numPts --> Total no. of points
   rectCumCount[] --> total no. of points covered by the       rectangles .
   rect[][]
   random 
2. Solution function 
   a.Initialize all the variables 
   b. Fill the rectCumCount[] using a loop 
     total no. of points in a rect = (x2-x1+1)*(y2-y2+1)

3. Pick function
   a. ptIdx = random.nextInt(numPts) --> generates a random number within numPts
  b. Do a binary search to find the index of the rectCumCount where ptIdx will be there and store it in l.
  c. cal no. of points in that particular rect --> ptsInRect
   ptStart = rectCumCount[l] - ptsInRect
   offset = ptIdx - ptStart --> Specific pos within rect
  d. ans
     x_ = rect[0] + offset%x
     y_ = rect[1] + offset/x
 */
