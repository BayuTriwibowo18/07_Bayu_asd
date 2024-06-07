package Tugas;
import java.util.*;

public class SistemPengolahanNilai07 {
    static List<Mahasiswa07> mahasiswa07List = new ArrayList<>();
    static List<Matakuliah07> matakuliah07List = new ArrayList<>();
    static List<Nilai07> nilaiList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mahasiswa07List.add(new Mahasiswa07("20001", "Thalhah", "021xxx"));
        mahasiswa07List.add(new Mahasiswa07("20002", "Zubair", "021xxx"));
        mahasiswa07List.add(new Mahasiswa07("20003", "Abdur-Rahman", "021xxx"));
        mahasiswa07List.add(new Mahasiswa07("20004", "Sa'ad", "021xxx"));
        mahasiswa07List.add(new Mahasiswa07("20005", "Sa'id", "021xxx"));
        mahasiswa07List.add(new Mahasiswa07("20006", "Ubaidah", "021xxx"));

        matakuliah07List.add(new Matakuliah07("00001", "Internet of Things", 3));
        matakuliah07List.add(new Matakuliah07("00002", "Algoritma dan Struktur Data", 2));
        matakuliah07List.add(new Matakuliah07("00003", "Algoritma dan Pemrograman", 2));
        matakuliah07List.add(new Matakuliah07("00004", "Praktikum Algoritma dan Struktur Data", 3));
        matakuliah07List.add(new Matakuliah07("00005", "Praktikum Algoritma dan Pemrograman", 3));

        int choice;
        do {
            System.out.println("****************************************************");
            System.out.println("SISTEM PENGOLAHAN DATA NILAI MAHASISWA SEMESTER");
            System.out.println("****************************************************");
            System.out.println("1. Input Nilai");
            System.out.println("2. Tampil Nilai");
            System.out.println("3. Mencari Nilai Mahasiswa");
            System.out.println("4. Urut Data Nilai");
            System.out.println("5. Hapus Mahasiswa");
            System.out.println("6. Keluar");
            System.out.println("****************************************************");
            System.out.print("Pilih    : ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    inputNilai(scanner);
                    break;
                case 2:
                    tampilNilai();
                    break;
                case 3:
                    mencariNilaiMahasiswa(scanner);
                    break;
                case 4:
                    urutDataNilai(scanner);
                    break;
                case 5:
                    hapusMahasiswa(scanner);
                    break;
                case 6:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 6);

        scanner.close(); // Closing the scanner
    }

    public static void inputNilai(Scanner scanner) {
        System.out.println("****************************************************");
        System.out.println("DAFTAR MAHASISWA");
        System.out.println("****************************************************");
        System.out.printf("%-10s %-15s %-10s%n", "NIM", "Nama", "No HP");
        for (Mahasiswa07 mhs : mahasiswa07List) {
            System.out.printf("%-10s %-15s %-10s%n", mhs.getNim(), mhs.getNama(), mhs.noHp);
        }
        System.out.print("Pilih mahasiswa by NIM: ");
        String nim = scanner.nextLine();
        Mahasiswa07 mahasiswa07 = mahasiswa07List.stream().filter(m -> m.getNim().equals(nim)).findFirst().orElse(null);

        if (mahasiswa07 == null) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
            return;
        }

        System.out.println("****************************************************");
        System.out.println("DAFTAR MATA KULIAH");
        System.out.println("****************************************************");
        System.out.printf("%-10s %-30s %-5s%n", "Kode", "Nama Mata Kuliah", "SKS");
        for (Matakuliah07 mk : matakuliah07List) {
            System.out.printf("%-10s %-30s %-5d%n", mk.kode, mk.nama, mk.sks);
        }
        System.out.print("Pilih MK by kode: ");
        String kode = scanner.nextLine();
        Matakuliah07 matakuliah07 = matakuliah07List.stream().filter(mk -> mk.kode.equals(kode)).findFirst().orElse(null);

        if (matakuliah07 == null) {
            System.out.println("Mata kuliah dengan kode " + kode + " tidak ditemukan.");
            return;
        }

        System.out.print("Nilai: ");
        double nilai;
        try {
            nilai = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
        } catch (InputMismatchException e) {
            System.out.println("Nilai harus berupa angka.");
            scanner.nextLine(); // Consume invalid input
            return;
        }

        nilaiList.add(new Nilai07(mahasiswa07, matakuliah07, nilai));
        System.out.println("Nilai berhasil ditambahkan.");
    }

    public static void tampilNilai() {
        System.out.println("****************************************************");
        System.out.println("DAFTAR NILAI MAHASISWA");
        System.out.println("****************************************************");
        System.out.printf("%-10s %-15s %-30s %-5s %-5s%n", "NIM", "Nama", "Mata Kuliah", "SKS", "Nilai");
        for (Nilai07 nilai : nilaiList) {
            System.out.println(nilai);
        }
    }

    public static void mencariNilaiMahasiswa(Scanner scanner) {
        System.out.print("Masukkan data mahasiswa (nim): ");
        String nim = scanner.nextLine();
        List<Nilai07> nilaiMahasiswa07 = new ArrayList<>();
        double totalSKS = 0;

        for (Nilai07 nilai : nilaiList) {
            if (nilai.getMahasiswa().getNim().equals(nim)) {
                nilaiMahasiswa07.add(nilai);
                totalSKS += nilai.matkul.getSks();
            }
        }

        System.out.println("****************************************************");
        System.out.println("DAFTAR NILAI MAHASISWA");
        System.out.println("****************************************************");
        for (Nilai07 nilai : nilaiMahasiswa07) {
            System.out.println(nilai);
        }
        System.out.println("Total SKS yang telah diambil: " + totalSKS);
    }

    public static void urutDataNilai(Scanner scanner) {
        System.out.println("****************************************************");
        System.out.println("URUT DATA NILAI");
        System.out.println("****************************************************");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        System.out.print("Pilih    : ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            Collections.sort(nilaiList);
        } else if (choice == 2) {
            Collections.sort(nilaiList, Comparator.reverseOrder());
        } else {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        System.out.println("****************************************************");
        System.out.println("DAFTAR NILAI MAHASISWA");
        System.out.println("****************************************************");
        System.out.printf("%-10s %-15s %-30s %-5s %-5s%n", "NIM", "Nama", "Mata Kuliah", "SKS", "Nilai");
        for (Nilai07 nilai : nilaiList) {
            System.out.println(nilai);
        }
    }

    public static void hapusMahasiswa(Scanner scanner) {
        System.out.println("****************************************************");
        System.out.println("DAFTAR MAHASISWA");
        System.out.println("****************************************************");
        System.out.printf("%-10s %-15s %-10s%n", "NIM", "Nama", "No HP");
        for (Mahasiswa07 mhs : mahasiswa07List) {
            System.out.printf("%-10s %-15s %-10s%n", mhs.getNim(), mhs.getNama(), mhs.noHp);
        }
        System.out.print("Pilih mahasiswa by NIM untuk dihapus: ");
        String nim = scanner.nextLine();
        Mahasiswa07 mahasiswa07 = mahasiswa07List.stream().filter(m -> m.getNim().equals(nim)).findFirst().orElse(null);

        if (mahasiswa07 == null) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
            return;
        }

        mahasiswa07List.remove(mahasiswa07);
        nilaiList.removeIf(nilai -> nilai.getMahasiswa().equals(mahasiswa07));
        System.out.println("Mahasiswa dengan NIM " + nim + " telah dihapus dari sistem.");
    }
}
