import java.util.Arrays;
import java.util.Comparator;

// Kelas Buku
class Buku {
    // Atribut privat
    private String judul;
    private String penulis;
    private int tahunTerbit;

    // Konstruktor
    public Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    // Getter dan Setter untuk atribut judul
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    // Getter dan Setter untuk atribut penulis
    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    // Getter dan Setter untuk atribut tahunTerbit
    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    // Menampilkan informasi buku
    public void tampilkanInfo() {
        System.out.println("Judul: " + judul + ", Penulis: " + penulis + ", Tahun Terbit: " + tahunTerbit);
    }
}

// Kelas Utama untuk mendemonstrasikan Array of Objects
public class Main {
    public static void main(String[] args) {
        // Membuat array objek Buku
        Buku[] bukuArray = new Buku[5];

        // Mengisi array dengan objek Buku
        bukuArray[0] = new Buku("Laskar Pelangi", "Andrea Hirata", 2005);
        bukuArray[1] = new Buku("Harry Potter", "J.K. Rowling", 1997);
        bukuArray[2] = new Buku("Bumi Manusia", "Pramoedya Ananta Toer", 1980);
        bukuArray[3] = new Buku("Sang Pemimpi", "Andrea Hirata", 2006);
        bukuArray[4] = new Buku("Pride and Prejudice", "Jane Austen", 1813);

        // Menampilkan semua elemen dalam array objek
        System.out.println("Daftar Buku:");
        for (Buku buku : bukuArray) {
            buku.tampilkanInfo();
        }

        // Demonstrasi Searching: Mencari buku berdasarkan judul
        String judulDicari = "Harry Potter";
        Buku hasilCari = cariBukuByJudul(bukuArray, judulDicari);
        if (hasilCari != null) {
            System.out.println("\nBuku yang dicari: ");
            hasilCari.tampilkanInfo();
        } else {
            System.out.println("\nBuku dengan judul \"" + judulDicari + "\" tidak ditemukan.");
        }

        // Demonstrasi Sorting: Mengurutkan buku berdasarkan tahun terbit
        Arrays.sort(bukuArray, new Comparator<Buku>() {
            @Override
            public int compare(Buku b1, Buku b2) {
                return Integer.compare(b1.getTahunTerbit(), b2.getTahunTerbit()); // Urutkan dari yang terlama
            }
        });

        // Menampilkan buku setelah diurutkan berdasarkan tahun terbit
        System.out.println("\nDaftar Buku setelah diurutkan berdasarkan tahun terbit (terlama):");
        for (Buku buku : bukuArray) {
            buku.tampilkanInfo();
        }
    }

    // Metode untuk mencari buku berdasarkan judul
    public static Buku cariBukuByJudul(Buku[] array, String judul) {
        for (Buku buku : array) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                return buku;
            }
        }
        return null; // Mengembalikan null jika tidak ditemukan
    }
}
