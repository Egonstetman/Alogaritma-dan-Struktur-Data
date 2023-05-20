public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr, true);
        System.out.println("Array setelah diurutkan secara ascending menggunakan bubble sort:");
        printArray(arr);

        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        insertionSort(arr2, true);
        System.out.println("Array 2 setelah diurutkan secara ascending menggunakan insertion sort:");
        printArray(arr2);

        int[] arr3 = {64, 34, 25, 12, 22, 100, 90};
        selectionSort(arr3, true);
        System.out.println("Array 3 setelah diurutkan secara ascending menggunakan selection sort:");
        printArray(arr3);

        int[] arr4 = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr4, false);
        System.out.println("Array 4 setelah diurutkan secara descending menggunakan bubble sort:");
        printArray(arr4);

        int[] arr5 = {64, 34, 25, 12, 22, 11, 90};
        insertionSort(arr5, false);
        System.out.println("Array 5 setelah diurutkan secara descending menggunakan insertion sort:");
        printArray(arr5);

        int[] arr6 = {64, 34, 25, 12, 22, 100, 90};
        selectionSort(arr6, false);
        System.out.println("Array 6 setelah diurutkan secara descending menggunakan selection sort:");
        printArray(arr6);
    }

    public static void insertionSort(int[] arr, boolean ascending){
        int n = arr.length;
        for (int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && compare(arr[j], key, ascending)) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(int[] arr, boolean ascending){
        int pos;
        int temp;
        for (int i = 0; i < arr.length; i++){
            pos = i;
            for (int j = i+1; j < arr.length; j++){
                if (compare(arr[j], arr[pos], ascending)){
                    pos = j;
                }
            }
            temp = arr[pos];
            arr[pos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort(int[] arr, boolean ascending){
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (compare(arr[j], arr[j + 1], ascending)){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp; 
                }
            }
        }
    }

    public static boolean compare(int a, int b, boolean ascending) {
        if (ascending) {
            return a > b;
        }
        else {
            return a < b;
        }
    }

    public static void printArray(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
