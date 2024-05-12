class Solution {
    
    public int findMax(int[][] grid, int start, int end) {
        
        int ans = Integer.MIN_VALUE;
        for(int i=start;i<start+3;i++) {
            
            for(int j=end;j<end+3;j++) {
                
                ans = Math.max(ans, grid[i][j]);
            }
        }
        return ans;
    }
    public int[][] largestLocal(int[][] grid) {
        
       int n = grid.length;
        int[][] ans = new int[n-2][n-2];
        
        for(int i=0;i<n-2;i++) {
            
            for(int j=0;j<n-2;j++) {
                
                ans[i][j] = findMax(grid,i,j);
            }
        }
        return ans;
    }
}