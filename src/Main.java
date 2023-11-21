import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] data = new int[5];
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < data.length; ++i) {
            data[i] = scan.nextInt();
        }

        int[] mirror_data = new int[5];
        for (int i = data.length - 1, j = 0; i >= 0; --i, ++j) {
            mirror_data[j] = data[i];
        }

        for (int i = 0; i < data.length; ++i) {
            System.out.print(mirror_data[i] + " ");
        }
    }
}