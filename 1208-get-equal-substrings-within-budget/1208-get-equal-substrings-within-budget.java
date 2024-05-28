class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int right = 0;
        int left = 0;
        int cost = 0;
        int maxLen = Integer.MIN_VALUE;
        
        while(right < s.length()) {
            
            cost+= Math.abs(s.charAt(right) - t.charAt(right));
            while(cost > maxCost) {
                
                cost-= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, (right-left+1));
            right++;
        }
        return maxLen;
    }
}