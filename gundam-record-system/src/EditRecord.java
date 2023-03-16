import java.util.*;

public class EditRecord {

    public static void editRecord(){
        ArrayList<GundamModel> allModels = RetrieveRecord.getAllModels();
        RetrieveRecord.printSortedList(allModels);

        System.out.println("""
        Enter the record number you wish to edit.
        Type in "-1" to cancel at any point and return to the main menu.""");

        int userInput;

        while(true){
            userInput = Integer.parseInt(DeleteRecord.checkInpDelRecord(allModels));
            if(userInput == -1){
                Main.returnToMainMenu();
            }
            if(userInput > (allModels.size()) || userInput < 1){
                System.out.println(allModels.size());
                System.out.println("Please enter a valid record number between the stated parameters.");
            }else{
                break;
            }
        }

        GundamModel selectedModel = allModels.get(userInput-1);
        System.out.println(selectedModel.toString());

        System.out.println("""
                What property would you like to edit?
                [1] Name
                [2] Grade
                [3] Series
                [4] Price""");

        String checkInpProperty = Main.checkValidInput(Constants.VALID_4_INPUTS_AL);

        editProperty(checkInpProperty, selectedModel, allModels);

        System.out.println();
    }

    public static void editPropertyName(GundamModel selectedModel, ArrayList<GundamModel> allModels){
        Scanner scanner = new Scanner(System.in);

        System.out.println("The current Name is " + selectedModel.getModelName() + ", what would you like to change it to?");
        String gundName = CreateRecord.checkIfNameIsValid();
        selectedModel.setModelName(gundName);
        CreateRecord.saveAllGundam(allModels);

        System.out.println("Record altered successfully. New Record:");
        System.out.println(selectedModel.toString() + "\n");

        System.out.println("Press enter to return to the Main Menu.");
        scanner.nextLine();
        Main.returnToMainMenu();
    }

    public static void editPropertyGrade(GundamModel selectedModel, ArrayList<GundamModel> allModels){
        GundamModel.Grade gundGrade = selectedModel.getGrade();
        Scanner scanner = new Scanner(System.in);
        System.out.println("The current Grade is " + selectedModel.getGrade() + ", what would you like to change it to?");
        System.out.println("""
                        [1] High Grade
                        [2] Real Grade
                        [3] Master Grade
                        [4] Perfect Grade""");

        String enteredGrade = Main.checkValidInput(Constants.VALID_4_INPUTS_AL);
        GundamModel.Grade newGrade = switch(enteredGrade){
            case "1" -> GundamModel.Grade.HIGH;
            case "2" -> GundamModel.Grade.REAL;
            case "3" -> GundamModel.Grade.MASTER;
            case "4" -> GundamModel.Grade.PERFECT;
            default -> gundGrade;
        };

        selectedModel.setGrade(newGrade);
        CreateRecord.saveAllGundam(allModels);

        System.out.println("Record altered successfully. New Record:");
        System.out.println(selectedModel.toString() + "\n");

        System.out.println("Press enter to return to the Main Menu.");
        scanner.nextLine();
        Main.returnToMainMenu();
    }

    public static void editPropertySeries(GundamModel selectedModel, ArrayList<GundamModel> allModels){
        GundamModel.Series gundSeries = selectedModel.getSeries();
        Scanner scanner = new Scanner(System.in);
        System.out.println("The current Series is " + selectedModel.getSeries() + ", what would you like to change it to?");
        System.out.println("""
                        [1] Mobile Suit Gudam.
                        [2] Mobile Suit Gundam: Thunderbolt.
                        [3] Mobile Suit Gundam: Unicorn.
                        [4] Mobile Suit Gundam: The Witch From Mercury""");

        String enteredSeries = Main.checkValidInput(Constants.VALID_4_INPUTS_AL);
        GundamModel.Series newSeries = switch(enteredSeries){
            case "1" -> GundamModel.Series.MOBILE_SUIT_GUNDAM;
            case "2" -> GundamModel.Series.MSG_THUNDERBOLT;
            case "3" -> GundamModel.Series.MSG_UNICORN;
            case "4" -> GundamModel.Series.MSG_WitchFromMercury;
            default -> gundSeries;
        };

        selectedModel.setSeries(newSeries);
        CreateRecord.saveAllGundam(allModels);

        System.out.println("Record altered successfully. New Record:");
        System.out.println(selectedModel.toString() + "\n");

        System.out.println("Press enter to return to the Main Menu.");
        scanner.nextLine();
        Main.returnToMainMenu();
    }

    public static void editPropertyPrice(GundamModel selectedModel, ArrayList<GundamModel> allModels){
        Scanner scanner = new Scanner(System.in);
        System.out.println("The current Price is " + selectedModel.getReleasePrice() + ", what would you like to change it to?");
        String gundPrice = CreateRecord.checkIfPriceIsValid();

        selectedModel.setReleasePrice(gundPrice);
        CreateRecord.saveAllGundam(allModels);

        System.out.println("Record altered successfully. New Record:");
        System.out.println(selectedModel.toString() + "\n");

        System.out.println("Press enter to return to the Main Menu.");
        scanner.nextLine();
        Main.returnToMainMenu();
    }
    public static void editProperty(String chosenProperty, GundamModel selectedModel, ArrayList<GundamModel> allModels){
        Scanner scanner = new Scanner(System.in);

        switch(chosenProperty){
            // Chosen Name
            case "1" -> editPropertyName(selectedModel, allModels);
            // Chosen Grade
            case "2" -> editPropertyGrade(selectedModel, allModels);
            // Chosen Series
            case "3" -> editPropertySeries(selectedModel, allModels);
            // Chosen Price
            case "4" -> editPropertyPrice(selectedModel, allModels);

            default -> System.out.println("Invalid");
        }

    }


}
