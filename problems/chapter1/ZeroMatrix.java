import java.util.HashSet;

class ZeroMatrix {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        int[][] test = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                test[i][j] = i + 1;
            }
        }
        test[3][4] = 0;
        test[2][3] = 0;
        printMatrix(test);
        test = zeroMatrix(test);
        printMatrix(test);
    }

    public static int[][] zeroMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashSet<Integer> set_i = new HashSet<>();
        HashSet<Integer> set_j = new HashSet<>();

        int[][] res = matrix;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    set_i.add(i);
                    set_j.add(j);
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (set_i.contains(i))
                    res[i][j] = 0;
                if (set_j.contains(j))
                    res[i][j] = 0;
            }
        }

        return res;
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
}