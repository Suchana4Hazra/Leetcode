class Solution {
    
    int len = 0;
    int drow[] = {0,-1,0,1};
    int dcol[] = {-1,0,1,0};
                
    public class Pair{
        
        int row;
        int col;
        
        public Pair(int row, int col) {
            
            this.row = row;
            this.col = col;
        }
    }
    public int[][] calManhattnDistance(List<List<Integer>> grid, int m, int n) {
        
        Queue<Pair> qu = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] distance = new int[m][n];
        
        for(int i=0;i<m;i++) {
            
            for(int j=0;j<n;j++) {
                
                if(grid.get(i).get(j) == 1) {
                    
                    visited[i][j] = true;
                    qu.add(new Pair(i,j));
                    distance[i][j] = 0;
                }
            }
        }
        
        while(qu.size() > 0) {
            
            int sz = qu.size();
            for(int i=0;i<sz;i++) {
                
                Pair temp = qu.poll();
                distance[temp.row][temp.col] = len;
              
                for(int k=0;k<4;k++) {
                    int nrow = drow[k]+temp.row;
                    int ncol = dcol[k]+temp.col;
                    
                    if(nrow >=0 && ncol >=0 && nrow < m && ncol < n && visited[nrow][ncol] == false) {
                        
                        visited[nrow][ncol] = true;
                        qu.add(new Pair(nrow,ncol));
                    }
                }
            }
            len++;
        }
        return distance;
    }
    
    public boolean isSafePathExist(int[][] distance, int sf, int m, int n) {
        
        if(distance[0][0] < sf) return false;
        
        Queue<Pair> qu = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        qu.add(new Pair(0,0));
        visited[0][0] = true;
        
        while(qu.size() > 0) {
            
            Pair temp = qu.poll();
            if(temp.row == m-1 && temp.col == n-1) return true;
            
            for(int k=0;k<4;k++) {
                    int nrow = drow[k]+temp.row;
                    int ncol = dcol[k]+temp.col;
                    
                    if(nrow >=0 && ncol >=0 && nrow < m && ncol < n && visited[nrow][ncol] == false && distance[nrow][ncol] >= sf) {
                        
                        visited[nrow][ncol] = true;
                        qu.add(new Pair(nrow,ncol));
                    }
              }
        }
        return false;
    }
public int maximumSafenessFactor(List<List<Integer>> grid) {
        
        int m = grid.size();
        int n = grid.get(0).size();
        
        int[][] distance = new int[m][n];
        distance = calManhattnDistance(grid,m,n);
        
        int low = 0;
        int high = len;
        int ans = 0;
 while(low <= high) {
            
            int mid = (low+high)/2;
            
      if(isSafePathExist(distance,mid,m,n)){//check for one particular value of sf whether path exist or not 
                
                ans = mid;
                low = mid+1;  //to search for larger safest factor as we have to find the maximum one
            } else {
                
                high = mid-1; 
            }
        }
        return ans;
    }
}