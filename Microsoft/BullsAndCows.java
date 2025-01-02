import java.util.HashMap;

class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int bulls = 0, cows = 0;

        
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];

        for (int i = 0; i < n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++;
            } else {
                secretCount[s - '0']++;
                guessCount[g - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }

        return bulls + "A" + cows + "B";
    }
}
