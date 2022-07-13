package BasicAlgo.BinarySearch;

public class P378_KthSmallestElementInSortedMatrix {
    //nlog(max - min)
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (check(matrix, n, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            } 
        }
        return l;
    }

    private boolean check(int[][] matrix, int n, int mid, int k) {
        int count = 0;
        int i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count >= k; 
    }
}
