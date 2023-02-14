import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DeleteRecord {

    public static void deleteRecord(){
        Scanner scanner = new Scanner(System.in);
        String userInput = new String();
        boolean whileBool = true;

        ArrayList<GundamModel> modelRecords = RetrieveRecord.getAllModels();
        Iterator<GundamModel> modelIterator = modelRecords.iterator();

        if(modelRecords.isEmpty()){
            System.out.println("There are no model records. Returning to main menu.");
            scanner.nextLine();
            Main.returnToMainMenu();
        }

        for (int i = 0; i < modelRecords.size(); i++) {
            System.out.printf("Record %d: ", i+1);
            System.out.println(modelRecords.get(i) + "\n");
        }

        System.out.printf("Enter a corresponding record number to delete (1-%d):\n", modelRecords.size());

        userInput = checkInpDelRecord(modelRecords);
        for (int i = 0; i < modelRecords.size(); i++) {
            modelIterator.next();
            if(i == Integer.parseInt(userInput)-1){
                modelIterator.remove();
            }
        }

        CreateRecord.saveAllGundamThenMM(modelRecords);

    }
    public static String checkInpDelRecord(ArrayList<GundamModel> modelRecords){
        Scanner scanner = new Scanner(System.in);

        while(true){
            String userInput = scanner.nextLine();
            if(userInput.matches("[0-9]+")){
                if(Integer.parseInt(userInput) >= 1 || Integer.parseInt(userInput) <= modelRecords.size()){
                    return userInput;
                }
            }
            System.out.printf("Please input only valid inputs between 1-%d.\n", modelRecords.size());
        }
    }

}
