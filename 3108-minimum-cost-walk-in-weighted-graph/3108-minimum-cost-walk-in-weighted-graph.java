class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        
        int parent[] = new int[n];
        
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
        
        for(int[] edge : edges) {
            
            union(edge[0],edge[1],parent);
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int[] edge: edges) {
            
            int p = findParent(edge[1],parent);
            if(map.containsKey(p)) map.put(p,(edge[2] & map.get(p)));
            else map.put(p,edge[2]);
        }
        
        int res[] = new int[query.length];
        for(int i=0;i<query.length;i++) {
            
            if(query[i][0] == query[i][1]) {
                res[i] = 0;
                continue;
            }
            int p1 = findParent(query[i][0],parent);
            int p2 = findParent(query[i][1],parent);
            
            if(p1 != p2) res[i] = -1;
            else {
                res[i] = map.get(p1);
        }
    }
        return res;
}
                                           
 public int union(int u, int v, int[] parent) {
        
        u = findParent(u,parent);
        v = findParent(v,parent);
     if(u == v) {
         return u;
     }
        parent[v] = u;
        return u;
    }
    public int findParent(int child, int[] parent) {
        
        if(parent[child] == child) return child;
        else return parent[child] = findParent(parent[child],parent);
    }
}