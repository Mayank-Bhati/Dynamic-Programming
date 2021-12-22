import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public static void main(String[] args) {
        int[][] out = updateMatrixDP(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}});
        for (int[] arr : out) {
            for (int i : arr)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    public static int[][] updateMatrixBFS(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] out = new int[m][n];
        Queue<pair> q = new LinkedList<>();
        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1)
                    out[i][j] = Integer.MAX_VALUE;
                else
                    q.add(new pair(i,j));
            }
        }
        int[][] dir = {
                {-1,0},
                {1,0},
                {0,-1},
                {0,1}
        };
        while(!q.isEmpty()){
            pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int i = 0; i < 4; i++){
                int newR = x+dir[i][0], newC = y+dir[i][1];
                if(newR >= 0 && newC >= 0 && newR < m && newC < n){
                    if(out[newR][newC] > out[x][y] + 1){
                        out[newR][newC] = 1+out[x][y];
                        q.add(new pair(newR,newC));
                    }
                }
            }
        }
        return out;
    }
 static class pair {
     int x, y;

     pair(int x, int y) {
         this.x = x;
         this.y = y;
     }
 }

    public static int[][] updateMatrixDP(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] out = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0)
                    out[i][j] = 0;
                else
                    out[i][j] = Integer.MAX_VALUE-10;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(out[i][j] != 0){
                    if(i > 0)
                        out[i][j] = Math.min(out[i][j],out[i-1][j]+1);
                    if(j > 0)
                        out[i][j] = Math.min(out[i][j-1]+1,out[i][j]);
                }
            }
        }
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(out[i][j] != 0){
                    if(i < m-1)
                        out[i][j] = Math.min(out[i][j],out[i+1][j]+1);
                    if(j < n-1)
                        out[i][j] = Math.min(out[i][j+1]+1,out[i][j]);
                }
            }
        }
        return out;
    }

//    public static int[][] updateMatrix(int[][] mat) {
//        int[][] out = new int[mat.length][mat[0].length];
//        for (int[] arr : out)
//            Arrays.fill(arr, -1);
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[0].length; j++) {
//                out[i][j] = dist(i, j, mat, out);
//            }
//        }
//        return out;
//    }
//
//    static int dist(int i, int j, int[][] mat, int[][] out) {
//        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length)
//            return Integer.MAX_VALUE;
//        if (mat[i][j] == 0) {
//            out[i][j] = 0;
//            return out[i][j];
//        }
//        if (out[i][j] != -1)
//            return out[i][j];
//        else {
//            out[i][j] = 1 + Math.min(dist(i + 1, j, mat, out), Math.min(dist(i - 1, j, mat, out),
//                    Math.min(dist(i, j + 1, mat, out), dist(i, j - 1, mat, out))));
//            return out[i][j];
//        }
//    }
}
