import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class EditRecord {

    public static void editRecord(){
        ArrayList<GundamModel> allModels = RetrieveRecord.retrieveRecords();

        RetrieveRecord.displayRecordsInner();
        int userInput = editRecordInner(allModels);
        if(userInput == -1){
            System.out.println("Error reached in editRecord.");
        }

        GundamModel selectedModel = allModels.get(userInput-1);
        System.out.println(selectedModel.toString());

        System.out.println();
    }

    public static int editRecordInner(ArrayList<GundamModel> allModels){
        List<String> validInput = new ArrayList<>(Arrays.asList("1", "2"));
        System.out.println("Please input the record number you wish to edit.");
        int userInput = Integer.parseInt(DeleteRecord.checkInpDelRecord(allModels));

        GundamModel selectedModel = allModels.get(userInput-1);

        System.out.println("Model selected:");
        System.out.println(selectedModel.toString());

        System.out.println("""
        Is this correct?
        [1] Yes
        [2] No""");

        String isCorrect = Main.checkValidInput(validInput);

        if (Objects.equals(isCorrect, "1")){
            return userInput;
        }
        else{
            return editRecordInner(allModels);
        }
    }

}
