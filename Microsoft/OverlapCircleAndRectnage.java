class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x = Math.max(x1,Math.min(x2,xCenter));
        int y = Math.max(y1,Math.min(y2,yCenter));
        int disx = x - xCenter;
        int disy = y - yCenter;
        if(disx*disx + disy*disy <= radius*radius) return true;
        return false;
    }
}

/*
1. Calculate the nearest point on rectangle to the circle
  x = max(x1,min(x2,xCenter))
  y = max(y1,min(y2,yCenter))
2. Calculate the distance between the nearest point and center of the circle . 
 disx = x - xCenter , disy = y - yCenter
3. If disx**2 + disy**2 <= radius**2 then they overlap.
*/