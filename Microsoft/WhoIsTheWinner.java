class Solution {
    public int findTheWinner(int n, int k) {
        int ind = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++) arr.add(i+1);
        while(n!=1){
            ind = (ind+k-1)%n;
            arr.remove(ind);
            n--;
        }
        return arr.get(0);
    }
}

/*
Method - 1 
Use the list concept --> O(n^2)

Method - 2
Use the queue rotation concept --> O(n*k)
for (int i = 0; i < k - 1; i++)  circle.add(circle.remove());

Method - 3
Iterative concept  --> O(n)
ans = 0;
 for (int i = 2; i <= n; i++)  ans = (ans + k) % i;
 return ans + 1;
       
*/