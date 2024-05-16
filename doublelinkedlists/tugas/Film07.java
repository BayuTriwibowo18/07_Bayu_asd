package doublelinkedlists.tugas;

public class Film07 {
    String id;
    String judul;
    double rating;
    Film07 next;
    Film07 prev;

    public Film07(String id, String judul, double rating) {
        this.id = id;
        this.judul = judul;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
