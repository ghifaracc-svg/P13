public class DoubleLinkedListsMain {
    public static void main(String[] args) {

        DoubleLinkedLists dll = new DoubleLinkedLists();

        dll.print();

        dll.addFirst(new Student("111", "Anton", "TI-1I", 3.57));
        dll.addLast(new Student("112", "Prabowo", "TI-1I", 3.7));
        dll.addFirst(new Student("113", "Herco", "TI-1I", 3.89));

        System.out.println("\nInitial Data:");
        dll.print();

        System.out.println("\nAdd data at index 2:");
        dll.add(new Student("114", "Rizki", "TI-1I", 3.8), 2);
        dll.print();

        System.out.println("\nInsert after NIM 112:");
        dll.insertAfter("112", new Student("115", "Hanzel", "TI-1I", 3.6));
        dll.print();

        System.out.println("\nRemove data after NIM 111:");
        dll.removeAfter("111");
        dll.print();

        System.out.println("\nFirst Data:");
        dll.getFirst().print();

        System.out.println("\nLast Data:");
        dll.getLast().print();

        System.out.println("\nData at index 1:");
        dll.getIndex(1).print();

        System.out.println("\nSize of Double Linked List:");
        System.out.println(dll.getSize());

        System.out.println("\nIndex of NIM 112:");
        System.out.println(dll.indexOf("112"));

        System.out.println("\nIndex of NIM 120:");
        System.out.println(dll.indexOf("120"));
    }
}