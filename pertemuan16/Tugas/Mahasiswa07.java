package Tugas;

public class Mahasiswa07 {
    
        String nim;
        String nama;
        String noHp;
    
        public Mahasiswa07(String nim, String nama, String noHp) {
            this.nim = nim;
            this.nama = nama;
            this.noHp = noHp;
        }
        public String getNim() {
            return nim;
        }
        public String getNama(){
            return nama;
        }
        
        @Override
        public String toString() {
           return nim + "    " + nama + "    " +         noHp;
        }
    }
    

