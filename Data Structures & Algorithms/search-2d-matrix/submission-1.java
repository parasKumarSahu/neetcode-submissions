class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, n = matrix.length, m = matrix[0].length;

        int l = 0, r = n-1;

        while(l<r) {
            int mid = (l+r)/2;

            if(target==matrix[mid][0]) return true;
            else if(target>matrix[mid][0] && target<=matrix[mid][m-1]) {
                l = mid;
                break;
            }
            else if(target>matrix[mid][0]) l = mid+1;
            else r = mid-1;
        }

        row = l;

        l = 0; r = m-1;

        while(l<r) {
            int mid = (l+r)/2;

            if(target==matrix[row][mid]) return true;
            else if(target>matrix[row][mid]) l = mid+1;
            else r = mid-1;
        }

        return matrix[row][l] == target;
        
    }
}
