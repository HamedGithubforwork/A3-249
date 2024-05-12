import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class FileManager {
    // class for managing files

    /**

     * @param path the path of the file to be read
     * @return the file as a string
     */
    public String turnFileToString(String path) {
        // reads a file and returns it as a string
        InputStream ios = null;// to open the file
        Scanner read = null; // to read the file
        String fileAsString = ""; // to store the file as a string
        String nextLineAsString; // to store the next line of the file
        try {
            ios = new FileInputStream(path); // open the file at the path
            read = new Scanner(ios); // read the file
            while (read.hasNextLine()) { // while there are lines to read

                nextLineAsString = read.nextLine(); // read the next line into nextLine as a string
                if (!nextLineAsString.isBlank()) // if the line is not blank add it to the fileAsString
                    fileAsString += nextLineAsString + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println(path + " not found");
        } finally {
            if (ios != null) { // close the file if it was opened
                try {
                    ios.close();
                } catch (IOException e) {
                    System.out.println("Error closing file");
                }
            }
        }
        return fileAsString.substring(0, fileAsString.length() - 1);// removes the last \n
    }

    /**

     * @param textFile the text file to be read
     * @return an arraylist of the vocabs in the list
     */
    public ArrayList<String> arrayOfVocabs(String textFile) {
        // takes in a text file and finds the vocabs in the list
        Scanner scan = new Scanner(textFile);
        ArrayList<String> vocabs = new ArrayList<String>();
        while (scan.hasNext()) {
            String textLine = scan.nextLine();
            if (textLine.contains("#")) {
                textLine = textLine.substring(1);// removes the # from the beginning of the line
                vocabs.add(textLine); // adds the vocab to the list
            }
        }
        return vocabs;
    }

    /**

     * @param textFile the text file to be read
     * @return a 2 dimensional arraylist of the vocabs and their contents for each vocab
     */
    public ArrayList<ArrayList<String>> returnAs2dArrayList(String textFile) {
        // takes in a text file and returns a 2 dimensional arraylist of the vocabs
        // and their contents for each vocab
        FileManager file = new FileManager();
        ArrayList<String> topicsInVocab = new ArrayList<>();
        ArrayList<ArrayList<String>> twoDArrayList = new ArrayList<>();
        Scanner scan = new Scanner(textFile);
        boolean firstLine = true;
        while (scan.hasNextLine()) { // while there are lines to read
            String textLine = scan.nextLine(); // read the next line into nextLine as a string
            if (!firstLine && textLine.contains("#")) { // if the line contains a # then we are at the end of the vocab list
                twoDArrayList.add(topicsInVocab); // add the vocab list to the 2d arraylist
                topicsInVocab = new ArrayList<>(); // reset the arraylist for the next vocab topic
            }
            firstLine = false; // the first line has been read
            if (!textLine.contains("#")) // if the line does not contain a # then it is a word in the vocab list
                topicsInVocab.add(textLine); // add the line to the vocab  list
        }
        twoDArrayList.add(topicsInVocab); // add the last vocab list to the 2d arraylist
        return twoDArrayList;
        //takes in a text file and returns the first vocabs contents as a string


    }

    /**
     * // takes in a text file and returns the first vocabs contents as a string
     * @param textFile the text file to be read
     */
    public void convertToArrayListAndPrintBack(String textFile) {
        FileManager file = new FileManager();
        ArrayList<String> vocabArray = file.arrayOfVocabs(textFile);
        ArrayList<ArrayList<String>> twoDArrayList = file.returnAs2dArrayList(textFile);
        for (ArrayList<String> vocab : twoDArrayList) { // goes through the list of vocab arrays
            for (String vocabtype : vocabArray) { // That specific vocab array content is pritned
                System.out.println(vocabtype);
                for (String word : vocab) {
                    System.out.println(word);
                }
            }
        }
    }

    /**
     *  takes in a text file and returns a list of vocab objects
     * @param textFile the text file to be read
     * @return a list of vocab objects and their contents for each vocab
     */
    public ArrayList<Vocab> turnFileToVocabObjects(String textFile) {
        // takes in a text file and returns a list of vocab objects
        // and their contents for each vocab

        FileManager file = new FileManager(); // creates a new file manager object
        ArrayList<Vocab> listOfVocabObjects = new ArrayList<>(); // creates a new list of vocab objects
        ArrayList<String> vocabArray = file.arrayOfVocabs(textFile); // creates a new arraylist of vocabsName
        ArrayList<ArrayList<String>> twoDArrayList = file.returnAs2dArrayList(textFile);  // creates a new 2d arraylist of vocabs and their contents
        // the following code adds the name of the vocab to the vocab object
        for (int i = 0; i < vocabArray.size(); i++) {
            listOfVocabObjects.add(new Vocab(vocabArray.get(i))); // adds the vocab object to the list of vocab objects
        }
        // the following code adds the words to the vocab object respective to its name
        for (int i = 0; i < listOfVocabObjects.size(); i++) {// goes through the list of vocab objects
            for (int j = 0; j < twoDArrayList.get(i).size(); j++) { // goes through the list of words in the vocab array and adds them to the vocab object
                listOfVocabObjects.get(i).addWord(twoDArrayList.get(i).get(j)); // adds the word to the vocab object list of words
            }
        }
        return listOfVocabObjects; // returns the list of vocab objects
    }

    /**
     * takes in a text file and returns a doubly linked list of vocab objects
     * @param textFile the text file to be read
     * @return a doubly linked list of vocab objects and their contents for each vocab
     */
    public DoublyLinkedList turnFileToDoubleyLinkedList(String textFile) {
        ArrayList<Vocab> listOfVocabObjects = turnFileToVocabObjects(textFile); // creates a list of vocab objects
        DoublyLinkedList list = new DoublyLinkedList(); // creates a new doubly linked list
        for (Vocab vocab : listOfVocabObjects) { // goes through the list of vocab objects
            list.addDNode(vocab); // adds the vocab object to the doubly linked list
        }
        return list; // returns the doubly linked list
    }

    /**
     * takes in a doubly linked list and saves it to a file
     * @param list the doubly linked list to be saved
     * @param path the path of the file to be saved
     */
    public void savetoFile(DoublyLinkedList list, String path) {
        // takes in a doubly linked list and saves it to a file
        PrintWriter writer = null;
        try {

            DoublyLinkedList.DNode currentNode = list.head; // the current DNode to be saved
            SinglyLinkedList.SNode currentWord; // the current word to be saved
             writer = new PrintWriter(new FileOutputStream(path)); // creates a new print writer object
            writer=new PrintWriter(new FileOutputStream(path,true));
            while (currentNode != null) { // while there are DNodes to save
                writer.println("#" + currentNode.vocab.name); // save the name of the vocab
                currentWord = currentNode.vocab.NodeS.head; // the current word to be saved
                while (currentWord != null) { // while there are words to save
                    writer.println(currentWord.data); // save the word
                    currentWord = currentWord.nextNode; // move to the next word
                }
                currentNode = currentNode.next; // move to the next DNode
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
finally {
            System.out.println("Done Saving");
            writer.close();
        }

    }
}