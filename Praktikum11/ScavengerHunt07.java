package Praktikum11;

public class ScavengerHunt07 {
    Pointer07 head;

    public ScavengerHunt07() {
        this.head = null;
    }

    public void addPoint(String question, String answer) {
        Pointer07 newPoint = new Pointer07(question, answer);
        if (head == null) {
            head = newPoint;
        } else {
            Pointer07 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPoint;
        }
    }

    public void displayPoints() {
        Pointer07 current = head;
        int index = 1;
        while (current != null) {
            System.out.println("Point " + index + ": " + current.pertanyaan);
            current = current.next;
            index++;
        }
    }

    public boolean checkAnswer(String userAnswer) {
        if (head != null) {
            if (head.jawaban.equals(userAnswer)) {
                head = head.next;
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
}
