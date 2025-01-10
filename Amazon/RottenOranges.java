class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        int[][] vis = grid;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh==0){
            return 0;
        }
        if(q.isEmpty()){
            return -1;
        }
        int ans = -1;
        int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int s = q.size();
            while(s>0){
                int[] arr = q.poll();
                int x = arr[0];
                int y = arr[1];
                for(int[] dir:direction){
                    int i = x+dir[0];
                    int j = y+dir[1];
                    if(i>=0 && i<n && j>=0 && j<m && vis[i][j]==1){
                        vis[i][j] = 2;
                        fresh--;
                        q.offer(new int[]{i,j});
                    }
                }
                s--;
            }
            ans++;
        }
        if(fresh == 0) return ans;
        return -1;
    }
}