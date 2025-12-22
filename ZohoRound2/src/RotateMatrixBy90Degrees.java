import java.util.Arrays;

public class RotateMatrixBy90Degrees {
    static void main() {
        int[][] matrix = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
        };

        rotateMatrix2(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotateMatrix(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;

        int[][] mat = new int[n][m];

        int reverse = m - 1;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                mat[col][reverse] = nums[row][col];
            }
            reverse--;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = mat[i][j];
            }
        }
    }

    public static void rotateMatrix2(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length / 2; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[i][nums.length - 1 - j];
                nums[i][nums.length -1 -j] = temp;
            }
        }
    }
}