class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] maxRight = new int[n];
        maxRight[n-1]=-1;
        int currMax=prices[n-1];
        for(int i=n-2;i>=0;i--){
            if(currMax>prices[i]){
                maxRight[i]=currMax;
            }else{
                currMax=prices[i];
                maxRight[i]=-1;
            }
        }
        int maxProfit=0;
        for(int i=0;i<n;i++){
            if(maxRight[i]!=-1){
                maxProfit=Math.max(maxRight[i]-prices[i],maxProfit);
            }
        }
        return maxProfit;
    }
}
