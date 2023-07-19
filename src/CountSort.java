import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
    public static int[] countSort(int[] array, int n) {
        int max = getMax(array);
        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[array[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] sorted = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sorted[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }
        return sorted;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        array = countSort(array, n);
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
