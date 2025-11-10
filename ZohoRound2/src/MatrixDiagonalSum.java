public class MatrixDiagonalSum {
    static void main() {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println(diagonalSum2(matrix));
    }

    // Brute Force Solution
    // TC = O(n^2)  SC = O(1)
    public static int diagonalSum(int[][] mat) {
        int sum = 0;

        int leftToRight = 0;
        int rightToLeftRev = mat.length-1;
        int rightToLeftFar = 0;

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                int mid = mat.length / 2;
                if (row == mid && col == mid) {
                    sum+= mat[row][col];
                    continue;
                }

                if (leftToRight == row && leftToRight == col) {
                    sum += mat[row][col];
                }

                if (row == rightToLeftFar && col == rightToLeftRev) {
                    sum += mat[row][col];
                }
            }
            leftToRight++;
            rightToLeftFar++;
            rightToLeftRev--;
        }

        return sum;
    }


    // Optimal Solution
    // TC = O(n)  SC = O(1)
    public static int diagonalSum2(int[][] mat) {
        int sum = 0;

        int leftToRight = 0;
        int rightToLeft = mat.length -1;

        for (int i = 0; i < mat.length; i++) {
            int mid = mat.length / 2;

            if (i == mid && leftToRight == mid && rightToLeft == mid) {
                sum += mat[leftToRight][i];
                leftToRight++;
                rightToLeft--;
                continue;
            }

            sum += mat[leftToRight][i];
            leftToRight++;

            sum += mat[i][rightToLeft];
            rightToLeft--;
        }

        return sum;
    }
}
