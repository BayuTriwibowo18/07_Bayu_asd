import java.util.Scanner;

public class RentalService07 {
    
     private static final int MAX_KENDARAAN = 5;
    private static final int MAX_TRANSAKSI = 100;
    private BarangRental07[] kendaraanList = new BarangRental07[MAX_KENDARAAN];
    private TransaksiRental07.TransaksiRental[] transaksiList = new TransaksiRental07.TransaksiRental[MAX_TRANSAKSI];
    private int kendaraanCount = 0;
    private int transaksiCount = 0;
    private Scanner scanner = new Scanner(System.in);
    // SOAL NOMOR 2
    // public RentalService07() {
    //     kendaraanList[kendaraanCount++] = new BarangRental07("S 4567 YV", "Honda Beat", "Motor", 2017, 10000);
    //     kendaraanList[kendaraanCount++] = new BarangRental07("N 4511 VS", "Honda Vario", "Motor", 2018, 10000);
    //     kendaraanList[kendaraanCount++] = new BarangRental07("N 1453 AA", "Toyota Yaris", "Mobil", 2022, 30000);
    //     kendaraanList[kendaraanCount++] = new BarangRental07("AB 4321 A", "Toyota Innova", "Mobil", 2019, 60000);
    //     kendaraanList[kendaraanCount++] = new BarangRental07("B 1234 AG", "Toyota Avanza", "Mobil", 2021, 25000);
    // }
    public RentalService07() {
        kendaraanList[kendaraanCount++] = new BarangRental07("S 4567 YV", "Honda Beat", "Motor", 2017, 25000);
        kendaraanList[kendaraanCount++] = new BarangRental07("N 4511 VS", "Honda Vario", "Motor", 2018, 25000);
        kendaraanList[kendaraanCount++] = new BarangRental07("N 1453 AA", "Toyota Yaris", "Mobil", 2022, 40000);
        kendaraanList[kendaraanCount++] = new BarangRental07("AB 4321 A", "Toyota Innova", "Mobil", 2019, 40000);
        kendaraanList[kendaraanCount++] = new BarangRental07("B 1234 AG", "Toyota Avanza", "Mobil", 2021, 40000);
    }

    public void daftarKendaraan() {
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("Daftar Kendaraan Rental Serba Serbi");
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("| Nomor TNKB | Nama Kendaraan | Jenis | Tahun | Biaya Sewa Perjam |");
        for (int i = 0; i < kendaraanCount; i++) {
            BarangRental07 kendaraan = kendaraanList[i];
            System.out.printf("| %-10s | %-13s | %-5s | %-5d | %-15d |%n",
                    kendaraan.noTKNB, kendaraan.namaKendaraan, kendaraan.jenisKendaraan, kendaraan.tahun, kendaraan.biayaSewa);
        }
    }

    public void peminjaman() {
        System.out.println("Masukkan Data Peminjaman");
        System.out.print("Masukkan Nama Peminjam: ");
        String namaPeminjam = scanner.nextLine();
        System.out.print("Masukkan Nomor TNKB: ");
        String noTKNB = scanner.nextLine();
        System.out.print("Masukkan Lama Pinjam: ");
        int lamaPinjam = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Apakah Member (ya/tidak): ");
        String isMember = scanner.nextLine();

        BarangRental07 kendaraan = null;
        for (int i = 0; i < kendaraanCount; i++) {
            if (kendaraanList[i].noTKNB.equalsIgnoreCase(noTKNB)) {
                kendaraan = kendaraanList[i];
                break;
            }
        }

        if (kendaraan != null) {
            if (kendaraan.isRented) {
                System.out.println("Tidak bisa diproses, kendaraan sudah dipinjam orang lain");
            } else {
                double totalBiaya = lamaPinjam * kendaraan.biayaSewa;
                
                // Apply membership discount
                if (isMember.equalsIgnoreCase("ya")) {
                    totalBiaya -= 25000; // Member gets a discount of 25000
                }

                // Apply duration-based discount
                if (lamaPinjam >= 48 && lamaPinjam <= 78) {
                    totalBiaya *= 0.9; // 10% discount untuk rental dari 48 and 78 hours
                } else if (lamaPinjam > 78) {
                    totalBiaya *= 0.8; // 20% discount untuk rental lebuh 78 hours
                }

                kendaraan.isRented = true;
                transaksiList[transaksiCount++] = new TransaksiRental07.TransaksiRental(namaPeminjam, lamaPinjam, totalBiaya, kendaraan);
                System.out.printf("Kendaraan %s berhasil dipinjam oleh %s selama %d jam dengan total biaya %.2f%n",
                        kendaraan.namaKendaraan, namaPeminjam, lamaPinjam, totalBiaya);
            }
        } else {
            System.out.println("Kendaraan tidak ditemukan!");
        }
    }

