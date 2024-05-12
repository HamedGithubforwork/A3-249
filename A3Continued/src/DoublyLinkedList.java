import java.util.ArrayList;

public class DoublyLinkedList {
    /**
     * This class is a doubly linked list of vocab objects
     */

    DNode head; // the head of the list
    DNode tail; // the tail of the list

    class DNode {
        // class for the DNodes of the list
       Vocab vocab; // the vocab class  of the DNode
        DNode next; // the next DNode
        DNode prev; // the previous DNode
        public DNode(Vocab vocab) { // initially the DNode only has vocab class  and no next or prev so theyre null
            this.vocab = vocab;
            this.next = null;
            this.prev = null;
        }
        public DNode (){ // if no vocab class  is given, the DNode is empty
            this.vocab = null;
            this.next = null;
            this.prev = null;
        }
    }

    /**]
     * This method adds a DNode to the end of the list
     * @param vocab the vocab class  of the DNode
     */
        public void addDNode(Vocab vocab) {
        // adds a DNode to the end of the list
            DNode newDNode = new DNode(vocab); // create a new DNode with the vocab class 
            DNode currentNode = head; // start at the head
            if (head == null)
                head = newDNode; // if the list is empty, the new DNode is the head
            else {
                while (currentNode.next != null) // go to the end of the list
                    currentNode = currentNode.next;
                currentNode.next = newDNode; // add the new DNode to the end of the list
                tail = newDNode; // the new DNode is now the tail
                tail.prev = currentNode; // the current node is now the previous node of the tail
            }
        }

    /**
     * This method prints the list in order
     */
    public void printList() { // prints the list in order
        DNode currentNode = head; // start at the head
        while (currentNode != null) { // while there are DNodes to print
            currentNode.vocab.printVocab(); // print the vocab class  of the current DNode
            currentNode = currentNode.next; // move to the next DNode
        }
    }
    /**
     * This method prints the list in  a specific index
     * @param index the index of the vocab to be printed
     */
    public void printSpecificIndex(int index) { // prints the list in order
        // the following method starts a counter at 1 and goes through the list until the index is reached
        // once the index is reached, the vocab class  of that DNode is printed
        // it starts as one as the menu will start at 1 instead of index 0
        DNode currentNode = head; // start at the head
        int counter = 1; // the counter for the index of the vocab
        while (currentNode != null) { // while there are DNodes to print
            if(counter==index) {
                currentNode.vocab.printVocab(); // print the vocab class  of the current DNode
            }
            currentNode = currentNode.next; // move to the next DNode
            counter++; // increment the counter
        }
    }
    /**
     * This method prints the list in order
     */
    public void printVocabNames() { // prints the list in order
        DNode currentNode = head; // start at the head
        int counter = 1; // the counter for the index of the vocab
        while (currentNode != null) { // while there are DNodes to print
            System.out.println(counter+"  "+currentNode.vocab.name); // print the vocab class  of the current DNode
            currentNode = currentNode.next; // move to the next DNode
            counter++; // increment the counter
        }
    }

    /**
     * This method prints the list in reverse order
     */
    public void printListReverse(){ // prints the list in reverse order
        // prints the list in reverse order
        DNode currentNode = tail; // start at the head
        while (currentNode != null) { // while there are DNodes to print
            System.out.println(currentNode.vocab); // print the vocab class  of the current DNode
            currentNode = currentNode.prev; // move to the next DNode
        }
    }

    /**
     * This method returns the size of the list
     * @return the size of the list
     */
    public int size() { // returns the size of the list
        int sizeOfList= 0; // start the counter at 0
        DNode currentNode = head; // start at the head
    while(currentNode != null){ // while there are DNodes to count
        sizeOfList++; // increment the counter
        currentNode = currentNode.next; // move to the next DNode
    }
    return sizeOfList; // return the size of the linked list as an integer
}

    /**
     * This method inserts a new DNode after a given index
     * @param index    the index of the DNode after which the new DNode will be inserted
     * @param vocab the vocab class  of the DNode
     */

