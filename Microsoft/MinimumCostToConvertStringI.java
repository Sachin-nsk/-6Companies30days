class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int a = source.length(),b=target.length();
        int n = original.length;
        if(a!=b) return -1;
        int dist[][] = new int[26][26];
        for(int i=0;i<26;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for(int i=0;i<n;i++){
            int so = original[i] - 'a';
            int dest = changed[i] - 'a';
            if(cost[i]<dist[so][dest]){
                dist[so][dest] = Math.min(cost[i],dist[so][dest]);
            }
        }

        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }

        long c = 0;
        for(int i=0;i<a;i++){
            int s = source.charAt(i) - 'a' , d = target.charAt(i) - 'a';
            if(s==d) continue;
            if(dist[s][d]==Integer.MAX_VALUE) return -1;
            c+=dist[s][d];
        }
        return c;
    }
}