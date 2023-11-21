```markdown
# Linked List Operations

This Java program demonstrates basic operations on a linked list. The linked list class includes methods to insert values, check if a value is present, print the list, and perform a search-and-move operation.

## Classes

### Main.java

The main class contains the `main` method, which creates a linked list, adds random values to "Source.txt" and "Search.txt" files, reads values from "Source.txt" into the linked list, and performs a search-and-move operation based on the values in "Search.txt". The results are then printed.

### LinkedList.java

The `LinkedList` class represents a linked list. It includes methods for inserting values, checking for existence, printing the list, reading values from a file, adding random values to a file, and performing a search-and-move operation.

### Node.java

The `Node` class represents a node in the linked list. Each node contains an integer data value and a reference to the next node in the list.

## How to Run

1. Compile the Java files using a Java compiler, for example:

   ```bash
   javac Main.java LinkedList.java Node.java
   ```

2. Run the compiled program:

   ```bash
   java Main
   ```

## Additional Notes

- The `addRandomValuesToTxt` method in the `LinkedList` class adds 10,000 random values to a file with the given filename.

- The `searchAndMove` method searches for values in the linked list and moves them to the beginning if found.

- The program demonstrates file I/O operations, random value generation, and basic linked list manipulations.

Feel free to modify and extend the code as needed for your specific requirements.
```
