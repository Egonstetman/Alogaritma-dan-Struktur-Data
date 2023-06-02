import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        int[] array = {4, 2, 9, 7, 1, 5, 6, 3, 8};

        int target = 6;

        // Linear Search
        long startTime = System.nanoTime();
        int linearSearchIndex = linearSearch(array, target);
        long endTime = System.nanoTime();
        long executionTimeLinear = (endTime - startTime) / 1000; // Waktu eksekusi dalam mikro detik
        double executionTimeLinearMillis = executionTimeLinear / 1000.0; // Konversi ke mili detik

        if (linearSearchIndex != -1) {
            System.out.println("Elemen ditemukan pada indeks " + linearSearchIndex);
        } else {
            System.out.println("Elemen tidak ditemukan");
        }
        System.out.println("Waktu eksekusi Linear Search: " + executionTimeLinearMillis + " ms");

        // Binary Search
        Arrays.sort(array); // Binary search membutuhkan array yang terurut
        startTime = System.nanoTime();
        int binarySearchIndex = binarySearch(array, target);
        endTime = System.nanoTime();
        long executionTimeBinary = (endTime - startTime) / 1000; // Waktu eksekusi dalam mikro detik
        double executionTimeBinaryMillis = executionTimeBinary / 1000.0; // Konversi ke mili detik

        if (binarySearchIndex != -1) {
            System.out.println("Elemen ditemukan pada indeks " + binarySearchIndex);
        } else {
            System.out.println("Elemen tidak ditemukan");
        }
        System.out.println("Waktu eksekusi Binary Search: " + executionTimeBinaryMillis + " ms");
    }

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
