package Praktikum11;

public class LinkedList07 {
    Node07 head;

    public boolean isEmpty(){
        return (head == null);
    }
    public void print(){
        if (!isEmpty()){
            System.out.print("Isi linked List: ");
            Node07 currentNode07 = head;

            while (currentNode07 != null){
                System.out.print(currentNode07.data + "\t");
                currentNode07 = currentNode07.next;
            }
            System.out.println("");
        }else{
            System.out.println("Linked list kosong!");
        }
    }
    public void addFirst(int input){
        Node07 newNode07 = new Node07(input, null);

        if (isEmpty()){
            head = newNode07;
        }else{
            newNode07.next = head;
            head = newNode07;
        }
    }
    public void addLast(int input){
        Node07 newNode = new Node07(input, null);

        if (isEmpty()){
            head = newNode;
        }else{
            Node07 currentNode07 = head;

            while (currentNode07.next != null){
                currentNode07 = currentNode07.next;
            }
            currentNode07.next = newNode;
            
        }
    }
    public void insertAfter (int key, int input){
        Node07 newnode07 = new Node07(input, null);

        if (!isEmpty()){
            Node07 currentNode07 = head;

            do{
                if (currentNode07.data == key){
                    newnode07.next = currentNode07.next;
                    currentNode07.next = newnode07;
                    break;
                }
                currentNode07 = currentNode07.next;
            }while (currentNode07 != null);
        }else{
            System.out.print("Linked list kosong!");
        }
    }
    public int getData (int index){
        Node07 currentNode07 = head;

        for (int i =0; i < index; i++){
            currentNode07 = currentNode07.next;
        }
        return currentNode07.data;
    }
    public int indexof (int key){
        Node07 currentNode07 = head;
        int index = 0;

        while (currentNode07 != null && currentNode07.data != key) {
            currentNode07 = currentNode07.next;
            index++;
            
        }
        if (currentNode07 == null){
            return -1;
        }else{
            return index;
        }
    }
    public void removeFirst(){
        if (!isEmpty()){
            head = head.next;
        }else{
            System.out.println("Linked list kosong");
        }
    }
    public void removeLast(){
        if (isEmpty()){
            System.out.println("Linked list kosong");
        }else if (head.next == null){
            head = null;
        }else{
            Node07 currentNode07 = head;

            while (currentNode07.next != null){
                if (currentNode07.next.next == null){
                    currentNode07.next = null;
                    break;
                }
                currentNode07 = currentNode07.next;
            }
        }
    }
    public void remove(int key){
        if (isEmpty()){
            System.out.println("Linked list kosong");

        }else if (head.data == key){
            removeFirst();
        }else{
            Node07 currentNode07 = head;

            while (currentNode07.next != null){
                if(currentNode07.next.data == key){
                    currentNode07.next = currentNode07.next.next;
                    break;
                }
                currentNode07 = currentNode07.next;
            }
        }
    }
    public void insertAt(int index, int input) {
        if (index == 0) {
            addFirst(input);
        } else {
            Node07 newNode = new Node07(input, null);
            Node07 currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                if (currentNode == null) {
                    System.out.println("Index melebihi batas");
                    return;
                }
                currentNode = currentNode.next;
            }
            if (currentNode == null) {
                System.out.println("Index melebihi batas");
            } else {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
            }
        }
    }
    public void insertBefore(int key, int input) {
        Node07 newNode = new Node07(input, null);
        if (isEmpty()) {
            System.out.println("Linked list kosong");
        } else if (head.data == key) {
            addFirst(input);
        } else {
            Node07 currentNode = head;
            while (currentNode.next != null && currentNode.next.data != key) {
                currentNode = currentNode.next;
            }
            if (currentNode.next == null) {
                System.out.println("Key tidak ditemukan");
            } else {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
            }
        }
    }
    public void removeAt(int index) {
        if (isEmpty()) {
            System.out.println("Linked list kosong");
        } else if (index == 0) {
            removeFirst();
        } else {
            Node07 currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                if (currentNode.next == null) {
                    System.out.println("Index melebihi batas");
                    return;
                }
                currentNode = currentNode.next;
            }
            if (currentNode.next == null) {
                System.out.println("Index melebihi batas");
            } else {
                currentNode.next = currentNode.next.next;
            }
        }
    }


}
