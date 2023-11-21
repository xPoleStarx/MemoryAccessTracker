import java.io.*;
import java.util.Random;

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

        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            current = current.next;

            if (current != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
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

    public  void  addRandomValuesToTxt(String filename){
        filename = filename + ".txt";
        try(BufferedWriter writer   = new BufferedWriter(new FileWriter(filename));){
            Random random = new Random();
            for (int i = 0; i < 10000 ; i++) {
                int value = random.nextInt(300);
                writer.write(value+",");
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void moveToBeginning(int value) {
        Node current = head;
        Node prev = null;

        // Search for the node with the specified value
        while (current != null && current.data != value) {
            prev = current;
            current = current.next;
        }

        // If the value is found and it's not already at the beginning
        if (current != null && prev != null) {
            prev.next = current.next; // Remove the node from its current position

            // Move the node to the beginning
            current.next = head;
            head = current;
        } else if (current != null && prev == null) {
            // The node is already at the beginning
            // No need to change anything
        }
    }

    // Method to search for a value in the linked list and move it to the beginning
    public int searchAndMove(int value) {
        int memoryAccesses = 0;
        Node current = head;
        Node prev = null;

        while (current != null) {
            memoryAccesses++; // Counting memory access

            if (current.data == value) {
                moveToBeginning(value); // Move the value to the beginning of the list
                return memoryAccesses;
            }

            prev = current;
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
                    int memoryAccesses = searchAndMove(value);
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
}





