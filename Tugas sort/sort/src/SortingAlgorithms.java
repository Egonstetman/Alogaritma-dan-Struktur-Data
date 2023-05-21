import java.util.Arrays;

public class SortingAlgorithms {
    // Heap Sort
    public static void heapSortAscending(int[] array) {
        int n = array.length;

        // Buat heap (mengatur ulang array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // Ekstrak elemen satu per satu dari heap
        for (int i = n - 1; i > 0; i--) {
            // Pindahkan root saat ini ke elemen akhir
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Panggil heapify maksimum pada heap yang telah dikurangi
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i; // Inisialisasi nilai terbesar sebagai root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // Jika anak kiri lebih besar dari root
        if (left < n && array[left] > array[largest])
            largest = left;

        // Jika anak kanan lebih besar dari nilai terbesar sejauh ini
        if (right < n && array[right] > array[largest])
            largest = right;

        // Jika nilai terbesar bukan root
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Menerapkan heapify secara rekursif pada sub-tree yang terpengaruh
            heapify(array, n, largest);
        }
    }

    public static void heapSortDescending(int[] array) {
        heapSortAscending(array);
        reverseArray(array);
    }

    // Merge Sort
    public static void mergeSortAscending(int[] array) {
        mergeSort(array, 0, array.length - 1, true);
    }

    private static void mergeSort(int[] array, int left, int right, boolean ascending) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Urutkan bagian pertama dan bagian kedua
            mergeSort(array, left, middle, ascending);
            mergeSort(array, middle + 1, right, ascending);

            merge(array, left, middle, right, ascending);
        }
    }

    private static void merge(int[] array, int left, int middle, int right, boolean ascending) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; ++i)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            rightArray[j] = array[middle + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if ((ascending && leftArray[i] <= rightArray[j]) || (!ascending && leftArray[i] >= rightArray[j])) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void mergeSortDescending(int[] array) {
        mergeSort(array, 0, array.length - 1, false);
    }

    private static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] array = { 7, 2, 8, 1, 4 };

        System.out.println("Array Asli: " + Arrays.toString(array));

        // Heap Sort Ascending
        heapSortAscending(array);
        System.out.println("Heap Sort (Ascending): " + Arrays.toString(array));

        // Heap Sort Descending
        heapSortDescending(array);
        System.out.println("Heap Sort (Descending): " + Arrays.toString(array));

        // Merge Sort Ascending
        mergeSortAscending(array);
        System.out.println("Merge Sort (Ascending): " + Arrays.toString(array));

        // Merge Sort Descending
        mergeSortDescending(array);
        System.out.println("Merge Sort (Descending): " + Arrays.toString(array));
    }
}