    public void insertAfter(int index,Vocab vocab){ // the DNode at that index with have its next value set to the new DNode
        DNode currentNode = null;  // the current DNode to be inserted, initially null as it will be set in the loop, up here for greater scope
        if (index == 1) { // if the index is 1, then the new DNode will be the head
            head.prev= new DNode(vocab); // the new DNode's previous is the head
            head.prev.next = head; // the new DNode's next is the head
            head=head.prev; // the new DNode is now the head
        } else if (index == size()) {
            tail.next = new DNode(vocab); // the new DNode's previous is the head
            DNode temp = tail; // the new DNode's next is the head
            tail = tail.next; // the new DNode is now the head
            tail.prev = temp; // the new DNode is now the head
        }
        else {
            currentNode = head; // start from the head of the list to find the index
            for (int i = 1; i < index; i++) {// goes through the list, until the index is reached to find the DNode at the index
                currentNode = currentNode.next;
            }
            DNode newNode = new DNode(vocab); // create a new DNode with the vocab class
            DNode nextNode = currentNode.next; // the next DNode of the current DNode
            currentNode.next = newNode; // the current DNode's next is the new DNode
            newNode.prev = currentNode; // the new DNode's previous is the current DNode
            newNode.next = nextNode; // the new DNode's next is the next DNode
            nextNode.prev = newNode; // the next DNode's previous is the new DNode


        }
        }

    /**
     *
     * @param index the index of the DNode before which the new DNode will be inserted
     * @param vocab the vocab class  of the DNode
     */
    public void insertBefore(int index,Vocab vocab) {
            // inserts a new DNode before the index
            DNode currentNode = null;  // the current DNode to be inserted, initially null as it will be set in the loop, up here for greater scope
            if (index == 1) { // if the index is 1, then the new DNode will be the head
            head.prev= new DNode(vocab); // the new DNode's previous is the head
                head.prev.next = head; // the new DNode's next is the head
                head=head.prev; // the new DNode is now the head
            } else {
                currentNode = head; // start from the head of the list to find the index
                for (int i = 1; i < index; i++) {// goes through the list, until the index is reached to find the DNode at the index
                    currentNode = currentNode.next;
                }
                DNode newNode = new DNode(vocab); // create a new DNode with the vocab class
                DNode prevNode = currentNode.prev; // the previous DNode of the current DNode
                DNode nextNode = currentNode; // the next DNode of the current DNode
                prevNode.next = newNode; // the previous DNode's next is the new DNode
                newNode.prev = prevNode; // the new DNode's previous is the previous DNode
                newNode.next = nextNode; // the new DNode's next is the current DNode
                nextNode.prev = newNode; // the current DNode's previous is the new DNode
            }
        }

    /**
     * This method removes a DNode at a given index
     * @param index the index of the DNode to be removed
     */
        public void remove(int index){
        // removes the DNode at the index
            DNode currentNode = null;  // the current DNode to be removed, initially null as it will be set in the loop, up here for greater scope
            if(size()<index) { // if the index is greater than the size of the list, print an error message
                System.out.println("Index out of bounds");
            }
            if(index==1){ // if the index is 1, then the head is the DNode to be removed
                head = head.next; // the head is now the next DNode
                head.prev = null; // the head's previous is now null
            }
            else if(index==size()){ // if the index is the size of the list, then the tail is the DNode to be removed
                tail = tail.prev; // the tail is now the previous DNode
                tail.next = null; // the tail's next is now null
            }
            else{
                currentNode = head; // start from the head of the list to find the index
                for (int i = 1; i < index; i++) // goes through the list, until the index is reached to find the DNode at the index
                    currentNode = currentNode.next;

                currentNode.prev.next=currentNode.next; // the previous DNode's next is the current DNode's next
                currentNode.next.prev=currentNode.prev; // the next DNode's previous is the current DNode's previous
              currentNode=null; // the current DNode is now null and will be garbage collected
            }
        }

