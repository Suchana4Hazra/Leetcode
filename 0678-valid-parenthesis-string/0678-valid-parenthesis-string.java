class Solution {
    public boolean checkValidString(String s) {
        
        
        Stack<Integer> st = new Stack<>();
        Stack<Integer> asterics = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            
            if(s.charAt(i) == '(') st.push(i);
            else if(s.charAt(i) == '*') asterics.push(i);
            else {
                
                if(!st.isEmpty()) st.pop();
                else if(!asterics.isEmpty()) asterics.pop();
                else {
                    return false;
                }
            }
        }
        
        while(!st.isEmpty() && !asterics.isEmpty()) {
            
            if(st.pop() > asterics.pop()) return false;
        }
        return st.isEmpty();
    }
}