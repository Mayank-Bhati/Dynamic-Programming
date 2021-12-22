import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> in = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            List<Integer> l = new ArrayList<>();
            for(int j = 0; j < i+1; j++){
                l.add(j+1);
            }
            in.add(l);
        }
        System.out.println(minimumTotal(in));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1)
            return triangle.get(0).get(0);
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int[] arr : dp)
            Arrays.fill(arr,-1);
        return helper(0,0,triangle,dp);
    }
    static int helper(int r, int c, List<List<Integer>> triangle, int[][] dp){
        if(r >= dp.length || c >= dp[0].length)
            return Integer.MAX_VALUE-10000;
        if(r == dp.length-1 && c < dp[0].length)
            return triangle.get(r).get(c);
        if(dp[r][c] != -1)
            return dp[r][c];
        dp[r][c] = triangle.get(r).get(c) + Math.min(helper(r+1,c,triangle,dp),helper(r+1,c+1,triangle,dp));
        return dp[r][c];
    }
}
