class Solution {
    
    public class pair {
        
        double ratio;
        int quality;
        
        pair(double ratio, int quality) {
            
            this.ratio = ratio;
            this.quality = quality;
        } 
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
        ArrayList<pair> list = new ArrayList<>();
        
        int n = quality.length;
        for(int i=0;i<n;i++) {
            
            list.add(new pair((double) wage[i] / quality[i], quality[i]));
        }
       Collections.sort(list, Comparator.comparingDouble(a -> a.ratio));
        
        double ans = Double.MAX_VALUE;
        int QualitySum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(pair worker:list) {
            
            QualitySum+= worker.quality;
            pq.add(worker.quality);
            
            if(pq.size() > k) {
                
                QualitySum-= pq.poll();
            }
            if(pq.size() == k) ans = Math.min(ans,(QualitySum*worker.ratio));
        }
        return ans;
    }
}