import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FileManager file = new FileManager();
//        DoublyLinkedList list = new DoublyLinkedList();

//        ArrayList<Vocab> listOfVocabObjects = file.turnFileToVocabObjects(textFile);
//        ArrayList<Vocab> listOfVocabObjects = new ArrayList<>();
//
////       file.convertToArrayListAndPrintBack(textFile);
//        ArrayList<String> vocabArray = file.arrayOfVocabs(textFile);
//        ArrayList<ArrayList<String>> twoDArrayList = file.returnAs2dArrayList(textFile);
//        Boolean setVocabName = false;
//
//        //  for(String whichVocab: vocabArray)
//        // goes through the list of vocabs, setting the  name of the object to the vocab name
//        Vocab current = null; // creates a new vocab object with the name of the vocab and its words
//
//        // the following code adds the name of the vocab to the vocab object
//
//
//
//        System.out.println(twoDArrayList.size());
//        System.out.println(listOfVocabObjects.size());
//
////        for(ArrayList<String> vocab: twoDArrayList){
////            for(String word: vocab){
////                System.out.println(word);
////            }
////        }
////        for (String a : vocabArray) {
////            System.out.println(a);
////        }
//
//        // the following code adds the name of the vocab to the vocab object
//        for (int i = 0; i < vocabArray.size(); i++) {
//            listOfVocabObjects.add(new Vocab(vocabArray.get(i))); // adds the vocab object to the list of vocab objects
//        }
//// the following code adds the words to the vocab object respective to its name
//        for(int i=0; i<listOfVocabObjects.size(); i++){// goes through the list of vocab objects
//            for(int j=0; j<twoDArrayList.get(i).size(); j++){ // goes through the list of words in the vocab array and adds them to the vocab object
//                listOfVocabObjects.get(i).addWord(twoDArrayList.get(i).get(j)); // adds the word to the vocab object list of words
//            }
//        }
//                for (Vocab vocab : listOfVocabObjects) { // goes through the list of vocab objects
//            vocab.printVocab();
//        }
        //  list1.printList();
        DoublyLinkedList list1 = null;

        MenuManger menu = new MenuManger();
        Scanner scan = new Scanner(System.in);
        while (true) { // runs the program until the user exits
            menu.startingScreen();
            int response = Integer.parseInt(scan.nextLine()); // gets the response from the user
            if (response == 1) { // if the user selects option 1
                menu.response1Main(response, list1);
            } else if (response == 2) { // if the user selects option 2, it will insert a new vocab before another one
                if (list1 == null)
                    System.out.println("Please load a file first");
                else {
                    System.out.println("------------------------------");
                    System.out.println("Pick a topic to insert before");
                    System.out.println("------------------------------");
                    list1.printVocabNames(); // prints the list of vocab names in the linked list
                    response = Integer.parseInt(scan.nextLine()); // gets the response from the user to select the vocab to insert before
                    menu.printVocabsToInsert(); // prints the list of vocab names in the arraylist of topics
                    String word = scan.nextLine();
                    if (!word.isBlank()) { // if the word is not blank
                        list1.insertBefore(response, new Vocab(word)); // add the new vocab to the linked list
                        menu.topics.remove(word); // remove the word from the arraylist of topics
                        menu.topics.trimToSize(); // trim the arraylist of topics
                    }
                }
                //menu.response2Main(response, list1);

            } else if (response == 3) {
                if (list1 == null)
                    System.out.println("Please load a file first");
                else {
                    System.out.println("------------------------------");
                    System.out.println("Pick a topic to insert After");
                    System.out.println("------------------------------");
                    list1.printVocabNames(); // prints the list of vocab names in the linked list
                    response = Integer.parseInt(scan.nextLine()); // gets the response from the user to select the vocab to insert before
                    menu.printVocabsToInsert(); // prints the list of vocab names in the arraylist of topics
                    String word = scan.nextLine();
                    if (!word.isBlank()) { // if the word is not blank
                        list1.insertAfter(response, new Vocab(word)); // add the new vocab to the linked list
                        menu.topics.remove(word); // remove the word from the arraylist of topics
                        menu.topics.trimToSize(); // trim the arraylist of topics
                    }
                }
                    } else if (response == 4) {
                System.out.println("------------------------------");
                System.out.println("Pick a topic to remove ");
                System.out.println("------------------------------");
                list1.printVocabNames(); // prints the list of vocab names in the linked list
                response = Integer.parseInt(scan.nextLine()); // gets the response from the user to select the vocab to insert before
                list1.remove(response);
                    } else if (response == 5) {
                System.out.println("------------------------------");
                System.out.println("Pick a topic to modify ");
                System.out.println("------------------------------");
                list1.printVocabNames(); // prints the list of vocab names in the linked list
                int topic = Integer.parseInt(scan.nextLine()); // gets the response from the user to select the vocab to insert before
                System.out.println("a add a word");
                System.out.println("r remove a word");
                System.out.println("c change a word");
                System.out.println("anything else to exit");
                String word = scan.nextLine();
                if (word.equals("a")) {
                    System.out.println("Enter the word you want to add");
                    String wordToAdd = scan.nextLine();
                    list1.addWord(topic, wordToAdd);
                }
                if(word.equals("r")){
                    list1.printSpecificIndexWord(topic); // prints the list of vocab names in the linked list
                    System.out.println("Enter the index of the word you want to remove");
                    int index = Integer.parseInt(scan.nextLine());
                    list1.removeWord(topic, index);
                }
                if(word.equals("c")){
                    list1.printSpecificIndexWord(topic); // prints the list of vocab names in the linked list
                    System.out.println("Enter the index of the word you want to modify");
                    int index = Integer.parseInt(scan.nextLine());
                    System.out.println("Enter the new word");
                    String newWord = scan.nextLine();
                    list1.changeWord(topic, index, newWord);
                }
                    } else if (response == 6) {
System.out.println("Enter the word you want to search for");
String word = scan.nextLine();
                list1.searchForWord(word);
                    } else if (response == 7) {
                        list1 = menu.response7Main();
                    }
            else if( response == 8){
System.out.println("Enter the letter you want to search for");
String letter = scan.nextLine();
                list1.searchForWordStartingWithAGivenLetter(letter,list1);
            }
            else if(response == 9){
                file.savetoFile(list1,"src/output.txt");
            }

                else if (response == 0) {
                        break; // exits the program
                    }
                }
            }
        }


//        for(Vocab vocab: listOfVocabObjects){
//            System.out.println(vocab.name);
//        }
//        for (ArrayList<String> vocab : twoDArrayList) { // goes through the list of vocab arrays
//            for (String word : vocab) { // goes through the list of words in the vocab array and adds them to the vocab object
//                current.addWord(word); // adds the word to the vocab object list of words
//            }
//            listOfVocabObjects.add(current); // adds the vocab object to the list of vocab objects
//        }
//        for (Vocab vocab : listOfVocabObjects) { // goes through the list of vocab objects
//            vocab.NodeS.printList(); // prints the name of the vocab object
//        }



