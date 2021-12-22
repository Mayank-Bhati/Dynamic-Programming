import java.util.Arrays;

public class BeautifulArray {
    public static void main(String[] args) {
        int[] res = beautifulArray(4);
        for(int a : res)
            System.out.print(a+" ");
    }
    public static int[] beautifulArray(int n) {
        int[] out = new int[n];
        out = util(n,out);
        return out;
    }
    static int[] util(int n, int[] out){
        int p=0;
        if(n == 1){
            int i = 0;
            for(i = 0; i < out.length; i++){
                if(out[i] == 0)
                    out[i] = n;
            }
            if(check(out))
                return out;
            else {
                Arrays.fill(out, 0);
                p += 1;
            }
        }
        for(int i = p; i < out.length; i++){
            if(out[i] == 0){
                out[i] = n;
                int[] res = out;
                res = util(n-1, res);
                if(check(res))
                    return res;
                else
                    out[i] = 0;
            }
        }
        return out;
    }
    static boolean check(int[] nums){
        boolean done = true;
        for(int i = 0; i < nums.length; i++){
            if(i-1 >= 0 && i+1 < nums.length && 2*nums[i] == nums[i-1]+nums[i+1])
                return false;
            if(nums[i] == 0){
                done = false;
                break;
            }
        }
        return true;
    }
}
