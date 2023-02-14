import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class RetrieveRecord {

    //ONLY sort the list.
    public static void displaySortOption(){
        List<String> validInput = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        ArrayList<GundamModel> allRecords = getAllModels();


        if(getAllModels().isEmpty()){
            System.out.println("No records exist, returning to Main Menu.");
            Main.returnToMainMenu();
        }

        System.out.println("""
                Would you like to sort the list?
                [1] Yes
                [2] No""");

        String userInput = Main.checkValidInput(new ArrayList<>(Arrays.asList("1", "2")));

        if(Objects.equals(userInput, "1")){

            System.out.println("""
                    How would you like to sort the list?
                    [1] By Grade (Ascending)
                    [2] By Grade (Descending)
                    [3] By Name (Ascending)
                    [4] By Name (Descending)""");

            userInput = Main.checkValidInput(validInput);
            NameComparator nameComparator = new NameComparator();

            // If they've chosen 1
            if(Objects.equals(userInput, "1")){
                Collections.sort(allRecords);
                printSortedList(allRecords);
            }
            // If they've chosen 2
            else if (Objects.equals(userInput, "2")) {
                Collections.sort(allRecords);
                Collections.reverse(allRecords);
                printSortedList(allRecords);
            }
            // If they've chosen 3
            else if (Objects.equals(userInput, "3")){
                Collections.sort(allRecords, nameComparator);
                printSortedList(allRecords);
            }
            // If they've chosen 4
            else{
                Collections.sort(allRecords, nameComparator);
                Collections.reverse(allRecords);
                printSortedList(allRecords);
            }
        } else{
            printSortedList(allRecords);
        }


    }

    // Sort list AND return to Main Menu
    public static void sortedListReturnToMM(){
        Scanner scanner = new Scanner(System.in);
        displaySortOption();
        System.out.println("Press enter to return to the main menu.");
        scanner.nextLine();
        Main.returnToMainMenu();
    }

    public static void printSortedList(ArrayList<GundamModel> allRecords) {
        for (int i = 0; i < allRecords.size(); i++) {
            System.out.println("Record " + (i+1));
            System.out.println(allRecords.get(i).toString() + "\n");
        }

    }

    public static ArrayList<GundamModel> getAllModels(){
        try{
            FileInputStream fileInputStream = new FileInputStream("save.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<GundamModel>)objectInputStream.readObject();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println("Error converting data to object: " + e.getMessage());
        }
        catch(ClassNotFoundException e){
            System.out.println("Class not found exception: " + e.getMessage());
        }
        return new ArrayList<GundamModel>();
    }
}
