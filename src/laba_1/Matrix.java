package laba_1;

import java.util.Scanner;

//6 7 6 2 1
//0 9 2 7 6
//6 5 2 1 2
//9 2 6 4 2
//7 6 1 2 4

public class Matrix {
    public static void main(String[] args) {
        // int data[ROWS][COLS];
        Scanner scan = new Scanner(System.in);
        int[][] data = new int[5][5];

        for (int i = 0; i < data.length; ++i) {
            for (int j = 0; j < data[i].length; ++j) {
                data[i][j] = scan.nextInt();
            }
        }

        // diagonals
        int sum_main_diag = 0, sum_secondary_diag = 0;
        for (int i = 0; i < data.length; ++i) {
            for (int j = 0; j < data[i].length; ++j) {
                if (i == j) {
                    sum_main_diag += data[i][j];
                }
                if (i + j == data.length - 1) {
                    sum_secondary_diag += data[i][j];
                }
            }
        }

        // perimeter
        int sum_perimeter = 0;
        for (int i = 0; i < data.length; ++i) {
            for (int j = 0; j < data[i].length; ++j) {
                if (i == 0 || j == 0 || i == data.length - 1 || j == data.length - 1) {
                    sum_perimeter += data[i][j];
                }
            }
        }

        System.out.print("laba_1.Main diag: " + sum_main_diag + "\n");
        System.out.print("Secondary diag: " + sum_secondary_diag + "\n");
        System.out.print("Perimeter: " + sum_perimeter + "\n");

    }
}
