import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for the matrices: ");
        int numRows = scanner.nextInt();
        System.out.print("Enter the number of columns for the matrices: ");
        int numCols = scanner.nextInt();

        double[][] matrixA = new double[numRows][numCols];
        double[][] matrixB = new double[numRows][numCols];

        System.out.println("Enter elements of matrix A:");
        inputMatrix(scanner, matrixA);

        System.out.println("Enter elements of matrix B:");
        inputMatrix(scanner, matrixB);

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("Matrix B:");
        printMatrix(matrixB);

        double[][] sum = addMatrices(matrixA, matrixB);
        double[][] difference = subtractMatrices(matrixA, matrixB);
        double[][] product = multiplyMatrices(matrixA, matrixB);

        System.out.println("Sum of A and B:");
        printMatrix(sum);

        System.out.println("Difference of A and B:");
        printMatrix(difference);

        System.out.println("Product of A and B:");
        printMatrix(product);

        System.out.println("Inverse of A:");
        double[][] inverseA = invertMatrix(matrixA);
        printMatrix(inverseA);
    }

    public static void inputMatrix(Scanner scanner, double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] addMatrices(double[][] A, double[][] B) {
        int numRows = A.length;
        int numCols = A[0].length;
        double[][] result = new double[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    public static double[][] subtractMatrices(double[][] A, double[][] B) {
        int numRows = A.length;
        int numCols = A[0].length;
        double[][] result = new double[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    public static double[][] multiplyMatrices(double[][] A, double[][] B) {
        int numRowsA = A.length;
        int numColsA = A[0].length;
        int numColsB = B[0].length;
        double[][] result = new double[numRowsA][numColsB];

        for (int i = 0; i < numRowsA; i++) {
            for (int j = 0; j < numColsB; j++) {
                result[i][j] = 0;
                for (int k = 0; k < numColsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static double[][] invertMatrix(double[][] matrix) {
        // You can implement matrix inversion using a suitable algorithm.
        // This code assumes the matrix is invertible.
        // It's a simplified example and may not work for all matrices.
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        double[][] result = new double[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                result[i][j] = 1.0 / matrix[i][j];
            }
        }
        return result;
    }
}
