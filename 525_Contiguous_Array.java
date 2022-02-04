class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        if(n==1)return 0;
        HashMap<Integer,Integer> map= new HashMap<>();
        int max=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0)count--;
            else count++;
            
            if(count==0){
                max=Integer.max(max,i+1);
            }
            
            if(map.containsKey(count)){
                max=Integer.max(i-map.get(count),max);
            }else{
                map.put(count,i);
            }
        }
        return max;
    }
}
