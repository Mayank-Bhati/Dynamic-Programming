public class DecodeWays {
    public static void main(String[] args) {
        String s = "111111111111111111111111111";
        System.out.println(numDecodings(s));
    }
    public static int numDecodings(String s) {
        int l = s.length();
        if(l > 1){
            if(s.charAt(l-1) == '0' && Integer.parseInt(s.substring(l-2)) > 26)
                return 0;
        }
        int[] dp = new int[l];
        for(int i = 0; i < l; i++)
            dp[i] = -1;
        return utility(s,0,dp);
    }
    static int utility(String s,int l, int[] dp){
        if(dp[l] != -1)
            return dp[l];
        if(l >= s.length())
            return 0;
        else if(s.charAt(l) == '0'){
            dp[l] = 0;
            return dp[l];
        }
        else if(l == s.length()-1){
            dp[l] = 1;
            return dp[l];
        }
        else if(l == s.length()-2){
            dp[l] = (Integer.parseInt(s.substring(l)) <= 26 && s.charAt(l+1) != '0')?2:1;
            return dp[l];
        }
        else if(Integer.parseInt(s.substring(l,l+2)) > 26){
            dp[l] = utility(s,l+1,dp);
            return dp[l];
        }
        else{
            dp[l] = utility(s,l+1,dp) +  utility(s,l+2,dp);
            return dp[l];
        }
    }
}
