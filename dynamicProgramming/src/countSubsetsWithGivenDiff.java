public class countSubsetsWithGivenDiff {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        System.out.println(count(arr,4,1));
    }
    public static int count(int arr[], int n, int x) {
        int sum = 0, count = 0;
        for(int i = 0; i < n; i++)
            sum += arr[i];
        //  s1 - s2 = x
        //  s1 + s2 = sum
        //  s1 = (sum+x)/2
       sum = (x+sum)/2;
       return countSubsetsWithGivenSum.count(arr,n,sum);
    }

}
