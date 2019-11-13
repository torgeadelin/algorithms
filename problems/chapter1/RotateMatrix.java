class RotateMatrix {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        int[][] test = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                test[i][j] = i;
            }
        }
        printMatrix(test);
        test = rotate(test);
        printMatrix(test);

    }

    public static void printMatrix(int[][] ma) {
        int m = ma.length;
        int n = ma[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(ma[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static int[][] rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] res = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                res[i][j] = matrix[m - j - 1][i];
            }
        }
        return res;
    }
}
