package jobsheet6;

public class DaftarMahasiswaBerprestasi07 {
        Mahasiswa07 listMhs[] = new Mahasiswa07[5];
        int idx;

        void tambah(Mahasiswa07 m){
            if(idx < listMhs.length){
                listMhs[idx] = m;
                idx++;
            }else{
                System.out.println("Data sudah penuh!!");
            }
        }

        void tampil(){
            for(Mahasiswa07 m : listMhs){
                m.tampil();
                System.out.println("___________________________________");

            }
        }

        void bubbleSort(){
            for(int i=0; i<listMhs.length-1; i++ ){
                for(int j = 1; j<listMhs.length-i; j++){
                    if(listMhs[j].ipk > listMhs[j-1].ipk){
                        Mahasiswa07 tmp = listMhs[j];
                        listMhs[j] = listMhs[j-1];
                        listMhs[j-1] = tmp;
                    }
                }
            }
        }

        void selectionSort(){
            for(int i=0; i<listMhs.length-1; i++){
                int idxMin =1;
                for(int j=i+1; j<listMhs.length; j++){
                    if(listMhs[j].ipk < listMhs[idxMin].ipk){
                        idxMin = j;
                    }
                }
                Mahasiswa07 tmp = listMhs[idxMin];
                listMhs[idxMin] = listMhs[i];
                listMhs[i] = tmp;
            }
        }
        void insertionSort(){
            for (int i = 1; i < listMhs.length; i++){
                Mahasiswa07 temp = listMhs[i];
                int j = i;
                while (j > 0 && listMhs[j].ipk > temp.ipk){
                    listMhs[j + 1] = listMhs[j];
                    j--;
                }
                listMhs[j] = temp;
            }
        

       //#endregion void insertionSort(){
            for(int i = 1; i < listMhs.length; i++){
                Mahasiswa07 temp = listMhs[i];
                int j = i-1;
                while ( j >= 0 && listMhs[j].ipk < temp.ipk){
                    listMhs[j+1] = listMhs[j];
                    j--;
                }
                listMhs[j+1] = temp;
            }
        }
}
    