    public void tampilkanTransaksi() {
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("Daftar Transaksi Rental Serba Serbi");
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("| Kode Transaksi | Nama Peminjam | Nomor TNKB | Nama Kendaraan | Lama Pinjam | Total Biaya |");
        for (int i = 0; i < transaksiCount; i++) {
            TransaksiRental07.TransaksiRental t = transaksiList[i];
            System.out.printf("| %-14d | %-13s | %-10s | %-13s | %-11d | %-11.2f |%n",
                    t.kodeTransaksi, t.namaPeminjam, t.br.noTKNB, t.br.namaKendaraan, t.lamaPinjam, t.totalBiaya);
        }
    }

    public void urutkanTransaksi() {
        TransaksiRental07.TransaksiRental[] sortedAtoM = new TransaksiRental07.TransaksiRental[transaksiCount];
        TransaksiRental07.TransaksiRental[] sortedNtoZ = new TransaksiRental07.TransaksiRental[transaksiCount];
        int countAtoM = 0;
        int countNtoZ = 0;

        // Memisahkan transaksi berdasarkan kriteria A-M dan N-Z
        for (int i = 0; i < transaksiCount; i++) {
            if (transaksiList[i].namaPeminjam.charAt(0) >= 'A' && transaksiList[i].namaPeminjam.charAt(0) <= 'M') {
                sortedAtoM[countAtoM++] = transaksiList[i];
            } else {
                sortedNtoZ[countNtoZ++] = transaksiList[i];
            }
        }

        // Sorting transaksi A-M berdasarkan nomor TNKB secara descending
        for (int i = 0; i < countAtoM - 1; i++) {
            for (int j = 0; j < countAtoM - 1 - i; j++) {
                if (sortedAtoM[j].br.noTKNB.compareTo(sortedAtoM[j + 1].br.noTKNB) < 0) {
                    TransaksiRental07.TransaksiRental temp = sortedAtoM[j];
                    sortedAtoM[j] = sortedAtoM[j + 1];
                    sortedAtoM[j + 1] = temp;
                }
            }
        }

        // Sorting transaksi N-Z berdasarkan nama peminjam secara descending
        for (int i = 0; i < countNtoZ - 1; i++) {
            for (int j = 0; j < countNtoZ - 1 - i; j++) {
                if (sortedNtoZ[j].namaPeminjam.compareTo(sortedNtoZ[j + 1].namaPeminjam) < 0) {
                    TransaksiRental07.TransaksiRental temp = sortedNtoZ[j];
                    sortedNtoZ[j] = sortedNtoZ[j + 1];
                    sortedNtoZ[j + 1] = temp;
                }
            }
        }

        // Menggabungkan kembali hasil sorting ke dalam transaksiList
        System.arraycopy(sortedAtoM, 0, transaksiList, 0, countAtoM);
        System.arraycopy(sortedNtoZ, 0, transaksiList, countAtoM, countNtoZ);
    }

    
    public void menu() {
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Daftar Kendaraan");
            System.out.println("2. Peminjaman");
            System.out.println("3. Tampilkan seluruh transaksi");
            System.out.println("4. Urutkan Transaksi urut no TNKB");
            System.out.println("5. Keluar");
            System.out.print("Pilih(1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    daftarKendaraan();
                    break;
                case 2:
                    peminjaman();
                    break;
                case 3:
                    tampilkanTransaksi();
                    break;
                case 4:
                    urutkanTransaksi();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
                    System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        RentalService07 service = new RentalService07();
        service.menu();
    }
}

