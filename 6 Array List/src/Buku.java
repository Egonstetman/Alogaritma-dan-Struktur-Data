public class Buku {
    String judul;
    String pengarang;
    String penerbit;
    int tahun;
    int kategori;
    Buku(String judul, String pengarang, String penerbit, int tahun, int kategori) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahun = tahun;
        this.kategori = kategori;
    }
        
    String kategoriToString() {
        switch (kategori) {
            case 1:
                return "Teknik";
            case 2:
                return "Managemen";
            case 3:
                return "Fiksi";
            case 4:
                return "Buku lainnya";
            default:
                return "";
        }
    }
}                       
