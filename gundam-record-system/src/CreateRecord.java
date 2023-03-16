import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class CreateRecord {
    public static void enterNewGundam(ArrayList<GundamModel> newRecords) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                -- Entering a new Gundam --
                Enter "-1" at any point to quit to the main menu.""");

        System.out.println("Enter the Name:");
        String newName = CreateRecord.checkIfNameIsValid();

        System.out.println("Enter the new Grade");
        GundamModel.Grade newGrade = CreateRecord.getNewGrade();

        System.out.println("Enter the new Series");
        GundamModel.Series newSeries = CreateRecord.getNewSeries();

        System.out.println("Enter the Price:");
        String newPrice = checkIfPriceIsValid();

        GundamModel newGundamModel = new GundamModel(newName, newPrice, newGrade, newSeries);
        System.out.println("You entered:");
        System.out.println(newGundamModel.toString());

        newRecords.add(newRecords.size(), newGundamModel);
        System.out.println("""
                Would you like to add another record?
                [1] Yes
                [2] No (This will save all data entered so far)""");
        String userInput = Main.checkValidInput(new ArrayList<>(Arrays.asList("1", "2")));
        if(Objects.equals(userInput, "1")){
            enterNewGundam(newRecords);
        }
        else{
            saveAllGundam(newRecords);
            Main.returnToMainMenu();
        }


    }

    public static GundamModel.Grade getNewGrade(){
        System.out.println("""
                [1] Easy.
                [2] Medium.
                [3] Hard.
                [4] Extreme.""");

        String tempGrade = Main.checkValidInput(Constants.VALID_4_INPUTS_AL);

        return switch(tempGrade){
            case "1" -> GundamModel.Grade.EASY;
            case "2" -> GundamModel.Grade.MEDIUM;
            case "3" -> GundamModel.Grade.HARD;
            default -> GundamModel.Grade.EXTREME;
        };
    }

    public static GundamModel.Series getNewSeries(){
        System.out.println("""
                [1] Mobile Suit Gundam.
                [2] Mobile Suit Gundam: Thunderbolt.
                [3] Mobile Suit Gundam: Unicorn.
                [4] Mobile Suit Gundam: The Witch From Mercury""");

        String tempSeries = Main.checkValidInput(Constants.VALID_4_INPUTS_AL);

        return switch(tempSeries){
            case "1" -> GundamModel.Series.MOBILE_SUIT_GUNDAM;
            case "2" -> GundamModel.Series.MSG_THUNDERBOLT;
            case "3" -> GundamModel.Series.MSG_UNICORN;
            default -> GundamModel.Series.MSG_WitchFromMercury;
        };
    }
    public static String checkIfNameIsValid(){
        Scanner scanner = new Scanner(System.in);
        String newName;
        while(true){
            newName = scanner.nextLine();
            if(Objects.equals(newName, "-1")){Main.returnToMainMenu();}
            if(newName.isEmpty()){
                System.out.println("Name cannot be empty. Enter a new name:");
            }else{
                return newName;
            }
        }

    }
    public static String checkIfPriceIsValid() {
        Scanner scanner = new Scanner(System.in);
        String newPrice;
        while(true){

            //Obtains input from user and then removes any leading 0's.
            //Code adapted from Polygenelubricants, 2010
            newPrice = scanner.nextLine().replaceFirst("^0+(?!$)", "");
            //End of adapted code.

            if(Objects.equals(newPrice, "-1")){
                Main.returnToMainMenu();
            }
            try{
                Double.parseDouble(newPrice.trim());
                if(Double.parseDouble(newPrice.trim()) > 0){
                    return newPrice;
                }
                System.out.println("Enter a positive number.");
            }
            catch(NumberFormatException e){
                System.out.println("Enter a number.\n");
            }
        }
    }

    public static void saveAllGundam(ArrayList<GundamModel> newModels){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("save.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(newModels);
        }
        catch(FileNotFoundException e){
            System.out.println("""
        File not found.
        Data could not be written to disk.""");
            System.out.println(e.getMessage());
            Main.returnToMainMenu();
        }
        catch(IOException e){
            System.out.println("""
                    Unable to create object out of string.
                    Data could not be written to disk.""");
            System.out.println(e.getMessage());
            Main.returnToMainMenu();
        }
    }
}
