import java.util.Scanner;
import java.util.ArrayList;
public class MenuManger {
    // class for managing the menu

    /**
     * constructor for the menu manager
     */
    public MenuManger() {
        topics=new ArrayList<>();
        topics.add("apple");
        topics.add("orange");
        topics.add("banana");
        topics.add("plum");
        topics.add("melon");
    }
   ArrayList <String> topics;

    /**
     * prints the starting screen of the program
     */
    public void startingScreen(){
        System.out.println("------------------------------");
        System.out.println("Vocabulary Control Center");
        System.out.println("------------------------------");
        System.out.println("1 browse a topic");
        System.out.println("2 insert a new topic before another one");
        System.out.println("3 insert a new topic after another one");
        System.out.println("4 remove a topic");
        System.out.println("5 modify a topic");
        System.out.println("6 search topics for a word");
        System.out.println("7 load from a file");
        System.out.println("8 show all words starting with a given letter");
        System.out.println("9 save to file");
        System.out.println("0 exit");
        System.out.println("------------------------------");
        System.out.print("Enter Your Choice: ");
    }

    /**
     * prints the list of vocab names and asks the user to select one
     * @param response the response from the user
     * @param list1 the list of vocab objects
     */
    public void response1Main(int response, DoublyLinkedList list1){
        // this method is called when the user selects option 1 from the main menu
        // it prints the list of vocab names and asks the user to select one
        // it then prints the vocab at that index
        // if the user selects an invalid index, it will print an error messag
        Scanner scan = new Scanner(System.in);
        if(list1==null){
            System.out.println("Please load a file first");
        }
        else{
            System.out.println("------------------------------");
            list1.printVocabNames();
            System.out.println("------------------------------");
            System.out.println("Enter Your Choice: ");
            response = Integer.parseInt(scan.nextLine());
            if(response>0&&response<=list1.size()){ // if the response is a valid index of the list of vocabs
                list1.printSpecificIndex(response); // print the vocab at that index
            }
        }
    }
    public DoublyLinkedList response7Main(){
        // this method is called when the user selects option 7 from the main menu
        // it asks the user to enter the name of the file they want to load
            // it then loads the file and returns the list of vocab objects as a doubly linked list
        // if the file does not exist, it will print an error message
        //
        FileManager file = new FileManager(); // creates a new file manager object
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the input file:");
        String textFileFromUser = scan.nextLine();
        String textFile = file.turnFileToString("src/" + textFileFromUser); // turns the file into a string
       DoublyLinkedList list1=  file.turnFileToDoubleyLinkedList(textFile);
        System.out.println("Done Loading");
        return list1;
    }
    /**
     * prints the list of vocab names to insert
     */
    public void printVocabsToInsert(){
        for(String topic: topics){ // goes through the list of vocab arrays
            System.out.println(topic);
        }
    }
}
