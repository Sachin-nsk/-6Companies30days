//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            char[] nuts = new char[n], bolts = new char[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nuts[i] = (inputLine[i].charAt(0));
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                bolts[i] = (inputLine[i].charAt(0));
            }

            new Solution().matchPairs(n, nuts, bolts);
            for (int i = 0; i < n; i++) {
                System.out.print(nuts[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(bolts[i] + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        HashMap<Character,Character> mpp = new HashMap<>();
        mpp.put('!','1');
        mpp.put('#','2');
        mpp.put('$','3');
        mpp.put('%','4');
        mpp.put('&','5');
        mpp.put('*','6');
        mpp.put('?','7');
        mpp.put('@','8');
        mpp.put('^','9');
        mpp.put('1','!');
        mpp.put('2','#');
        mpp.put('3','$');
        mpp.put('4','%');
        mpp.put('5','&');
        mpp.put('6','*');
        mpp.put('7','?');
        mpp.put('8','@');
        mpp.put('9','^');
        
        for(int i=0;i<n;i++){
            nuts[i] = mpp.get(nuts[i]);
            bolts[i] = mpp.get(bolts[i]);
        }
        
        Arrays.sort(nuts);
        Arrays.sort(bolts);
        for(int i=0;i<n;i++){
            nuts[i] = mpp.get(nuts[i]);
            bolts[i] = mpp.get(bolts[i]);
        }
        
    }
}