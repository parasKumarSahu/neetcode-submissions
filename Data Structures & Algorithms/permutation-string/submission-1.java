class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        if(s2.length()<n) return false;
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i=0; i<n; i++) {
            freq1[s1.charAt(i)-'a'] += 1;
            freq2[s2.charAt(i)-'a'] += 1;
        }

        if(isMatch(freq1, freq2)) return true;

        for(int i=n; i<s2.length(); i++) {
            freq2[s2.charAt(i)-'a'] += 1;
            freq2[s2.charAt(i-n)-'a'] -= 1;

            if(isMatch(freq1, freq2)) return true;
        }

        return false;
    }

    private boolean isMatch(int[] freq1, int[] freq2) {
        for(int i=0; i<26; i++) {
            if(freq1[i] != freq2[i]) return false;
        }

        return true;
    }
}
