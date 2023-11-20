public class Main {
        public static void main(String[] args) {
            LinkedList linkedList = new LinkedList();
            linkedList.readFromFile("Source.txt");

            System.out.println("Linked List after inserting values from Source.txt:");
            linkedList.printList();
            System.out.println();

            linkedList.searchAndMove(1531); // Example search and move operation
            System.out.println();

            System.out.println("Linked List after searching and moving value 1531");
            linkedList.printList();
        }
}

