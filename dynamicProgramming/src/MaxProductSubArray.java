public class MaxProductSubArray {
    static int maxProduct(int arr[]){
        int ans = 1, n = arr.length;
        for(int i = 0; i < n; i++){
            int m = 1;
            for(int j = i; j < n; j++){
                m *= arr[j];
            }
            ans = Math.max(ans,m);
        }
        return ans;
    }

    public static int maxProductEff(int[] arr) {
        int n = arr.length,max = arr[0], min = arr[0], ans = arr[0];
        for(int i = 1; i < n; i++){
            int temp = max;
            max = Integer.max(arr[i],Integer.max(arr[i]*max,arr[i]*min));
            min = Integer.min(arr[i],Integer.min(arr[i]*temp,arr[i]*min));
            if(ans < max)
                ans = max;
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
        System.out.println("Maximum Sub array product is "
                + maxProductEff(arr));
    }
}
