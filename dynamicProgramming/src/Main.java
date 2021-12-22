import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++){
                arr[i] = sc.nextInt();
            }
            int out[] = before(arr,0,n-1,1,0,0);
            if(out[1] == 1)
                System.out.print("Red"+" ");
            else if(out[1] == -1)
                System.out.print("Green"+" ");
            else
                System.out.print("Tie"+" ");
            int[] out2 = after(arr,0,n-1,1,0,0);
            if(out[1] ==1)
                System.out.println("Red");
            else if(out[1] == -1)
                System.out.println("Green");
            else
                System.out.println("Tie");
        }
    }
    static  int[] before(int[] arr,int i,int j, int t, int r, int g){
        if(i <= j){
            if(t%2 != 0){
                int max = r;
                if(before(arr,i++,j,t++,r+arr[i],g)[0] > max && before(arr,i++,j,t++,r+arr[i],g)[1] == 1)
                    max = before(arr,i++,j,t++,r+arr[i],g)[0];
                if(before(arr,i,j--,t++,r+arr[j],g)[0] > max && before(arr,i,j--,t++,r+arr[j],g)[1] == 1)
                    max = before(arr,i,j--,t++,r+arr[j],g)[0];
                r += max;
            }
            else{
                int max = g;
                if(before(arr,i++,j,t++,r,arr[i]+g)[0] > max && before(arr,i++,j,t++,r,arr[i]+g)[1] == -1)
                    max = before(arr,i++,j,t++,r,arr[i]+g)[0];
                if(before(arr,i++,j,t++,r,arr[i]+g)[0] > max && before(arr,i++,j,t++,r,arr[i]+g)[1] == -1)
                    max = before(arr,i++,j,t++,r,arr[i]+g)[0];
                g += max;
            }
        }
        else{
            int out[] = new int[2];
            if(r > g){
                out[0] = r;
                out[1] = 1;
                return out;
            }
            else if(r < g){
                out[0] = g;
                out[1] = -1;
                return out;
            }
            else{
                out[0] = r;
                out[1] = 0;
                return out;
            }
        }
        return new int[]{0,0};
    }
    static int[] after(int[] arr,int i,int j, int t, int r, int g){
        if(i <= j){
            if(t%2 != 0){
                int max = r;
                if(before(arr,i++,j,t++,r+arr[i],g)[0] > max && before(arr,i++,j,t++,r+arr[i],g)[1] == 1)
                    max = before(arr,i++,j,t++,r+arr[i],g)[0];
                if(before(arr,i,j--,t++,r+arr[j],g)[0] > max && before(arr,i,j--,t++,r+arr[j],g)[1] == 1)
                    max = before(arr,i,j--,t++,r+arr[j],g)[0];
                if(arr[i] == arr[j] && after(arr,i++,j--,t++,r+arr[i]+arr[j],g)[0] > max && after(arr,i++,j--,t++,r+arr[i]+arr[j],g)[1] == 1)
                    max = after(arr,i++,j--,t++,r+arr[i]+arr[j],g)[0];
                r += max;
            }
            else{
                int max = g;
                if(after(arr,i++,j,t++,r,arr[i]+g)[0] > max && after(arr,i++,j,t++,r,arr[i]+g)[1] == -1)
                    max = after(arr,i++,j,t++,r,arr[i]+g)[0];
                if(after(arr,i++,j,t++,r,arr[i]+g)[0] > max && after(arr,i++,j,t++,r,arr[i]+g)[1] == -1)
                    max = after(arr,i++,j,t++,r,arr[i]+g)[0];
                if(arr[i] == arr[j] && after(arr,i++,j--,t++,r,g+arr[i]+arr[j])[0] > max && after(arr,i++,j--,t++,r,g+arr[i]+arr[j])[1] == -1)
                    max = after(arr,i++,j--,t++,r,g+arr[i]+arr[j])[0];
                g += max;
            }
        }
        else{
            int out[] = new int[2];
            if(r > g){
                out[0] = r;
                out[1] = 1;
                return out;
            }
            else if(r < g){
                out[0] = g;
                out[1] = -1;
                return out;
            }
            else{
                out[0] = r;
                out[1] = 0;
                return out;
            }
        }
        return new int[]{0,0};
    }
}








//    public static void main(String[] args) {
//        // YOUR CODE GOES HERE
//        // Please take input and print output to standard input/output (stdin/stdout)
//        // DO NOT USE ARGUMENTS FOR INPUTS
//        // E.g. 'Scanner' for input & 'System.out' for output
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int gas = sc.nextInt();
//        int[][] roads = new int[n+1][n+1];
//        for(int k = 0; k < n-1; k++){
//            int i = sc.nextInt();
//            int j = sc.nextInt();
//            int d = sc.nextInt();
//            roads[i][j] = d;
//            roads[j][i] = d;
//        }
//        int q = sc.nextInt();
//        List<Hotel> l = new ArrayList<>();
//        for(int t = 0; t < q; t++){
//            if(sc.next().charAt(0)=='H'){
//                Hotel h = new Hotel();
//                h.name = sc.next();
//                h.city = sc.nextInt();
//                h.cost = sc.nextInt();
//                l.add(h);
//            }
//            else{
//                int platform = sc.nextInt();
//                Hotel h = null;
//                int min = Integer.MAX_VALUE;
//                for(int i = 0;i < l.size();i++){
//                    int city = l.get(i).city;
//                    int cost = l.get(i).cost;
//                    boolean visited[] = new boolean[n+1];
//                    visited[platform] = true;
//                    int d = minimumCostSimplePath(platform,city,visited,roads);
//                    int money = d*gas+cost;
//                    if(money < min){
//                        min = money;
//                        h = l.get(i);
//                    }
//                }
//                System.out.println(h.name + " "+ min);
//            }
//        }
//    }
//    static class Hotel{
//        String name;
//        int city, cost;
//    }
//    static int minimumCostSimplePath(int u, int destination,
//                                     boolean visited[],
//                                     int graph[][])
//    {
//        int V = graph.length;
//        if (u == destination)
//            return 0;
//        visited[u] = true;
//        int ans = Integer.MAX_VALUE;
//        for(int i = 0; i < V; i++)
//        {
//            if (graph[u][i] != 0 && !visited[i])
//            {
//                int curr = minimumCostSimplePath(i,
//                        destination, visited, graph);
//                if (curr < Integer.MAX_VALUE)
//                {
//                    ans = Math.min(ans, graph[u][i] + curr);
//                }
//            }
//        }
//        visited[u] = false;
//        return ans;
//    }
//
//
