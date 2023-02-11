import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------------------------");
        System.out.println("| Welcome to the Gundam Model Database |");
        System.out.println("----------------------------------------");
        System.out.println("What would you like to do?:");
        System.out.println(
                """
                        [1] Create a new records (This will overwrite previously entered data.)
                        [2] Retrieve current records.
                        [3] Delete a record.
                        [4] Edit properties of a record.
                        [6] Quit."""
        );

        checkValidMMInput();
    }

    public static String checkValidInput(List<String> validInput){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String tempString = scanner.nextLine();
            if(Objects.equals(tempString, "-1")){
                returnToMainMenu();
            }
            else if(!validInput.contains(tempString)){
                System.out.println("Input a valid option.");
            }
            else{
                return tempString;
            }
        }

    }

    public static void returnToMainMenu() {

        System.out.println("\nReturned to the main menu.");
        System.out.println(
                """
                        [1] Create a new record (This will overwrite previously entered data.)
                        [2] Retrieve current records.
                        [3] Delete a record.
                        [4] Edit properties of a record.
                        [6] Quit."""
        );

        checkValidMMInput();
    }

    public static void checkValidMMInput(){
        ArrayList<GundamModel> newModels = new ArrayList<>();
        List<String> validInputs = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "6"));
        Scanner scanner = new Scanner(System.in);
        String userInput;
        while (true) {
            System.out.println();
            userInput = scanner.nextLine();
            if (!validInputs.contains(userInput)) {
                System.out.println("Invalid input, try again.");
            } else {

                break;
            }
        }
        switch(userInput){
            case "1" -> CreateRecord.enterNewGundam(newModels);
            case "2" -> RetrieveRecord.displayRecords();
            case "3" -> DeleteRecord.deleteRecord();
            case "4" -> EditRecord.editRecord();
            case "6" -> quit();
        }
    }

    public static void quit(){
        System.exit(0);
    }
}