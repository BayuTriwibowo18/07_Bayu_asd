import java.util.Scanner;

public class MainJavaCollection07 {
    public static void main(String[] args) {
        MahasiswaJavaCollection07 mahasiswaCollection = new MahasiswaJavaCollection07();
        mahasiswaCollection.add(new Mahasiswa07("002", "Alice", "01-01-2000"));
        mahasiswaCollection.add(new Mahasiswa07("001", "Bob", "02-02-2001"));
        mahasiswaCollection.add(new Mahasiswa07("004", "Charlie", "03-03-2002"));
        mahasiswaCollection.add(new Mahasiswa07("003", "David", "04-04-2003"));

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Cari Mahasiswa");
            System.out.println("4. Cetak Semua Mahasiswa");
            System.out.println("5. Urutkan Mahasiswa berdasarkan NIM");
            System.out.println("6. Keluar");
            System.out.print("Pilih: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Tanggal Lahir: ");
                    String tglLahir = scanner.nextLine();
                    mahasiswaCollection.add(new Mahasiswa07(nim, nama, tglLahir));
                    break;
                case 2:
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    nim = scanner.nextLine();
                    mahasiswaCollection.delete(nim);
                    break;
                case 3:
                    System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
                    nim = scanner.nextLine();
                    Mahasiswa07 mhs = mahasiswaCollection.search(nim);
                    if (mhs != null) {
                        System.out.println("Mahasiswa ditemukan:");
                        System.out.println("+------+----------------+--------------+");
                        System.out.println("| NIM  | Nama           | Tgl Lahir    |");
                        System.out.println("+------+----------------+--------------+");
                        System.out.format("| %-4s | %-14s | %-12s |%n", mhs.nim, mhs.nama, mhs.tglLahir);
                        System.out.println("+------+----------------+--------------+");
                    } else {
                        System.out.println("Mahasiswa tidak ditemukan.");
                    }
                    break;
                case 4:
                    mahasiswaCollection.printAll();
                    break;
                case 5:
                    mahasiswaCollection.sort();
                    System.out.println("Mahasiswa telah diurutkan.");
                    mahasiswaCollection.printAll();
                    break;
                case 6:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
