package doublelinkedlists.tugas;

import java.util.Scanner;

public class FilmList07 {
    private Film07 head;
    private Film07 tail;
    private int size;

    public FilmList07() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void tambahDataAwal(String id, String judul, double rating) {
        Film07 newFilm = new Film07(id, judul, rating);
        if (head == null) {
            head = tail = newFilm;
        } else {
            newFilm.next = head;
            head.prev = newFilm;
            head = newFilm;
        }
        size++;
        System.out.println("Film telah ditambahkan di awal.");
    }

    public void tambahDataAkhir(String id, String judul, double rating) {
        Film07 newFilm = new Film07(id, judul, rating);
        if (tail == null) {
            head = tail = newFilm;
        } else {
            tail.next = newFilm;
            newFilm.prev = tail;
            tail = newFilm;
        }
        size++;
        System.out.println("Film telah ditambahkan di akhir.");
    }

    public void tambahDataIndexTertentu(int index, String id, String judul, double rating) {
        if (index < 0 || index > size) {
            System.out.println("Index tidak valid.");
            return;
        }
        if (index == 0) {
            tambahDataAwal(id, judul, rating);
        } else if (index == size) {
            tambahDataAkhir(id, judul, rating);
        } else {
            Film07 newFilm = new Film07(id, judul, rating);
            Film07 current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newFilm.next = current.next;
            newFilm.prev = current;
            current.next.prev = newFilm;
            current.next = newFilm;
            size++;
            System.out.println("Film telah ditambahkan di index " + index + ".");
        }
    }

    public void hapusDataPertama() {
        if (head == null) {
            System.out.println("Tidak ada data film.");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        System.out.println("Data film pertama telah dihapus.");
    }

    public void hapusDataTerakhir() {
        if (tail == null) {
            System.out.println("Tidak ada data film.");
            return;
        }
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        System.out.println("Data film terakhir telah dihapus.");
    }

    public void hapusDataTertentu(String id) {
        if (head == null) {
            System.out.println("Tidak ada data film.");
            return;
        }
        Film07 current = head;
        while (current != null && !current.id.equals(id)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Data film tidak ditemukan.");
        } else {
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }
            size--;
            System.out.println("Data film dengan ID " + id + " telah dihapus.");
        }
    }

    public void cetak() {
        if (head == null) {
            System.out.println("Tidak ada data film.");
            return;
        }
        Film07 current = head;
        System.out.println("Daftar Film Layar Lebar:");
        System.out.println("=================================");
        System.out.println("|ID    |Judul                   |Rating|");
        System.out.println("=================================");
        while (current != null) {
            System.out.printf("|%-6s|%-24s|%-6.1f|\n", current.id, current.judul, current.rating);
            current = current.next;
        }
        System.out.println("=================================");
    }

    public void cariIDFilm(String id) {
        if (head == null) {
            System.out.println("Tidak ada data film.");
            return;
        }
        Film07 current = head;
        while (current != null) {
            if (current.id.equals(id)) {
                System.out.println("Film ditemukan:");
                System.out.printf("ID: %s\nJudul: %s\nRating: %.1f\n", current.id, current.judul, current.rating);
                return;
            }
            current = current.next;
        }
        System.out.println("Film dengan ID " + id + " tidak ditemukan.");
    }

    public void urutDataRatingDESC() {
        if (head == null) {
            System.out.println("Tidak ada data film untuk diurutkan.");
            return;
        }
        for (Film07 current = head; current != null; current = current.next) {
            for (Film07 index = current.next; index != null; index = index.next) {
                if (current.rating < index.rating) {
                    // Tukar data film
                    String tempId = current.id;
                    String tempJudul = current.judul;
                    double tempRating = current.rating;

                    current.id = index.id;
                    current.judul = index.judul;
                    current.rating = index.rating;

                    index.id = tempId;
                    index.judul = tempJudul;
                    index.rating = tempRating;
                }
            }
        }
        System.out.println("Data film telah diurutkan berdasarkan rating secara descending.");
        cetak();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=================================");
            System.out.println("DATA FILM LAYAR LEBAR");
            System.out.println("=================================");
            System.out.println("1. Tambah Data Awal");
            System.out.println("2. Tambah Data Akhir");
            System.out.println("3. Tambah Data Index Tertentu");
            System.out.println("4. Hapus Data Pertama");
            System.out.println("5. Hapus Data Terakhir");
            System.out.println("6. Hapus Data Tertentu");
            System.out.println("7. Cetak");
            System.out.println("8. Cari ID Film");
            System.out.println("9. Urut Data Rating Film-DESC");
            System.out.println("10. Keluar");
            System.out.println("=================================");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan ID Film: ");
                    String id1 = scanner.nextLine();
                    System.out.print("Masukkan Judul Film: ");
                    String judul1 = scanner.nextLine();
                    System.out.print("Masukkan Rating Film: ");
                    double rating1 = scanner.nextDouble();
                    tambahDataAwal(id1, judul1, rating1);
                    break;
                case 2:
                    System.out.print("Masukkan ID Film: ");
                    String id2 = scanner.nextLine();
                    System.out.print("Masukkan Judul Film: ");
                    String judul2 = scanner.nextLine();
                    System.out.print("Masukkan Rating Film: ");
                    double rating2 = scanner.nextDouble();
                    tambahDataAkhir(id2, judul2, rating2);
                    break;
                case 3:
                    System.out.print("Masukkan Index: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Masukkan ID Film: ");
                    String id3 = scanner.nextLine();
                    System.out.print("Masukkan Judul Film: ");
                    String judul3 = scanner.nextLine();
                    System.out.print("Masukkan Rating Film: ");
                    double rating3 = scanner.nextDouble();
                    tambahDataIndexTertentu(index, id3, judul3, rating3);
                    break;
                case 4:
                    hapusDataPertama();
                    break;
                case 5:
                    hapusDataTerakhir();
                    break;
                case 6:
                    System.out.print("Masukkan ID Film: ");
                    String id6 = scanner.nextLine();
                    hapusDataTertentu(id6);
                    break;
                case 7:
                    cetak();
                    break;
                case 8:
                    System.out.print("Masukkan ID Film: ");
                    String id8 = scanner.nextLine();
                    cariIDFilm(id8);
                    break;
                case 9:
                    urutDataRatingDESC();
                    break;
                case 10:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
