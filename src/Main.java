public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addRandomValuesToTxt("Source");
        linkedList.addRandomValuesToTxt("Search");

        linkedList.readFromFile("Source.txt");
        System.out.println("*********************************************************************************************");

        System.out.println("Linked List after inserting values from Source.txt:");
        linkedList.printList();
        System.out.println("*********************************************************************************************");


        linkedList.searchValuesInFile("Search.txt");

        System.out.println("Linked List after searching and moving values from Search.txt:");
        linkedList.printList();
        System.out.println("*********************************************************************************************");

    }
}