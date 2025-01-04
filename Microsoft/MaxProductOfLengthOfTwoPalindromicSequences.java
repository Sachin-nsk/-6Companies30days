class Solution {
    int maxi = 0;
    public int maxProduct(String s) {
        char[] c = s.toCharArray();
        dfs(c,0,"","");
        return maxi;
    }

    public void dfs(char[] c,int i,String s1,String s2){
        if(i==c.length){
            if(isPalindrome(s1) && isPalindrome(s2)){
                maxi = Math.max(maxi,s1.length()*s2.length());
            }
            return ;
        }

        dfs(c,i+1,s1+c[i],s2);
        dfs(c,i+1,s1,s2+c[i]);
        dfs(c,i+1,s1,s2);
    }

    public boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

/**
 * 1. Recursion 
a. Convert the string into char array & pass it to dfs.
b. dfs function , when the char arr reaches end it check if the two subsequence s1 & s2 are palindrome , if so then it take the product of the length and maintains a maxi.
c. dfs(c,i+1,s1+c[i],s2);dfs(c,i+1,s1,s2+c[i]);
dfs(c,i+1,s1,s2);
d. Make a isPalindrome function .
 */