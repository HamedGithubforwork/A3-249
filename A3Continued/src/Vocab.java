public class Vocab {
    // class for managing vocabulary
    /**
     * constructor for the vocabulary
     */
    String name; // the name of the vocabulary
    SinglyLinkedList NodeS; // the list of words in the vocabulary
    public Vocab(String name) { // the vocabulary is created with a name
        this.name = name; // the name of the vocabulary is the name given
        this.NodeS = new SinglyLinkedList(); // the list of words is created
    }

    /**
     * adds a word to the vocabulary
     * @param word the word to be added
     */
    public void addWord(String word) { // adds a word to the vocabulary
        if(NodeS.contains(word)) // if the word is already in the list, print an error message
            System.out.println("The word is already in the list");
        else {
            NodeS.addSNode(word); // adds the word to the list of words
            NodeS.bubbleSort(); // sorts the list of words in alphabetical order
        }
    }

    /**
     * prints the vocabulary
     */
    public void printVocab() { // prints the vocabulary
        System.out.println(name); // prints the name of the vocabulary
        NodeS.printList(); // prints the list of words
    }

    /**
     * searches for a word in the vocabulary
     * @param word the word to be searched for
     * @param indexOfWord the index of the word to be searched for
     */
    public void modifyWord(String word, int indexOfWord) { // modifies a word in the vocabulary
        SinglyLinkedList.SNode currentNode = NodeS.head; // the current SNode to be removed, initially null as it will be set in the loop, up here for greater scope
      for(int i=1; i<indexOfWord; i++) // goes through the list of words until the index is reached
            currentNode = currentNode.nextNode;
            currentNode.data = word; // the word at the index is changed to the new word
            NodeS.bubbleSort(); // sorts the list of words in alphabetical order

    }

    /**
     * removes a word from the vocabulary
     * @param indexOfWord the index of the word to be removed
     */
    public void removeWord(int indexOfWord) { // removes a word from the vocabulary
        SinglyLinkedList.SNode currentNode = NodeS.head; // the current SNode to be removed, initially null as it will be set in the loop, up here for greater scope
        if(indexOfWord==1){
            NodeS.head = NodeS.head.nextNode;
            NodeS.head.prevNode = null;
        }
       else if(indexOfWord==NodeS.size()){
            NodeS.tail = NodeS.tail.prevNode;
            NodeS.tail.nextNode = null;
        }
        else {
            for (int i = 1; i < indexOfWord; i++) // goes through the list of words until the index is reached
                currentNode = currentNode.nextNode;
            System.out.println(NodeS.size());
            SinglyLinkedList.SNode previousNode = currentNode.prevNode; // the previous SNode of the current SNode
            SinglyLinkedList.SNode nextNode = currentNode.nextNode; // the next SNode of the current SNode
            previousNode.nextNode = nextNode; // the previous SNode's next is the next SNode
            nextNode.prevNode = previousNode; // the next SNode's previous is the previous SNode
        }
    }
}
