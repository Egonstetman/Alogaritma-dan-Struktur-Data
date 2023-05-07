import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TodoList {
    
    public static void main(String[] args) {
        Queue<String> todoQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        
        while (!choice.equals("5")) {
            displayMenu();
            choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    System.out.print("Masukkan tugas yang ingin ditambahkan: ");
                    String task = scanner.nextLine();
                    todoQueue.offer(task);
                    System.out.println("Tugas ditambahkan ke daftar.\n");
                    break;
                case "2":
                    if (todoQueue.isEmpty()) {
                        System.out.println("Daftar tugas kosong.\n");
                    } else {
                        System.out.println("Tugas selanjutnya: " + todoQueue.peek());
                        System.out.println("Apakah Anda ingin menghapus tugas ini dari daftar? (Y/N)");
                        String confirmation = scanner.nextLine().toUpperCase();
                        if (confirmation.equals("Y")) {
                            todoQueue.poll();
                            System.out.println("Tugas dihapus dari daftar.\n");
                        }
                    }
                    break;
                case "3":
                    if (todoQueue.isEmpty()) {
                        System.out.println("Daftar tugas kosong.\n");
                    } else {
                        System.out.println("Semua tugas dalam daftar:");
                        for (String taskInList : todoQueue) {
                            System.out.println("- " + taskInList);
                        }
                        System.out.println();
                    }
                    break;
                case "4":
                    todoQueue.clear();
                    System.out.println("Semua tugas dihapus dari daftar.\n");
                    break;
                case "5":
                    System.out.println("Selamat tinggal!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.\n");
                    break;
            }
        }
        scanner.close();
    }
    
    public static void displayMenu() {
        System.out.println("Menu Todo List");
        System.out.println("---------------");
        System.out.println("1. Tambah tugas");
        System.out.println("2. Tugas yang selesai1");
        System.out.println("3. Daftar semua tugas");
        System.out.println("4. Hapus semua tugas");
        System.out.println("5. Keluar");
        System.out.print("Masukkan pilihan Anda: ");
    }
}
