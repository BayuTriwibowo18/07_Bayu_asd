package doublelinkedlists;

import javax.swing.text.EditorKit;

public class Doublelikendlists07 {
    Node07 head;
    int size;

    public Doublelikendlists07(){
        head =null;
        size =0;
    }
    public boolean isEmpty(){
        return head == null;     
    }
    public void addFirst(int item){
        if (isEmpty()){
            head = new Node07(null, item, null);
        }else{
            Node07 newNode07 = new Node07(null, item, head);
            head.prev = newNode07;
            head = newNode07;
        }
        size++;
    }
    public void addLast(int item){
        if (isEmpty()){
            addFirst(item);
        }else{
            Node07 current = head;
            while (current.next != null){
                current = current.next;
            }
            Node07 newNode07 = new Node07(current, item, null);
            current.next = newNode07;
            size++;
        }
    }
    public void add(int item, int index)throws Exception{
        if(isEmpty()){
            addFirst(item);
        }else if(index < 0 || index > size){
            throw new Exception("Nilai indeks di luar batas");
        }else{
            Node07 current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;     
            }
            if(current.prev == null){
                Node07 newNode07 = new Node07(null, item, current);
                current.prev = newNode07;
                head = newNode07;
            }else{
                Node07 newNode07 = new Node07(current.prev, item, current);
                newNode07.prev = current.prev;
                newNode07.next = current;
                current.prev.next = newNode07;
                current.prev =newNode07;
            }
        }
        size++;
    }
    public int size(){
        return size;
    }
    public void clear(){
        head = null;
        size =0;
    }
    public void print(){
        if (!isEmpty()){
            Node07 tmp = head;
            while (tmp != null){
                System.out.print(tmp.data +"\t");
                tmp = tmp.next;
            }
            System.out.println("\nberhasil diisi");

        }else{
            System.out.println("Linked list kosong!!");
        }
    }
    public void removeFirst() throws Exception{
        if (isEmpty()){
            throw new Exception("Linked List masing kosong, tidak dapat dihapus!!");  
        }else if (size == 1){
            removeLast();
        }else{
            head = head.next;
            head.prev = null;
            size--;
        }
    }
    public void removeLast() throws Exception{
        if (isEmpty()){
            throw  new Exception("Linked List masing kosong, tidak dapat dihapus!!");
        }else if (head.next == null){
            head = null;
            size--;
            return;
        }
        Node07 current = head;
        while (current.next.next != null) {
            current = current.next;     
        }
        current.next = null;
        size--;
    }
    public void remove(int index) throws Exception{
        if (isEmpty() || index >= size){
            throw new Exception("Nilai indeks di luar batas");
        }else if (index == 0){
            removeFirst();
        }else{
            Node07 current = head;
            int i =0;
            while (i < index) {
                current = current.next;
                i++;
                
            }
            if (current.next == null){
                current.prev.next = null;
            }else if (current.prev == null){
                current = current.next;
                current.prev = null;
                head= current;
            }else{
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }
    public int getFirst() throws Exception{
        if (isEmpty()){
            throw new Exception("Linked List kosong!1");
        }
        return head.data;

    }
    public int getLast() throws Exception{
        if (isEmpty()){
            throw new Exception("linked List kosong!!");
        }
        Node07 tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        return tmp.data;
    }
    public int get(int index) throws Exception {
        if (isEmpty() || index >= size){
            throw new Exception("Nilai indeks di luar batas.");
        }
        Node07 tmp = head;
        for (int i = 0; i < index; i++){
            tmp = tmp.next;
        }
        return tmp.data;
    }
    
}
    

