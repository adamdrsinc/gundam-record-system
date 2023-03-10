import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class CreateRecord {
    public static void enterNewGundam(ArrayList<GundamModel> newRecords) {
        Scanner scanner = new Scanner(System.in);

        GundamModel.Grade newGrade;
        GundamModel.Series newSeries;

        System.out.println("""
                -- Entering a new Gundam --
                Enter "-1" at any point to quit to the main menu.""");

        System.out.println("Enter the Name:");
        String newName = scanner.nextLine();
        if(Objects.equals(newName, "-1")){Main.returnToMainMenu();}

        System.out.println("Enter the Grade");
        System.out.println("""
                [1] High Grade.
                [2] Real Grade.
                [3] Master Grade.
                [4] Perfect Grade.""");

        String tempGrade = Main.checkValidInput(Constants.VALID_4_INPUTS_AL);

        newGrade = switch(tempGrade){
            case "1" -> GundamModel.Grade.HIGH;
            case "2" -> GundamModel.Grade.REAL;
            case "3" -> GundamModel.Grade.MASTER;
            default -> GundamModel.Grade.PERFECT;
        };

        System.out.println("Enter the Series");
        System.out.println("""
                [1] Mobile Suit Gudam.
                [2] Mobile Suit Gundam: Thunderbolt.
                [3] Mobile Suit Gundam: Unicorn.
                [4] Mobile Suit Gundam: The Witch From Mercury""");

        String tempSeries = Main.checkValidInput(Constants.VALID_4_INPUTS_AL);

        newSeries = switch(tempSeries){
            case "1" -> GundamModel.Series.MOBILE_SUIT_GUNDAM;
            case "2" -> GundamModel.Series.MSG_THUNDERBOLT;
            case "3" -> GundamModel.Series.MSG_UNICORN;
            default -> GundamModel.Series.MSG_WitchFromMercury;
        };

        System.out.println("Enter the Price:");
        String newPrice = checkIfPriceIsDouble();

        if(Objects.equals(newPrice, "-1")){Main.returnToMainMenu();}

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
            saveAllGundamThenMM(newRecords);
        }


    }

    public static String checkIfPriceIsDouble() {
        Scanner scanner = new Scanner(System.in);
        String newPrice;
        while(true){
            newPrice = scanner.nextLine();
            try{
                Double.parseDouble(newPrice.trim());
                return newPrice;
            }
            catch(NumberFormatException e){
                System.out.println("Enter a number.\n");
            }
        }
    }

    public static void saveAllGundamThenMM(ArrayList<GundamModel> newModels){
        saveAllGundam(newModels);
        Main.returnToMainMenu();
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
