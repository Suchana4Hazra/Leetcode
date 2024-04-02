class Solution {
    public int lengthOfLastWord(String s) {
        
        s = s.trim();
        
        int c = 0;
        int i=s.length()-1;
        while(i >= 0 && s.charAt(i) != ' ') {
            
            c++;
            i--;
        }
        return c;
    }
}