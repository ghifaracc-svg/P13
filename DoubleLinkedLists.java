public class DoubleLinkedLists {
    Node head;
    Node tail;

    DoubleLinkedLists() {
        head = null;
        tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(Student data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void addLast(Student data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void add(Student data, int index) {
        if (index < 0) {
            System.out.println("Invalid index!");
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node temp = head;
        int count = 0;

        while (temp != null && count < index - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Index exceeds the size of the linked list!");
        } else if (temp == tail) {
            addLast(data);
        } else {
            Node newNode = new Node(data);
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    void insertAfter(String key, Student data) {
        Node newNode = new Node(data);
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.data.nim.equalsIgnoreCase(key)) {
                found = true;

                if (temp == tail) {
                    addLast(data);
                } else {
                    newNode.next = temp.next;
                    newNode.prev = temp;
                    temp.next.prev = newNode;
                    temp.next = newNode;
                }
                break;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Insertion failed. Data (" + key + ") not found!!");
        }
    }

    void removeAfter(String key) {
        Node temp = head;

        while (temp != null && !temp.data.nim.equalsIgnoreCase(key)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Data (" + key + ") not found!!");
        } else if (temp.next == null) {
            System.out.println("No data after " + key);
        } else {
            Node delete = temp.next;

            if (delete == tail) {
                tail = temp;
                tail.next = null;
            } else {
                temp.next = delete.next;
                delete.next.prev = temp;
            }
        }
    }

    Student getFirst() {
        if (isEmpty()) {
            System.out.println("Double linked list is currently empty!!");
            return null;
        }
        return head.data;
    }

    Student getLast() {
        if (isEmpty()) {
            System.out.println("Double linked list is currently empty!!");
            return null;
        }
        return tail.data;
    }

    Student getIndex(int index) {
        if (isEmpty()) {
            System.out.println("Double linked list is currently empty!!");
            return null;
        }

        if (index < 0) {
            System.out.println("Invalid index!");
            return null;
        }

        Node temp = head;
        int count = 0;

        while (temp != null) {
            if (count == index) {
                return temp.data;
            }
            temp = temp.next;
            count++;
        }

        System.out.println("Index exceeds the size of the linked list!");
        return null;
    }

    int getSize() {
        int size = 0;
        Node temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }

    int indexOf(String key) {
        Node temp = head;
        int index = 0;

        while (temp != null) {
            if (temp.data.nim.equalsIgnoreCase(key)) {
                return index;
            }
            temp = temp.next;
            index++;
        }

        return -1;
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("Double linked list is currently empty!!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("Double linked list is currently empty!!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    void remove(int index) {
        if (isEmpty()) {
            System.out.println("Double linked list is currently empty!!");
            return;
        }

        if (index < 0) {
            System.out.println("Invalid index!");
            return;
        }

        Node temp = head;
        int count = 0;

        while (temp != null && count < index) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Index exceeds the size of the linked list!");
            return;
        }

        if (index == 0) {
            removeFirst();
        } else if (temp == tail) {
            removeLast();
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    void print() {
        if (!isEmpty()) {
            Node temp = head;

            while (temp != null) {
                temp.data.print();
                temp = temp.next;
            }
            System.out.println();
        } else {
            System.out.println("Double linked list is currently empty!!");
        }
    }
}