import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class knapsack_01 {
    public static void main(String[] args) {
        int[] wt = {256, 424, 3, 86, 183, 286, 89, 427, 118, 258, 333, 433, 170, 155, 222, 190, 477, 330, 369, 193, 426, 56, 435, 50, 442, 13, 146, 61, 219};
        int[] val = { 647, 363, 887, 876, 434, 870, 143, 845, 417, 882, 999, 323, 652, 22, 700, 558, 477, 893, 390, 76, 713, 601, 511, 4, 870, 862, 689, 402, 790};
        System.out.println(knapSack(754,wt,val));
        List<Integer> res = new ArrayList<>();
    }
    static int knapSack(int w, int wt[], int val[]) {
        int n = wt.length;
        int[][] dp = new int[n+1][w+1];
      for(int[] arr : dp){
          Arrays.fill(arr,-1);
      }
      return util(w,wt,val,n,dp);
    }
   static int util(int w, int[] wt, int[] val, int n, int[][] dp){
        if(n == 0 || w == 0)
            return 0;
        if(dp[n][w] != -1)
            return dp[n][w];
        if(wt[n-1] < w){
            dp[n][w] = Math.max(util(w,wt,val,n-1,dp),val[n-1]+util(w-wt[n-1],wt,val,n-1,dp));
            return dp[n][w];
        }
        else{
            dp[n][w] = util(w,wt,val,n-1,dp);
            return dp[n][w];
        }
   }
}
