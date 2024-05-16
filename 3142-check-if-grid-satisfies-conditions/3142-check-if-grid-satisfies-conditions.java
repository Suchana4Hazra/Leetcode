class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        for(int j=0;j<n;j++) {
            
            int val = grid[0][j];
            for(int i=1;i<m;i++) {
                
                if(grid[i][j] != val) return false;
            }
        }
        for(int i=1;i<n;i++) {
            
            if(grid[0][i] == grid[0][i-1]) return false;
        }
        return true;
    }
}