class Solution {
    public int specialArray(int[] nums) {
        
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length;
        
        while(start <= end) {
            
            int mid = (start+end)/2;
            int count = countNoOfElementsGreaterThanMid(nums,mid);
            
            if(mid == count) return mid;
            else if(mid < count) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
    public int countNoOfElementsGreaterThanMid(int[] nums, int target) {
        
        int count = 0;
        
        for(int arrayElements : nums){
            
            if(arrayElements >= target) count++;
        }
        return count;
    }
}