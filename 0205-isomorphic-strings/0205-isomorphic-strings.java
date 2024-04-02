class Solution {
    public boolean isIsomorphic(String s, String t) {
        
           int freqS[] = new int[200];
           int freqT[] = new int[200];
        
        for(int i=0;i<s.length();i++) {
            
            if(freqS[s.charAt(i)] != freqT[t.charAt(i)]) return false;
            freqS[s.charAt(i)] = i+1;
            freqT[t.charAt(i)] = i+1;
        }
        return true;
    }
}