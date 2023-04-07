import java.util.ArrayList;
import java.util.Scanner;

public class DaftarBuku {
    static ArrayList<Buku> daftarBuku = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Tambahkan buku");
            System.out.println("2. Tampilkan daftar buku");
            System.out.println("3. Keluar");

            System.out.print("Pilihan anda: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    input.nextLine(); // membaca karakter newline yang tersisa
                    String judul = input.nextLine();

                    System.out.print("Masukkan nama pengarang: ");
                    String pengarang = input.nextLine();

                    System.out.print("Masukkan nama penerbit: ");
                    String penerbit = input.nextLine();

                    System.out.print("Masukkan tahun terbit: ");
                    int tahun = input.nextInt();

                    System.out.println("Pilih kategori buku:");
                    System.out.println("1. Teknik");
                    System.out.println("2. Managemen");
                    System.out.println("3. Fiksi");
                    System.out.println("4. Buku lainnya");
                    System.out.print("Pilihan anda: ");
                    int kategori = input.nextInt();

                    Buku bukuBaru = new Buku(judul, pengarang, penerbit, tahun, kategori);
                    daftarBuku.add(bukuBaru);
                    break;

                case 2:
                    System.out.println("Daftar Buku Yang Tersedia:");
                    System.out.printf("%-3s %-30s %-30s %-20s %-6s %-20s\n", "No", "Judul", "Pengarang", "Penerbit", "Tahun", "Kategori");
                    for (int i = 0; i < daftarBuku.size(); i++) {
                        Buku buku = daftarBuku.get(i);
                        System.out.printf("%-3d %-30s %-30s %-20s %-6d %-20s\n",
                                i + 1, buku.judul, buku.pengarang, buku.penerbit, buku.tahun, buku.kategoriToString());
                    }

                    int jumlahBukuTeknik = 0;
                    int jumlahBukuManagemen = 0;
                    int jumlahBukuFiksi = 0;
                    int jumlahBukuLainnya = 0;
                    int jumlahBukuLawas = 0;
                    int jumlahBukuBaru = 0;

                    for (int i = 0; i < daftarBuku.size(); i++) {
                        Buku buku = daftarBuku.get(i);
                        if (buku.tahun < 2010) {
                            jumlahBukuLawas++;
                        } else {
                            jumlahBukuBaru++;
                        }

                        switch (buku.kategori) {
                            case 1:
                                jumlahBukuTeknik++;
                                break;
                            case 2:
                                jumlahBukuManagemen++;
                                break;
                            case 3:
                                jumlahBukuFiksi++;
                                break;
                            case 4:
                                jumlahBukuLainnya++;
                                break;
                            default:
                                break;
                        }
                    }
                    System.out.printf("Jumlah buku yang tersedia: %d\n", daftarBuku.size());
                    System.out.printf("Jumlah buku kategori Teknik: %d\n", jumlahBukuTeknik);
                    System.out.printf("Jumlah buku kategori Managemen: %d\n", jumlahBukuManagemen);
                    System.out.printf("Jumlah buku kategori Fiksi: %d\n", jumlahBukuFiksi);
                    System.out.printf("Jumlah buku kategori Lainnya: %d\n", jumlahBukuLainnya);
                    System.out.printf("Jumlah buku lawas: %d\n", jumlahBukuLawas);
                    System.out.printf("Jumlah buku baru: %d\n", jumlahBukuBaru);
                    break;
    
                case 3:
                    exit = true;
                    break;
    
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        }
    }
}    