    /**
     * This method adds a word to the vocab class  of a DNode at a given index
     * @param indexOfTopic the index of the DNode
     * @param word the word to be added
     */
        public void addWord(int indexOfTopic,String word){ //
        DNode currentNode = head;  // the current DNode to be removed, initially null as it will be set in the loop, up here for greater scope
            for(int i=1; i<indexOfTopic; i++) // goes through the list, until the index is reached to find the DNode at the index
                currentNode = currentNode.next;
            currentNode.vocab.addWord(word);
// adds a word to the vocab class  of the DNode at the index

                }

    /**
     * This method prints the vocab class  of a DNode at a given index
     * @param index the index of the DNode
     */
    public void printSpecificIndexWord(int index) { // prints the list in order
    DNode currentNode = head;  // the current DNode to be removed, initially null as it will be set in the loop, up here for greater scope
    for(int i=1; i<index; i++) // goes through the list, until the index is reached to find the DNode at the index
        currentNode = currentNode.next;
    currentNode.vocab.NodeS.printList(); // print the vocab class  of the current DNode
}

    /**
     * This method changes a word in the vocab class  of a DNode at a given index
     * @param indexOfTopic the index of the DNode
     * @param indexOfWord the index of the word
     * @param word the new word
     */
    public void changeWord(int indexOfTopic,int indexOfWord,String word){
    DNode currentNode = head;  // the current DNode to be removed, initially null as it will be set in the loop, up here for greater scope
    for(int i=1; i<indexOfTopic; i++) // goes through the list, until the index is reached to find the DNode at the index
        currentNode = currentNode.next;

    currentNode.vocab.modifyWord(word,indexOfWord);
}

    /**
     * This method removes a word in the vocab class  of a DNode at a given index
     * @param indexOfTopic the index of the DNode
     * @param indexOfWord the index of the word
     */
    public void removeWord(int indexOfTopic,int indexOfWord){
    DNode currentNode = head;  // the current DNode to be removed, initially null as it will be set in the loop, up here for greater scope
    for(int i=1; i<indexOfTopic; i++) // goes through the list, until the index is reached to find the DNode at the index
        currentNode = currentNode.next;
    currentNode.vocab.removeWord(indexOfWord);
}

    /**
     * This method searches for a word in the vocab class  of a DNode at a given index
     * @param word the word to be searched for
     */
    public void searchForWord(String word){
    DNode currentNode = head;  // the current DNode to be removed, initially null as it will be set in the loop, up here for greater scope
    while(currentNode!=null) {
        if (currentNode.vocab.NodeS.contains(word)) {
            System.out.println("The word is in the list of " + currentNode.vocab.name);
            break;
        }
        currentNode = currentNode.next;
    }
    if(currentNode==null)
        System.out.println("The word is not in any of the lists");
}

    /**
     * This method searches for a word in the vocab class  of a DNode at a given index
     * @param letter the letter the word should start with
     * @param list1 the doubly linked list
     */
    public void searchForWordStartingWithAGivenLetter(String letter,DoublyLinkedList list1){
        // turns the list into an array first adding all its elements to an array
        // then goes through the array and checks if the first letter of each word is the same as the letter given
        // if it is, it prints the word
        // if it is not, it does nothing
        DNode currentNode = head;  // the current DNode to be removed, initially null as it will be set in the loop, up here for greater scope
    SinglyLinkedList.SNode currentNode2 = null;  // the current SNode to be removed, initially null as it will be set in the loop, up here for greater scope
    ArrayList<String> words = new ArrayList<>();
    currentNode2 = currentNode.vocab.NodeS.head;
    while(currentNode!=null) {
        while(currentNode2!=null) {
            words.add(currentNode2.data);
            currentNode2 = currentNode2.nextNode;
        }
        currentNode = currentNode.next;
    }
    for(String word: words){
        if(word.startsWith(letter))
            System.out.println(word);
    }
}
                }




