package Jobsheet16;


public class Mahasiswa07 {
    
    String nim;
    String nama;
    String notelp;

   

    public Mahasiswa07(String nim, String nama, String notelp) {
        this.nim = nim;
        this.nama = nama;
        this.notelp = notelp;
    }
    public String getNim() {
        return nim;
    }
   
    public String toString() {
        return "Mahasiswa07{" + 
               "nim=" + nim + 
               ", nama=" + nama + 
               ", notelp=" + notelp + 
               '}';
    }
    
}

