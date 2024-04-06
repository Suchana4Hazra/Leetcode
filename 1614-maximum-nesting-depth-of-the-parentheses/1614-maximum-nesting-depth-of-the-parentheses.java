class Solution {
    public int maxDepth(String s) {
        
        int bracket = 0;
        int ans = Integer.MIN_VALUE;
        
        for(int i=0;i<s.length();i++) {
            
            if(s.charAt(i) == '(') bracket++;
            else if(s.charAt(i) == ')') bracket--;
            ans = Math.max(ans,bracket);
        }
        return ans;
    }
}