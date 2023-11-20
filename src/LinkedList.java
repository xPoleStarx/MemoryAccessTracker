import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Method to insert a new value at the end of the linked list if not already inserted
    public void insertIfNotExists(int value) {
        if (!contains(value)) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
            } else {
                Node last = head;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = newNode;
            }
        }
    }

    // Method to check if the linked list contains a specific value
    private boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to read values from a file and insert them into the linked list
    public void readFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String val : values) {
                    int value = Integer.parseInt(val);
                    insertIfNotExists(value);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }


    public int search(int value) {
        int memoryAccesses = 0;
        Node current = head;
        while (current != null) {
            memoryAccesses++; // Counting memory access
            if (current.data == value) {
                return memoryAccesses;
            }
            current = current.next;
        }
        return -1; // Value not found
    }

    // Method to calculate the total and average number of memory accesses for values in a file
    public void searchValuesInFile(String filename) {
        int totalMemoryAccesses = 0;
        int totalValues = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String val : values) {
                    int value = Integer.parseInt(val);
                    int memoryAccesses = search(value);
                    if (memoryAccesses != -1) {
                        totalMemoryAccesses += memoryAccesses;
                        totalValues++;
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        double averageMemoryAccesses = (double) totalMemoryAccesses / totalValues;

        System.out.println("Total Memory Accesses: " + totalMemoryAccesses);
        System.out.println("Total Values Found: " + totalValues);
        System.out.println("Average Memory Accesses per Value: " + averageMemoryAccesses);
    }


    // Method to move a specific value to the beginning of the linked list
    public void moveToBeginning(int value) {
        Node current = head;
        Node prev = null;

        // Search for the node with the specified value
        while (current != null && current.data != value) {
            prev = current;
            current = current.next;
        }

        // If the value is found and it's not already the first node, move it to the beginning
        if (current != null && prev != null) {
            prev.next = current.next; // Remove the node from its current position

            // Move the node to the beginning
            current.next = head;
            head = current;
        } else if (current != null && prev == null) {
            System.out.println("Already first node");
        }
    }


    // Method to search for a value in the linked list and move it to the beginning
    public int searchAndMove(int value) {
        int memoryAccesses = 0;
        Node current = head;
        Node prev = null;

        while (current != null) {
            memoryAccesses++; // Counting memory access
            System.out.println("Memory Access #" + memoryAccesses + ": Checking Node with Data " + current.data);

            if (current.data == value) {
                System.out.println("Value " + value + " found!");
                moveToBeginning(value); // Move the value to the beginning of the list
                return memoryAccesses;
            }

            prev = current;
            current = current.next;
        }

        System.out.println("Value " + value + " not found!");
        return -1; // Value not found
    }

    // ... (previous methods remain unchanged)
}




