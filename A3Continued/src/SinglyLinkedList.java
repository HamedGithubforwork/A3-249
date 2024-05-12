public class SinglyLinkedList {

    SNode head; // the head of the list
    SNode tail; // the tail of the list

    /**
     * constructor for the singly linked list
     */
    public SinglyLinkedList() { // the list is created with no head or tail
        this.head = null; // the head is null
        this.tail = null; // the tail is null
    }

    /**
     * returns the size of the list
     * @return the size of the list
     */
    public int size() {
        int sizeOfList= 0; // start the counter at 0
        SNode currentNode = head; // start at the head
    while(currentNode != null) { // while there are SNodes to count
        sizeOfList++; // increment the counter
        currentNode = currentNode.nextNode; // move to the next SNode
    }
        return sizeOfList; // return the size of the linked list as an integer

    }

    /**
     * class for the SNode
     */

    public class SNode {

        String data; // the data of the SNode
        SNode nextNode; // the next SNode

        public void setData(String data) {
            this.data = data;
        }

        /**
         * returns the size of the list
         * @return the size of the list
         */
        public int size() { // returns the size of the list
        int sizeOfList= 0; // start the counter at 0
        SNode currentNode = head; // start at the head
    while(currentNode != null){ // while there are SNodes to count
        sizeOfList++; // increment the counter
        currentNode = currentNode.nextNode; // move to the next SNode
    }
    return sizeOfList; // return the size of the linked list as an integer
}
        SNode prevNode; // the previous SNode
        /**
         * constructor for the SNode
         * @param name the name of the SNode
         */
        public SNode(String name) { // the SNode is created with a name and no next
            this.data = name; // the data of the SNode is the name
            this.nextNode = null; // the next SNode is null
            this.prevNode = null; // the previous SNode is null
        }

    }

    /**
     * adds a SNode to the end of the list
     * @param name the name of the SNode
     */
    public void addSNode(String name) {
        // adds a SNode to the end of the list
        if (head!=null&&contains(name)) {
            System.out.println("The word is already in the list");
        }
        else{
            SNode newNode = new SNode(name); // create a new SNode with the name
            if (head == null) { // if the list is empty
                head = newNode; // the new SNode is the head
                tail = newNode; // the new SNode is the tail
            } else {
                tail.nextNode = newNode; // the tail's next is the new SNode
                newNode.prevNode = tail; // the new SNode's previous is the tail
                tail = newNode; // the new SNode is the tail
            }
        }
    }

    /**
     * prints the list
     */
    public void printList() { // prints the list in order
        SNode currentNode = head; // start at the head
//        while (currentNode != null) { // while there are SNodes to print
//            System.out.println(currentNode.data); // print the data of the current SNode
//            currentNode = currentNode.nextNode; // move to the next SNode
        int count = 1;
        while (currentNode != null) {
            System.out.printf("%d: %s\t", count, currentNode.data);
            // After every third element, print a newline
            if (count % 3 == 0) {
                System.out.println();
            }
            currentNode = currentNode.nextNode;
            count++;
        }
        // Print a newline if the last line did not end with the third element
        if ((count - 1) % 3 != 0) {
            System.out.println();
        }
        System.out.println("--------------------------------------");
    }

    /**
     * prints the list in reverse order
     */

    public void printListReverse() { // prints the list in reverse order
        // prints the list in reverse order
        SNode currentNode = tail; // start at the head
        while (currentNode != null) { // while there are SNodes to print
            System.out.println(currentNode.data); // print the data of the current SNode
            currentNode = currentNode.prevNode; // move to the next SNode
        }
    }

    /**
     * sorts the list in alphabetical order
     */
    public void bubbleSort() { // sorts the list in alphabetical order
        boolean swapped; // if the list is swapped
        do { // do the following
            swapped = false; // the list is not swapped
            SNode current = head; // start at the head
            while (current != null && current.nextNode != null) { // while there are SNodes to sort
                if (current.data.compareTo(current.nextNode.data) < 0) { // if the current SNode is greater than the next SNode
                    // Swap the data
                    String temp = current.data; // the current data is stored in temp
                    current.data = current.nextNode.data; // the current data is the next data
                    current.nextNode.data = temp; // the next data is the temp data
                    swapped = true; // the list is swapped
                }
                current = current.nextNode; // move to the next SNode
            }
        } while (swapped);
    }

    /**
     * @param searchData checks if the list contains the data
     * @return true if the data is found, false if the data is not found
     */
    public boolean contains(String searchData) {
        SNode current = head;
        while (current != null) {
            if (searchData.equals(current.data)) {
                return true; // Data found
            }
            current = current.nextNode;
        }
        return false; // Data not found
    }
}
